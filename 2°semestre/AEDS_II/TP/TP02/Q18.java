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



class Q18 {

		public static void swap(Jogador j1, Jogador j2){
			Jogador tmp;
			tmp = new Jogador();

			tmp.clone(j1);
			j1.clone(j2);
			j2.clone(tmp);
		}

		public static void quickSortParcial(Jogador[] players, int tam){
			quickSortParcial(players, 0, tam-1, 10);
			selectionSort(players, 10);
		}

		public static void selectionSort(Jogador[] players, int tam){
			int menor;
			int resultado;

			for(int i = 0; i < tam-1; i++){
				menor = i;
				for(int j = i+1; j < tam; j++){

					resultado = players[menor].getEstadoNascimento().compareTo(players[j].getEstadoNascimento()); 
					if(resultado > 0 || resultado == 0 && players[menor].getNome().compareTo(players[j].getNome()) > 0){ 
						menor = j;
					} 
				}
				swap(players[menor], players[i]);
			}
		}

		public static void quickSortParcial(Jogador[] players, int esq, int dir, int k) {
			if (esq < dir) {
				int i = esq, j = dir;
				Jogador pivo = new Jogador();
				pivo.clone(players[(dir + esq) / 2]);
		
				while (i <= j) {
					while (players[i].getEstadoNascimento().compareTo(pivo.getEstadoNascimento()) < 0 ||
						   (players[i].getEstadoNascimento().compareTo(pivo.getEstadoNascimento()) == 0 &&
							players[i].getNome().compareTo(pivo.getNome()) < 0)) {
						i++;
					}
					while (players[j].getEstadoNascimento().compareTo(pivo.getEstadoNascimento()) > 0 ||
						   (players[j].getEstadoNascimento().compareTo(pivo.getEstadoNascimento()) == 0 &&
							players[j].getNome().compareTo(pivo.getNome()) > 0)) {
						j--;
					}
					if (i <= j) {
						swap(players[i], players[j]);
						i++;
						j--;
					}
				}
		
				if (k <= j - esq + 1) { //Se o k estiver na primeira metade
					quickSortParcial(players, esq, j, k); 
				} else { //Se o k estiver na segunda metade
					quickSortParcial(players, i, dir, k - (i - esq)); 
				}
			}
		}
		
		
        
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
			int id , pos = 0;
			Jogador[] playersClone = new Jogador[3923]; //Cria um array de jogadores para armazenar os jogadores clonados


			while(!(entrada.equals("FIM"))){
				id = Integer.parseInt(entrada);
				playersClone[pos] = new Jogador();
				playersClone[pos].clone(players[id]); //Clona os jogadores

				entrada = MyIO.readLine();
				pos++;
			}

			//Ordenando por QuickSort Parcial / EstadoNascimento x Nome
            quickSortParcial(playersClone, pos);
            
            

			//Imprimindo Jogadores ordenandos
		 	for(int i = 0; i < 10; i++){
        		playersClone[i].imprimir();
			} 
		}
}