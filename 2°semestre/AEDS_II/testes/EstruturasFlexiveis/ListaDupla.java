public class ListaDupla {
    public CelulaDupla primeiro, ultimo;

    ListaDupla(){
        primeiro = new CelulaDupla();
        ultimo = primeiro;
    }

    public void inserirInicio(int x) {
        CelulaDupla tmp = new CelulaDupla(x);

        tmp.ant = primeiro;
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
        
        if(primeiro == ultimo){
            ultimo = tmp;
        } else{
            tmp.prox.ant = tmp;
        }
        tmp = null;
    }
    public void inserirFim(int x) {
        CelulaDupla tmp = new CelulaDupla(x);

        ultimo.prox = tmp;
        tmp.ant = ultimo;
        ultimo = tmp;

        tmp = null;
    }
    public int removerInicio() {
        primeiro = primeiro.prox;
        primeiro.ant.prox = null;
        primeiro.ant = null;

        int resp = primeiro.elemento;

        return resp;
    }
    public int removerFim() {
        int resp = ultimo.elemento;

        ultimo = ultimo.ant;
        ultimo.prox.ant = null;
        ultimo.prox = null;

        return resp;
    }
    public void inserir(int x, int pos) {
        CelulaDupla tmp = new CelulaDupla(x);

        CelulaDupla i = primeiro;
        for(int j = 0; j < pos; j++){
            i = i.prox;
        }

        tmp.ant = i;
        tmp.prox = i.prox;
        tmp.prox.ant = tmp;
        tmp.ant.prox = tmp;

        tmp = i = null;
    }
    public int remover(int pos) {
        CelulaDupla i = primeiro;
        for(int j = 0; j < pos; j++){
            i = i.prox;
        }

        CelulaDupla tmp = i.prox;
        int resp = tmp.elemento;
        i.prox = tmp.prox;
        i.prox.ant = i;
        tmp.prox = tmp.ant = null;
        tmp = null;

        return resp;
    }
    public void mostrar() {
        CelulaDupla i = primeiro.prox;
        while(i != null){
            System.out.println(i.elemento + " ");
            i = i.prox;
        }

        i = null;
    }

    public void inverte(){
        CelulaDupla i = primeiro.prox;
        CelulaDupla j = ultimo;

        while(i != j && i.ant != j){
            int tmp;
            tmp = i.elemento;
            i.elemento = j.elemento;
            j.elemento = tmp;

            i = i.prox;
            j = j.ant;
        }
    }

    public void quicksort(){
        quicksort(primeiro.prox, ultimo);
    }

    public void quicksort(CelulaDupla esq, CelulaDupla dir){
        CelulaDupla i = esq;
        CelulaDupla j = dir;
        CelulaDupla pivot = esq;

        //Calculando o pivot
        while(i != j && i.ant != j){
            i = i.prox;
            j = j.ant;
        }
        pivot = i;
        i = esq; //Voltando para a posicao inicial
        j = dir;

        while(i.ant != j && i.ant != j.prox){ //i <= j
            while(i.elemento < pivot.elemento){
                i = i.prox;
            }
            while(j.elemento > pivot.elemento){
                j = j.ant;
            }

            if(i.ant != j && i.ant != j.prox){
                int tmp = i.elemento;
                i.elemento = j.elemento;
                j.elemento = tmp;

                i = i.prox;
                j = j.ant;
            }
        }

        if(j != null && j.prox != esq && j != esq){ //j > esq
            quicksort(esq, j);
        }
        if(i != null && i.ant != dir && i != dir){ //i < dir
            quicksort(i, dir);
        }

    }
}
