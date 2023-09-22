class HeapSort{

	private static int array[] = {8, 3, 13, 2, 4};
	private static int n = 5;

	public static void heapsort(){
		//Alterar o vetor ignorando a posicao zero
		int[] tmp = new int[n+1];
		for(int i = 0; i < n; i++){
        		tmp[i+1] = array[i];
		}
		array = tmp;

	        //Contrucao do heap
      		for(int tamHeap = 2; tamHeap <= n; tamHeap++){
			construir(tamHeap);
      		}

   
	}

	public static void construir(int tam){
		for(int i = tam; i > 1 && array[i]> array[i/2]; i/2){
			swap(i, i/2);
		}
	}

	public static void reconstruir(){
	
	}

	public static int getMaiorFilho(){
		return 0;		
	}
	

	public static void main(String[] args){
		MyIO.print("Array inicial: ");
		for(int i = 0; i < 5; i++){
			MyIO.print("["+ array[i] +"] ");
		}

		heapsort();

		MyIO.println("");
		MyIO.print("Array ordenado: ");
		for(int i = 1; i <= 5; i++){
			MyIO.print("["+ array[i] +"] ");
		}

		MyIO.println("");

	}

}

