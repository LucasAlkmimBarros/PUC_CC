import java.util.Random;

class Insercao{
	private static int TAM = 5;
	private static int[] array;

	Insercao()
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
		for(int i = 1; i < TAM; i++)
		{
			int tmp = array[i];
			int j = i -1;

			while((j >= 0) && (array[j] > tmp))
			{
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = tmp;
		}
	}

	public static void main(String[] args)
	{
		Insercao teste = new Insercao();
		preencheArray();
		mostraArray();
		ordenaArray();
		mostraArray();
	}	




}
