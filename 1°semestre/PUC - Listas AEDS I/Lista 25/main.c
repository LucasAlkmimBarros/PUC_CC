#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

bool negativosIguaisPositivos(float A[][3], int n)
{
    bool ehIgual = false;
    int pos = 0, neg = 0;
    for(int i = 0; i < n; i++)
    {
        for(int j = 0; j < n; j++)
        {
            if(A[i][j] > 0) pos++;
            else if(A[i][j] < 0) neg++;
        }
    }
    if (pos == neg) ehIgual = true;
    return ehIgual;
}

int main()
{
    float matriz[3][3] = {{-1,2,-7}, {4,-9,-6}, {0,8,9}};
    bool negIgualPos = negativosIguaisPositivos(matriz, 3);
    if(negIgualPos) printf("SAO IGUAIS!");
    else printf("SAO DIFERENTES!");



    return 0;
}

