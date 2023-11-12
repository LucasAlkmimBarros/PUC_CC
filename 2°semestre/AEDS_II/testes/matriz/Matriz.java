import java.util.*;

public class Matriz {
    Celula inicio;
    private int linha, coluna;

    Matriz(){
        this(3,3);
    }
    
    Matriz(int linha, int coluna){
        this.linha = linha;
        this.coluna = coluna;

        criarMatriz();
    }

    public void criarMatriz(){
        inicio = new Celula();
        Celula tmp = inicio;

        //Primeira linha
        for(int i = 0; i < coluna-1; i++){
            tmp.dir = new Celula();
            tmp.dir.esq = tmp;

            tmp = tmp.dir;
        }

        //Outras linhas
        Celula linhaAnterior = inicio;
        for(int i = 0; i < linha-1; i++){
            linhaAnterior.inf = new Celula();
            linhaAnterior.inf.sup = linhaAnterior;

            linhaAnterior = linhaAnterior.inf;
            tmp = linhaAnterior;
            for(int j = 0; j < coluna-1; j++){
                tmp.dir = new Celula();
                tmp.dir.esq = tmp;
                tmp.dir.sup = tmp.sup.dir;
                tmp.dir.sup.inf = tmp.dir;

                tmp = tmp.dir;
            }
        }
    }

    public void inserir(){
        Scanner sc = new Scanner(System.in);

        Celula tmp = inicio;
        Celula linhaAnterior = inicio;

        for(int i = 0; i < linha; i++){
            for(int j = 0; j < coluna; j++){
                tmp.elemento = sc.nextInt();
                tmp = tmp.dir;
            }
            linhaAnterior = linhaAnterior.inf;
            tmp = linhaAnterior;
        }

        sc.close();
    }

    public void mostrar(){
        Celula tmp = inicio;
        Celula linhaAnterior = inicio;

        for(int i = 0; i < linha; i++){
            for(int j = 0; j < coluna; j++){
                System.out.print(tmp.elemento + " ");
                tmp = tmp.dir;
            }
            linhaAnterior = linhaAnterior.inf;
            tmp = linhaAnterior;
            System.out.println("");
        }
    }

    
}
