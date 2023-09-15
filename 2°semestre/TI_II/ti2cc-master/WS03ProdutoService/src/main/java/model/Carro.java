package model;

public class Carro {
	private int id;
	private String modelo;
	private String placa;
	private int ano;
    private String cor;

	public Carro() {
		id = -1;
		modelo = "";
		placa = "";
		ano = 0;
        cor = "";
	}

	public Carro(int id, String modelo, String placa, int ano, String cor) {
		setId(id);
		setModelo(modelo);
        setPlaca(placa);
        setAno(ano);
        setCor(cor);
	}		
	
	public int getID() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

	/**
	 * Método sobreposto da classe Object. É executado quando um objeto precisa
	 * ser exibido na forma de String.
	 */
	@Override
	public String toString() {
		return "Modelo: " + modelo + "   Ano: " + ano + "   Placa: "
				+ placa  + "   Cor: " + cor;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (this.getID() == ((Carro) obj).getID());
	}	
}