public class CelulaDupla {
    public CelulaDupla prox;
    public CelulaDupla ant;
    public int elemento;

    CelulaDupla(){
        this(0);
    }

    CelulaDupla(int x){
        this.elemento = x;
        this.prox = this.ant = null;
    }
}
