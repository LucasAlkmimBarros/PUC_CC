public class Testes {
    public static void main(String[] args){
        //Arvore
        Arvore arvore = new Arvore();
        arvore.inserir(7);
        arvore.inserir(3);
        arvore.inserir(11);
        arvore.inserir(1);
        arvore.inserir(5);
        arvore.inserir(4);
        arvore.inserir(20);
        arvore.inserir(0);
        arvore.inserir(2);
        arvore.inserir(9);
        arvore.inserir(13);

        arvore.caminharCentral();

        System.out.println("Removendo o maior na esquerda do 11: " + arvore.removerMaiorEsq(11));

        arvore.caminharCentral();
    }
}

