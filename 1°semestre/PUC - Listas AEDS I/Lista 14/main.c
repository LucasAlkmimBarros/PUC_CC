#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <ctype.h>
#include <stdbool.h>
#include <math.h>

const int NCOL = 5;

int fibonacci(int k)
{
    if (k <= 0) {
        return 0; // Condição de parada quando k é menor ou igual a 0
    } else if (k == 1 || k == 2) {
        return 1; // Condição de parada quando k é igual a 1 ou 2
    } else {
        return fibonacci(k - 1) + fibonacci(k - 2); // Chamada recursiva correta
    }
}



int main()
{
    int k;
    int prim = 1;
    int seg = 1;
    printf("Digite o k-esimo termo: ");
    scanf("%i", &k);
    int fib = fibonacci(k);
    printf("O valor eh %i", fib);


    return 0;
}
