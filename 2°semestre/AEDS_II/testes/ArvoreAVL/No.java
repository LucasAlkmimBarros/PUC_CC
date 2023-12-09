class No{
	public int elemento;
	public No esq;
	public No dir;
	public int nivel;

	No(){
		this(-1);
	}

	No(int elemento){
		this.elemento = elemento;
		this.esq = this.dir = null;
		this.nivel = 1;
	}

	public void setNivel(){
		this.nivel = 1 + Math.max(getNivel(esq), getNivel(dir));
	}

	public int getNivel(No no){
		return (no == null) ? 0 : no.nivel;
	}
}
