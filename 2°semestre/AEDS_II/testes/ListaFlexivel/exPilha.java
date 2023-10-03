class Celula{
	public int elemento;
	public Celula prox;

	public Celula(){
		this(0);	
	}

	public Celula(int x){
		this.prox = null;
		this.elemento = x;
	}
}

	
class Pilha{
	private Celula topo;

	public Pilha(){
		topo = null;
	}

	public void inserir(int x){
		Celula tmp = new Celula(x);
		
		tmp.prox = topo;
		topo = tmp;

		tmp  = null;
		
	}
	public int remover(){
		if(topo == null){
			MyIO.println("ERRO!");
			return 0;
		}

		int resp = topo.elemento;

		Celula tmp = topo;
		topo = tmp.prox;
		
		tmp.prox = null;
		tmp = null;
		return resp;
	}

	public void mostrar(){
		MyIO.print("[ ");
		mostrarRec(topo);
		MyIO.println("]");
	}

	public void mostrarRec(Celula i){
		if(i != null){
			mostrarRec(i.prox);
			MyIO.print(i.elemento + " ");
		}
	}

	public void mostrarIterativo(){
		Celula tmp = new Celula();
		MyIO.print("[ ");

		for(Celula i = topo; i != null; i = i.prox){ //Percorre o array inteiro
			Celula j = topo;
			while(j != null && tmp.prox != j){
				if(j.prox == null || j.prox == tmp){
					tmp = j;
				}
				j = j.prox;
			}
			MyIO.print(tmp.elemento + " ");
		}
		MyIO.println("]");
	}

	public int somar(){
		return somarRec(topo);
	}

	public int somarRec(Celula i){
		int soma;
		if(i == null) soma = 0;
		else{
			soma = i.elemento + somarRec(i.prox);
		}
		return soma;
	}
	
	public int maior(){
		int maior = topo.elemento;
		maior = maiorRec(topo, maior);

		return maior;
	}

	public int maiorRec(Celula i, int maior){
		
		if(i != null){
			int elemento = i.elemento;
			if(elemento > maior){
				maior = elemento;
			}
			maior = maiorRec(i.prox, maior);
		}

		return maior;
	}
}



class exPilha{
	public static void main(String[] args){
		Pilha p = new Pilha();
		int soma, maior;

		p.remover();
		p.inserir(3);
		p.inserir(5);
		p.inserir(1);
		p.mostrarIterativo();
		maior = p.maior();
		soma = p.somar();
		MyIO.println("A soma e "+ soma);
		MyIO.println("O maior e " + maior +"\n");
		p.inserir(7);
		p.mostrarIterativo();
		maior = p.maior();
		soma = p.somar();
		MyIO.println("A soma e "+ soma);
		MyIO.println("O maior e " + maior +"\n");
		p.remover();
		p.mostrarIterativo();
		p.remover();
		maior = p.maior();
		MyIO.println("O maior e " + maior +"\n");
		p.mostrarIterativo();
	}
}