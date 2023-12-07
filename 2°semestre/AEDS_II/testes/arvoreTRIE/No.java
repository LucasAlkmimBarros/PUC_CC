class No{
	public No[] prox;
	public int tam;
	public char letra;
	public boolean folha;

	No(){
		this(' ');
	}

	No(char letra){
		this.letra = letra;
		this.tam = 255;
		this.folha = false;
		prox = new No[tam];

		for(int i = 0; i < prox.length; i++){
			prox[i] = null;
		}
	}

	public int hash(char c){
		return (int) c;
	}
}
