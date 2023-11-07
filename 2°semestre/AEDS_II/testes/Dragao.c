#include <stdio.h>
#include <stdlib.h> 
#include <stdbool.h>
#include <string.h>

typedef struct {
    int dias;
    int preco;

    float custo;
}Dragao;

void main(){
    Dragao* dragao[105];
    int i = 0;
    int dias, preco;

    while(i < 5){
        dragao[i] = (Dragao*)malloc(sizeof(Dragao));
        scanf("%i %i", &dias, &preco);
        dragao[i]->dias = dias;
        dragao[i]->preco = preco;

        i++;
    }

    
    for(int j = 0; j < i; j++){ //Calulando o custo
        dragao[j]->custo = dragao[j]->preco / dragao[j]->dias;
    }

    for(int j = 0; j < i-1; j++){ //Ordenando pelo custo
        for(int k = j+1; k < i; k++){
            if(dragao[j]->custo > dragao[k]->custo){
                Dragao* tmp = dragao[j];
                dragao[j] = dragao[k];
                dragao[k] = tmp;
            }
        }
    }

    //Printando
    for(int j = 0; j < i; j++){
        printf("%i %i\n", dragao[j]->dias, dragao[j]->preco);
    }

    strcmp()
    strcpy()
    strtok()
    
}