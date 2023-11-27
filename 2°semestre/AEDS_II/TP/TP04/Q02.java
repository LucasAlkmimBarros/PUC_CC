import java.util.*;

import javax.swing.JOptionPane;

import java.time.LocalDateTime;

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

class No {
    public No esq;
    public No dir;
    public int chave;
    public Arvore arvore;

    public No(int chave) {
        this(chave, null, null);
    }

    public No(int chave, No esq, No dir) {
        this.chave = chave;
        this.esq = esq;
        this.dir = dir;
        this.arvore = new Arvore();
    }
}

class No2 {
    public No2 esq;
    public No2 dir;
    public String nome;

    No2() {
        this("");
    }

    No2(String nome) {
        this.nome = nome;
        this.esq = this.dir = null;
    }

}

class ArvoreArvore {
    No raiz;

    ArvoreArvore() {
        // 7, 3, 11, 1, 5, 9, 13, 0, 2, 4, 6, 8, 10, 12 e 14
        inserir(7);
        inserir(3);
        inserir(11);
        inserir(1);
        inserir(5);
        inserir(9);
        inserir(13);
        inserir(0);
        inserir(2);
        inserir(4);
        inserir(6);
        inserir(8);
        inserir(10);
        inserir(12);
        inserir(14);

    }

    public void inserir(int chave) { // Primeira chamada inserir chave
        raiz = inserir(chave, raiz);
    }

    public No inserir(int chave, No i) { // Inserir chave
        if (i == null) {
            i = new No(chave);
        } else {
            if (chave < i.chave) {
                i.esq = inserir(chave, i.esq);
            } else if (chave > i.chave) {
                i.dir = inserir(chave, i.dir);
            }
        }

        return i;
    }

    public void inserir(Jogador j) { // Primeira chamada inserir jogador
        raiz = inserir(j, raiz);
    }

    public No inserir(Jogador j, No i) { // Encontrar a árvore certa para inserir o jogador
        if (i != null) {
            int chave = j.getAltura() % 15;
            if (i.chave > chave) {
                i.esq = inserir(j, i.esq);
            } else if (i.chave < chave) {
                i.dir = inserir(j, i.dir);
            } else {
                i.arvore.raiz = inserir(j.getNome(), i.arvore.raiz);
            }
        }

        return i;
    }

    public No2 inserir(String nome, No2 i) { // Inserir nome
        if (i == null) {
            i = new No2(nome);
        } else {
            if (nome.compareTo(i.nome) < 0) {
                i.esq = inserir(nome, i.esq);
            } else if (nome.compareTo(i.nome) > 0) {
                i.dir = inserir(nome, i.dir);
            }
        }

        return i;
    }

    public boolean mostrar(String nome) {
        System.out.print(nome + " raiz");
        return mostrar(nome, raiz);
    }

    public boolean mostrar(String nome, No i) {
        boolean resp = false;
        if (i != null) {
            if (!resp) {
                resp = mostrar(nome, i.arvore.raiz);
            }
            if (!resp) {
                System.out.print(" esq");
                resp = mostrar(nome, i.esq);
            }
            if (!resp) {
                System.out.print(" dir");
                resp = mostrar(nome, i.dir);
            }
        }

        return resp;
    }

    public boolean mostrar(String nome, No2 i) {
        boolean resp = false;
        if (i != null) {
            if (nome.equals(i.nome)) {
                resp = true;
            } else {
                System.out.print(" ESQ");
                resp = mostrar(nome, i.esq);
                if (!resp) {
                    System.out.print(" DIR");
                    resp = mostrar(nome, i.dir);
                }
            }
        }

        return resp;
    }

}

    class Arvore {
        No2 raiz;

        Arvore() {
            raiz = null;
        }
    }

class Q02 {

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
        ArvoreArvore playersClone = new ArvoreArvore();

        String entrada = sc.nextLine();

        while (!(entrada.equals("FIM"))) {
            id = Integer.parseInt(entrada);
            playersClone.inserir(players[id]);

            entrada = sc.nextLine();
        }

        entrada = sc.nextLine();


        while (!(entrada.equals("FIM"))) {
            if (playersClone.mostrar(entrada)) {
                System.out.println(" SIM");
            } else {
                System.out.println(" NAO");
            }

            entrada = sc.nextLine();
        }

        sc.close();
    }
}

