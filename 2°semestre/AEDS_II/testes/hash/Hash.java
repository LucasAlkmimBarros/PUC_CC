class Hash{
	public char[] tabela;
	public int tam;

	Hash(){
		this(255);
	}

	Hash(int tam){
		this.tam = tam;
		this.tabela = new char[tam];

		for(int i = 0; i < tam; i++){
			tabela[i] = ' ';
		}
	}

	public int h(char c){
		return (int) c % tam;
	}

	public int reh(char c){
		return (((int) c) + 1) % tam;
	}

	public boolean inserir(char c){
		int pos;
		boolean resp = false;
		pos = h(c);

		if(tabela[pos] == ' '){
			tabela[pos] = c;
			resp = true;
		}
		else{
			pos = reh(c);
			if(tabela[pos] == ' '){
				tabela[pos] = c;
				resp = true;
			}
		}
		return resp;
	}

	public boolean pesquisar(char c){
		int pos;
		boolean resp = false;
		pos = h(c);

		if(tabela[pos] == c){
			resp = true;
		}
		else{
			pos = reh(c);
			if(tabela[pos] == c){
				resp = true;
			}
		}

		return resp;
	}

	public boolean remover(char c){
		int pos;
                boolean resp = false;
                pos = h(c);

                if(tabela[pos] == c){
			tabela[pos] = ' ';
                        resp = true;
                }
                else{
                        pos = reh(c);
                        if(tabela[pos] == c){
				tabela[pos] = ' ';
                                resp = true;
                        }
                }

                return resp;
        }
	
	public static void main(String[] args){
		//testes
		Hash hash = new Hash();
		hash.inserir('a');
		hash.inserir('h');
		hash.inserir('b');

		System.out.println(hash.pesquisar('a'));
		System.out.println(hash.pesquisar('c'));
		System.out.println(hash.pesquisar(' '));

		hash.remover('a');

		System.out.println(hash.pesquisar('a'));

		hash.inserir('a');

		System.out.println(hash.pesquisar('a'));
	}	
}
