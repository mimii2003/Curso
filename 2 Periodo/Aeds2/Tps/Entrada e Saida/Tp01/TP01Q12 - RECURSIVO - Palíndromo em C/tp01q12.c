/*
 * TP - Algoritmos e Estruturas de Dados II
 * @author - Milena Soares Barreira
 * 2021 - 2o. Semestre
 */
#include <stdio.h>
#include <string.h>
int isPalind(char *palavra, int tamanho, int pos){
    int i, auxiliar=0;
    // divide a procura no array
if((tamanho/2) > pos){
    // se for diferentes nao é palindromo
        if(palavra[pos] != palavra[tamanho - 1 - pos]){
            auxiliar = 1;
            } 
        else {
            auxiliar = 0;
            return isPalind(palavra, tamanho, pos + 1);
        } 
}
        return auxiliar;
    }

int isFim (char palavra[]){
    int result=0;
    if (strcmp(palavra, "FIM")==0)
    result=1;
    return result;
}
int main(){

    char palavra[1000];
    int i=0, tamanho=0,j;
    
do{ 
scanf("%[^\n]", palavra);
scanf("%*[^\n]"); scanf("%*c");
    tamanho = strlen(palavra);
    j = isPalind(palavra, strlen(palavra), 0);
    // so imprime se a palavra for diferente de fim
 if(strcmp(palavra, "FIM")){
        if (j == 0) 
        printf("SIM\n");
        else 
        printf("NAO\n");}
}while (isFim(palavra)!=1);
    
    return 0;
}



