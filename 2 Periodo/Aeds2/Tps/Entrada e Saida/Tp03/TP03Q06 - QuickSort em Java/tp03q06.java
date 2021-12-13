/**
 * Créditos da classe Série a João Augusto 
 * TP - Algoritmos e Estruturas de Dados II
 * @author - Milena Soares Barreira
 * 2021 - 2o. Semestre
 */

import java.io.*;
import java.io.FileReader;

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
        this.name = this.name.trim();  
        return this.name;  
    }
    //método para retornar o atributo format
    public String getFormat(){
        this.format = this.format.trim();  
        return this.format; 
    }
    //método para retornar o atributo duration
    public String getDuration(){ 
        return this.duration; 
    }
    //método para retornar o atributo country
    public String getCountry(){
        this.country = this.country.trim(); 
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
	private int n;
    int movimentacoes;
    int comparacoes=0;
    public Lista3() {
		this(10000);
	}

	public Lista3(int tamanho) {
		array = new Serie6[tamanho];
		n = 0;
	}
    public void inserirFim(Serie6 item) {
        if (n <= array.length) {
            comparacoes++;
            movimentacoes++;
            array[n] = item;
            n++;
        }
    }
    public void quicksort(int esq, int dir) {
    int i = esq, j = dir;
    Serie6 pivo = array[(dir+esq)/2];
    movimentacoes++;
    while (i <= j) {
        while ((array[i].getCountry().compareTo(pivo.getCountry()) < 0)|| 
        ((array[i].getCountry().compareTo(pivo.getCountry()) == 0) && 
        (array[i].getName().compareTo(pivo.getName())< 0))){
            movimentacoes++;
        i++;
        comparacoes = 2*(comparacoes++);
        }
        while ((array[j].getCountry().compareTo(pivo.getCountry()) > 0) || 
        ((array[j].getCountry().compareTo(pivo.getCountry()) == 0) && 
        (array[j].getName().compareTo(pivo.getName())> 0))){
            movimentacoes++;
        j--;
        comparacoes = 2*(comparacoes++);}
        if (i <= j) {
            swap(i, j);
            i++;
            j--;
        }
    }
    if (esq < j) { 
        quicksort(esq, j);
        comparacoes++;}
    if (i < dir){ 
        quicksort(i, dir);
        comparacoes++;}
}
public void sort() {
    quicksort(0, n-1);
}
public void swap(int pos1, int pos2){
    movimentacoes =  3*movimentacoes;;
    Serie6 aux;
    aux = array[pos1];
    array[pos1] = array[pos2];
    array[pos2] = aux;
}


    public void mostrar (){
        for(int i = 0; i < n; i++){
            comparacoes++;
        this.array[i].printClass();
        }  
    }
    
}
public class tp03q06 {
    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }
    public static void main(String[] args){
        long start = System.nanoTime();
        int j=0;
        String entrada = MyIO.readLine();
        Serie6[] ser = new Serie6[10000];
        Serie6 serie = new Serie6();   
        Lista3 lista = new Lista3();

        do{
            ser[j] = new Serie6();
            try {
                ser[j].readClass(entrada);
            } catch (Exception e) {}
            j++;
            serie = new Serie6();
            try{
                serie.readClass(entrada);
            }catch(Exception e){}
            try{
            lista.inserirFim(serie);
            }catch(Exception e){}
            entrada = MyIO.readLine();
        }while(isFim(entrada)!=true);
        if(entrada.charAt(0)=='F' && entrada.charAt(1)=='I' && entrada.charAt(2)=='M'){
        lista.sort();
        lista.mostrar();}
        long end = System.nanoTime();

        long elapsedTime = end - start;

        // 1 second = 1_000_000_000 nano seconds
        double elapsedTimeInSecond = (double) elapsedTime / 1_000_000_000;
        Arq.openWrite("matricula_quicksort.txt");
        Arq.println("727541" + "\t" + elapsedTimeInSecond+ "\t" +lista.comparacoes+ "\t" + lista.movimentacoes );
        Arq.close();
        Arq.openRead("matricula_quicksort.txt");
    }
}