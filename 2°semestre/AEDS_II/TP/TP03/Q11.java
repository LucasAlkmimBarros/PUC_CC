class Jogador{
	private int id;
	private String nome;
	private int altura;
	private int peso;
	private String universidade;
	private int anoNascimento;
	private String cidadeNascimento;
	private String estadoNascimento;


	Jogador(){
		id = -1;
		nome = "";
		altura = -1;
		peso = -1;
		universidade = "";
		anoNascimento = -1;
		cidadeNascimento = "";
		estadoNascimento = "";
	}

	Jogador(int id, String nome, int altura, int peso, String universidade, int anoNascimento, String cidadeNascimento, String estadoNascimento){
		this.id = id;
		this.nome = nome;
		this.altura = altura;
		this.peso = peso;
		this.universidade = universidade;
		this.anoNascimento = anoNascimento;
		this.cidadeNascimento = cidadeNascimento;
		this.estadoNascimento = estadoNascimento;
	}

	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return id;
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	public String getNome(){
		return nome;
	}
	public void setAltura(int altura){
		this.altura = altura;
	}
	public int getAltura(){
		return altura;
	}
	public void setPeso(int peso){
		this.peso = peso;
	}
	public int getPeso(){
		return peso;
	}
	public void setUniversidade(String universidade){
		this.universidade = universidade;
	}
	public String getUniversidade(){
		return universidade;
	}
	public void setAnoNascimento(int anoNascimento){
		this.anoNascimento = anoNascimento;
	}
	public int getAnoNascimento(){
		return anoNascimento;
	}
	public void setCidadeNascimento(String cidadeNascimento){
		this.cidadeNascimento = cidadeNascimento;
	}
	public String getCidadeNascimento(){
		return cidadeNascimento;
	}
	public void setEstadoNascimento(String estadoNascimento){
		this.estadoNascimento = estadoNascimento;
	}
	public String getEstadoNascimento(){
		return estadoNascimento;
	}

	public void imprimir(){		
		MyIO.println("["+ id +" ## "+ nome + " ## " + altura + " ## " + peso + " ## " + anoNascimento + " ## " + universidade + " ## " + cidadeNascimento + " ## " + estadoNascimento +"]");
	}

	public void ler(String s){
		String[] array = s.split(",", 8);
		this.id = Integer.parseInt(array[0]);
		this.nome = array[1].isEmpty() ? "nao informado" : array[1];
		this.altura = Integer.parseInt(array[2]);
		this.peso = Integer.parseInt(array[3]);
		this.universidade = array[4].isEmpty() ? "nao informado" : array[4] ;
		this.anoNascimento = Integer.parseInt(array[5]);
		this.cidadeNascimento = array[6].isEmpty() ? "nao informado" : array[6];
		this.estadoNascimento = array[7].isEmpty() ? "nao informado" : array[7];
	}

	public void clone(Jogador j){
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

class CelulaDupla {
    public Jogador elemento;
    public CelulaDupla prox;
    public CelulaDupla ant; 

    CelulaDupla(){
        this(new Jogador());
    }

    CelulaDupla(Jogador elemento){
        this.elemento = elemento;
        this.prox = null;
		this.ant = null;
    }
}

class ListaFlex{
    public static CelulaDupla primeiro, ultimo;

    ListaFlex(){
        primeiro = new CelulaDupla();
        ultimo = primeiro;
    }

    public void inserir(Jogador jogador){
        ultimo.prox = new CelulaDupla(jogador);
        ultimo = ultimo.prox;
    }

    public void mostar(){
        CelulaDupla i;
        for(i = primeiro.prox; i != null; i = i.prox){
            i.elemento.imprimir();
        }
    }

    public static void swap(Jogador j1, Jogador j2){
        Jogador tmp = new Jogador();
        tmp.clone(j1);
        j1.clone(j2);
        j2.clone(tmp);
    }

	public void quickSort() {
		quickSort(primeiro.prox, null);
	}

	private void quickSort(CelulaDupla esq, CelulaDupla dir) {
		if (esq != dir) {
			CelulaDupla pivo = particiona(esq, dir);
			quickSort(esq, pivo);
			quickSort(pivo.prox, dir);
		}
	}

	private CelulaDupla particiona(CelulaDupla esq, CelulaDupla dir) {
		CelulaDupla i = esq;
		CelulaDupla j = esq.prox;
		Jogador pivo = esq.elemento;

		while (j != dir) {
			int comparacaoEstados = compareEstados(j.elemento.getEstadoNascimento(), pivo.getEstadoNascimento());
			
			if (comparacaoEstados < 0 || (comparacaoEstados == 0 && j.elemento.getNome().compareTo(pivo.getNome()) <= 0)) {
				i = i.prox;
				swap(i.elemento, j.elemento);
			}
			j = j.prox;
		}

		swap(i.elemento, esq.elemento);
		return i;
	}

	private int compareEstados(String estado1, String estado2) {
		return estado1.compareTo(estado2);
	}



}

class Q11{  //Lista com Alocação Flexível em Java

    public static void main(String[] args){
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

        String entrada = MyIO.readLine();
        int id;
        ListaFlex playersClone = new ListaFlex();

        while(!(entrada.equals("FIM"))){
            id = Integer.parseInt(entrada);
            playersClone.inserir(players[id]);

            entrada = MyIO.readLine();
        }

        playersClone.quickSort();
        playersClone.mostar();
    }
}