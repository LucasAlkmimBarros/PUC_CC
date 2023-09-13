import java.util.Scanner;

class mrSeverino{
	static public void main(String[] args){
		Scanner sc = new Scanner(System.in);

		int n;
		n = sc.nextInt();

		int[] array = new int[n];
		for(int i = 0; i < n; i++){
			array[i] = sc.nextInt();
		}
		
		for(int i = 0; i < n-1; i++){
			int menor = i;
			for(int j = i+1; j < n; j++){
				if(array[menor] > array[j]){
					menor = j;
				}
			}
			int aux = array[i];
			array[i] = array[menor];
			array[menor] = aux;
		}
		for(int i = 0; i < n; i++)
		{
			String formattedNumber = String.format("%04d", array[i]);
            		System.out.println(formattedNumber);
		}
	}
}	

		
