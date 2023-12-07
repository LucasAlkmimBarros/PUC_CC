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
	public No[] prox;
	public int tam;
	public char letra;
	public boolean folha;

	No(){
		this(' ');
	}

	No(char letra){
		this.letra = letra;
		this.tam = 255;
		this.folha = false;
		prox = new No[tam];

		for(int i = 0; i < prox.length; i++){
			prox[i] = null;
		}
	}

	public int hash(char c){
		return (int) c;
	}
}

class ArvoreTRIE{
	public No raiz;
	public int comparacoes;
	
	ArvoreTRIE(){
		this.raiz = new No();
		this.comparacoes = 0;
	}


	/**
	 * Primeira chamada para a insercao
	 *
	 * @param nome nome que sera inserido
	 **/
	public void inserir(String nome){
		inserir(nome, raiz, 0);
	}


	/**
	 * Chamadas recursivas da insercao
	 *
	 * @param nome nome que sera inserido
	 * @param no no que estamos no momento
	 * @param i contador que marca a posicao da leta a ser inserida
	 */
	public void inserir(String nome, No no, int i){
		if(no.prox[nome.charAt(i)] == null){  //Caso nao tenha a letra
			no.prox[nome.charAt(i)] = new No(nome.charAt(i));

			if(i == nome.length() - 1){
				no.prox[nome.charAt(i)].folha = true;
			}
			else{
				inserir(nome, no.prox[nome.charAt(i)], i + 1);
			}

		}
		else{ //Caso ja tenha a letra 
			if(no.prox[nome.charAt(i)].folha == false && i < nome.length() - 1){
				inserir(nome, no.prox[nome.charAt(i)], i + 1);
			}
		}
	}
	

	/**
	 * Primeira chamda da pesquisa
	 *
	 * @param nome nome que sera pesquisado
	 *
	 * @return true se a palavra existir
	 * 	   false se a palavra nao existir
	 */
	public boolean pesquisar(String nome){
		return pesquisar(nome, raiz, 0);
	}


	/**
	 * Chamadas recursivas da pesquisa
	 *
	 * @param nome nome que sera pesquisado
	 * @param no no que estamos no momento
	 * @param i contador que marca a posicao da letra a ser inserida
	 *
	 * @return true se a palavra existir
	 * 	   false se a palavra nao existir
	 */
	public boolean pesquisar(String nome, No no, int i){
		boolean resp = false;
		comparacoes++;
		if(no.prox[nome.charAt(i)] == null){
			resp = false;
		}
		else if(i == nome.length() - 1){
			comparacoes++;
			resp = (no.prox[nome.charAt(i)].folha == true);
		}
		else if(i < nome.length() - 1){
			comparacoes += 2;
			resp = pesquisar(nome, no.prox[nome.charAt(i)], i + 1);
		}
		else{
			comparacoes += 2;
		}
		return resp;
	}
	

	/**
	 * Primeira chamada da remocao
	 *
	 * @param nome nome que sera removido
	 */
	public void mostrar(){
		mostrar("", raiz);
	}


	/**
	 * Chamadas recursivas da remocao
	 *
	 * @param nome nome que sera removido
	 * @param no no que estamos no momento
	 */
	public void mostrar(String nome, No no){
		if(no.folha == true){
			System.out.println(nome + no.letra);
		}
		else {
			for(int i = 0; i < no.prox.length; i++){
				if(no.prox[i] != null){
					mostrar(nome + no.letra, no.prox[i]);
				}
			}

		}	
	}

	public void concatenar(ArvoreTRIE a1, ArvoreTRIE a2){
		concatenar(a1, a2.raiz, "");
	}

	public void concatenar(ArvoreTRIE a1, No no, String nome){
		if(no.folha == true){
			nome += no.letra;
			if(nome.charAt(0) == ' '){ //Removendo o espaco do inicio
                		nome = nome.substring(1);
            		}
			a1.inserir(nome);
		}
		else{
			for(int i = 0; i < no.prox.length; i++){
				if(no.prox[i] != null){
					concatenar(a1, no.prox[i], nome + no.letra);
				}
			}
		}
	}
}

public class Q06 {
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
        ArvoreTRIE a1 = new ArvoreTRIE();
	ArvoreTRIE a2 = new ArvoreTRIE();

        String entrada = sc.nextLine(); //Lendo as linhas da primeira arvore

        while (!(entrada.equals("FIM"))) {
            id = Integer.parseInt(entrada);
            a1.inserir(players[id].getNome());
            

            entrada = sc.nextLine();
        }

        entrada = sc.nextLine(); //Lendo as linahs da segunda arvore

        while (!(entrada.equals("FIM"))) {
            id = Integer.parseInt(entrada);
            a2.inserir(players[id].getNome());


            entrada = sc.nextLine();
        }

	a1.concatenar(a1, a2);
	
        entrada = sc.nextLine(); // Lendo as linhas depois do FIM

        double inicio = System.currentTimeMillis();
        while (!(entrada.equals("FIM"))) {
	    System.out.print(entrada);
            if(a1.pesquisar(entrada)){
                System.out.println(" SIM");  
            }
            else{
                System.out.println(" NAO");
            }
            entrada = sc.nextLine();
        }
        double fim = System.currentTimeMillis();
        double tempo = (fim - inicio) / 1000.0;
        sc.close();

        arq = new Arq();
        arq.openWrite("807205_arvoreTrie.txt");
        arq.print("807205\t" + tempo + "\t" + a1.comparacoes);

        arq.close();
    }
}
