public class No {
    public No2 raiz2;
    public No esq, dir;
    public char letra;

    No(char letra){
        this(letra, null, null);
    }

    No(char letra, No esq, No dir){
        this.letra = letra;
        this.esq = esq;
        this.dir = dir;
    }
}
