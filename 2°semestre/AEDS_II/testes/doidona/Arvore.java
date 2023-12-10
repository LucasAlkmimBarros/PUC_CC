public class Arvore {
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
        else{
            if(x < no.elemento){
                no.esq = inserir(x, no.esq);
            }
            else if(x > no.elemento){
                no.dir = inserir(x, no.dir);
            }
            else{
                System.out.println("Elemento ja existe!");
            }
        }

        return no;
    }

    public boolean pesquisar(int x){
        return pesquisar(x, raiz);
    }

    public boolean pesquisar(int x, No no){
        boolean resp = false;
        if(no != null){
            if(x == no.elemento){
                resp = true;
            }
            else if(x < no.elemento){
                resp = pesquisar(x, no.esq);
            }
            else{
                resp = pesquisar(x, no.dir);
            }
        }

        return resp;
    }

    public void mostrar(){
        mostrar(raiz);
        System.out.println();
    }

    public void mostrar(No no){
        if(no != null){
            System.out.print(no.elemento + " ");
            mostrar(no.esq);
            mostrar(no.dir);
        }
    }

    public void remover(int x){
        raiz = remover(x, raiz);
    }

    public No remover(int x, No no){
        if(no != null){
            if(x < no.elemento){
                no.esq = remover(x, no.esq);
            }
            else if(x > no.elemento){
                no.dir = remover(x, no.dir);
            }
            else if(no.dir == null){
                no = no.esq;
            }
            else if(no.esq == null){
                no = no.dir;
            }
            else{
                no.esq = maiorEsq(no, no.esq);
            }
        }

        return no;
    }

    private No maiorEsq(No i, No j) {

          if (j.dir == null) {
              i.elemento = j.elemento; 
              j = j.esq;
  
          } else {
              j.dir = maiorEsq(i, j.dir);
          }
          return j;
      }  
}
