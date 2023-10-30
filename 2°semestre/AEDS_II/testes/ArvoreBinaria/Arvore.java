class Arvore{
	public No raiz;

	public Arvore(){
		raiz = null;
	}

	public void inserir(int x){
		raiz = inserir(x, raiz);
	}
	public No inserir(int x, No i){
		if(i == null){
			i = new No(x);
		}
		else if (x < i.elemento){
			i.esq = inserir(x, i.esq);
		}
		else if (x > i.elemento){
			i.dir = inserir(x, i.dir);
		}
		else {
			MyIO.println("elemento repetido");
		}
		return i;
	}
	
	public boolean pesquisar(int x){
		return pesquisar(x, raiz);
	}
	public boolean pesquisar(int x, No i){
		boolean resp;
		if(i == null){
			resp = false;
		}
		else if(x == i.elemento){
			resp = true;
		}
		else if( x < i.elemento){
			resp = pesquisar(x, i.esq);
		}
		else {
			resp = pesquisar(x, i.dir);
		}
		return resp;
	}

	public void caminhar(No i){
		if(i != null){
			caminhar(i.esq);
			MyIO.println(i.elemento + " ");
			caminhar(i.dir);
		}
	}

	public int getAltura(){
		return getAltura(raiz, 0);
	}

	public int getAltura(No i, int altura){
		if(i == null){
			altura--;
		}
		else {
			int alturaEsq = getAltura(i.esq, altura + 1);
			int alturaDir = getAltura(i.dir, altura + 1);

			altura = (alturaEsq > alturaDir) ? alturaEsq : alturaDir;
		}
		return altura;
	}

	public int soma(){
		return soma(raiz);
	}

	public int soma(No i){
		int soma = 0;
		if(i!= null){
			soma = i.elemento;
			soma += soma(i.esq) + soma(i.dir);
		}
		return soma;
	}

	public int pares(){
		return pares(raiz);
	}

	public int pares(No i){
		int pares = 0;
		if(i!= null){
			if(i.elemento % 2 == 0) pares++;
			pares += pares(i.esq) + pares(i.dir);
		}
		return pares;
	}

	public static boolean iguais(Arvore a, Arvore b){
		return iguais(a.raiz, b.raiz);
	}

	public static boolean iguais(No a, No b){
		boolean resp = true;

		if(a != null && b != null){
			if(a.elemento == b.elemento){
				resp = resp && iguais(a.esq, b.esq) && iguais(a.dir, b.dir);
			}
			else{
				resp = false;
			}
		}
		else if(!(a == null && b == null)){
			resp = false;
		}

		return resp;
	}

	public boolean hasDiv11(){
		return hasDiv11(raiz);
	}

	public boolean hasDiv11(No i){
		boolean resp = false;

		if(i!= null){
			if(i.elemento % 11 == 0) resp = true;
			resp = resp || hasDiv11(i.esq) || hasDiv11(i.dir);
		}

		return resp;
	}

	public static void main(String[] args){
		Arvore a = new Arvore();
		
		a.inserir(3);
		a.inserir(2);
		a.inserir(1);
		a.inserir(11);
		a.inserir(4);
		a.inserir(5);
		a.inserir(6);

	
		boolean b = a.pesquisar(1);
		if(b) MyIO.println("tem o elemento 1");
		b = a.pesquisar(4);
		if(b) MyIO.println("tem o elemento 4");
		
		a.caminhar(a.raiz);

		int altura = a.getAltura();
		MyIO.println("altura: " + altura);

		int soma = a.soma();
		MyIO.println("soma: " + soma);

		int pares = a.pares();
		MyIO.println("pares: " + pares);

		b = a.hasDiv11();
		if(b) MyIO.println("tem divisivel por 11");
		else MyIO.println("nao tem divisivel por 11");
	}
}

