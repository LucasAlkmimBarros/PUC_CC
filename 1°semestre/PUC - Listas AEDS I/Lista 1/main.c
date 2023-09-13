#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <ctype.h>
#include <stdbool.h>
#include <math.h>

int main()
{
    //Parte 1 e 2
    FILE* arq;
    arq = fopen("exemplo.dat", "w");
    if (arq == NULL) {
        printf("Erro ao criar arquivo\n");
    }
    fprintf(arq, "17\n");
    fclose(arq);

    //Parte 3
    arq = fopen("exemplo.dat", "a");
    fprintf(arq, "60\n");
    fprintf(arq, "54\n");

    //Parte 4
    int idade, pai, mae;
    arq = fopen("exemplo.dat", "r");
    fscanf(arq, " %i", &idade);
    printf("Minha idade: %i\n", idade);
    fscanf(arq, " %i", &pai);
    printf("Idade do meu pai: %i\n", pai);
    fscanf(arq, " %i", &mae);
    printf("Idade da minha mae: %i\n", mae);
    fclose(arq);





return 0;

}

