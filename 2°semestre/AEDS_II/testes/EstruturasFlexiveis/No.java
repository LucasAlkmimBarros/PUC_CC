public class No {
    public No esq;
    public No dir;
    public int elemento;
    
    No(){
        this(0);
    }

    No(int x){
        this(x, null, null);
    }

    No(int x, No esq, No dir){
        this.elemento = x;
        this.esq = esq;
        this.dir = dir;
    }
}
