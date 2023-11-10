public class Fila {
    public Celula primeiro, ultimo;

    Fila(){
        primeiro = new Celula();
        ultimo = primeiro;

    }

    public void inserir(int x){
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }

    public int remover(){
        int resp = -1;
        if(primeiro != ultimo){
            Celula tmp = primeiro;
            primeiro = primeiro.prox;
            resp = primeiro.elemento;
            tmp.prox = null;
            tmp = null;
        }
        return resp;
    }

    public void mostrar(){
        Celula i = primeiro.prox;
        while(i != null){
            System.out.println(i.elemento);
            i = i.prox;
        }
    }
}
