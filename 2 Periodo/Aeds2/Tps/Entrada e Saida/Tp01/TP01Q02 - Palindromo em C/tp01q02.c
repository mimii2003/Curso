/*
 * TP - Algoritmos e Estruturas de Dados II
 * @author - Milena Soares Barreira
 * 2021 - 2o. Semestre
 */
#include <stdio.h>
#include <string.h>
int isFim (char palavra[]){
    int result=0;
    if (strcmp(palavra, "FIM")==0)
    result=1;
    return result;
}
int main(){

    char palavra[500];
    int i, tamanho, dif = 0;
    
    scanf("%[^\n]", palavra);
    scanf("%*[^\n]"); scanf("%*c");
    while (isFim(palavra)!=1){
    tamanho = strlen(palavra);
    tamanho--;
    
    i = 0; 

    while(tamanho >= i){
        if(palavra[i] != palavra[tamanho]) 
        dif ++;
        i++;
        tamanho--;
    }


    if(dif == 0)
    
        printf("SIM\n");
    else
        printf("NAO\n");
        
    scanf("%[^\n]", palavra);
    scanf("%*[^\n]"); scanf("%*c"); 
    
    dif=0;
}
    // inverter a palavra
    return 0;
}
