public class ArvoreArvore {
    public No raiz;

    ArvoreArvore(){
        raiz = null;

        //inserindo para que fique balanceada
        inserir('m');
        inserir('f');
        inserir('t');
        inserir('a');
        inserir('d');
        inserir('i');
        inserir('o');
        inserir('w');
        inserir('b');
        inserir('c');
        inserir('e');
        inserir('g');
        inserir('h');
        inserir('j');
        inserir('k');
        inserir('l');
        inserir('n');
        inserir('p');
        inserir('q');
        inserir('r');
        inserir('s');
        inserir('u');
        inserir('v');
        inserir('x');
        inserir('y');
        inserir('z');
    }

    public void inserir(char letra){
        raiz = inserir(letra, raiz);
    }

    public No inserir(char letra, No i){
        if(i == null){
            i = new No(letra);

        } else if(letra < i.letra){
            i.esq = inserir(letra, i.esq);

        } else if(letra > i.letra){
            i.dir = inserir(letra, i.dir);

        } else {
            System.out.println("Letra já existe!");
        }

        return i;
    }

    public void inserir(String palavra){
        inserir(palavra, raiz);
    }

    public void inserir(String palavra, No i){
        if(i == null){
            System.out.println("ERRO! Letra não existe!");

        } else if(palavra.charAt(0) < i.letra){
            inserir(palavra, i.esq);

        } else if(palavra.charAt(0) > i.letra){
            inserir(palavra, i.dir);

        } else{
            i.raiz2 = inserir(palavra, i.raiz2);
        }
    }

    public No2 inserir(String palavra, No2 i){
        if(i == null){
            i = new No2(palavra);

        } else if(palavra.compareTo(i.palavra) < 0){
            i.esq = inserir(palavra, i.esq);

        } else if(palavra.compareTo(i.palavra) > 0){
            i.dir = inserir(palavra, i.dir);

        } else {
            System.out.println("ERRO! Palavra ja existe!");
        }

        return i;   
    }

    public void mostrar(){
        mostrar(raiz);
    }

    public void mostrar(No i){
        if(i != null){
            mostrar(i.esq);
            mostrar(i.raiz2);
            mostrar(i.dir);
        }
    }

    public void mostrar(No2 i){
        if(i != null){
            mostrar(i.esq);
            System.out.println(i.palavra);
            mostrar(i.dir);
        }
    }

    public int contarPalavras(char primeiro, char ultimo){
        return contarPalavras(primeiro, ultimo, raiz);
    }

    public int contarPalavras(char primeiro, char ultimo, No i){
        if(i == null){
            System.out.println("ERRO! LETRA NAO EXISTE");
            return 0;
        
        } else if(primeiro < i.letra){
            return contarPalavras(primeiro, ultimo, i.esq);
        
        } else if(primeiro > i.letra){
            return contarPalavras(primeiro, ultimo, i.dir);
        } else{
           return contarPalavras(primeiro, ultimo, i.raiz2);
        }
    }

    public int contarPalavras(char primeiro, char ultimo, No2 i){
        int resp  = 0;
        if(i != null){
            if(i.palavra.charAt(i.palavra.length()-1) == ultimo){
                resp++;
            }
            resp += contarPalavras(primeiro, ultimo, i.esq);
            resp += contarPalavras(primeiro, ultimo, i.dir);
        }
        return resp;
    }

    //TreeSort
    public void treeSort(String[] array){
        treeSort(array, raiz);
    }

    public void treeSort(String[] array, No i){
        if(i != null){
            treeSort(array, i.esq);
            treeSort(array, i.raiz2);
            treeSort(array, i.dir);
        }
    }

    public void treeSort(String[] array, No2 i){
        if(i != null){
            treeSort(array, i.esq);
            int x = 0;
            while(array[x] != null){
                x++;
            }
            array[x] = i.palavra;
            treeSort(array, i.dir);
        }
    }
}
