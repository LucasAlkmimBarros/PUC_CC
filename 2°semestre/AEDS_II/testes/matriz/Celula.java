class Celula{
    public int elemento;
    public Celula inf, sup, esq, dir;

    Celula(){
        this(0);
    }

    Celula(int elemento){
        this(elemento, null, null, null, null);
    }

    Celula(int elemento, Celula inf, Celula sup, Celula esq, Celula dir){
        this.elemento = elemento;
        this.inf = inf;
        this.sup = sup;
        this.esq = esq;
        this.dir = dir;
    }
}