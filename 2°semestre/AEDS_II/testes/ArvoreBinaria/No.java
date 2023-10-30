class No{
	public int elemento;
	public No dir;
	public No esq;

	public No(int elemento){
		this(elemento, null, null);
	}
	public No(int elemento, No dir, No esq){
		this.elemento = elemento;
		this.dir = dir;
		this.esq = esq;
	}
}
