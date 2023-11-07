class Celula{
    public int elemento;
    public Celula sup, inf, dir, esq;

    Celula(){
        this(0);
    }

    Celula(int e){
        this(e, null, null, null, null);
    }

    Celula(int e, Celula sup, Celula inf, Celula dir, Celula esq){
        elemento = e;
        this.sup = sup;
        this.inf = inf;
        this.dir = dir;
        this.esq = esq;
    }
}

class Matriz{
    public Celula inicio;
    public int linha, coluna;

    Matriz(){
        this(3, 3);
    }

    Matriz(int l, int c){
        linha = l;
        coluna = c;

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
        Celula k;
        tmp = inicio;

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
        Celula tmp = inicio;
        Celula linhaAnterior = inicio;

        for(int i = 0; i < linha; i++){
            for(int j = 0; j < coluna; j++){
                tmp.elemento = MyIO.readInt();
                tmp = tmp.dir;
            }
            linhaAnterior = linhaAnterior.inf;
            tmp = linhaAnterior;
        }
    }

    public void mostrar(int l, int c){
        linha = l;
        coluna = c;
        Celula tmp = inicio;
        Celula linhaAnterior = inicio;

        for(int i = 0; i < linha; i++){
            for(int j = 0; j < coluna; j++){
                MyIO.print(tmp.elemento + " ");
                tmp = tmp.dir;
            }
            linhaAnterior = linhaAnterior.inf;
            tmp = linhaAnterior;
            MyIO.println("");
        }
    }

    public void mostrarDiagonalPrincipal(){
        Celula tmp = inicio;

        while(tmp != null){
            MyIO.print(tmp.elemento + " ");
            tmp = tmp.dir;
            if(tmp != null){
                tmp = tmp.inf;
            }
        }
        MyIO.println("");
    }

    public void mostrarDiagonalSecundaria(){
        Celula tmp = inicio;
        while(tmp.dir != null){ // Anda para a direita
            tmp = tmp.dir;
        }
        while(tmp != null){
            MyIO.print(tmp.elemento + " ");
            tmp = tmp.esq;
            if(tmp != null){
                tmp = tmp.inf;
            }
        }
    }

    public Matriz soma(Matriz m2){
        Matriz m3 = new Matriz();
        Celula tmp = this.inicio;
        Celula tmp2 = m2.inicio;
        Celula tmp3 = m3.inicio;
        Celula linhaAnterior = this.inicio;
        Celula linhaAnterior2 = m2.inicio;
        Celula linhaAnterior3 = m3.inicio;

        for(int i = 0; i < linha; i++){
            for(int j = 0; j < coluna; j++){
                tmp3.elemento = tmp.elemento + tmp2.elemento;
                tmp = tmp.dir;
                tmp2 = tmp2.dir;
                tmp3 = tmp3.dir;
            }
            linhaAnterior = linhaAnterior.inf;
            linhaAnterior2 = linhaAnterior2.inf;
            linhaAnterior3 = linhaAnterior3.inf;
            tmp = linhaAnterior;
            tmp2 = linhaAnterior2;
            tmp3 = linhaAnterior3;
        }

        return m3;
    }

    public Matriz multiplica(Matriz m2){
        Matriz m3 = new Matriz();
        Celula tmp = this.inicio;
        Celula tmp2 = m2.inicio;
        Celula tmp3 = m3.inicio;
        Celula linhaAnterior = this.inicio;
        Celula linhaAnterior2 = m2.inicio;
        Celula linhaAnterior3 = m3.inicio;

        for(int i = 0; i < linha; i++){
            for(int j = 0; j < coluna; j++){
                tmp3.elemento = tmp.elemento * tmp2.elemento;
                tmp = tmp.dir;
                tmp2 = tmp2.dir;
                tmp3 = tmp3.dir;
            }
            linhaAnterior = linhaAnterior.inf;
            linhaAnterior2 = linhaAnterior2.inf;
            linhaAnterior3 = linhaAnterior3.inf;
            tmp = linhaAnterior;
            tmp2 = linhaAnterior2;
            tmp3 = linhaAnterior3;
        }

        return m3;
    }

}

class Q09 {
    public static void main(String[] args){
        int n = MyIO.readInt();
        for(int i = 0; i < n; i++){
            int l = MyIO.readInt();
            int c = MyIO.readInt();
            Matriz m1 = new Matriz(l, c);
            m1.inserir();
            m1.mostrarDiagonalPrincipal();
            m1.mostrarDiagonalSecundaria();

            l = MyIO.readInt();
            c = MyIO.readInt();
            Matriz m2 = new Matriz(l, c);
            m2.inserir();

            Matriz m3 = m1.soma(m2);
            m3.mostrar(l, c);

            m3 = m1.multiplica(m2);
            m3.mostrar(l, c);

        }

    }
}
