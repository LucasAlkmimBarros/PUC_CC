using System;

class Lista
{
    private int[] array; // Use int[] to declare an integer array
    private int n;

    public Lista()
    {
        array = new int[6];
        n = 0;
    }

    public Lista(int tam)
    {
        array = new int[tam];
        n = 0;
    }

    public void InserirInicio(int num)
    {
        if (n >= array.Length) // Use Length property instead of Length()
        {
            Console.WriteLine("Erro: Lista cheia!");
        }
        else
        {
            for (int i = n; i > 0; i--)
            {
                array[i] = array[i - 1];
            }
            array[0] = num;
            n++;
        }
    }

    public void InserirFim(int num)
    {
        if (n >= array.Length)
        {
            Console.WriteLine("Erro: Lista cheia!");
        }
        else
        {
            array[n] = num;
            n++;
        }
    }

    public void Inserir(int num, int pos)
    {
        if (n >= array.Length)
        {
            Console.WriteLine("Erro: Lista cheia!");
        }
        else
        {
            for (int i = n; i > pos; i--)
            {
                array[i] = array[i - 1];
            }
            array[pos] = num;
            n++;
        }
    }

    public void Mostrar()
    {
        for (int i = 0; i < n; i++)
        {
            Console.WriteLine("[" + i + "] = " + array[i]);
        }
    }

    public int RemoverInicio()
    {
        int removedValue = array[0];
        for (int i = 0; i < n - 1; i++)
        {
            array[i] = array[i + 1];
        }
        n--;
        return removedValue;
    }

    public int RemoverFim()
    {
        int removedValue = array[n - 1];
        array[n - 1] = 0;
        n--;
        return removedValue;
    }

    public int Remover(int pos)
    {
        int removedValue = array[pos];
        for (int i = pos; i < n - 1; i++)
        {
            array[i] = array[i + 1];
        }
        n--;
        return removedValue;
    }

    public int soma(int pos1, int pos2)
    {
	    int soma = array[pos1] + array[pos2];
	    return soma;
    }

    public int maior(){
	    int maior = array[0];
	    for(int i = 1; i < n; i++){
		    if(array[i] > maior) maior = array[i];
	    }
	    return maior;
    }

    public void inverte(){
	    int aux;
	    for(int i = 0; i < array.Length/2; i++){
		    aux = array[i];
		    array[i] = array[n-1-i];
		    array[n-1-i] = aux;
	    }
    }

    public int paresMult5(){
	    int qt = 0;
	    for(int i = 0; i < n; i++){
		   if(array[i] % 2 == 0 && array[i] % 5 == 0){
			  qt++;
		   }
	    }
	    return qt 


}

class Program
{
    static void Main()
    {
        Console.WriteLine("==== LISTA LINEAR ====");
        Lista lista = new Lista(6);
        int x1, x2, x3;
        lista.InserirInicio(1);
        lista.InserirFim(7);
        lista.InserirFim(9);
        lista.InserirInicio(3);
        lista.Inserir(8, 3);
        lista.Inserir(4, 2);

        lista.Mostrar();

        x1 = lista.RemoverInicio();
        x2 = lista.RemoverFim();
        x3 = lista.Remover(2);
        Console.WriteLine(x1 + ", " + x2 + ", " + x3);
        lista.Mostrar();
    }
}
