public class Testes {
    public static void main(String[] args){
        //Arvore
        Arvore arvore = new Arvore();
        arvore.inserir(7);
        arvore.inserir(3);
        arvore.inserir(11);
        arvore.inserir(1);
        arvore.inserir(5);
        arvore.inserirPai(9);
        arvore.inserirPai(13);

        arvore.caminharCentral();

        arvore.remover(7);
        
        System.out.println("Removendo 7");
        arvore.caminharCentral();
    }
}
