public class Celula {
    public int elemento;
    public Celula prox;

    Celula(){
        this(-1);
    }

    Celula(int elemento){
        this(elemento, null);
    }

    Celula(int elemento, Celula prox){
        this.elemento = elemento;
        this.prox = prox;
    }
}
