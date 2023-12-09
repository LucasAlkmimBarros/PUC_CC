import java.util.*;

class Jogador {
    private int id;
    private String nome;
    private int altura;
    private int peso;
    private String universidade;
    private int anoNascimento;
    private String cidadeNascimento;
    private String estadoNascimento;

    Jogador() {
        id = -1;
        nome = "";
        altura = -1;
        peso = -1;
        universidade = "";
        anoNascimento = -1;
        cidadeNascimento = "";
        estadoNascimento = "";
    }

    Jogador(int id, String nome, int altura, int peso, String universidade, int anoNascimento, String cidadeNascimento,
            String estadoNascimento) {
        this.id = id;
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.universidade = universidade;
        this.anoNascimento = anoNascimento;
        this.cidadeNascimento = cidadeNascimento;
        this.estadoNascimento = estadoNascimento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getAltura() {
        return altura;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getPeso() {
        return peso;
    }

    public void setUniversidade(String universidade) {
        this.universidade = universidade;
    }

    public String getUniversidade() {
        return universidade;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setCidadeNascimento(String cidadeNascimento) {
        this.cidadeNascimento = cidadeNascimento;
    }

    public String getCidadeNascimento() {
        return cidadeNascimento;
    }

    public void setEstadoNascimento(String estadoNascimento) {
        this.estadoNascimento = estadoNascimento;
    }

    public String getEstadoNascimento() {
        return estadoNascimento;
    }

    public void imprimir() {
        System.out.println("[" + id + "] ## " + nome + " ## " + altura + " ## " + peso + " ## " + anoNascimento + " ## "
                + universidade + " ## " + cidadeNascimento + " ## " + estadoNascimento + " ##");
    }

    public void ler(String s) {
        String[] array = s.split(",", 8);
        this.id = Integer.parseInt(array[0]);
        this.nome = array[1].isEmpty() ? "nao informado" : array[1];
        this.altura = Integer.parseInt(array[2]);
        this.peso = Integer.parseInt(array[3]);
        this.universidade = array[4].isEmpty() ? "nao informado" : array[4];
        this.anoNascimento = Integer.parseInt(array[5]);
        this.cidadeNascimento = array[6].isEmpty() ? "nao informado" : array[6];
        this.estadoNascimento = array[7].isEmpty() ? "nao informado" : array[7];
    }

    public void clone(Jogador j) {
        this.id = j.id;
        this.nome = j.nome;
        this.altura = j.altura;
        this.peso = j.peso;
        this.universidade = j.universidade;
        this.anoNascimento = j.anoNascimento;
        this.cidadeNascimento = j.cidadeNascimento;
        this.estadoNascimento = j.estadoNascimento;
    }
}

class NoAN {
    public Jogador jogador;
    public boolean cor;
    public NoAN esq, dir;

    public NoAN() {
        this(new Jogador());
    }

    public NoAN(Jogador jogador) {
        this(jogador, false, null, null);
    }

    public NoAN(Jogador jogador, boolean cor) {
        this(jogador, cor, null, null);
    }

    public NoAN(Jogador jogador, boolean cor, NoAN esq, NoAN dir) {
        this.jogador = jogador;
        this.cor = cor;
        this.esq = esq;
        this.dir = dir;
    }
}

class ArvoreAN {
    public NoAN raiz;
    public int comparacoes = 0;

    public ArvoreAN() {
        raiz = null;
    }


    /**
     * Metodo para inserir elemento na arvore.
     * 
     * @param jogador Elemento a ser inserido.
     */
    public void inserir(Jogador jogador){
        if(raiz == null){ // 0 elementos
            raiz = new NoAN(jogador);
        }
        else if(raiz.esq == null && raiz.dir == null){ // 1 elemento
            if(jogador.getNome().compareTo(raiz.jogador.getNome()) < 0){
                raiz.esq = new NoAN(jogador);
            }
            else{
                raiz.dir = new NoAN(jogador);
            }
        }
        else if(raiz.esq == null){ // 2 elementos
            if(jogador.getNome().compareTo(raiz.jogador.getNome()) < 0){
                raiz.esq = new NoAN(jogador);
            }
            else if(jogador.getNome().compareTo(raiz.dir.jogador.getNome()) < 0){
                raiz.esq = new NoAN(raiz.jogador);
                raiz.jogador = jogador;
            }
            else{
                raiz.esq = new NoAN(raiz.jogador);
                raiz.jogador = raiz.dir.jogador;
                raiz.dir.jogador = jogador;
            }
            raiz.esq.cor = raiz.dir.cor = false;
        }
        else if(raiz.dir == null){ // 2 elementos
            if(jogador.getNome().compareTo(raiz.jogador.getNome()) > 0){
                raiz.dir = new NoAN(jogador);
            }
            else if(jogador.getNome().compareTo(raiz.esq.jogador.getNome()) > 0){
                raiz.dir = new NoAN(raiz.jogador);
                raiz.jogador = jogador;
            }
            else{
                raiz.dir = new NoAN(raiz.jogador);
                raiz.jogador = raiz.esq.jogador;
                raiz.esq.jogador = jogador;
            }
            raiz.esq.cor = raiz.dir.cor = false;
        }
        else{ // mais de 3 elementos
            inserir(jogador, null, null, null, raiz);
        }
        raiz.cor = false;
    }


    /**
     * Metodo recursivo para inserir elemento.
     * 
     * @param jogador Elemento a ser inserido.
     * @param bisavo NoAN bisavo
     * @param avo NoAN avo
     * @param pai NoAN pai
     * @param i NoAN filho
     */
    public void inserir(Jogador jogador, NoAN bisavo, NoAN avo, NoAN pai, NoAN i){
        if (i == null) {
            if (jogador.getNome().compareTo(pai.jogador.getNome()) < 0) {
                i = pai.esq = new NoAN(jogador, true);
            } else {
                i = pai.dir = new NoAN(jogador, true);
            }
            if (pai.cor == true) {
                balancear(bisavo, avo, pai, i);
            }
        } else {
            if (i.esq != null && i.dir != null && i.esq.cor == true && i.dir.cor == true) {
                i.cor = true;
                i.esq.cor = i.dir.cor = false;
                if (i == raiz) {
                    i.cor = false;
                } else if (pai.cor == true) {
                    balancear(bisavo, avo, pai, i);
                }
            }
            if (jogador.getNome().compareTo(i.jogador.getNome()) < 0) {
                inserir(jogador, avo, pai, i, i.esq);
            } else if (jogador.getNome().compareTo(i.jogador.getNome()) > 0) {
                inserir(jogador, avo, pai, i, i.dir);
            } else {
                System.out.println("Erro inserir (jogador repetido)!");
            }
        }
    }


    /**
     * Metodo para balancear a arvore apos insercao.
     * 
     * @param bisavo NoAN bisavo
     * @param avo NoAN avo
     * @param pai NoAN pai
     * @param i NoAN filho
     */
    public void balancear(NoAN bisavo, NoAN avo, NoAN pai, NoAN i) {
        if (pai.cor == true) {
            if (pai.jogador.getNome().compareTo(avo.jogador.getNome()) > 0) {
                if (i.jogador.getNome().compareTo(pai.jogador.getNome()) > 0) {
                    avo = rotacaoEsq(avo);
                } else {
                    avo = rotacaoDirEsq(avo);
                }
            } else {
                if (i.jogador.getNome().compareTo(pai.jogador.getNome()) < 0) {
                    avo = rotacaoDir(avo);
                } else {
                    avo = rotacaoEsqDir(avo);
                }
            }
            if (bisavo == null) {
                raiz = avo;
            } else {
                if (avo.jogador.getNome().compareTo(bisavo.jogador.getNome()) < 0) {
                    bisavo.esq = avo;
                } else {
                    bisavo.dir = avo;
                }
            }
            avo.cor = false;
            avo.esq.cor = avo.dir.cor = true;
        }
    }


    /**
     * Metodo para rotacionar a arvore a esquerda.
     * 
     * @param no NoAN no
     * @return NoAN no rotacionado
     */
    public NoAN rotacaoDir(NoAN no) {
        NoAN noEsq = no.esq;
        NoAN noEsqDir = noEsq.dir;

        noEsq.dir = no;
        no.esq = noEsqDir;

        return noEsq;
    }


    /**
     * Metodo para rotacionar a arvore a direita.
     * 
     * @param no NoAN no
     * @return NoAN no rotacionado
     */
    public NoAN rotacaoEsq(NoAN no) {
        NoAN noDir = no.dir;
        NoAN noDirEsq = noDir.esq;

        noDir.esq = no;
        no.dir = noDirEsq;
        return noDir;
    }


    /**
     * Metodo para rotacionar a arvore a direita e depois a esquerda.
     * 
     * @param no NoAN no
     * @return NoAN no rotacionado
     */
    public NoAN rotacaoDirEsq(NoAN no) {
        no.dir = rotacaoDir(no.dir);
        return rotacaoEsq(no);
    }


    /**
     * Metodo para rotacionar a arvore a esquerda e depois a direita.
     * 
     * @param no NoAN no
     * @return NoAN no rotacionado
     */
    public NoAN rotacaoEsqDir(NoAN no) {
        no.esq = rotacaoEsq(no.esq);
        return rotacaoDir(no);
    }


    /**
     * Metodo para pesquisar um elemento na arvore.
     * 
     * @param nome Nome do elemento a ser pesquisado.
     * @return <code>true</code> se o elemento estiver na arvore, <code>false</code> caso contrario.
     */
    public boolean pesquisar(String nome){
        return pesquisar(nome, raiz);
    }


    /**
     * Metodo para pesquisar um elemento na arvore.
     * 
     * @param nome Nome do elemento a ser pesquisado.
     * @param i NoAN no em analise.
     * @return <code>true</code> se o elemento estiver na arvore, <code>false</code> caso contrario.
     */
    public boolean pesquisar(String nome, NoAN i){
        boolean resp = false;
        comparacoes++;
        if(i != null && resp == false){
            comparacoes++;
            if(nome.compareTo(i.jogador.getNome()) == 0){
                resp = true;
            }
            else if(nome.compareTo(i.jogador.getNome()) < 0){
                comparacoes++;
                System.out.print("esq ");
                resp = pesquisar(nome, i.esq);
            }
            else{
                comparacoes++;
                System.out.print("dir ");
                resp = pesquisar(nome, i.dir);
            }
        }
        return resp;
    }
}

public class Q04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Jogador[] players = new Jogador[3923];
        Arq arq = new Arq();
        String str;
        arq.openRead("/tmp/players.csv");
        str = arq.readLine(); // Pular a primeira linha
        for (int i = 0; i < 3922; i++) {
            str = arq.readLine();
            players[i] = new Jogador();
            players[i].ler(str);
        }
        arq.close();

        int id;
        ArvoreAN playersClone = new ArvoreAN();

        String entrada = sc.nextLine();

        while (!(entrada.equals("FIM"))) {
            id = Integer.parseInt(entrada);
            playersClone.inserir(players[id]);
            

            entrada = sc.nextLine();
        }

        entrada = sc.nextLine(); // Lendo as linhas depois do FIM

        double inicio = System.currentTimeMillis();
        while (!(entrada.equals("FIM"))) {
            System.out.print(entrada + " raiz ");
            if(playersClone.pesquisar(entrada)){
                System.out.println("SIM");  
            }
            else{
                System.out.println("NAO");
            }
            entrada = sc.nextLine();
        }
        double fim = System.currentTimeMillis();
        double tempo = (fim - inicio) / 1000.0;
        sc.close();

        arq = new Arq();
        arq.openWrite("807205_avinegra.txt");
        arq.print("807205\t" + tempo + "\t" + playersClone.comparacoes);

        arq.close();
    }
}
