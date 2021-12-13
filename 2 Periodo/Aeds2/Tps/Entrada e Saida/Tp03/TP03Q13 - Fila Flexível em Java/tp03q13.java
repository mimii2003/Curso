/**
 * Créditos da classe Série a João Augusto 
 * TP - Algoritmos e Estruturas de Dados II
 * @author - Milena Soares Barreira
 * 2021 - 2o. Semestre
 */

import java.io.*;
import java.io.FileReader;

class Serie{
    //declaração dos atributos
    private String name;
    private String format;
    private String duration;
    private String country;
    private String language;
    private String broadcaster;
    private String streaming;
    private int seasons;
    private int episodes;
    //construtor primário
    public Serie(){
        name = "";
        format = "";
        duration = "";
        country = "";
        language = "";
        broadcaster = "";
        streaming = "";
        seasons = 0;
        episodes = 0;
    }
    //construtor secundário
    public Serie(String name, String format, String duration, String country, String language, String broadcaster, String streaming, int seasons, 
    int episodes){
        this.name = name;
        this.format = format;
        this.duration = duration;
        this.country = country;
        this.language = language;
        this.broadcaster = broadcaster;
        this.streaming = streaming;
        this.seasons = seasons;
        this.episodes = episodes;
    }
    //método para setar o atributo name
    public void setName(String name){
        this.name = name;
    }
    //método para setar o atributo formato
    public void setFormat(String format){
        this.format = format;
    }
    //método para setar o atributo duration
    public void setDuration(String duration){
        this.duration = duration;
    }
    //método para setar o atributo country
    public void setCountry(String country){
        this.country = country;
    }
    //método para setar o atributo language
    public void setLanguage(String language){
        this.language = language;
    }
    //método para setar o atributo broadcaster
    public void setBroadcaster(String broadcaster){
        this.broadcaster = broadcaster;
    }
    //método para setar o atributo streaming
    public void setStreaming(String streaming){
        this.streaming = streaming;
    }
    //método para setar o atributo seasons
    public void setSeasons(int seasons){
        this.seasons = seasons;
    }
    //método para setar o atributo episodes
    public void setEpisodes(int episodes){
        this.episodes = episodes;
    }
    //método para retornar o atributo name
    public String getName(){ 
        return this.name; 
    }
    //método para retornar o atributo format
    public String getFormat(){ 
        return this.format; 
    }
    //método para retornar o atributo duration
    public String getDuration(){ 
        return this.duration; 
    }
    //método para retornar o atributo country
    public String getCountry(){ 
        return this.country; 
    }
    //método para retornar o atributo language
    public String getLanguage(){ 
        return this.language; 
    }
    //método para retornar o atributo broadcaster
    public String getBroadcaster(){ 
        return this.broadcaster; 
    }
    //método para retornar o atributo streaming
    public String getStreaming(){ 
        return this.streaming; 
    }
    //método para retornar o atributo seasons
    public int getSeasons(){ 
        return this.seasons; 
    }
    //método para retornar o atributo episodes
    public int getEpisodes(){ 
        return this.episodes; 
    }
    //método para clonar a classe
    public Serie clone(){
        Serie resp = new Serie();
        resp.name = this.name;
        resp.format = this.format;
        resp.duration = this.duration;
        resp.country = this.country;
        resp.language = this.language;
        resp.broadcaster = this.broadcaster;
        resp.streaming = this.streaming;
        resp.seasons = this.seasons;
        resp.episodes = this.episodes;
        return resp;
    }
    //método para printar a classe
    public void printClass(){
        System.out.println(this.name + " " + this.format + " " + this.duration + " " + this.country + " " + this.language + " " + this.broadcaster + " " +
        this.streaming + " " + this.seasons + " " + this.episodes);
    }
    //método para tratar a linha, deixar apenas números e converter o retorno de String para Integer
    public int justInt(String line){
        String resp = "";
        for(int i = 0; i < line.length(); i++){
            if(line.charAt(i) >= '0' && line.charAt(i) <= '9'){ //caso o caracter seja um número ele é concatenado a variável resp
                resp += line.charAt(i);
            } else { //caso seja outro caracter, o i recebe o valor da condição de parada e o método de repetição é encerrado
                i = line.length();
            }
        }
        return Integer.parseInt(resp); //conversão da string resp para número inteiro a ser retornado
    }
    //método para a remoção das tags da linha lida do arquivo para retornar apenas o que é desejado
    public String removeTags(String line){
        String resp = "";
        int i = 0;
        while(i < line.length()){ //enquanto i for menor que o tamanho da String linha
            if(line.charAt(i) == '<'){ // é testado para verificar se o contador i ainda está dentro das tags
                i++;
                while(line.charAt(i) != '>') i++; //ao encontrar o sinal de fechamento das tags o laço de repetição é encerrado
            } else if(line.charAt(i) == '&'){ //mesmo tratamento de cima mas para outras exceções presentes em alguns outros arquivos
                i++;
                while(line.charAt(i) != ';') i++;
            } else { //o que estiver fora das tags é concatenado a String resp a ser retornada
                resp += line.charAt(i);
            }
            i++;
        }
        return resp;
    }
    //método para tratar o nome do arquivo e retornar o nome da série
    public String searchName(String fileName){
        String resp = "";
        for(int i = 0; i < fileName.length(); i++){
            if(fileName.charAt(i)  == '_'){ //caso o caracter na posição i seja igual ao '_' a variável resp recebe um espaço em branco
                resp += ' ';
            } else { //caso não tenha espaço em branco o caracter é concatenado à string resp
                resp += fileName.charAt(i);
            }
        }
        return resp.substring(0, resp.length()-5); //retorno da substring resp retirando os 5 últimos caracteres relacionados à extensão do arquivo
    }
    //método para leitura do arquivo .html e tratamento das linhas
    public void readClass(String fileName){
        String file = "/tmp/series/" + fileName;
        try {
            FileReader fileReader = new FileReader(file); //declaração da variável fileReader que será recebida pelo bufferedReader

            BufferedReader br = new BufferedReader(fileReader); //declaração do bufferedReader para leitura do arquivo

            //set nome da série
            this.name = searchName(fileName);

            //set Formato da série
            while(!br.readLine().contains("Formato"));
            this.format = removeTags(br.readLine());

            //set duração da série
            while(!br.readLine().contains("Duração"));
            this.duration = removeTags(br.readLine());

            //set país da série
            while(!br.readLine().contains("País de origem"));
            this.country = removeTags(br.readLine());

            //set idioma da série
            while(!br.readLine().contains("Idioma original"));
            this.language = removeTags(br.readLine());

            //set emissora da série
            while(!br.readLine().contains("Emissora de televisão"));
            this.broadcaster = removeTags(br.readLine());

            //set transmissão original da série
            while(!br.readLine().contains("Transmissão original"));
            this.streaming = removeTags(br.readLine());

            //set temporadas da série
            while(!br.readLine().contains("N.º de temporadas"));
            this.seasons = justInt(removeTags(br.readLine()));

            //set episódios da série
            while(!br.readLine().contains("N.º de episódios"));
            this.episodes = justInt(removeTags(br.readLine()));

            //fechamento do bufferedReader
            br.close();         
        //Tratamento de exceções
        } catch(FileNotFoundException e) {
            System.out.println("Unable to open file '" + fileName + "'");                
        } catch(IOException e) {
            System.out.println("Error reading file '" + fileName + "'");
        }
    }
}    
class CCelula2 {
	public Serie item;
	public CCelula2 prox;    	
    public CCelula2(Serie valorItem, CCelula2 proxCelula)
    {
        item = valorItem;
        prox = proxCelula;
    }    			
    public CCelula2(Serie valorItem)
    {
        item = valorItem;
        prox = null;
    }    			        	
    public CCelula2()
    {
    	item = null;
        prox = null;
    }    			        	
}              
class Lista3 {
    private CCelula2 frente; // Celula cabeca.
	private CCelula2 tras; // Ultima celula.
	private int qtde;

    public Lista3() {
		frente = new CCelula2();
		tras = frente;
	}
    public boolean vazia() {
		return frente == tras;
	}

    //Insere elemento na pilha (politica FILO).
	public void empilhar(Serie valorItem) {
        if (qtde==5)
            tras.item=valorItem;
        
        tras.prox = new CCelula2(valorItem);
		tras = tras.prox;
		qtde++;
	}

    //Remove elemento da pilha (politica FILO).
	public Serie desempilhar() {
        if (frente != tras) {
		CCelula2 tmp = frente;
        frente = frente.prox;
        Serie resp = frente.item;
        tmp.prox = null;
        tmp = null;
        qtde--;
		return resp;
		}
		return null;
    }   
    public boolean Cheia() {
        return(qtde == 5);
	}
    public int Media() {
    float media=0, soma=0;
    int media_int=0;
        for(CCelula2 i = frente.prox; i != null; i = i.prox){
        soma += i.item.getSeasons();
        }
        media = soma/qtde;
        media_int=Math.round(media);
        return media_int;
    }
    public void mostrar (){
        for (CCelula2 c = frente.prox; c != null; c = c.prox)
        System.out.print(c.item + " ");
    }
    public int quantidade() {
		return qtde;
	}
    
}
public class tp03q13 {
    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }
    public static void main(String[] args){
        String entrada = MyIO.readLine();
        Serie[] ser = new Serie[1000];
        Serie serie = new Serie();   
        Lista3 lista = new Lista3();
        int i=0; 
        do{
            ser[i] = new Serie();
            try {
                ser[i].readClass(entrada);
            } catch (Exception e) {}
            i++;
            entrada = MyIO.readLine();
        }while(isFim(entrada)!=true);


        for(int j=0; j < i; j++){
            if(lista.Cheia() == true){
                try{
                lista.desempilhar();
                }catch(Exception e){}
                serie = ser[j];
                try{
                    lista.empilhar(serie);
                }catch(Exception e){}
            }
            else{
                serie = ser[j];
            try{
                lista.empilhar(serie);
            }catch(Exception e){}
            }
            MyIO.println(lista.Media());
        }

        int n = MyIO.readInt();
        for(int k=0; k< n; k++){
            entrada = MyIO.readLine();
            if(entrada.charAt(0)=='I'){
                //insere no inicio a serie desejada
                entrada = entrada.replace("I", "");
                entrada=entrada.trim();
                serie = new Serie();
                try{
                serie.readClass(entrada);
                }
                catch(Exception e){}

                if(lista.Cheia() == false){
                try{
                lista.empilhar(serie);
                }catch(Exception e){}
                }

                else{
                    try{
                lista.desempilhar();
                }catch(Exception e){}
                try{
                    lista.empilhar(serie);
                }catch(Exception e){}
                }
                MyIO.println(lista.Media());
            }
            else if(entrada.charAt(0)=='R'){
                //insere no fim a serie desejada
                serie = lista.desempilhar();  
            }
        }
    }
}
