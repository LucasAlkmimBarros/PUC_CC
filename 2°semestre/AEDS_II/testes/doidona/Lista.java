class Lista{
    Celula primeiro;
    Celula ultimo;

    Lista(){
        primeiro = new Celula();
        ultimo = primeiro;
    }

    public void inserir(int x){
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }

    public boolean pesquisar(int x){
        boolean resp = false;
        for(Celula i = primeiro.prox; i != null; i = i.prox){
            if(i.elemento == x){
                resp = true;
            }
        }

        return resp;
    }

    public void mostrar(){
        System.out.print("[ ");
        for(Celula i = primeiro.prox; i != null; i = i.prox){
            System.out.print(i.elemento + " ");
        }
        System.out.println("]");
    }

    public void remover(int x){
        Celula i = primeiro;
        while(i.prox != null && i.prox.elemento != x){
            i = i.prox;
        }
        if(i.prox != null){
            i.prox = i.prox.prox;
        }
    }
}