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
    while(strcmp(n, "FIM") != 0){
        for(int k = 0; k < i; k++){ // i é a quantidade de jogadores totais
            if(players[k].id == atoi(n)){
                clone(&players[k], &playersClone[j]);
            }

        }
        scanf("%s", n);
        j++;
    }

    char nomeJogador[50];

    
    //Ordenando os jogadores pelo nome para pesquisa binaria
    for(int k = 0; k < j; k++){
        for(int l = k + 1; l < j; l++){
            if(strcmp(playersClone[k].nome, playersClone[l].nome) > 0){
                Jogador tmp;
                clone(&playersClone[k], &tmp);
                clone(&playersClone[l], &playersClone[k]);
                clone(&tmp, &playersClone[l]);
            }
        }
    }

    bool temNome;
    int comp = 0;
    float inicioTempo, fimTempo;
    getchar();
    scanf("%99[^\n]", nomeJogador);

    while(strcmp(nomeJogador, "FIM") != 0){

        temNome = false;

        //Pesquisa binaria
        int inicio = 0, fim = j - 1, meio;

        inicioTempo = clock();
        while(inicio <= fim){
            meio = (inicio + fim) / 2;

            comp++;
	    char nomeAsterisco[50];
	    strcpy(nomeAsterisco, playersClone[meio].nome);
	    nomeAsterisco[strcspn(nomeAsterisco, "*")] = '\0';

            if(strcmp(nomeJogador, playersClone[meio].nome) == 0 || strcmp(nomeAsterisco, nomeJogador) == 0){ 
                temNome = true;
                break;

            } else if(strcmp(nomeJogador, playersClone[meio].nome) < 0){ //Se a primeira string for menor, o resultado é negativo
                fim = meio - 1;
                comp++;
            } 

              else{ //Se a primeira string for maior, o resultado é positivo
                inicio = meio + 1;
                comp++;
              } 
        }
        fimTempo = clock();

        if(temNome) printf("SIM\n");
        else printf("NAO\n");

        getchar();
        scanf("%99[^\n]", nomeJogador);

    }


    float tempo = fimTempo - inicioTempo; 
    fclose(arq);

    arq = fopen("807205_binaria", "w");
    fprintf(arq, "807205\t %f\t %i", tempo, comp);
}