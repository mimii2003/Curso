/*
 * TP - Algoritmos e Estruturas de Dados II
 * @author - Milena Soares Barreira
 * 2021 - 2o. Semestre
 */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Serie{
    char nome[100];
    char formato[100];
    char duracao[100];
    char pais[100];
    char idioma[100];
    char emissora[100];
    char transmissora[100];
    int temporadas;
    int episodios;
    
    
}Serie;
void MetodoConstrutor(Serie *serie){
    
    strcpy(serie -> nome, "");
    strcpy(serie -> formato, "");
    strcpy(serie -> duracao, "");
    strcpy(serie -> pais, "");
    strcpy(serie -> idioma, "");
    strcpy(serie -> emissora, "");
    strcpy(serie -> transmissora, "");
    serie -> temporadas = 0;
    serie -> episodios = 0;
}
void MetodoConstrutor2(Serie* serie, char nome[], char formato[], char duracao[], char pais[], char idioma[], char emissora[], char transmissora[])
{
    (*serie).temporadas = 0;
    (*serie).episodios = 0;
    strcpy(serie -> nome, nome);
    strcpy(serie -> formato, formato);
    strcpy(serie -> duracao, duracao);
    strcpy(serie -> idioma, idioma);
    strcpy(serie -> pais, pais);
    strcpy(serie -> duracao, emissora);
    strcpy(serie -> duracao, transmissora);

}
// metodos de get
char* GetNome(Serie *serie[], int i)
{
    return serie[i]->nome;
}
char* GetFormato(Serie *serie[], int i)
{
    return serie[i]->formato;
}
char* GetDuracao(Serie *serie[], int i)
{
    return serie[i]->duracao;
}
char* GetPais(Serie *serie[], int i)
{
    return serie[i]->pais;
}
char* GetIdioma(Serie *serie[], int i)
{
    return serie[i]->idioma;
}
char* GetEmissora(Serie *serie[], int i)
{
    return serie[i]->emissora;
}
char* GetTransmissao(Serie *serie[], int i)
{
    return serie[i]->transmissora;
}
int getEpisodios(Serie *serie){
    return serie->episodios;
}

int getTemporadas(Serie *serie){
    return serie->temporadas;
}
// funcao pra imprimir
void imprimir(Serie serie){
    printf("%s %s %s %s %s %s %s %i %i\n", serie.nome, serie.formato, serie.duracao, serie.pais, serie.idioma, serie.emissora, serie.transmissora, serie.temporadas, serie.episodios);
}
// remove as tags
char* removeTags(char* old){
    char *newLine = (char*) malloc(sizeof(strlen(old)));
    int i=0, j=0;
    while(i < strlen(old)){
        if(old[i] == '<'){
            i++;
            while(old[i] != '>') i++;
        }else{
            newLine[j] = old[i];
            j++;
        }
        i++;
    }
    newLine[j] = '\0';
    return newLine;
}
// transforma o remove tags de char pra int
int ConversorInt(char *s)
{
    char *ep;
    long l;

    l=strtol(removeTags(s),&ep,0);

    return l;
}
//remove os &160;
char* removeExtra(char* old){
    char *newLine = (char*) malloc(sizeof(strlen(old)));
    int i=0, j=0;
    for (int i = 0; i < strlen(old); i++) {
    // elemina a parte do &#160
        if(old[i] == '&'){
            i++;
            while(old[i] != ';') i++;
        }else{
            newLine[j] = old[i];
            j++;
        }
    }
    newLine[j] = '\0';
    return newLine;
}
// remove lista eps
char* removePalavra(char* old){
    char *newLine = (char*) malloc(sizeof(strlen(old)));
    int i=0, j=0;
    for (int i = 0; i < strlen(old); i++) {
    // elemina a parte do &#160
        if(old[i] == '('){
            i++;
            while(old[i] != ')') i++;
        }else{
            newLine[j] = old[i];
            j++;
        }
    }
    newLine[j] = '\0';
    return newLine;
}
char* ApagaEspaco(char* old){
    char *newLine = (char*) malloc(sizeof(strlen(old)));
    int i=0, j=0;
    for (int i = 0; i < strlen(old); i++) {
    // retira os espacos na hora de imprimir
        if(old[i] == '\n'){
            i++;
        }else{
            newLine[j] = old[i];
            j++;
        }
    }
    newLine[j] = '\0';
    return newLine;
}

void SetNome(Serie *serie, char nome[]){
    strcpy(serie -> nome, nome);
}
void SetFormato(Serie *serie, char formato[]){
    strcpy(serie -> formato, formato);
}
void SetDuracao(Serie *serie, char duracao[]){
    strcpy(serie -> duracao, duracao);
}
void SetPais(Serie *serie, char pais[]){
    strcpy(serie -> pais, pais);
}
void SetIdioma(Serie *serie, char idioma[]){
    strcpy(serie -> idioma, idioma);
}
void SetEmissora(Serie *serie, char emissora[]){
    strcpy(serie -> emissora, emissora);
}
void SetTransmissora(Serie *serie, char transmissora[]){
    strcpy(serie -> transmissora, transmissora);
}
void SetEpisodios(Serie *serie, int episodios){
    serie -> episodios = episodios;
}
void SetTemporadas(Serie *serie, int temporadas){
    serie -> temporadas = temporadas;
}
void ler(Serie *serie, char base[]) {
FILE *fp = fopen(base, "r");
char buf[2000];
char cont[200];
char cont2[200];
    while(strstr(buf, "infobox_v2")== NULL){
        fgets(buf, 2000,fp);
    }
    fgets(buf, 2000, fp);
    fgets(buf, 2000, fp);
    strcpy(cont, ApagaEspaco(buf));
    SetFormato(serie, removeTags(cont));
    while(strstr(buf, "Formato")== NULL){
        fgets(buf, 2000,fp);
    }
    fgets(buf, 2000, fp);
    removeTags(buf);
    while(strstr(buf, "Duração")== NULL){
        fgets(buf, 2000,fp);
    }
    fgets(buf, 2000, fp);
    strcpy(cont, ApagaEspaco(buf));
    SetDuracao(serie, removeTags(cont));
    while(strstr(buf, "País de origem")== NULL){
        fgets(buf, 2000,fp);
    }
    fgets(buf, 2000, fp);
    strcpy(cont, ApagaEspaco(buf));
    strcpy(cont2, removeTags(cont));
    SetPais(serie, removeExtra(cont2));
    while(strstr(buf, "Idioma original")== NULL){
        fgets(buf, 2000,fp);
    }
    fgets(buf, 2000, fp);
    strcpy(cont, ApagaEspaco(buf));
    SetIdioma(serie, removeTags(cont));
    while(strstr(buf, "Emissora de televisão original")== NULL){
        fgets(buf, 2000,fp);
    }
    fgets(buf, 2000, fp);
    strcpy(cont, ApagaEspaco(buf));
    SetEmissora(serie, removeTags(cont));
    while(strstr(buf, "Transmissão original")== NULL){
        fgets(buf, 2000,fp);
    }
    fgets(buf, 2000, fp);
    strcpy(cont, removeTags(buf));
    strcpy(cont2, ApagaEspaco(cont));
    SetTransmissora(serie, removeExtra(cont2));
    while(strstr(buf, "N.º de temporadas")== NULL){
        fgets(buf, 2000,fp);
    }
    fgets(buf, 2000, fp);
    strcpy(cont, ApagaEspaco(buf));
    SetTemporadas(serie, ConversorInt(cont));
    while(strstr(buf, "N.º de episódios")== NULL){
        fgets(buf, 2000,fp);
    }
    fgets(buf, 2000, fp);
    strcpy(cont, removePalavra(buf));
    SetEpisodios(serie, ConversorInt(cont));
    

fclose(fp);
}
int isFim (char palavra[]){
    int result=0;
    if (strcmp(palavra, "FIM")==0)
    result=1;
    return result;
}
int main()
{
    char html[100];
    int i=0;
    scanf("%[^\n]", html);
    scanf("%*[^\n]"); scanf("%*c");
    while (isFim(html)!=1){
    Serie serie;   
    MetodoConstrutor(&serie);
    char base[50] = "/tmp/series/";
    // junta a entrada base com o tmp series
    strcat(base, html);
    ler(&serie, base);
    imprimir(serie);
    scanf("%[^\n]", html);
    scanf("%*[^\n]"); scanf("%*c");
    }
    return 0;
}
