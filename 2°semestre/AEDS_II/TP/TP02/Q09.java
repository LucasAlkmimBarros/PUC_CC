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



class Q09 {
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


        public static int getMaiorFilho(int i, int tam, Jogador[] playersClone) {
            int filho;
            comp++;
            if (2 * i == tam || playersClone[2 * i].getAltura() > playersClone[2 * i + 1].getAltura()
                    || (playersClone[2 * i].getAltura() == playersClone[2 * i + 1].getAltura()
                        && playersClone[2 * i].getNome().compareTo(playersClone[2 * i + 1].getNome()) > 0)) { // Se o filho da esquerda for maior que o da direita ou se forem iguais e o da esquerda tiver o nome maior
                filho = 2 * i;
            } else {
                filho = 2 * i + 1;
            }
            return filho;
        }
        

        public static void reconstruirHeap(Jogador[] playersClone, int tam) {
            int i = 1;
            while (i <= tam / 2) {
                int filho = getMaiorFilho(i, tam, playersClone);
                comp++;
                if (playersClone[i].getAltura() < playersClone[filho].getAltura() // Se o pai for menor que o filho ou se forem iguais e o pai tiver o nome menor
                        || (playersClone[i].getAltura() == playersClone[filho].getAltura()
                            && playersClone[i].getNome().compareTo(playersClone[filho].getNome()) < 0)) {
                    swap(playersClone[i], playersClone[filho]);
                    i = filho;
                } else {
                    i = tam;
                }
            }
        }
        

        public static void construirHeap(Jogador[] playersClone, int tam) {
            comp++;
            for (int i = tam; i > 1 && (playersClone[i].getAltura() > playersClone[i / 2].getAltura() // Se o filho for maior que o pai ou se forem iguais e o filho tiver o nome maior
                    || (playersClone[i].getAltura() == playersClone[i / 2].getAltura()
                        && playersClone[i].getNome().compareTo(playersClone[i / 2].getNome()) > 0)); i /= 2) {
                swap(playersClone[i], playersClone[i / 2]);
                comp++;
            }
        }
        

        public static void heapsort(Jogador[] playersClone, int n){ 
            //Movendo os elementos do array uma casa para a direita
            for(int i = n; i > 0; i--){
                playersClone[i] = playersClone[i-1];
                mov++;
            }

            //Construindo o heap
            for(int tam = 2; tam <= n; tam++){
                construirHeap(playersClone, tam);
            }
            
            //Ordenando o array
            int tam = n;
            while(tam > 1){
                swap(playersClone[1], playersClone[tam--]);
                reconstruirHeap(playersClone, tam);
            }


            //Movendo os elementos do array uma casa para a esquerda
            for(int i = 0; i < n; i++){
                playersClone[i] = playersClone[i+1];
                mov++;
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




			//Ordenando por heapsort / Altura
            inicioTempo = now();
            heapsort(playersClone, pos);
            fimTempo = now();
            
            

			//Imprimindo Jogadores ordenandos
			for(int i = 0; i < pos; i++){
        		playersClone[i].imprimir();
			}

            tempo = (fimTempo - inicioTempo) / 1000.0;

			//Registro de Log
			arq.openWrite("807205_heapsort.txt");
			arq.println("807205\t" + comp + "\t" + mov + "\t" + tempo);
			arq.close(); 
		}
}