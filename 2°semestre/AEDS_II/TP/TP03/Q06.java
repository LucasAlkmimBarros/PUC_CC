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
		MyIO.println("["+ id +"] ## "+ nome + " ## " + altura + " ## " + peso + " ## " + anoNascimento + " ## " + universidade + " ## " + cidadeNascimento + " ## " + estadoNascimento +" ##");
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

class Celula {
    public Jogador elemento;
    public Celula prox; 

    Celula(){
        this(new Jogador());
    }

    Celula(Jogador elemento){
        this.elemento = elemento;
        this.prox = null;
    }
}

class PilhaFlex{
    private Celula topo;

    PilhaFlex(){
        topo = null;
    }

    public void inserir(Jogador jogador){ //Inserir no fim
        if(topo == null){
            topo = new Celula(jogador);
        }
        else{
            Celula i;
            for(i = topo; i.prox != null; i = i.prox);
            i.prox = new Celula(jogador);
        }
    }

    public Jogador remover(){
        Jogador resp = new Jogador();
        if(topo != null){
            if(topo.prox == null){ //SO tem 1 elemento
                resp.clone(topo.elemento);
                topo = null;
            }
            else{
                Celula i;
                for(i = topo; i.prox.prox != null; i = i.prox);
                resp.clone(i.prox.elemento);
                i.prox = null;
                i = null;
            }
        }
        return resp;
    }

    public void imprimir(){
        Celula i;
        for(i = topo; i != null; i = i.prox){
            i.elemento.imprimir();
        }
    }

    public void corrigeId(){
        Celula i;
        int j = 0;
        for(i = topo; i != null; i = i.prox, j++){
            i.elemento.setId(j);
        }
    }
}

class Q06{  //Pilha com Alocação Flexível em Java

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
        PilhaFlex playersClone = new PilhaFlex();

        while(!(entrada.equals("FIM"))){
            id = Integer.parseInt(entrada);
            playersClone.inserir(players[id]);

            entrada = MyIO.readLine();
        }

        int n = MyIO.readInt();

        for(int i = 0; i < n; i++){
            id = 0;
            String comando;

            entrada = MyIO.readLine();
            String[] partes = entrada.split(" "); //Obtendo as partes da entrada
            comando = partes[0];
            if(partes.length == 2){
                id = Integer.parseInt(partes[1]);
            }
            

            //Verificando as entradas

            if(comando.equals("I")){
                //Inserir

                Jogador aux = new Jogador();
                aux.clone(players[id]);

                playersClone.inserir(aux);
            }
            else if(comando.equals("R")){
                //Remover

                Jogador resp = new Jogador();
                resp.clone(playersClone.remover());
                MyIO.println("(R) " + resp.getNome());
            }
        }
        playersClone.corrigeId();
        playersClone.imprimir();
    }
}
    