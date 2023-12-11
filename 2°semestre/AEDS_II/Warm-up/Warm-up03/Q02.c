#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <stdbool.h>

void main()
{
    int entrada;
    scanf("%i", &entrada);

    while (entrada != 0)
    {
        // Criando as pilhas
        int p1[entrada];
        int p2[entrada];
        int p3[entrada];

        // Criando os contadores
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;

        for (int i = entrada - 1; i >= 0; i--)
        { // Aqui o for e invertido para inserirmos os ultimos elementos no final
            scanf("%i", &p1[i]);
            scanf("%i", &p2[i]);
            scanf("%i", &p3[i]);
        }

        bool ehValido = true;

        do
        {

            if (c1 < entrada && c2 < entrada && c3 < entrada && (p1[c1] + p2[c2] + p3[c3]) % 3 == 0)
            { // p1 + p2 + p3
                c1++;
                c2++;
                c3++;
            }
            else if (c1 < entrada && c2 < entrada && (p1[c1] + p2[c2]) % 3 == 0)
            { // p1 + p2
                c1++;
                c2++;
            }
            else if (c1 < entrada && c3 < entrada && (p1[c1] + p3[c3]) % 3 == 0)
            { // p1 + p3
                c1++;
                c3++;
            }
            else if (c2 < entrada && c3 < entrada && (p2[c2] + p3[c3]) % 3 == 0)
            { // p2 + p3
                c2++;
                c3++;
            }
            else if (c1 < entrada && p1[c1] % 3 == 0)
            { // p1
                c1++;
            }
            else if (c2 < entrada && p2[c2] % 3 == 0)
            { // p2
                c2++;
            }
            else if (c3 < entrada && p3[c3] % 3 == 0)
            { // p3
                c3++;
            }
            else
            {
                ehValido = false;
            }
        } while (ehValido && (c1 < entrada || c2 < entrada || c3 < entrada));

           if(ehValido){
                printf("1\n");    
           }    
           else{
            printf("0\n");
           }

           scanf("%i", &entrada);
    }
}