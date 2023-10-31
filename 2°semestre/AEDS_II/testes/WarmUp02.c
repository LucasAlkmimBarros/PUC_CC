#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

int main(){
	int linhas, colunas, u;
	scanf("%i %i %i", &linhas, &colunas, &u);
	
	int cartelas[linhas][colunas];
	for(int i = 0; i < linhas; i++){
		for(int j = 0; j < colunas; j++){
			scanf("%i", &cartelas[i][j]);
		}
	}
	
	int sorteados[u];
	for(int i = 0; i < u; i++){
		scanf("%i", &sorteados[i]);
	}

	int qtSorteados[linhas];
	for(int i = 0; i < linhas; i++){ //preenchendo o array contador com 0
		qtSorteados[i] = 0;
	}

	bool temVencedor = false;
	int n = 0;
	int num;
	while(!(temVencedor)){
		num = sorteados[n];
	        for(int i = 0; i < linhas; i++){
                	for(int j = 0; j < colunas; j++){
                        if(cartelas[i][j] == num){
							qtSorteados[i]++;
				}
                	}
        	}
		
		//Verificando se ja houve algum sorteado
		for(int i = 0; i < linhas; i++){
			if(qtSorteados[i] == colunas){
				temVencedor = true;
				printf("%i ", i+1);
			}
		}

		n++;
	}

	printf("\n");
}

