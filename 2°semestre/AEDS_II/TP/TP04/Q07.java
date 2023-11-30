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

class Hash {
    public Jogador[] tabela;
    public int m1, m2, m, reserva;

    Hash(){
        this(21, 9);
    }

    Hash(int m1, int m2){
        this.m1 = m1;
        this.m2 = m2;
        this.m = m1 +  m2;
        this.tabela = new Jogador[this.m];

        reserva = 0;
    }

    public int h(Jogador jogador){
        return jogador.getAltura() % m1;
    }

    public boolean inserir(Jogador jogador){
        boolean resp = false;
        if(jogador != null){
            int pos = h(jogador);

            if(tabela[pos] == null){
                tabela[pos] = jogador;
                resp = true;
            }
            else if(reserva < m2){ // Se tiver espaco na reserva
                tabela[m1 + reserva] = jogador;
                reserva++;
                resp = true;
            }
        }
        return resp;
    }

    public boolean pesquisar(String nome){
        boolean resp = false;
        for(int i = 0; i < m; i++){
            if(tabela[i] != null){
                if(tabela[i].getNome().equals(nome)){
                    resp = true;
                }
            }
        }

        return resp;
    }
}
public class Q07 {
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

        Hash playersClone = new Hash();
        String entrada;
        int id;

        entrada = sc.nextLine();

        while(!(entrada.equals("FIM"))){
            id = Integer.parseInt(entrada);
            playersClone.inserir(players[id]);

            entrada = sc.nextLine();
        }

        entrada = sc.nextLine();

        while(!(entrada.equals("FIM"))){
            System.out.print(entrada);
            if(playersClone.pesquisar(entrada)){
                System.out.println(" SIM");
            }
            else{
                System.out.println(" NAO");
            }

            entrada = sc.nextLine();
        }

        arq.openWrite("807205_hashReserva.txt");
        arq.print("807205");
        arq.close();
    }
}
