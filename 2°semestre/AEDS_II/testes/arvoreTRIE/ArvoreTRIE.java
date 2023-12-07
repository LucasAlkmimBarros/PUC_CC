class ArvoreTRIE{
	public No raiz;
	
	ArvoreTRIE(){
		this.raiz = new No();
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
		if(no.prox[nome.charAt(i)] == null){
			resp = false;
		}
		else if(i == nome.length() - 1){
			resp = (no.prox[nome.charAt(i)].folha == true);
		}
		else if(i < nome.length() - 1){
			resp = pesquisar(nome, no.prox[nome.charAt(i)], i + 1);
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
}
