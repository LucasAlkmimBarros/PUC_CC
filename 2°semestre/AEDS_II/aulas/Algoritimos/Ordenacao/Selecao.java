import java.util.Random;

class Selecao{
	private static int TAM = 5;
	private static int[] array;

	Selecao()
	{
		array = new int[TAM];
	}

	public static void preencheArray()
	{
		Random rand = new Random();
		for(int i = 0; i < TAM; i++)
		{
			array[i] = rand.nextInt(100);
		}
	}

	public static void mostraArray()
	{
		MyIO.print("[ ");
		for(int i = 0; i < TAM; i++)
		{
			MyIO.print(array[i] + " ");
		}
		MyIO.print("]\n");
	}

	public static void swap(int pos1, int pos2)
	{
		int aux;
		aux = array[pos1];
		array[pos1] = array[pos2];
		array[pos2] = aux;
	}

	public static void ordenaArray()
	{
		int menor;
		for(int i = 0; i < TAM-1; i++)
		{
			menor = i;
			for(int j = i+1; j < TAM; j++)
			{
				if(array[menor] > array[j])
				menor = j;
			}
		swap(menor, i);
		}
	}

	public static void main(String[] args)
	{
		Selecao teste = new Selecao();
		preencheArray();
		mostraArray();
		ordenaArray();
		mostraArray();
	}	




}
