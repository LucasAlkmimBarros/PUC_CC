#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
const int TAM = 5;

typedef struct
{
    int dia;
    int mes;
    int ano;
}Data;

void escreveData(Data* data)
{
    printf("%i/%i/%i\n", data->dia, data->mes, data->ano);
}

void leiaData(Data* data)
{
    printf("DIA: ");
    scanf("%i", &data->dia);
    printf("MES: ");
    scanf("%i", &data->mes);
    printf("ANO: ");
    scanf("%i", &data->ano);
    printf("\n\n");
}

bool confereMes(Data* data[], int mes)
{
    bool temMes = false;
    for(int i = 0; i < TAM; i++)
    {
        if(data[i]->mes == mes) temMes = true;
    }
    return temMes;
}

void escreveDataDoMes(Data* data[], int mes)
{
    bool existeData = false;
    for(int i = 0; i < TAM; i++)
    {
        if(data[i]->mes == mes)
        {
            escreveData(data[i]);
            existeData =  true;
        }
    }
    if(!existeData) printf("\nNAO EXITE NENHUMA DATA COM ESSE MES...");
}

int main()
{
    Data* datas[TAM];
    for(int i = 0; i < TAM; i++)
    {
        datas[i] = (Data*)malloc(sizeof(Data));
        leiaData(datas[i]);
    }
    for(int i = 0; i < TAM; i++)
    {
        printf("%i.a Data: ", i+1);
        escreveData(datas[i]);
    }
    int mes;
    printf("\n\nDigite o mes que voce que conferir: ");
    scanf("%i", &mes);
    bool temMes = confereMes(datas, mes);
    if(temMes) printf("TEM O MES!");
    else printf("NAO TEM O MES...");

    printf("\n\nDigite o mes que voce quer ver as datas: ");
    scanf("%i", &mes);
    escreveDataDoMes(datas, mes);

    return 0;
}
