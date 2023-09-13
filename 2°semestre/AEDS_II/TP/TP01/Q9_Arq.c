#include <stdio.h>

int main() {
    int n;
    long pos;
    double resp;
    scanf("%i", &n);

    /* Aqui fazemos a leitura dos valores reais e inserimos eles no arquivo */

    FILE* arq = fopen("Q9_Arq.txt", "wb+"); // Abrindo o arquivo no modo escrita
    if (arq == NULL) // Caso o arquivo não abra
    {
        printf("Ocorreu um erro ao abrir o arquivo\n");
        return 0;
    }

    double value;
    for (int i = 0; i < n; i++) // Laco para preencher o arquivo com os valores
    {
        scanf("%lf", &value);
        fwrite(&value, sizeof(double), 1, arq);
    }

    fclose(arq);

    /* Aqui vamos ler os valores de trás para frente e mostrá-los na tela */
    arq = fopen("Q9_Arq.txt", "rb+");
    if (arq == NULL) // Caso o arquivo não abra
    {
        printf("Ocorreu um erro ao abrir o arquivo\n");
        return 0;
    }

    for (int i = n - 1; i >= 0; i--) {
        fseek(arq, i * sizeof(double), SEEK_SET); // Move o cursor para a posição correta
        fread(&resp, sizeof(double), 1, arq);
        printf("%.6g\n", resp);
    }

    fclose(arq);

    return 0;
}

