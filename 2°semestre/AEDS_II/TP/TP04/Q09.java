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

class Celula{
    public Jogador elemento;
    public Celula prox; 

    Celula() {
        this(null);
    }

    Celula(Jogador elemento) {
        this.elemento = elemento;
        this.prox = null;
    }
}

class Lista {
    public Jogador[] array;
    public int n;
    public Celula primeiro, ultimo; 

    Lista () {
        this(10);
    }

    Lista (int tamanho){
        array = new Jogador[tamanho];
        n = 0;
        primeiro = new Celula();
        ultimo = primeiro;
    }

    public void inserirFim(Jogador jogador){
        array[n] = jogador;
        n++;
    }

    public Jogador removerFim() throws Exception {
        if (n == 0) {
            throw new Exception("Erro ao remover!");
        }

        Jogador resp = array[n - 1];
        n--;

        return resp;
    }

    
}

class Hash {
    public Lista[] tabela;
    public int m;

    Hash() {
        this(25);
    }

    Hash(int m) {
        this.m = m;
        this.tabela = new Lista[this.m];
        preenchendoTabela();
    }

    public void preenchendoTabela() {
        for (int i = 0; i < m; i++) {
            tabela[i] = new Lista();
        }
    }

    public int h(Jogador jogador) {
        int pos = jogador.getAltura() % m;
        return pos;
    }

    public boolean inserir(Jogador jogador) {
        boolean resp = false;
        if (jogador != null) {
            int pos = h(jogador);

            tabela[pos].inserirFim(jogador);
            resp = true;
        }
        return resp;
    }

    public boolean pesquisar(String nome) {
        boolean resp = false;
        for (int i = 0; i < m; i++) {
            for(int j = 0; j < tabela[i].n; j++){
                if(tabela[i].array[j].getNome().equals(nome)){
                    resp = true;
                }
            }
        }

        return resp;
    }
}

public class Q09{
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

        Hash playersClone = new Hash();
        String entrada;
        int id;

        entrada = sc.nextLine();

        while (!(entrada.equals("FIM"))) {
            id = Integer.parseInt(entrada);
            playersClone.inserir(players[id]);

            entrada = sc.nextLine();
        }

        entrada = sc.nextLine();

        while (!(entrada.equals("FIM"))) {
            System.out.print(entrada);
            if (playersClone.pesquisar(entrada)) {
                System.out.println(" SIM");
            } else {
                System.out.println(" NAO");
            }

            entrada = sc.nextLine();
        }

        arq.openWrite("807205_hashIndireta.txt");
        arq.print("807205");
        arq.close();
    }
}
