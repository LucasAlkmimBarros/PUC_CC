#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <time.h>

float inicioTempo, fimTempo;
int comp = 0, mov = 0;

typedef struct { //Struct para guardar os dados dos jogadores
    int id;
    char nome[50];
    int altura;
    int peso;
    char universidade[100];
    int anoNascimento;
    char cidadeNascimento[50];
    char estadoNascimento[50];

} Jogador;

void imprimir(Jogador *jogador){ //Funcao para imprimir os dados dos jogadores
    printf("[%i ## %s ## %i ## %i ## %i ## %s ## %s ## %s]\n", jogador->id, jogador->nome, jogador->altura, jogador->peso, jogador->anoNascimento, jogador->universidade, jogador->cidadeNascimento, jogador->estadoNascimento);
}

void replaceVirgula(char *str){
    int tamanho = strlen(str);
    char tmp[3 * tamanho];
    int j = 0; 

    for (int i = 0; i < tamanho; i++) {
        if (str[i] == ',' && str[i+1] == ',') {
            tmp[j++] = ','; 
            tmp[j++] = 'n';
            tmp[j++] = 'a';
            tmp[j++] = 'o';
            tmp[j++] = ' ';
            tmp[j++] = 'i';
            tmp[j++] = 'n';
            tmp[j++] = 'f';
            tmp[j++] = 'o';
            tmp[j++] = 'r';
            tmp[j++] = 'm';
            tmp[j++] = 'a';
            tmp[j++] = 'd';
            tmp[j++] = 'o';
            tmp[j++] = ',';
            
            i++;

        } else {
            tmp[j++] = str[i];
        }
        
    }

    if (tmp[j - 2] == ',') {
        tmp[j-1] = 'n';
        tmp[j++] = 'a';
        tmp[j++] = 'o';
        tmp[j++] = ' ';
        tmp[j++] = 'i';
        tmp[j++] = 'n';
        tmp[j++] = 'f';
        tmp[j++] = 'o';
        tmp[j++] = 'r';
        tmp[j++] = 'm';
        tmp[j++] = 'a';
        tmp[j++] = 'd';
        tmp[j++] = 'o';
    }

    tmp[j] = '\0';
    strcpy(str, tmp);
}

void ler(char str[300], Jogador *jogador){ //Funcao para ler os dados dos jogadores
    replaceVirgula(str); /* Como a funcao strtok ignora quando temos vazio, por exemplo ",," ,temos que substituir os valores antes de fazer a separaçao*/

    str[strcspn(str, "\n")] = '\0'; // Remove o '\n' no final da string
    char *tmp;
    int i = 0;
    tmp = strtok(str, ","); //Separa a string em virgulas

    while(tmp != NULL){
        if(i % 8 == 0){
            jogador->id = atoi(tmp);

        }else if(i % 8 == 1){
            strcpy(jogador->nome, tmp);

        }else if(i % 8 == 2){
            jogador->altura = atoi(tmp);

        }else if(i % 8 == 3){
            jogador->peso = atoi(tmp);

        }else if(i % 8 == 4){
            strcpy(jogador->universidade, tmp);

        }else if(i % 8 == 5){
            jogador->anoNascimento = atoi(tmp);

        }else if(i % 8 == 6){
            strcpy(jogador->cidadeNascimento, tmp);
            

        }else if(i % 8 == 7){
            strcpy(jogador->estadoNascimento, tmp);
        }
        i++;

      tmp = strtok(NULL, ",");
    }   
}

void clone(Jogador *jogador, Jogador *novo){ //Funcao para clonar um jogador
    novo->id = jogador->id;
    strcpy(novo->nome, jogador->nome);
    novo->altura = jogador->altura;
    novo->peso = jogador->peso;
    strcpy(novo->universidade, jogador->universidade);
    novo->anoNascimento = jogador->anoNascimento;
    strcpy(novo->cidadeNascimento, jogador->cidadeNascimento);
    strcpy(novo->estadoNascimento, jogador->estadoNascimento);
}

void swap(Jogador *j1, Jogador *j2){
    Jogador tmp;
    clone(j1, &tmp);
    clone(j2, j1);
    clone(&tmp, j2);
    mov += 3;
}

int getMax(Jogador array[], int n){
    int maior = array[0].id;
    for(int i = 1; i < n; i++){
        comp++;
        if(array[i].id > maior){
            maior = array[i].id;
        }
    }

    return maior;
}

void construir(Jogador array[], int tamHeap){
    for(int i = tamHeap; i > 1 && array[i].altura > array[i/2].altura || array[i].altura == array[i/2].altura && strcmp(array[i].nome, array[i/2].nome) > 0; i /=2){
        swap(&array[i], &array[i/2]);
    }
}

int getMaiorFilho(int i, int tamHeap, Jogador array[]){
    int filho;
    if (2*i == tamHeap || array[2*i].altura > array[2*i+1].altura || array[2*i].altura == array[2*i+1].altura && strcmp(array[2*i].nome, array[2*i+1].nome) > 0){
        filho = 2*i;
    } else {
        filho = 2*i + 1;
    }
    return filho;
}

void reconstruir(Jogador array[], int tamHeap){
    int i = 1;
    while (i <= tamHeap / 2) {
        int filho = getMaiorFilho(i, tamHeap, array);
        if (array[i].altura < array[filho].altura // Se o pai for menor que o filho ou se forem iguais e o pai tiver o nome menor
                || (array[i].altura == array[filho].altura
                    && strcmp(array[i].nome, array[filho].nome) < 0)) {
            swap(&array[i], &array[filho]);
            i = filho;
        } else {
            i = tamHeap;
        }
    }
}

void heapSortParcial(Jogador array[], int n) {
    //Jogando o array uma casa para frente para facilitar a implementacao
    Jogador tmp[n+1];
    for(int i = 0; i < n; i++){
        clone(&array[i], &tmp[i+1]);
    }
    //Construindo o heap com os 10 primeiros elementos
    int k = 10;
    for(int tam = 2; tam <= k; tam++){
        construir(tmp, tam) ;
    }

    //Comparar os demais elementos com o topo do heap (maior deles)
    for(int tam = k+1; tam <= n; tam++){
        if(tmp[tam].altura < tmp[1].altura || tmp[tam].altura == tmp[1].altura && strcmp(tmp[tam].nome, tmp[1].nome) < 0){
            swap(&tmp[tam], &tmp[1]);
            reconstruir(tmp, k);
        }
    }

    //Ordenando o array
    int tam = k;
    while (tam > 1){
        swap(&tmp[1], &tmp[tam--]);
        reconstruir(tmp, tam);
    }

    //Voltando o array para a posicao original
    for(int i = 0; i < n; i++){
        clone(&tmp[i+1], &array[i]);
    }
}



void main(){
    Jogador players[3923];
    char n[5];

    FILE *arq;
    arq = fopen("/tmp/players.csv", "r");

    if(arq == NULL){
        printf("Erro ao abrir o arquivo\n");
        return;
    }

    char str[300];
        fgets(str, sizeof(str), arq); // ler a primeira linha do arquivo
    int i = 0;
    while (fgets(str, sizeof(str), arq)) { // ler as outras linhas do arquivo
        ler(str, &players[i]);
        i++;
    }

    Jogador playersClone[3923];


    scanf("%s", n);
    int j = 0;
    while(strcmp(n, "FIM") != 0){ //Clonando os jogadores para um novo array
        clone(&players[atoi(n)], &playersClone[j]);
        scanf("%s", n);
        j++;
    }


    //Ordenando os jogadores pela altura usando heapSort parcial
    heapSortParcial(playersClone, j);

    for(int h = 0; h < 10; h++){
        imprimir(&playersClone[h]);
    } 

    fclose(arq);

}   