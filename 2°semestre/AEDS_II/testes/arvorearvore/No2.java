public class No2 {
    public No2 esq, dir;
    public String palavra;

    No2(String palavra){
        this(palavra, null, null);
    }

    No2(String palavra, No2 esq, No2 dir){
        this.palavra = palavra;
        this.esq = esq;
        this.dir = dir;
    }
}
