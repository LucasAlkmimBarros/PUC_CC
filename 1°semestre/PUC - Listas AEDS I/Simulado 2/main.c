#include <stdio.h>
#include <stdlib.h>

int main()
{
    int monica, f1, f2, f3;
    do{
    scanf("%i", &monica);
    }while(monica < 40 || monica > 110);
    do{
    do{
    scanf("%i", &f1);
    }while(f1 < 1 || f1 >= monica);
    do{
    scanf("%i", &f2);
    }while(f2 < 1 || f2 >= monica);
    }while(f1 == f2);
    f3 = monica - f1 - f2;
    int maior = f1;
    if(f2 > maior) maior = f2;
    if(f3 > maior) maior = f3;
    printf("%i", maior);

    return 0;
}
