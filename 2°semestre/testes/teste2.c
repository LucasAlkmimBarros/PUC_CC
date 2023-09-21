#include <stdio.h> 
#define N 4

int main() {
    int nums[N], ans[N], esq [N], dir[N], i = 0;
    // codigo para ler valores do teclado e armazenar no vetor nums
    for (i = 0; i < N; ++i) {
        scanf("%d", &nums[i]);
    }
    esq[0] = 1; //menor posicao do vetor

    // computando valores a esquerda da posicao i
    for(int i = 1; i < N; ++i) {
        esq[i] = esq[i-1] * nums[i-1];
    }

    // computando valores a direita da posicao i
    dir [N-1] = 1; //maior posicao do vetor
    for (int i = N-2; i >= 0; --i) { //vetor e preenchido de tras para frente
        dir[i] = dir[i+1] * nums[i+1];
    }

    // computando vetor final no vetor ans
    for (int i = 0; i < N; ++i) {
        ans[i] = esq[i] * dir[i];
    }

    // codigo para imprimir na tela os valores do vetor ans
    for (int i = 0; i < N; ++i) {
        printf("%d ", ans[i]);
    }
}

