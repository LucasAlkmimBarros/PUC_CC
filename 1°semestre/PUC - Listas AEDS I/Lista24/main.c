#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

float calculaAmplitudeReais(FILE* arq)
{
    float maior, menor, num;
    fscanf(arq, "%f", &num);
    maior = num;
    menor = num;
    while(!feof(arq))
    {
        fscanf(arq, "%f", &num);
        if (num > maior) maior = num;
        else if (num < menor) menor = num;
    }
    float amplitude = maior - menor;
    return amplitude;
}



int main()
{
    int c = 0;
    float valor;
    puts("Teste com amplitude\n");
    FILE* arq = fopen("amplitude.dat", "w");
    if (arq == NULL) printf("Erro ao abrir o arquivo\n");
    printf("[0]Para parar\nDigite o %i.o valor real: ", c+1);
    scanf("%f", &valor);
    while (valor != 0)7
    {
       c++;
       fprintf(arq, "%f\n", valor);
       printf("\nDigite o %i.o valor real: ", c+1);
       scanf("%f", &valor);
    }
    fclose(arq);
    arq = fopen("amplitude.dat", "r");
    if (arq == NULL) printf("Erro ao abrir o arquivo\n");
    float amplitude = calculaAmplitudeReais(arq);
    printf("\n\nA amplitude e: %f", amplitude);
    fclose(arq);

    return 0;
}
