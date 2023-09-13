
#include <stdio.h>
#include <string.h>

void combinaString(char str1[], char str2[])
{
	int maior, menor, tam;
	
	/* Atribuindo os tamanhos */

	    if (strlen(str1) > strlen(str2))
    {
        maior = strlen(str1);
        menor = strlen(str2);
    }
    else
    {
        maior = strlen(str2);
        menor = strlen(str1);
    }

    tam = maior + menor;
    char strCombinada[tam];
    int pos = 0;
    for (int i = 0; i < menor; i++) // PREENCHE A STRING ATÉ O TAMANHO DA MENOR
    {
        strCombinada[pos] = str1[i];
        pos++;
        strCombinada[pos] = str2[i];
        pos++;
    }

    if (maior == strlen(str1)) // QUANDO STR1 FOR MAIOR
    {
        for (int i = menor * 2; i < maior + menor; i++)
        {
            strCombinada[i] = str1[i - menor];
        }
    }
    else // QUANDO STR2 FOR MAIOR
    {
        for (int i = menor * 2; i < maior + menor; i++)
        {
            strCombinada[i] = str2[i - menor];
        }
    }

    // Adicione o caractere nulo de terminação para tornar a string válida
    strCombinada[tam] = '\0';

    printf("%s\n", strCombinada);
}

int main() {
	for(int i = 0; i < 3; i++)
	{
		char strOriginal[200];
    		char str1[100];
	    	char str2[100];

	
    		scanf(" %[^\n]", strOriginal); // Lê a string inteira
    		getchar(); // Limpa o buffer

    		int tam = strlen(strOriginal);
    		int pos = 0;
    
    	// Atribui a string até o espaço para str1
    		while (strOriginal[pos] != ' ' && pos < tam) {
       	 		str1[pos] = strOriginal[pos];
       	 		pos++;
    		}
    		str1[pos] = '\0'; // Termina str1 corretamente
	
   	 // Serve para tirar o espaço
    		pos++;
	
    		int i = 0;
    	// Atribui tudo que está depois do espaço para str2
    		while (pos < tam) {
      	 	 	str2[i] = strOriginal[pos];
       		 	i++;
       	 		pos++;
    		}
    		str2[i] = '\0'; // Termina str2 corretamente
	
		combinaString(str1, str2);
    	}
   	 return 0;
}

