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

void quickSortRec(Jogador array[], int esq, int dir) {
    int i = esq, j = dir;
    Jogador pivot = array[(esq + dir) / 2];

    while (i <= j) {
        comp++;
        while (strcmp(array[i].estadoNascimento, pivot.estadoNascimento) < 0 ||
               (strcmp(array[i].estadoNascimento, pivot.estadoNascimento) == 0 &&
                strcmp(array[i].nome, pivot.nome) < 0)) // Compara os estados de nascimento e os nomes dos jogadores
            comp++,
            i++;

        comp++;
        while (strcmp(array[j].estadoNascimento, pivot.estadoNascimento) > 0 ||
               (strcmp(array[j].estadoNascimento, pivot.estadoNascimento) == 0 &&
                strcmp(array[j].nome, pivot.nome) > 0)) 
            comp++,
            j--;

        if (i <= j) {
            swap(&array[i], &array[j]);
            i++;
            j--;
        }
    }
    if (esq < j) quickSortRec(array, esq, j);
    if (dir > i) quickSortRec(array, i, dir);
}

void quickSort(Jogador array[], int n) {
    quickSortRec(array, 0, n - 1);
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


    //Ordenando os jogadores pelo estadoNascimento usando o quicksort
    inicioTempo = clock();
    quickSort(playersClone, j);
    fimTempo = clock();

    for(int h = 0; h < j; h++){
        imprimir(&playersClone[h]);
    }

    fclose(arq);

    float tempo = fimTempo - inicioTempo;  

    arq = fopen(" matrícula_quicksort.txt", "w");
    fprintf(arq, "807205\t %i\t %i\t %fs", comp, mov, tempo/1000.0);

    fclose(arq);
    
}