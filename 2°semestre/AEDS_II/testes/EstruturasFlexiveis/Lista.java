public class Lista {
    public Celula primeiro, ultimo;

    Lista(){
        primeiro = new Celula();
        ultimo = primeiro;
    }

    public void inserirIncio(int x){
        Celula tmp = new Celula(x);

        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;

        if(primeiro == ultimo){
            ultimo = tmp;
        }
        tmp = null;
    }

    public void inserir(int x, int pos){
        Celula tmp = new Celula(x);
        Celula i = primeiro.prox;

        for(int j = 0; j < pos-1; j++){
            i = i.prox;
        }

        tmp.prox = i.prox;
        i.prox = tmp;
        if(tmp.prox == null){
            tmp = ultimo;
        }

        tmp = i = null;
    }

    public void inserirFim(int x){
        Celula tmp = new Celula(x);
        ultimo.prox = tmp;
        ultimo = ultimo.prox;
    }

    public void mostrar(){
        Celula i = primeiro.prox;
        while(i != null){
            System.out.println(i.elemento);
            i = i.prox;
        }
    }

    public int removerInicio(){
        Celula i = primeiro;
        primeiro = primeiro.prox;

        int resp = primeiro.elemento;
        i.prox = null;
        i = null;

        return resp;
    }

    public int remover(int pos){
        Celula i = primeiro.prox;

        for(int j = 0; j < pos-1; j++){
            i = i.prox;
        }

        Celula tmp = i.prox;
        int resp = tmp.elemento;
        i.prox = tmp.prox;
        tmp.prox = null;
        i = tmp = null;

        return resp;
    }

    public int removerFim(){
        Celula i = primeiro;
        while(i.prox != ultimo){
            i = i.prox;
        }

        int resp = ultimo.elemento;
        ultimo = i;
        i.prox = null;
        i = null;
        return resp;
    }

    public void ordenar(){
        for(Celula i = primeiro.prox; i.prox != null; i = i.prox){
            Celula menor = i;
            for(Celula k = i.prox; k != null; k = k.prox){
                if(menor.elemento > k.elemento){
                    menor = k;
                }
            }
            int tmp = i.elemento;
            i.elemento = menor.elemento;
            menor.elemento = tmp;

        }
    }

    public void inverte(){
        Celula i = primeiro.prox;
        Celula j = ultimo;
        Celula k;

        while(i != j && j.prox != i){
            int tmp = i.elemento;
            i.elemento = j.elemento;
            j.elemento = tmp;

            i = i.prox;
            for(k = primeiro; k.prox != j; k = k.prox); //Leva o k uma posicao antes do ultimo
            j = k;
        }
    }

    public int tamanho(){
        int tam = 0;
        Celula i = primeiro.prox;
        while(i != null){
            tam ++;
            i = i.prox;
        }

        return tam;
    }
/*
    public void quicksort(){
        quicksort(0, tamanho()-1);
    }

    public void quicksort(int esq, int dir){
        int i = esq;
        int j = dir;
        Celula ci = primeiro.prox;
        Celula cj = primeiro.prox;
        Celula pivot = primeiro.prox;
        Celula c;

        //Calculando o pivot
        for(int k = 0; k < ((i + j)/2); k++){
            pivot = pivot.prox;
        }

        //Calculando ci
        for(int k = 0; k < i; k++){
            ci = ci.prox;
        }

        //Calculando c2
        for(int k = 0; k < j; k++){
            cj = cj.prox;
        }

        while(i <= j){
            while(ci.elemento < pivot.elemento){
                i++;
                ci = ci.prox;
            }

            while(cj.elemento > pivot.elemento){
                j--;
                for(c = primeiro.prox; c.prox != cj; c = c.prox);
                cj = c;
            }

            if(i <= j){
                int tmp = ci.elemento;
                ci.elemento = cj.elemento;
                cj.elemento = tmp;

                i++;
                j--;

                ci = ci.prox;
                for(c = primeiro.prox; c.prox != cj; c = c.prox);
                cj = c;
            }
        }

        if(esq < j) quicksort(esq, j);
        if(i < dir ) quicksort(i, dir);

    } */

    public void quicksort(){
        quicksort(primeiro.prox, ultimo);
    }

    public void quicksort(Celula esq, Celula dir){
        Celula i = esq;
        Celula j = dir;
        Celula pivot = esq;
        Celula k;

        //Calculando o pivot
        while(i != j && j.prox != i){
            i = i.prox;
            for(k = primeiro; k.prox != j; k = k.prox); //j = j.ant
            j = k; 
        }

        while(j != null && j.prox != null && j.prox != i && j.prox.prox != i){ //i <= j 
            while(i != null && i.elemento < pivot.elemento){ 
                i = i.prox;
            }
            while(j.elemento > pivot.elemento){
                for(k = primeiro; k.prox != j; k = k.prox); //j = j.ant
                j = k; 
            }

            if(j != null && i != null && j.prox != null && j.prox != i && j.prox.prox != i){ //i <= j 
                int tmp = i.elemento;
                i.elemento = j.elemento;
                j.elemento = tmp;

                i = i.prox;
                for(k = primeiro; k.prox != j && k.prox != null; k = k.prox); //j = j.ant
                j = k; 
            }
        }
        if(j != null && j.prox != esq && j != esq){ //esq < j
            quicksort(esq, j);
        }
        
        for(k = primeiro; k.prox != i; k = k.prox); //k = i.ant
        if(i != null && k != dir && i != dir){ //dir > i
            quicksort(i, dir);
        }
    }
} 
