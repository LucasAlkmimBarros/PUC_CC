import java.util.*;

class No{
    public int elemento;
    public No esq;
    public No dir;

    No(int x){
        this(x, null, null);
    }

    No(int x, No esq, No dir){
        this.elemento = x;
        this.esq = esq;
        this.dir = dir;
    }
}

class Arvore{
    public No raiz;

    Arvore(){
        this.raiz = null;
    }

    public void inserir(int x){
        raiz = inserir(x, raiz);
    }

    public No inserir(int x, No no){
        if(no == null){
            no = new No(x);
        }
        else if(no.elemento > x){
            no.esq = inserir(x, no.esq);
        }
        else if(no.elemento < x){
            no.dir = inserir(x, no.dir);
        }

        return no;
    }

    public void bfs(int quant){ // quant = quantidade de elementos na arvore
        int[] vet = new int[quant];
        int i = 0;

        Queue<No> fila = new LinkedList<No>();

        fila.add(raiz);

        while(!fila.isEmpty()){
            No no = fila.remove();
            vet[i] = no.elemento;
            i++;
            if(no.esq != null){
                fila.add(no.esq);
            }
            if(no.dir != null){
                fila.add(no.dir);
            }
        }

        for(int j = 0; j < quant; j++){
            System.out.print(vet[j] + " ");
        }
        System.out.println();
        fila.add(raiz);
    }
}


class Q01{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n;
        n = sc.nextInt();

        for(int i = 0; i < n; i++){
            int quant;
            Arvore a = new Arvore();
            quant = sc.nextInt();
            for(int j = 0; j < quant; j++){ //Le todos os numeros e insere na arvore
                a.inserir(sc.nextInt());
            }
            System.out.println("Case: " + (i+1));
            a.bfs(quant);
        }
        
    }
}

