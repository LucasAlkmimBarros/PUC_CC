#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
	char str[1000];
	int tam;
	char oldChar, newChar;
//	int i = 0;
	

	scanf( " %[^\n]", str); // Lendo uma linha do teclado
	getchar();
	do{
		tam = strlen(str);
		oldChar = 'a' + (random() % 26);
		newChar = 'a' + (random() % 26);

//	i++;
//	printf("\nI = %i\nOld = %c \nNew = %c\n\n", i, oldChar, newChar);

		for(int i = 0; i < tam; i++)
		{
			if(str[i] == oldChar)
			{
				str[i] = newChar;  //Caso o caracter na posicao i seja a chave, vamos trocar ele pelo outro.
			}
		}

		printf("%s\n", str);

		scanf( " %[^\n]", str); // Lendo uma linha do teclado
		getchar(); //Limpa o buffer	
	}while(!(strlen(str) == 3 && str[0] == 'F' && str[1] == 'I' && str[2] == 'M'));
	
	return 0;
}



