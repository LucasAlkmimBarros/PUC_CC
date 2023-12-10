public class No {
    public int elemento;
    public No esq;
    public No dir;

    No(){
        this(-1);
    }

    No(int elemento){
        this(elemento, null, null);
    }

    No(int elemento, No esq, No dir){
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }
}
