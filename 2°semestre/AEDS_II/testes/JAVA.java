public class JAVA {
    inserir1(int x){ // Custo: 0(1)
        int pos = h(x);
        tabela[pos] = x;
    }

    inserir2(int x){ // Custo: 0(log n)
        raiz = inserir2(x, raiz);
    }

    inserir2(int x, No i){
        if(i == null){
            i = new No(x);
        }
        else if(x < i.elemento){
            i.esq = inserir2(x, i.esq);
        }
        else if(x > i.elemento){
            i.dir = inserir2(x, i.dir);
        }
    }

    inserir3(int x){ // Custo: 0(n)
        for(int i = 0; i < n; i++){
            if(array[i] == null){
                array[i] = x;
                break;
            }
        }
    }

    mostrar5Vogal(){
        mostrar5Vogal("", raiz);
    }

    mostrar5Vogal(String nome, No no){
        if(no.folha == true){
            if(nome.length() > 4){
                if(no.letra == 'a'){ //testar todas as vogais
                    System.out.println(nome + no.letra);
                }
            }
        }
        else{
            for(int i = 0; i < no.prox.length; i++){
                if(no.prox[i] != NULO){
                    mostrar5Vogal(nome + no.letra, no.prox[i]);
                }
            }
        }
    }

    4-
    a)
    Complexidades insercao:
    Hash = m x 1
    Arvore = m x lg n
    Lista = m x n

    b)
    No(){
        public char letra;
        public Celula primeiro, ultimo;
        public boolean folha;
        
        public void inserir(String nome){
            inserir(nome, raiz, 0);
        }

        public void inserir(String nome, No no, int i){
            if(no == null){
                
            }
        }
    }
}
