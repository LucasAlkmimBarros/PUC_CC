class Fila
{
    private ArrayList elementos = new ArrayList();

    public void Inserir(object item)
    {
        elementos.Add(item);
    }

    public object Remover()
    {
        if (elementos.Count == 0)
        {
            throw new InvalidOperationException("A fila está vazia.");
        }

        object primeiroElemento = elementos[0];
        elementos.RemoveAt(0);
        return primeiroElemento;
    }

    public void MostrarElementos()
    {
        if (elementos.Count == 0)
        {
            Console.WriteLine("A fila está vazia.");
        }
        else
        {
            Console.WriteLine("Elementos na fila:");
            foreach (object item in elementos)
            {
                Console.WriteLine(item);
            }
        }
    }
}

class Program
{
    static void Main(string[] args)
    {
        Fila minhaFila = new Fila();

        minhaFila.Inserir("Primeiro");
        minhaFila.Inserir("Segundo");
        minhaFila.Inserir("Terceiro");

        minhaFila.MostrarElementos();

        Console.WriteLine("Removendo: " + minhaFila.Remover());

        minhaFila.MostrarElementos();
    }
}
