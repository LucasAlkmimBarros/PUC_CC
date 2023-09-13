class FilaCircular{
	private static int[] array;
	private static int primeiro, ultimo;

	FilaCircular()
	{
		this(5);
	}

	FilaCircular(int tam)
	{
		array = new int[tam + 1];
		primeiro = ultimo = 0;
	}

	public static void inserir(int n)
	{
		if(((ultimo + 1) % array.length) == primeiro)
		{
			MyIO.println("Erro!");
		}
		
		else
		{
			array[ultimo] = n;
			ultimo = (ultimo + 1) % array.length;
		}
	}


	public static int remover()
	{
		int num = -1;
		if(ultimo == primeiro)
		{
			MyIO.println("Erro!");
		}

		else
		{
			num = array[primeiro];
			primeiro = (primeiro + 1) % array.length;
		}
		return num;
	}

	public static void mostrar()
	{
		int i = primeiro;
		MyIO.print("[ ");
		while(i != ultimo)
		{
			MyIO.print(array[i] + " ");
			i = (i + 1) % array.length;
		}
		MyIO.print("]");

	}

	public static void mostrarRec(int i)
	{
		String resp = "";
	
		if(i == ultimo)
		{
			resp = "";
		}
		else
		{       
			resp = (array[i] + " ");
			MyIO.print(resp);
			mostrarRec((i+1)%array.length);
		}
		
	}

	public static boolean isVazio()
	{
		boolean resp = false;
		if(primeiro == ultimo) resp = true;
		return resp;
	}

	public static boolean pesquisar(int n)
	{
		boolean resp = false;
		int i = primeiro;
		while(i != ultimo)
		{
			if(array[i] == n) resp = true;
			i = (i + 1) % array.length;
		}
		return resp;

	}

	public static void main(String[] args)
	{
		FilaCircular fila = new FilaCircular();
		int r;
		fila.inserir(1);
		fila.inserir(4);
		fila.inserir(6);
		fila.inserir(3);
		fila.inserir(8);
		if(fila.isVazio()) MyIO.println("Esta vazio");
		else MyIO.println("Nao esta vazio");
		r = fila.remover();
		r = fila.remover();
		r = fila.remover();
		r = fila.remover();
		r = fila.remover();
		if(fila.isVazio()) MyIO.println("Esta vazio");
		else MyIO.println("Nao esta vazio");
		fila.inserir(9);
		fila.mostrar();
		if(fila.pesquisar(6)) MyIO.println("\nTem valor");
		else MyIO.println("\nNao tem valor!");
	}	

}
