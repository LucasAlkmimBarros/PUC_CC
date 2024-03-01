import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Autor implements Registro{
    private int ID;
    private String nome;
    private String nacionalidade;

    public Autor() {
        this(-1, "", "");
    }

    public Autor(String n, String nac) {
        this(-1, n, nac);
    }

    public Autor(int id, String n, String nac) {
        this.ID = id;
        this.nome = n;
        this.nacionalidade = nac;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int id) {
        this.ID = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String n) {
        this.nome = n;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nac) {
        this.nacionalidade = nac;
    }

    public String toString() {
        return "ID: " + ID + " - Nome: " + nome + " - Nacionalidade: " + nacionalidade;
    }

    public byte[] toByteArray() throws Exception {
        ByteArrayOutputStream ba_out = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(ba_out);
        dos.writeInt(ID);
        dos.writeUTF(nome);
        dos.writeUTF(nacionalidade);
        return ba_out.toByteArray();        
    }

    public void fromByteArray(byte[] ba) throws Exception {
        ByteArrayInputStream ba_in = new ByteArrayInputStream(ba);
        DataInputStream dis = new DataInputStream(ba_in);
        ID = dis.readInt();
        nome = dis.readUTF();
        nacionalidade = dis.readUTF();
    }
}
