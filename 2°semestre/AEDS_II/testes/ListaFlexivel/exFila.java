
class Fila{
    private Celula primeiro;
    private Celula ultimo;

    Fila(){
        primeiro = new Celula();
        ultimo = primeiro;
    }

    public void inserir(int x){
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }

    public int remover(){
        if(primeiro == ultimo){
            MyIO.println("ERRO!");
            return 0;
        }
        Celula tmp = primeiro;
        primeiro = primeiro.prox;
        int resp = primeiro.elemento;
        
        tmp.prox = null;
        tmp = null;
        return resp;
    }

    public void mostrar(){
        MyIO.print("[ ");
        for(Celula i = primeiro.prox; i != null; i = i.prox){
            MyIO.print(i.elemento + " ");
        }
        MyIO.println("]");
    }

    public int maior(){
        if(!(primeiro == ultimo)){
            int maior = primeiro.prox.elemento;
            for(Celula i = primeiro.prox.prox; i != null; i = i.prox){
                if(maior < i.elemento){
                    maior = i.elemento;
                }
            }
            return maior;
        }
        else{
            MyIO.println("ERRO!");
            return -1;
        }

    }

    public int terceiro(){
        Celula i = primeiro.prox.prox.prox;

        return i.elemento;
    }

    public int soma(){
        int soma = 0;
        for(Celula i = primeiro.prox; i != null; i = i.prox){
            soma += i.elemento;
        }
        return soma;
    }

    public void inverte(){
        Celula p = primeiro.prox;
        Celula u = ultimo;
        int tmp;

        while(!(u.prox == p || u.prox.prox == p)){
            Celula c = p;
            while(c.prox != u){
                c = c.prox;
            }
    
            tmp = p.elemento;
            p.elemento = u.elemento;
            u.elemento = tmp;

            p = p.prox;
            u = c;
        }


    }
}


class exFila {
    public static void main(String[] args){
        Fila f = new Fila();
        int maior, terceiro, soma;

        f.remover();
        f.inserir(3);
        f.inserir(5);
        maior = f.maior();
        MyIO.println("O maior valor e: " + maior);
        f.inserir(7);
        maior = f.maior();
        MyIO.println("O maior valor e: " + maior);
        terceiro = f.terceiro();
        MyIO.println("O terceiro valor e: " + terceiro);
        f.mostrar();
        f.remover();
        f.inserir(4);
        maior = f.maior();
        MyIO.println("O maior valor e: " + maior);
        f.mostrar();
        soma = f.soma();
        MyIO.println("A soma e: " + soma);
        f.inserir(10);
        f.inserir(1);
        f.mostrar();
        f.inverte();
        f.mostrar();
        maior = f.maior();
        MyIO.println("O maior valor e: " + maior);
        terceiro = f.terceiro();
        MyIO.println("O terceiro valor e: " + terceiro);
        soma = f.soma();
        MyIO.println("A soma e: " + soma);
    }
}