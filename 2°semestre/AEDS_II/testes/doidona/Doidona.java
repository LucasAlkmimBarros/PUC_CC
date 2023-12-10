public class Doidona {
    final int TAMT1 = 3;
    final int TAMT3 = 3;
    final int NULO = -0x7FFFFF;

    int[] t1;
    int[] t3;

    Arvore a1;
    Arvore a2;
    Lista l1;

    public Doidona(){
        t1 = new int [TAMT1];
        t3 = new int [TAMT3];

        for(int i = 0; i < TAMT1; i++){
            t1[i] = NULO;
        }
        for(int i = 0; i < TAMT3; i++){
            t3[i] = NULO;
        }

        a1 = new Arvore();
        a2 = new Arvore();
        l1 = new Lista();
    }

    public int hashT1(int elemento){
        return elemento % TAMT1;
    }

    public int hashT2(int elemento){
        return elemento % 3;
    }

    public int hashT3(int elemento){
        return elemento % TAMT3;
    }

    public int rehashT3(int elemento){
        return (elemento + 1) % TAMT3;
    }

    public void inserir(int x){
        int pos = hashT1(x);
        if(t1[pos] == NULO){
            t1[pos] = x;
        }
        else{ //Ja tem na T1
            pos = hashT2(x);
            if(pos == 0){
                pos = hashT3(x);
                if(t3[pos] == NULO){
                    t3[pos] = x;
                }
                else{ // Ja tem na T3
                    pos = rehashT3(x);
                    if(t3[pos] == NULO){
                        t3[pos] = x;
                    }
                    else{ // Ja tem na rehash T3
                        a1.inserir(x);
                    }
                }
            }
            else if(pos == 1){
                l1.inserir(x);
            }
            else{
                a2.inserir(x);
            }
        }
    }

    public boolean pesquisar(int x){
        boolean resp = true;
        int pos = hashT1(x);
        if(t1[pos] == x){
            resp = true;
        }
        else{ // Nao ta na T1
            pos = hashT2(x);
            if(pos == 0){
                pos = hashT3(x);
                if(t3[pos] == x){
                    resp = true;
                }
                else{ // Nao ta na T3
                    resp = a1.pesquisar(x);
                }
            }
            else if(pos == 1){
                resp = l1.pesquisar(x);
            }
            else if(pos == 2){
                resp = a2.pesquisar(x);
            }
        }

        return resp;
    }

    public void mostrar(){
        System.out.println("T1:");
        for(int i = 0; i < TAMT1; i++){
            if(t1[i] != NULO){
                System.out.println(t1[i]);
            }
        }
        System.out.println("T3:");
        for(int i = 0; i < TAMT3; i++){
            if(t3[i] != NULO){
                System.out.println(t3[i]);
            }
        }
        System.out.println("A1:");
        a1.mostrar();
        System.out.println("L1:");  
        l1.mostrar();
        System.out.println("A2:");
        a2.mostrar();
    }

    public void remover(int x){
        int pos = hashT1(x);
        if(t1[pos] == x){
            t1[pos] = NULO;
        }
        else{ // Nao ta na T1
            pos = hashT2(x);
            if(pos == 0){
                pos = hashT3(x);
                if(t3[pos] == x){
                    t3[pos] = NULO;
                }
                else{ // Nao ta na T3
                    a1.remover(x);
                }
            }
            else if(pos == 1){
                l1.remover(x);
            }
            else if(pos == 2){
                a2.remover(x);
            }
        }
    }
}
