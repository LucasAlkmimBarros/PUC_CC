#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <time.h>

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

typedef struct CelulaDupla {
    Jogador elemento;       
	struct CelulaDupla* prox; 
    struct CelulaDupla* ant;
} CelulaDupla;

CelulaDupla* novaCelulaDupla(Jogador elemento) { //Construtor
    CelulaDupla* nova = (CelulaDupla*) malloc(sizeof(CelulaDupla));
    nova->elemento = elemento;
    nova->prox = NULL;
    nova->ant = NULL;
    return nova;
} 

float inicioTempo, fimTempo;
int comp = 0, mov = 0;
CelulaDupla* primeiro;
CelulaDupla* ultimo;

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
    mov += 3;
    Jogador tmp;
    clone(j1, &tmp);
    clone(j2, j1);
    clone(&tmp, j2);
    mov += 3;
}

void inserir(Jogador jogador){ //Inserir no fim
    ultimo->prox = novaCelulaDupla(jogador);
    ultimo->prox->ant = ultimo;
    ultimo = ultimo->prox;
}

void mostrar(){
    CelulaDupla* i = primeiro->prox;
    while(i != NULL){
        imprimir(&i->elemento);
        i = i->prox;
    }
}

int tamanho() {
   int tamanho = 0; 
   CelulaDupla* i;
   for(i = primeiro; i != ultimo; i = i->prox, tamanho++);
   return tamanho;
}

void start () {
    Jogador tmp;
    tmp.id = 0;
    strcpy(tmp.nome, "");
    tmp.altura = 0;
    tmp.peso = 0;
    strcpy(tmp.universidade, "");
    tmp.anoNascimento = 0;
    strcpy(tmp.cidadeNascimento, "");
    strcpy(tmp.estadoNascimento, "");

    primeiro = novaCelulaDupla(tmp);
    ultimo = primeiro;
}

void quickSortRec(CelulaDupla* esq, CelulaDupla* dir) {
    CelulaDupla* i = esq;
    CelulaDupla* j = dir;
    CelulaDupla* pivot = dir;


    while(i->ant != j && i->ant != j->prox){
        comp++;
        while(strcmp(i->elemento.estadoNascimento, pivot->elemento.estadoNascimento) < 0 ||
              (strcmp(i->elemento.estadoNascimento, pivot->elemento.estadoNascimento) == 0 &&
               strcmp(i->elemento.nome, pivot->elemento.nome) < 0)){
            i = i->prox;
            comp++;
        }

        comp++;
        while(strcmp(j->elemento.estadoNascimento, pivot->elemento.estadoNascimento) > 0 ||
              (strcmp(j->elemento.estadoNascimento, pivot->elemento.estadoNascimento) == 0 &&
               strcmp(j->elemento.nome, pivot->elemento.nome) > 0)){
            j = j->ant;
            comp++;
        }

        if(i->ant != j && i->ant != j->prox){
            swap(&i->elemento, &j->elemento);
            i = i->prox;
            j = j->ant;
        }
    }

    if(j != esq && esq->ant != j){
        quickSortRec(esq, j);
    }
    if(i != dir && dir->prox != i){
        quickSortRec(i, dir);
    }
}

void quickSort() {
    quickSortRec(primeiro->prox, ultimo);
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

    fclose(arq);

    scanf("%s", n);
    int j = 0;
    Jogador tmp;
    start();
    while(strcmp(n, "FIM") != 0){ //Clonando os jogadores para um novo array
        clone(&players[atoi(n)], &tmp);

        inserir(tmp);
        scanf("%s", n);
    }
    
    //Ordenando os jogadores pelo estadoNascimento usando o quicksort
    inicioTempo = clock();
    quickSort();
    fimTempo = clock();

    mostrar();

    float tempo = fimTempo - inicioTempo;  

    arq = fopen("807205_quicksort2.txt", "w");
    fprintf(arq, "807205\t %i\t %i\t %fs", comp, mov, tempo/1000.0);

    fclose(arq);
    
}