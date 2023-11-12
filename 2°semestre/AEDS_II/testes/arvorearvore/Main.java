public class Main {
    public static void main(String[] args){
        ArvoreArvore arvore = new ArvoreArvore();

        arvore.inserir("lucas");
        arvore.inserir("luciano");
        arvore.inserir("lucia");
        arvore.inserir("rafael");
        arvore.inserir("rafaela");
        arvore.inserir("jose");
        arvore.inserir("ana");
        arvore.inserir("maria");
        arvore.inserir("joao");
        arvore.inserir("wesley");
        arvore.inserir("weslley");
        arvore.inserir("yuri");
        arvore.inserir("yure");
        arvore.inserir("yago");

        // arvore.mostrar();

        String[] array = new String[50];
        arvore.treeSort(array);

        for(int i = 0; array[i] != null; i++){
            System.out.println(array[i]);
        }

    }
}
