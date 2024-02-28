import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;

public class Arquivo<T extends Registro> {

  private static int TAM_CABECALHO = 4;
  RandomAccessFile arq;
  String nomeArquivo = "";
  Constructor<T> construtor;

  public Arquivo(String na, Constructor<T> c) throws Exception {
    this.nomeArquivo = na;
    this.construtor = c;
    arq = new RandomAccessFile(na, "rw");
    if (arq.length() < TAM_CABECALHO) {
      arq.seek(0);
      arq.writeInt(0);
    }
  }

  public int create(T obj) throws Exception {
    arq.seek(0);
    int ultimoID = arq.readInt();
    ultimoID++;
    arq.seek(0);
    arq.writeInt(ultimoID);
    obj.setID(ultimoID);

    arq.seek(arq.length());
    // long endereco = arq.getFilePointer();
    byte[] ba = obj.toByteArray();
    short tam = (short) ba.length;
    arq.write(' '); // lápide
    arq.writeShort(tam);
    arq.write(ba);

    return obj.getID();
  }

  public T read(int id) throws Exception {
    T l = construtor.newInstance();
    byte[] ba;
    short tam;
    byte lapide;

    arq.seek(TAM_CABECALHO);
    while (arq.getFilePointer() < arq.length()) {

      lapide = arq.readByte();
      tam = arq.readShort();
      if (lapide == ' ') {
        ba = new byte[tam];
        arq.read(ba);
        l.fromByteArray(ba);
        if (l.getID() == id)
          return l;
      } else {
        arq.skipBytes(tam);
      }
    }
    return null;
  }

  public boolean delete(int id) throws Exception {
    T l = construtor.newInstance();
    byte[] ba;
    short tam;
    byte lapide;
    long endereco;

    arq.seek(TAM_CABECALHO);
    while (arq.getFilePointer() < arq.length()) {

      endereco = arq.getFilePointer();
      lapide = arq.readByte();
      tam = arq.readShort();
      if (lapide == ' ') {
        ba = new byte[tam];
        arq.read(ba);
        l.fromByteArray(ba);
        if (l.getID() == id) {
          arq.seek(endereco);
          arq.write('*');
          return true;
        }
      } else {
        arq.skipBytes(tam);
      }
    }
    return false;
  }

  public boolean update(T objAlterado) throws Exception {
    T l = construtor.newInstance();
    byte[] ba;
    short tam;
    byte lapide;
    long endereco;

    arq.seek(TAM_CABECALHO);
    while (arq.getFilePointer() < arq.length()) {

      endereco = arq.getFilePointer();
      lapide = arq.readByte();
      tam = arq.readShort();
      if (lapide == ' ') {
        ba = new byte[tam];
        arq.read(ba);
        l.fromByteArray(ba);
        if (l.getID() == objAlterado.getID()) {
          byte[] ba2 = objAlterado.toByteArray();
          short tam2 = (short) ba2.length;
          if (tam2 <= tam) {
            arq.seek(endereco + 1 + 2);
            arq.write(ba2);
          } else {
            arq.seek(endereco);
            arq.write('*');
            arq.seek(arq.length());
            arq.write(' ');
            arq.writeShort(tam2);
            arq.write(ba2);
          }
          return true;
        }
      } else {
        arq.skipBytes(tam);
      }
    }
    return false;
  }

  public void close() throws Exception {
    arq.close();
  }
}
