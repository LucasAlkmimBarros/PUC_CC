#include <stdio.h>
#include <stdbool.h>

void limpar_buffer() {
    int c;
    while ((c = getchar()) != '\n' && c != EOF) {
    }
}

int main() {
    int M, N;
    int qtO = 0;
    bool temHash;

    do {
        scanf("%i %i", &N, &M);
    } while (N < 3 || N > 500 || M < 3 || M > 500 || N % 2 == 0);

    char parede[N][M];

    // PRIMEIRA LINHA
    do {
        limpar_buffer();
        for (int j = 0; j < M; j++) {
            scanf(" %c", &parede[0][j]);
        }
        qtO = 0;
        temHash = false;
        for (int j = 0; j < M; j++) {
            if (parede[0][j] == 'o') {
                qtO++;
            }
            if (parede[0][j] == '#') {
                temHash = true;
            }
        }
    } while (qtO != 1 || temHash);

    // OUTRAS LINHAS
    for (int i = 1; i < N; i++) {
        do {
            temHash = false;
            do {
                limpar_buffer();
                for (int j = 0; j < M; j++) {
                    scanf(" %c", &parede[i][j]);
                }
                if (parede[i][0] == '#' || parede[i][M - 1] == '#') {
                    printf("ERRO\n");
                }
            } while (parede[i][0] == '#' || parede[i][M - 1] == '#');
        } while ((i + 1) % 2 != 0 && temHash);
    }

    // Molhar a parede
    for (int i = 1; i < N; i += 2) {
        for (int j = 0; j < M; j++) {
            if (parede[i][j] == '.') {
                if ((i > 0 && parede[i - 1][j] == 'o') ||
                    (j > 0 && parede[i][j - 1] == 'o' && parede[i + 1][j - 1] == '#') ||
                    (j < M - 1 && parede[i][j + 1] == 'o' && parede[i + 1][j + 1] == '#')) {
                    parede[i][j] = 'o';
                }
            }
        }
    }

    printf("\n\n");

    // Imprimir a parede molhada
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            printf("%c", parede[i][j]);
        }
        printf("\n");
    }

    return 0;
}

