class Pilha{   
    public Celula topo;

    Pilha(){
        topo = null;
    }

    public void inserir(int x){
        Celula tmp = new Celula(x);
        tmp.prox = topo;
        topo = tmp;

        tmp = null;
    }

    public int remover(){
        int resp = topo.elemento;
        Celula tmp = topo;
        topo = topo.prox;
        tmp.prox = null;
        tmp = null;

        return resp;
    }

    public void mostrar(){
        Celula i = topo;
        while(i != null){
            System.out.println(i.elemento + " ");
            i = i.prox;
        }
    }

    public void mostrarOrdemInsercao(){
        Celula i = topo;
        mostrarOrdemInsercao(i);
    }
    
    public void mostrarOrdemInsercao(Celula i){
        if(i != null){
            mostrarOrdemInsercao(i.prox);
            System.out.println(i.elemento);
        }
    }

    /* 
    public void mostrarOrdemInsercao(){
        Celula i, k;

        for(k = topo; k.prox != null; k = k.prox); //Coloca o k na ultima posicao
        while(k != topo){
            for(i = topo; i.prox != k; i = i.prox);
            System.out.println(k.elemento);
            k = i;
        }
        System.out.println(k.elemento);
    }
    */

    public int soma(){
        Celula i = topo;
        return soma(i);
    }

    public int soma(Celula i){
        int soma = 0;;
        if(i != null){
            soma = i.elemento + soma(i.prox);
        }
        return soma;
    }

    public Celula toFila(Celula topo){
        Fila f = new Fila();
        toFila(topo, f);

        return f.primeiro;
    }

    public void toFila(Celula i, Fila f){
        if(i != null){
            toFila(i.prox, f);
            f.inserir(i.elemento);
        }
    }
} 

 