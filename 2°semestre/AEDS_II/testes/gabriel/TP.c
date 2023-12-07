#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Lua{
    char nome[100];
    int raiolua;
}lua;//Lua é o nome da struct que contém os elementos das luas que vamos analisar

typedef struct planeta{
    char nome[100];
    int raioplaneta;
    int quantluas;
    lua* luas;
}planeta;//Planeta é o nome da struct que contém os elementos dos planetas que vamos analisar

typedef struct sistema{
    int tempo;
    char nome[100];
    int raiosol;
    int quantplanetas;
    planeta* planetas;
}sistema;//Sistema é o nome da struct que coném os elementos dos sistemas que vamos analisar


void bromerosortsistemas(sistema* vet, int l, int r); //função de ordenação

int ritacao(sistema* vet, int l, int r);//função para escolher o pivo

int compararsistemas(const void*a, const void*b); //função para comparar sistemas

void trocarsistemas(sistema* a, sistema* b); //função para trocar 2 sistemas de lugar


int main(){

    int n;//n é a quantidade de sistemas que vamos analisar
    scanf("%d", &n);
    sistema* sis;//Criação de um vetor de sistemas com tamanho n

    sis = malloc(n*sizeof(sistema));//Alocação dinâmica de memória para o vetor de sistemas

    for(int i = 0; i<n; i++){//estrutura de repetição para ler os dados de cada sistema
        scanf("%d", &sis[i].tempo);
        scanf("%s", sis[i].nome);
        scanf("%d", &sis[i].raiosol);
        scanf("%d", &sis[i].quantplanetas);

        sis[i].planetas = malloc(sis[i].quantplanetas*sizeof(planeta));//Alocação dinâmica de memória para o vetor de planetas de cada sistema

        for(int j = 0; j<sis[i].quantplanetas; j++){//estrutura de repetição para ler os dados de cada planeta
            scanf("%s", sis[i].planetas[j].nome);
            scanf("%d", &sis[i].planetas[j].raioplaneta);
            scanf("%d", &sis[i].planetas[j].quantluas);

            sis[i].planetas[j].luas = malloc(sis[i].planetas[j].quantluas*sizeof(lua));//Alocação dinâmica de memória para o vetor de luas de cada planeta

            for(int k = 0; k<sis[i].planetas[j].quantluas; k++){//estrutura de repetição para ler os dados de cada lua
                scanf("%s", sis[i].planetas[j].luas[k].nome);
                scanf("%d", &sis[i].planetas[j].luas[k].raiolua);
            }
        }


    }

    bromerosortsistemas(sis, 0, n-1);//enviamos 3 parâmetros para a função de ordenação: o vetor de sistemas, o índice inicial e o índice final

    //agora os sistemas ja estão ordenados, então vamos imprimir os dados de cada um

    for(int i = 0; i<n; i++){
        printf("%s\n", sis[i].nome);
    }

    //agora vamos liberar a memoria que foi alocada dinamicamente
    for(int i = 0; i<n; i++){
        for(int j = 0; j<sis[i].quantplanetas; j++){
            free(sis[i].planetas[j].luas);//liberamos a memória alocada para o vetor de luas de cada planeta
        }
        free(sis[i].planetas);//liberamos a memória alocada para o vetor de planetas de cada sistema
    }
    free(sis);//liberamos a memória alocada para o vetor de sistemas

    return 0;
}


void bromerosortsistemas(sistema* vet, int l, int r){//vet[] é o vetor de sistemas que estamos recebendo, baixo é o menor indice e alto é o maior
    if(l < r) {

        int q = ritacao(vet, l, r);//q é o indice do pivo, que é o elemento que vai dividir o vetor em 2 subarrays, um com elementos menores que ele e outro com elementos maiores que ele
        bromerosortsistemas(vet, l, q-1);//chamamos a função para ordenar o subarray da esquerda
        bromerosortsistemas(vet, q+1, r);//chamamos a função para ordenar o subarray da direita







        /*

        int pivo = r;//o pivo é o último elemento do vetor
        int i = l-1;// inicializamos i como l-1 para que ele sempre inicie com um valor menor que o indice do primeiro elemento do subarray

        for(int j = l; j<r; j++){//loop para percorrer o subarray
            if (compararsistemas(&vet[j], &vet[pivo]) < 0) { //mandamos 2 elementos para o sistema de comparação, se o retorno for menor que 0, significa que o primeiro elemento é menor que o segundo, então mandamos para a troca
                i++;
                trocarsistemas(&vet[i], &vet[j]);//mandamos 2 elementos para o sistema de troca
            }
        }

        trocarsistemas(&vet[i+1], &vet[r]);//mandamos 2 elementos para o sistema de troca, após percorrer o subarray, o pivo é trocado com o elemento na posição i+1
        pivo = i+1;//atualizamos o valor do pivo


        //chamadas recursivas para ordenar os subarrays da direita e da esquerda
        bromerosortsistemas(vet, l, pivo-1);//chamamos a função para ordenar o subarray da esquerda
        bromerosortsistemas(vet, pivo+1, r);//chamamos a função para ordenar o subarray da direita
        */
    }
}



int ritacao(sistema*vet, int l, int r){
    int q = r;
    int i = l-1;
    int j = l;

    for(j = l; j<r; j++){
        if(compararsistemas(&vet[j], &vet[q]) < 0){
            i++;
            trocarsistemas(&vet[i], &vet[j]);
        }
    }

    return i;
}






















int compararsistemas(const void*a, const void*b){//função para comparar sistemas
    sistema* A = (sistema*)a;//aqui, estou atribuindo o valor das variaveis passadas por parametro do tipo void para variaveis do tipo (sistema*), que é o que deve usar
    sistema* B = (sistema*)b;

    if(A->raiosol != B->raiosol){//criterio 1 de comparação (raio do sol do sistema)
        return B->raiosol - A->raiosol; //vamos retornar a diferença entre os raios dos sóis, pois se o resultado for negativo, quer dizer que o elemento a é maior que o b, e vai atender a condição dentro do loop
    }

    if(A->quantplanetas != B->quantplanetas){//criterio 2 de comparação (quantidade de planetas do sistema)
        return B->quantplanetas - A->quantplanetas;//vamos retornar a diferença entre as quantidades de planetas, pois se o resultado for negativo, quer dizer que o elemento a é maior que o b, e vai atender a condição dentro do loop
    }

    int maiorplanetaA = 0;//variável para armazenar o maior planeta do sistema A
    int maiorplanetaB = 0;//variável para armazenar o maior planeta do sistema B

    for(int i = 0; i<A->quantplanetas; i++){//loop para percorrer o vetor de planetas do sistema A
        if(A->planetas[i].raioplaneta > maiorplanetaA){//se o raio do planeta atual for maior que o maior raio armazenado, atualizamos o valor da variável
            maiorplanetaA = A->planetas[i].raioplaneta;
        }
    }

    for(int i = 0; i<B->quantplanetas; i++){//loop para percorrer o vetor de planetas do sistema B
        if(B->planetas[i].raioplaneta > maiorplanetaB){//se o raio do planeta atual for maior que o maior raio armazenado, atualizamos o valor da variável
            maiorplanetaB = B->planetas[i].raioplaneta;
        }
    }

    if(maiorplanetaA != maiorplanetaB){//criterio 3 de comparação (tamanho do maior planeta do sistema)
        return maiorplanetaB - maiorplanetaA;//vamos retornar a diferença entre os tamanhos dos maiores planetas de cada sistema, assim como nos outros critérios, se o resultado for negativo, quer dizer que o elemento a é maior que o b, e vai atender a condição dentro do loop
    }

    int quantluasA = 0;//variável para armazenar a quantidade de luas do sistema A
    int quantluasB = 0;//variável para armazenar a quantidade de luas do sistema B

    for(int i = 0; i<A->quantplanetas; i++){//loop para percorrer o vetor de planetas e ir somando a quantidade de luas do sistema no total(criterio 4)
        quantluasA += A->planetas[i].quantluas;
    }

    for(int i = 0; i<B->quantplanetas; i++){
        quantluasB += B->planetas[i].quantluas;
    }

    if(quantluasA != quantluasB){//criterio 4 de comparação (quantidade de luas do sistema)
        return quantluasB - quantluasA;//vamos retornar a diferença entre as quantidades de luas de cada sistema, igual os outros critérios, se o resultado for negativo, quer dizer que o elemento a é maior que o b, e vai atender a condição dentro do loop
    }

    int maiorluaA = 0;//variável para armazenar a maior lua do sistema A
    int maiorluaB = 0;//variável para armazenar a maior lua do sistema B

    for(int i = 0; i<A->quantplanetas; i++){
        for(int j = 0; i<A->planetas[i].quantluas; j++){//loop para percorrer o vetor de luas de cada planeta e ir atualizando o valor da variável com o maior raio de lua do sistema
            if(A->planetas[i].luas[j].raiolua > maiorluaA){
                maiorluaA = A->planetas[i].luas[j].raiolua;
            }
        }
    }

    for(int i = 0; i<B->quantplanetas; i++){
        for(int j = 0; i<B->planetas[i].quantluas; j++){//loop para percorrer o vetor de luas de cada planeta e ir atualizando o valor da variável com o maior raio de lua do sistema
            if(B->planetas[i].luas[j].raiolua > maiorluaB){
                maiorluaB = B->planetas[i].luas[j].raiolua;
            }
        }
    }

    if(maiorluaA != maiorluaB){//criterio 5 de comparação (tamanho da maior lua)
        return maiorluaB - maiorluaA;//retornamos a diferença entre os tamanhos das maiores luas de cada sistema, se o resultado for negativo, quer dizer que o elemento a é maior que o b, e vai atender a condição dentro do loop
    }

    if(A->tempo != B->tempo){//criterio 6 de comparação (tempo de vida do sistema)
        return A->tempo - B->tempo;//retornamos a diferença entre os tempos de vida de cada sistema, se o resultado for negativo, quer dizer que o elemento B é maior que o A, e vai atender a condição dentro do loop, já que no caso de tempo de descobrimento, prevalece o mais recente, ou seja, o menor
    }

    return 0;

}

void trocarsistemas(sistema* a, sistema* b){//função para trocar 2 sistemas de lugar
    sistema aux = *a;
    *a = *b;
    *b = aux;
}