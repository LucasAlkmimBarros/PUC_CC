class AVL{
	public No raiz;

	AVL(){
		this.raiz = null;
	}

	public boolean pesquisar(int x){
		return pesquisar(x, raiz);
	}

	public boolean pesquisar(int x, No no){
		boolean resp = false;
		if(no != null){
			if(x == no.elemento){
				resp = true;
			}
			else if(x < no.elemento){
				resp = pesquisar(x, no.esq);
			}
			else{
				resp = pesquisar(x, no.dir);
			}
		}
		return resp;
	}

	public void mostrar(){
		mostrar(raiz);
	}

	public void mostrar(No no){
		if(no != null){
			System.out.print(no.elemento + " ");
			mostrar(no.esq);
			mostrar(no.dir);
		}
	}

	public No rotacionarEsq(No no){
		No noDir = no.dir;
		No noDirEsq = noDir.esq;

		noDir.esq = no;
		no.dir = noDirEsq;
		no.setNivel();
		noDir.setNivel();

		return noDir;
	}

	public No rotacionarDir(No no){
		No noEsq = no.esq;
		No noEsqDir = noEsq.dir;

		noEsq.dir = no;
		no.esq = noEsqDir;
		no.setNivel();
		noEsq.setNivel();

		return noEsq;
	}

	public No rotacionarEsqDir(No no){
		no.esq = rotacionarEsq(no.esq);
		return rotacionarDir(no);
	}

	public No rotacionarDirEsq(No no){
		no.dir = rotacionarDir(no.dir);
		return rotacionarEsq(no);
	}

	public void inserir(int x){
		raiz = inserir(x, raiz);
	}

	public No inserir(int x, No no){
		if(no == null){
			no = new No(x);
		}
		else if(x < no.elemento){
			no.esq = inserir(x, no.esq);
		}
		else if(x > no.elemento){
			no.dir = inserir(x, no.dir);
		}
		else{
			System.out.println("Elemento ja existente!");
		}

		return balancear(no);
	}

	public No balancear(No no){
		if(no != null){
			int fator = no.getNivel(no.dir) - no.getNivel(no.esq);

			if(Math.abs(fator) <= 1){
				no.setNivel();
			}
			else if(fator == 2){
				int fatorFilhoDir = no.getNivel(no.dir.dir) - no.getNivel(no.dir.esq);
				if(fatorFilhoDir == -1){
					no.dir = rotacionarDir(no.dir);
				}
				no = rotacionarEsq(no);
			}
			else if(fator == -2){
				int fatorFilhoEsq = no.esq.dir.getNivel(no.esq.dir) - no.esq.esq.getNivel(no.esq.esq);
				if(fatorFilhoEsq == 1){
					no.esq = rotacionarEsq(no.esq);
				}
				no = rotacionarDir(no);
			}
			else{
				System.out.println("Erro ao balancear!");
			}
		}
		return no;

	}

	public void remover(int x){
		raiz = remover(x, raiz);
	}

	public No remover(int x, No no){
		if(no != null){
			if(x < no.elemento){
				no.esq = remover(x, no.esq);
			}
			else if(x > no.elemento){
				no.dir = remover(x, no.dir);
			}
			else{ //Achou o elemento
				if(no.dir == null){
					no = no.esq;
				}
				else if(no.esq == null){
					no = no.dir;
				}
				else{
					no.esq = maiorEsq(no, no.esq);
				}
			}

		}

		return balancear(no);
	}

	public No maiorEsq(No i, No j){
		if(j.dir == null){
			i.elemento = j.elemento;
			j = j.esq;
		}
		else{
			j.dir = maiorEsq(i, j.dir);
		}
		return j;
	}


	public static void main(String[] args){
		AVL arvore = new AVL();

		arvore.inserir(10);
		arvore.inserir(20);
		arvore.inserir(30);
		arvore.inserir(40);
		arvore.inserir(50);
		arvore.inserir(25);
		arvore.inserir(35);
		arvore.inserir(45);
		arvore.inserir(55);
		arvore.inserir(60);
		arvore.inserir(70);
		arvore.inserir(80);
		arvore.inserir(90);
		arvore.inserir(100);
	
		arvore.mostrar();
		
		System.out.println();
		System.out.println(arvore.pesquisar(10));
		System.out.println(arvore.pesquisar(20));
		
		arvore.remover(10);
		arvore.remover(20);

		arvore.mostrar();
	}

}
