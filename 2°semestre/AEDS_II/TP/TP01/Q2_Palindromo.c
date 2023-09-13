#include <stdio.h>
#include <string.h>
#include <stdbool.h>

bool ehPalindromo(char str[]){ // Função que verifica se a string é um palíndromo
    bool palindromo = true;
    int tam = strlen(str);
    for(int i = 0; i < tam/2; i++){
        if (str[i] != str[tam-1-i]){
            palindromo = false;
            i = tam/2;
        } 
    }
    if(palindromo) printf("SIM\n"); // Imprime SIM se for palíndromo
    else printf("NAO\n"); // Imprime NAO se não for palíndromo

    return palindromo;
}

int main(){
    char str[10000];
        scanf(" %[^\n]", str); // Lê a string
        getchar(); // Limpa o buffer 
    do{
        ehPalindromo(str);
        scanf(" %[^\n]", str); // Lê a string
        getchar(); // Limpa o buffer 
    }while(strcmp(str, "FIM") != 0); // Repete até a string ser igual a FIM

    return 0;
}
