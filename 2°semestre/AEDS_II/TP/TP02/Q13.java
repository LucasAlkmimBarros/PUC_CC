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



class Q13 {
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

        public static void mergeSort(Jogador[] players, int n){
            mergeSort(players, 0, n - 1);
        }
        
        public static void mergeSort(Jogador[] players, int esq, int dir){ //Mergesort / Universidade
            if(esq < dir){
                int meio = (esq + dir)/2;
                mergeSort(players, esq, meio);
                mergeSort(players, meio + 1, dir);
                intercalar(players, esq, meio, dir);
            }
        }

        public static void intercalar(Jogador[] players, int esq, int meio, int dir){
            int n1, n2, i, j, k;

            n1 = meio - esq+1;
            n2 = dir - meio;

            Jogador[] a1 = new Jogador[n1];
            Jogador[] a2 = new Jogador[n2];

            for(i = 0; i < n1; i++){
                a1[i] = players[esq+i];
            }

            for(j = 0; j < n2; j++){
                a2[j] = players[meio+j+1];
            }

            for(i = j = 0, k = esq; k <= dir; k++){ 
                if(i == n1){ // Se um dos arrays chegar ao fim, o outro continua normalmente
                    players[k] = a2[j++];
                }else if(j == n2){ 
                    players[k] = a1[i++];
                }else if(a1[i].getUniversidade().compareTo(a2[j].getUniversidade()) < 0){ //Compara as universidades
                    players[k] = a1[i++];
                }else if(a1[i].getUniversidade().compareTo(a2[j].getUniversidade()) > 0){
                    players[k] = a2[j++];
                }else if(a1[i].getNome().compareTo(a2[j].getNome()) < 0){ //Compara os nomes
                    players[k] = a1[i++];
                }else{
                    players[k] = a2[j++];
                }
                comp += 4;
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
            mergeSort(playersClone, pos);
            fimTempo = now();
            
            

			//Imprimindo Jogadores ordenandos
			for(int i = 0; i < pos; i++){
        		playersClone[i].imprimir();
			}

            tempo = (fimTempo - inicioTempo) / 1000.0;

			//Registro de Log
			arq.openWrite("807205_mergesort.txt");
			arq.println("807205\t" + comp + "\t" + mov + "\t" + tempo);
			arq.close(); 
		}
}