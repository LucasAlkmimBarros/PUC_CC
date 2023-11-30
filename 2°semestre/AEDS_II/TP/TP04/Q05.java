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

class No{
    public Jogador jogador;
    public No esq;
    public No dir;

    No(){
        this(new Jogador());
    }

    No(Jogador jogador){
        this.jogador = jogador;
        this.esq = this.dir = null;
    }
}

class Arvore{
    public No raiz;
    public int comparacoes;

    Arvore(){
        raiz = null;
    }

    public void inserir(Jogador jogador){
        raiz = inserir(jogador, raiz);
    }

    public No inserir(Jogador jogador, No i){
        if(i != null){
            if(i.jogador.getNome().compareTo(jogador.getNome()) > 0){
                comparacoes++;
                i.esq = inserir(jogador, i.esq);
            }
            else if(i.jogador.getNome().compareTo(jogador.getNome()) < 0){
                comparacoes+= 2;
                i.dir = inserir(jogador, i.dir);
            }
            else{
                comparacoes += 2;
            }
        }
        else{
            i = new No(jogador);
        }

        return i;
    }

    public void treeSort(Jogador[] players){
        treeSort(raiz, players);
    }

    public void treeSort(No i, Jogador[] players){
        if(i != null){
            treeSort(i.esq, players);
            System.out.println(i.jogador.getNome());
            treeSort(i.dir, players);
        }
    }
}


public class Q05 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Jogador[] players = new Jogador[3923];
        Arq arq = new Arq();
        String str;
        arq.openRead("/tmp/players.csv");
        str = arq.readLine(); //Pular a primeira linha
        for(int i = 0; i < 3922; i++){
            str = arq.readLine();
            players[i] = new Jogador();
            players[i].ler(str);
        }
        arq.close();

        int id;
        Jogador[] playersClone = new Jogador[3923];
        int pos = 0;

        String entrada = sc.nextLine();

        while(!(entrada.equals("FIM"))){
            id = Integer.parseInt(entrada);
            playersClone[pos] = new Jogador();
            playersClone[pos] = players[id];
            pos++;

            entrada = sc.nextLine();
        }

        entrada = sc.nextLine(); //Lendo as linhas depois do FIM
 
        while(!(entrada.equals("FIM"))){
            entrada = sc.nextLine();
        }

        sc.close();

        Arvore arvore = new Arvore();

        for(int i = 0; i < pos; i++){ //Inserindo o array na arvore
            arvore.inserir(playersClone[i]);
        }

        arvore.treeSort(playersClone);

        arq = new Arq();
        arq.openWrite("807205_treesort.txt");
        arq.print(arvore.comparacoes);

        arq.close();
    }
}
