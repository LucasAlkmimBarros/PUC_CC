//QUESTAO 42


#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Celula{
    int dado;
    struct Celula *prox;
}Celula;

Celula *novaCelula(int dado){
    Celula *nova = (Celula*) malloc(sizeof(Celula));
    nova->dado = dado;
    nova->prox = NULL;
    return nova;
}




int main(){



return 0;
}