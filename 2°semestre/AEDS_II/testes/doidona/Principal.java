public class Principal {
    public static void main(String[] args){
        Doidona doida = new Doidona();
        doida.inserir(7);
        doida.inserir(3);
        doida.inserir(10);
        doida.inserir(1);
        doida.inserir(5);
        doida.inserir(8);
        doida.inserir(12);
        doida.inserir(0);
        doida.inserir(2);
        doida.inserir(4);

        doida.mostrar();

        System.out.println("Pesquisar 7: " + doida.pesquisar(7));
        System.out.println("Pesquisar 17: " + doida.pesquisar(17));

        doida.remover(7);

        doida.mostrar();

        System.out.println("Pesquisar 7: " + doida.pesquisar(7));
    }
}
