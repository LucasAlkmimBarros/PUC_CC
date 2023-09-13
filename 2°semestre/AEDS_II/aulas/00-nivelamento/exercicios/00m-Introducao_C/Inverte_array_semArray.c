//QUESTAO 43


#include <stdio.h>
#include <stdlib.h>

int main() {
    printf("Digite o tamanho do array: ");	
    int n;
    scanf("%i", &n);
    int valor;
    
    FILE* arq = fopen("array.txt", "w");
    if (arq == NULL) {
        printf("Erro ao abrir o arquivo.\n");
        return 1; 
    }

    for (int i = 0; i < n; i++) {
        printf("Digite o valor da posicao %i: ", i);
        scanf("%i", &valor);
        fprintf(arq, "%i ", valor);
    }

    fclose(arq);  

    arq = fopen("array.txt", "r"); 
    if (arq == NULL) {
        printf("Erro ao abrir o arquivo.\n");
        return 1; 
    }

    printf("Números do arquivo na ordem inversa:\n");
    for (int i = 0; i < n; i++) {
        fseek(arq, -sizeof(int), SEEK_END);  
        fscanf(arq, "%i", &valor); 
        printf("%i ", valor);
        fseek(arq, -2 * sizeof(int), SEEK_CUR);  
    }
    
    fclose(arq);  

    return 0;
}
