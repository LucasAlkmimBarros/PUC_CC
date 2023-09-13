//QUESTAO 44

#include <stdio.h>

int main() {
    int n, number, lastNumber, totalPairs, totalOdd, totalSum;
    totalPairs = totalOdd = totalSum = 0;
    lastNumber = -1; 

    printf("Digite a quantidade de numeros: ");
    scanf("%d", &n);

    totalPairs = n / 2;
    totalOdd = n % 2;

    for (int i = 0; i < totalPairs + totalOdd; i++) {
        printf("Digite o %dº numero: ", i + 1);
        scanf("%d", &number);

        if (lastNumber != -1) {
            totalSum += number + lastNumber;
        }

        lastNumber = number;
    }

    printf("Soma dos pares adjacentes: %d\n", totalSum);

    return 0;
}
