#include <stdio.h>
#include <string.h>
#include <stdbool.h>

bool ehPalindromo(char str[], int inicio, int fim){
	bool palindromo = true;

	if(inicio >= fim)
	{
		return true;
	}
	else
	{
		if(str[inicio] != str[fim-1])
		{
			palindromo = false;
		}
		else
		{
			palindromo = palindromo && ehPalindromo(str, inicio+1, fim-1);
		}
		return palindromo;
	}
}
					



int main(){
    char str[10000];
    bool resp;
    scanf(" %[^\n]", str); // Lê a string
    getchar(); // Limpa o buffer
    do{
        resp = ehPalindromo(str, 0, strlen(str));
	if(resp) printf("SIM\n");
	else printf("NAO\n");
        scanf(" %[^\n]", str); // Lê a string
        getchar(); // Limpa o buffer
    }while(strcmp(str, "FIM") != 0); // Repete até a string ser igual a FIM

    return 0;
}

