/*
 * TP - Algoritmos e Estruturas de Dados II
 * @author - Milena Soares Barreira
 * 2021 - 2o. Semestre
 */
#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

int main(){
    int num;
    double aux, scan;
    // abre o arquivo
    FILE * arquivo = fopen("exercicio.txt", "wb");
    // lendo os inteiros;
    scanf("%d", &num);   
    for(int i = 0; i < num; i++){  
        scanf("%lf", &aux);
        // salva no arquivo
        fwrite(&aux, sizeof(double), 1, arquivo);
    }
     // fecha o arquivo igual nos exericicios de matricula.txt
    fclose(arquivo);     
    FILE * arquivo2 = fopen("exercicio.txt", "r");
    for(int i = 1; i <= num; i++){     
        // inverte os números
        fseek(arquivo2,-i*(sizeof(double)),SEEK_END);
        fread(&scan, sizeof(double), 1, arquivo2);
        printf("%g\n", scan);
    }
    // fechando o arquivo
    fclose(arquivo2);
    return 0;
}
