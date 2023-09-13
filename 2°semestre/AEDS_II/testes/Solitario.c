#include <stdio.h>
#include <stdlib.h>

int main(){
	int n, num;
	scanf("%i", &n);
	getchar();

	int array[n];
	int j = 0;
	for(int i = 0; i < n; i++){
		 scanf("%i", &num);
		 getchar();
		 if(num != ' '){
			 array[j] = num;
			 j++;
		 }
	}
	
	int verificador, contador;
	for(int i = 0; i < n; i++){
		contador = 0;
		verificador = array[i];
		for(int j = 0; j < n; j++){
			if(array[j] == verificador) contador++;
		}
		if(contador % 2 != 0) printf("%i", verificador);
	}




	return 0;
}
