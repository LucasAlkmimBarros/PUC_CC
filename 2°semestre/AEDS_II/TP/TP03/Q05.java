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

class ListaFlex{
    private Celula primeiro, ultimo;

    ListaFlex(){
        primeiro = new Celula();
        ultimo = primeiro;
    }

    public void inserirInicio(Jogador jogador){
        Celula tmp = new Celula(jogador);
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
        if(primeiro == ultimo){
            ultimo = tmp;
        }
        tmp = null;
    }

    public void inserir(Jogador jogador, int pos){
        int tamanho = tamanho();

        if(pos == 0){
            inserirInicio(jogador);
        }
        else if(pos == tamanho){
            inserirFim(jogador);
        }
        else{
            Celula i = primeiro;
            for(int j = 0; j < pos; j++, i = i.prox);

            Celula tmp = new Celula(jogador);
            tmp.prox = i.prox;
            i.prox = tmp;
            tmp = i = null;  
        }
    }

    public void inserirFim(Jogador jogador){
        ultimo.prox = new Celula(jogador);
        ultimo = ultimo.prox;
    }

    public Jogador removerInicio(){
        Jogador resp = new Jogador();

        Celula tmp = primeiro;
        primeiro = primeiro.prox;
        resp.clone(primeiro.elemento);

        tmp.prox = null;
        tmp = null;

        return resp;
    }

    public Jogador remover(int pos){
        Jogador resp = new Jogador();
        int tamanho = tamanho();
        if(pos == 0){
            resp = removerInicio();
        }
        else if(pos == tamanho-1){
            resp = removerFim();
        }
        else{
            Celula i = primeiro;
            for(int j = 0; j < pos; j++, i = i.prox);

            Celula tmp = i.prox;
            resp.clone(tmp.elemento);
            i.prox = tmp.prox;
            tmp.prox = null;
            i = tmp = null;
        }

        return resp;
    }

    public Jogador removerFim(){
        Jogador resp = new Jogador();

        Celula i;
        for(i = primeiro; i.prox != ultimo; i = i.prox);
        resp.clone(ultimo.elemento);
        ultimo = i;
        i = ultimo.prox = null;

        return resp;
    }

    public void imprimir(){
        Celula i;
        for(i = primeiro.prox; i != null; i = i.prox){
            i.elemento.imprimir();
        }
    }

    public void corrigeId(){
        Celula i;
        int j = 0;
        for(i = primeiro.prox; i != null; i = i.prox, j++){
            i.elemento.setId(j);
        }
    }

    public int tamanho(){
        int resp = 0;
        Celula i;
        for(i = primeiro; i != ultimo; i = i.prox, resp++);

        return resp;
    }
}

class Q05{  //Lista com Alocação Flexível em Java

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
            playersClone.inserirFim(players[id]);

            entrada = MyIO.readLine();
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

                playersClone.inserirInicio(aux);
            }
            else if(partes[0].equals("I*")){
                //Inserir

                Jogador aux = new Jogador();
                aux.clone(players[id]);

                playersClone.inserir(aux, p);
            } 
            else if(partes[0].equals("IF")){
                //Inserir no fim

                Jogador aux = new Jogador();
                aux.clone(players[id]);

                playersClone.inserirFim(aux);
            }
            else if(partes[0].equals("RI")){
                //Remover no inicio

                Jogador resp = playersClone.removerInicio();
                MyIO.println("(R) " + resp.getNome());
            }
            else if(partes[0].equals("R*")){
                //Remover
                p = id; //O valor da posição está na variável id

                Jogador resp = playersClone.remover(p);
                MyIO.println("(R) " + resp.getNome());
            }
            else if(partes[0].equals("RF")){
                //Remover no fim

                Jogador resp = playersClone.removerFim();
                MyIO.println("(R) " + resp.getNome());
            }
        }

        playersClone.corrigeId();
        playersClone.imprimir(); 
    }
}