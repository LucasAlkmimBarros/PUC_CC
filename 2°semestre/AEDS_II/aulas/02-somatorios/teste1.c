#include <stdio.h>
#include <stdlib.h>

int somatorioPArecusivo(double a, double b, int n){
    int soma = a;
    if(n == 0){
        return 0;
    } 
    else{
        soma += somatorioPArecusivo(a+b, b, n-1);
    }
    return soma;
}

int somatorioPAiterativo(double a, double b, int n){
    int soma = 0;
    for(int i = 0; i < n; i++){
        soma += a;
        a += b;
    }
    return soma;
}


int main(){
    int soma = somatorioPArecusivo(0, 2, 5);
    printf("A soma e: %i", soma);
}