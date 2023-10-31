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
		MyIO.println("["+ id +"] ## "+ nome + " ## " + altura + " ## " + peso + " ## " + anoNascimento + " ## " + universidade + " ## " + cidadeNascimento + " ## " + estadoNascimento +" ## ");
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

class Q01{  //Lista com Alocação Sequencial em Java

    public static void inserirInicio(Jogador[] array, Jogador jogador, int pos){
        array[pos] = new Jogador();
        for(int i = pos; i > 0; i--){   //Pula o array uma casa pra frente
            array[i].clone(array[i-1]);
        }
        array[0].clone(jogador);
    }

    public static void inserir(Jogador[] array, Jogador jogador, int pos, int p){
        array[pos] = new Jogador();
        for(int i = pos; i > p; i--){
            array[i].clone(array[i-1]);
        }
        array[p].clone(jogador);
    }

    public static void inserirFim(Jogador[] array, Jogador jogador, int pos){
        array[pos] = new Jogador();
        array[pos].clone(jogador);
    }

    public static Jogador removerInicio(Jogador[] array, int pos){
        Jogador resp = new Jogador();
        resp.clone(array[0]);

        for(int i = 0; i < pos-1; i++){
            array[i].clone(array[i+1]);
        }

        return resp;
    }

    public static Jogador remover(Jogador[] array, int pos, int p){
        Jogador resp = new Jogador();
        resp.clone(array[p]);

        for(int i = p; i < pos-1; i++){
            array[i].clone(array[i+1]);
        }
        return resp;
    }

    public static Jogador removerFim(Jogador[] array, int pos){
        Jogador resp = new Jogador();
        resp.clone(array[pos-1]);

        return resp;
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
 
        int n = MyIO.readInt();

        for(int i = 0; i < n; i++){
            id = 0;
            int p = 0;
    
            entrada = MyIO.readLine();
            String[] partes = entrada.split(" "); //Obtendo as partes da entrada
            if(partes.length == 2){
                id = Integer.parseInt(partes[1]);
            }
            else if(partes.length == 3){
                p = Integer.parseInt(partes[1]);
                id = Integer.parseInt(partes[2]);
            }

            //Verificando as entradas

            if(partes[0].equals("II")){
                //Inserir no inicio

                Jogador aux = new Jogador();
                aux.clone(players[id]);

                inserirInicio(playersClone, aux, pos);
                pos++;
            }
            else if(partes[0].equals("I*")){
                //Inserir

                Jogador aux = new Jogador();
                aux.clone(players[id]);

                inserir(playersClone, aux, pos, p);
                pos++;
            } 
            else if(partes[0].equals("IF")){
                //Inserir no fim

                Jogador aux = new Jogador();
                aux.clone(players[id]);

                inserirFim(playersClone, aux, pos);
                pos++;
            }
            else if(partes[0].equals("RI")){
                //Remover no inicio

                Jogador resp = removerInicio(playersClone, pos);
                pos--;
                MyIO.println("(R) " + resp.getNome());
            }
            else if(partes[0].equals("R*")){
                //Remover

                Jogador resp = remover(playersClone, pos, id); //Aqui, o segundo parametro (e ultimo), representa a posicao que sera removida
                pos--;
                MyIO.println("(R) " + resp.getNome());
            }
            else if(partes[0].equals("RF")){
                //Remover no fim

                Jogador resp = removerFim(playersClone, pos);
                pos--;
                MyIO.println("(R) " + resp.getNome());
            }
        }

        //Corrigindo os ids
        for(int i = 0; i < pos; i++){
            playersClone[i].setId(i);
        }

        for(int i = 0; i < pos; i++){
            playersClone[i].imprimir();
        }
    }
}