import java.util.Date;

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



class Q11 {
    	public static int comp = 0, mov = 0;;

		public static long now(){
			return new Date().getTime();
		}

		public static void swap(Jogador j1, Jogador j2){
            mov += 3;
			Jogador tmp;
			tmp = new Jogador();

			tmp.clone(j1);
			j1.clone(j2);
			j2.clone(tmp);
		}

        public static int getMaior(Jogador[] players, int n){
            int maior = players[0].getAltura();

            for(int i = 1; i < n; i++){
                if(maior < players[i].getAltura()){
                    maior = players[i].getAltura();
                }
            }
            return maior;
        }

        public static void countingSort(Jogador[] players, int n) {
            int maiorAltura = getMaior(players, n);
        
            // Criando os arrays
            int[] count = new int[maiorAltura + 1];
            Jogador[] ordenado = new Jogador[n];
        
            // Atribuir a quantidade de ocorrências de cada elemento
            for (int i = 0; i < n; i++) {
                count[players[i].getAltura()]++;
            }
        
            // Atribuir a posição anterior de cada elemento
            for (int i = 1; i <= maiorAltura; i++) {
                count[i] += count[i - 1];
            }
        
            // Ordenando pela altura
            for (int i = n - 1; i >= 0; i--) {
                mov++;
                ordenado[count[players[i].getAltura()] - 1] = players[i];
                count[players[i].getAltura()]--;
            }
        
            // Ordenar os jogadores com alturas iguais pelo nome
            for (int i = 0; i < n; i++) {
                if (i > 0 && ordenado[i].getAltura() == ordenado[i - 1].getAltura()) {
                    int j = i;
                    while (j > 0 && ordenado[j].getAltura() == ordenado[j - 1].getAltura() &&
                           ordenado[j].getNome().compareTo(ordenado[j - 1].getNome()) < 0) {
                        // Swap pelo nome
                        Jogador temp = ordenado[j];
                        ordenado[j] = ordenado[j - 1];
                        ordenado[j - 1] = temp;
                        j--;
                        mov += 3;
                    }
                }
            }
        
            // Copiando os elementos ordenados para o array original
            for (int i = 0; i < n; i++) {
                mov++;
                players[i] = ordenado[i];
            }
        }
        
        

        
		public static void main(String[] args){
            double tempo = 0, inicioTempo = 0, fimTempo = 0;

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




			//Ordenando por countingSort / Altura
            inicioTempo = now();
            countingSort(playersClone, pos);
            fimTempo = now();
            
            

			//Imprimindo Jogadores ordenandos
			for(int i = 0; i < pos; i++){
        		playersClone[i].imprimir();
			}

            tempo = (fimTempo - inicioTempo) / 1000.0;

			//Registro de Log
			arq.openWrite("matrícula_countingsort.txt");
			arq.println("807205\t" + comp + "\t" + mov + "\t" + tempo);
			arq.close(); 
		}
}