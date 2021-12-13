/**
 * Créditos da classe Série a João Augusto 
 * TP - Algoritmos e Estruturas de Dados II
 * @author - Milena Soares Barreira
 * 2021 - 2o. Semestre
 */

import java.io.*;
import java.io.FileReader;
import java.io.BufferedReader;
class CCelula2 {
	public Serie6 item;
	public CCelula2 prox;    	
    public CCelula2(Serie6 valorItem, CCelula2 proxCelula)
    {
        item = valorItem;
        prox = proxCelula;
    }    			
    public CCelula2(Serie6 valorItem)
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
class Serie6{
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
    public Serie6(){
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
    public Serie6(String name, String format, String duration, String country, String language, String broadcaster, String streaming, int seasons, 
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
        this.language = this.language.trim(); 
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
    public Serie6 clone(){
        Serie6 resp = new Serie6();
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
    public String toString() {
        return this.name + " " + this.format + " " + this.duration + " " + this.country + " " + this.language + " " + this.broadcaster + " " +
        this.streaming + " " + this.seasons + " " + this.episodes;
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
        //System.out.println(resp);
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
            
            //método para mostrar a classe
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
class Lista3 {
    private Serie6[] array;
    private int primeiro; // Remove do indice "primeiro".
    private int ultimo; // Insere no indice "ultimo".

    /**
     * Construtor da classe.
     */
    public Lista3 () {
        this(1000);
    }

    /**
     * Construtor da classe.
     * @param tamanho Tamanho da fila.
     */
    public Lista3(int tamanho){
            array = new Serie6[tamanho+1];
        primeiro = ultimo = 0;
    }

    /**
     * Insere um elemento na ultima posicao da fila.
     * @param x int elemento a ser inserido.
     * @throws Exception Se a fila estiver cheia.
     */
    public void empilhar(Serie6 x) throws Exception {

       //validar insercao
        if (((ultimo + 1) % array.length) == primeiro) {
            throw new Exception("Erro ao inserir!");
        }

        array[ultimo] = x;
        ultimo = (ultimo + 1) % array.length;
    }

    /**
     * Remove um elemento da primeira posicao da fila e movimenta 
     * os demais elementos para o primeiro da mesma.
     * @return resp int elemento a ser removido.
     * @throws Exception Se a fila estiver vazia.
     */
    public Serie6 desempilhar() throws Exception {

       //validar remocao
        if (primeiro == ultimo) {
            throw new Exception("Erro ao remover!");
        }

        Serie6 resp = array[primeiro];
        for(int i=0; i<ultimo-1; i++){
            array[i] = array[i+1];
        }
        ultimo--;
        return resp;
    }
    public int Media() {
        float media=0, soma=0;
        int media_int=0;
            for(int i = primeiro; i < ultimo; i++){
            soma += array[i].getSeasons();
            }
            media = soma/ ultimo - primeiro;
            media_int=Math.round(media);
            return media_int;
        }
        public boolean Cheia() {
            return (ultimo == 5); 
        }
    /**
     * Mostra os array separados por espacos.
     */
    public void mostrar (){

        for(int i = primeiro; i != ultimo; i = ((i + 1) % array.length)) {
            System.out.print(array[i].toString() + " ");
        }
    }

    

    public boolean isVazia() {
        return (primeiro == ultimo); 
    }
    }

public class tp02q7 {
    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }
    public static void main(String[] args){
        String entrada = MyIO.readLine();
        Serie6[] ser = new Serie6[1000];
        Serie6 serie = new Serie6();   
        Lista3 lista = new Lista3();
        int i=0; 
        do{
            ser[i] = new Serie6();
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
                serie = new Serie6();
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
                try {
                    serie = lista.desempilhar();
                } catch (Exception e) {
                }  
            }
        }
    }
}