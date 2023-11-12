public class Arvore {
    public No raiz;

    Arvore(){
        raiz = null;
    }

    public void inserir(int x){
        raiz = inserir(x, raiz);
    }

    public No inserir(int x, No i){
        if(i == null){
            i = new No(x);
        } else if(x < i.elemento){
            i.esq = inserir(x, i.esq);
        } else if(x > i.elemento){
            i.dir = inserir(x, i.dir);
        } else{
            System.out.println("ERRO! ELEMENTO JA CADASTRADO!");
        }
        return i;
    }

    void inserirPai(int x){
        if(raiz == null){
            raiz = new No(x);
        } else if (x < raiz.elemento){
            inserirPai(x, raiz.esq, raiz);
        } else if (x > raiz.elemento){
            inserirPai(x, raiz.dir, raiz);
        } else{
            System.out.println("ERRO! ELEMENTO JA CADASTRADO!");
        }
    }

    void inserirPai(int x, No i, No pai){
        if(i == null){
            if(x < pai.elemento){
                pai.esq = new No(x);
            } else{
                pai.dir = new No(x);
            }
        } else if(x < i.elemento){
            inserirPai(x, i.esq, i);
        } else if(x > i.elemento){
            inserirPai(x, i.dir, i);
        } else{
            System.out.println("ERRO! ELEMENTO JA CADASTRADO!");
        }
    }

    boolean pesquisar(int x){
        return pesquisar(x, raiz);
    }

    boolean pesquisar(int x, No i){
        boolean resp;
        if(i == null){
            resp = false;
        } else if(x < i.elemento){
            resp = pesquisar(x, i.esq);
        } else if(x > i.elemento){
            resp = pesquisar(x, i.dir);
        } else{
            resp = true;
        }

        return resp;
    }

    void caminharCentral(){ 
        caminharCentral(raiz);
    }

    void caminharCentral(No i){
        if(i != null){
            caminharCentral(i.esq);
            System.out.println(i.elemento + " ");
            caminharCentral(i.dir);
        }
    }
    void caminharPre(){ 
        caminharPre(raiz);
    }

    void caminharPre(No i){
        if(i != null){
            System.out.println(i.elemento + " ");
            caminharPre(i.esq);
            caminharPre(i.dir);
        }
    }

    void caminharPos(){ 
        caminharPos(raiz);
    }

    void caminharPos(No i){
        if(i != null){
            caminharPos(i.esq);
            caminharPos(i.dir);
            System.out.println(i.elemento + " ");
        }
    }
    void remover(int x) { 
        raiz = remover(x, raiz);
    }

    No remover(int x, No i){
        if(i == null){
            System.out.println("ELEMENTO INEXISTENTE");
        } else if(x < i.elemento){
            i = remover(x, i.esq);
        } else if(x > i.elemento){
            i = remover(x, i.dir);
        } else if(i.esq == null){
            i = i.dir;
        } else if(i.dir == null){
            i = i.esq;
        } else{
            i.esq = maiorEsq(i, i.esq);
        }

        return i;
    }

    No maiorEsq(No i, No j){
        if(j.dir == null){
            i.elemento = j.elemento;
            j = j.esq;
        } else{
            j.dir = maiorEsq(i, j.dir);
        }

        return j;
    }

    int removerMaiorEsq(int x){
        return removerMaiorEsq(x, raiz);
    }

    int removerMaiorEsq(int x, No i){
        if(i == null){
            System.out.println("Elemento na existe!");
            return 0;

        } else if (x < i.elemento){
            return removerMaiorEsq(x, i.esq);

        } else if (x > i.elemento){
            return removerMaiorEsq(x, i.dir);

        } else{
            return removerMaior(i.esq, i);
        }
    }

    int removerMaior(No i, No pai){
        int resp = 0;
        if(i.dir == null){ 
            resp = i.elemento;
            pai.dir = i.esq;
        } else{
            pai = i;
            i = i.dir;
            resp = removerMaior(i, pai);
        }

        return resp;
    }
}
