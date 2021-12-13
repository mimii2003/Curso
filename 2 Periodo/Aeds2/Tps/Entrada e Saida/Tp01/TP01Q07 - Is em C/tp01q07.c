/*
 * TP - Algoritmos e Estruturas de Dados II
 * @author - Milena Soares Barreira
 * 2021 - 2o. Semestre
 */
#include <stdio.h>
#include<string.h>
int isFim (char palavra[]){
    int result=0;
    if (strcmp(palavra, "FIM")==0)
    result=1;
    return result;
}

int Vogais(char *palavra){
    int tamanho, i ,Contavog=0;
    tamanho = strlen(palavra);
        //conta vogais
for ( i = 0; i < tamanho; i++)
{
            // verifica se é uma vogal de a a u
if ((palavra[i] == 'a' || palavra[i] == 'e' ||  palavra[i] == 'i' ||  palavra[i] == 'o' ||  palavra[i] == 'u'|| palavra[i] == 'A' || palavra[i]== 'E' || palavra[i] == 'I' || palavra[i] == 'O' ||palavra[i] == 'U' )){
    Contavog++;
}
}
if(strcmp(palavra, "FIM")){
    
if (Contavog==tamanho)
printf ("SIM ");

else 
printf ("NAO ");}
}

int Consoantes(char *palavra){
    int tamanho, i ,ContaCons=0;
    tamanho = strlen(palavra);
    for ( i = 0; i < tamanho; i++)
{
if ((palavra[i] == 'b' || palavra[i] == 'c' ||  palavra[i] == 'd' ||  palavra[i] == 'f' ||  palavra[i] == 'g'|| palavra[i] == 'h' || palavra[i]== 'j' || palavra[i] == 'k' || palavra[i] == 'm' ||palavra[i] == 'n'|| palavra[i] == 'p' || palavra[i] == 'q' ||palavra[i] == 'r' ||  palavra[i] == 's' ||  palavra[i] == 't' ||  palavra[i] == 'v' ||  palavra[i] == 'w' || palavra[i] == 'x' || palavra[i] == 'y' ||  palavra[i] == 'z' )){
ContaCons++;
}
}
if(strcmp(palavra, "FIM")){
if (ContaCons==tamanho){
printf ("SIM ");}
else {
printf ( "NAO ");}
}
}

int Inteiros(char *palavra){
    int tamanho, i ,ContaInt=0;
    tamanho = strlen(palavra);
    for ( i = 0; i < tamanho; i++)
{
if ((palavra[i] == '1' || palavra[i] == '2' ||  palavra[i] == '3' ||  palavra[i] == '4' ||  palavra[i] == '5'|| palavra[i] == '6' || palavra[i]== '7' || palavra[i] == '8' || palavra[i] == '9' ||palavra[i] == '0' )){
ContaInt++;
}}
if(strcmp(palavra, "FIM")){
if (ContaInt==tamanho)
printf ("SIM ");
else printf ( " NAO ");
}
}

int Real(char *palavra){
    int tamanho, i ,ContaReal=0;
    tamanho = strlen(palavra);
    for ( i = 0; i < tamanho; i++)
{
    if ((palavra[i] >= '0' &&  palavra[i] <= '9' || palavra[i] == '.' ||palavra[i] == ',')){
ContaReal++;
}}
if(strcmp(palavra, "FIM")){
if (ContaReal==tamanho)
printf ("SIM \n");
else printf ( "NAO \n");
}
}

int main()
{
char entrada[2000];
int Contavog=0, ContaCons2=0, ContaInt=0, ContaReal=0;
int i, tamanho;

do {
    Contavog=0, ContaCons2=0, ContaInt=0, ContaReal=0 ;
    scanf("%[^\n]", entrada);
    scanf("%*[^\n]"); scanf("%*c");
    
        tamanho = strlen(entrada);
Vogais(entrada);
Consoantes(entrada);
Inteiros(entrada);
Real(entrada);

}while (isFim(entrada)!=1);    
return 0;

}



