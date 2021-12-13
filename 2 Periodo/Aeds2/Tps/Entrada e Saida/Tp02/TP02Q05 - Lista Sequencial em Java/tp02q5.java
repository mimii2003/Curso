/**
 * Créditos da classe Série a João Augusto 
 * TP - Algoritmos e Estruturas de Dados II
 * @author - Milena Soares Barreira
 * 2021 - 2o. Semestre
 */

import java.io.*;
import java.io.FileReader;
import java.io.BufferedReader;

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
class Lista4 {
    private Serie6[] array;
    private int n;

	public Lista4() {
        this(10000);
	}
    public Lista4 (int tamanho){
        array = new Serie6[tamanho];
        n = 0;
        }
        public void inserirInicio(Serie6 x) throws Exception {

        //validar insercao
        if(n >= array.length){
            throw new Exception("Erro ao inserir!");
        } 
        //levar elementos para o fim do array
        for(int i = n; i > 0; i--){
            array[i] = array[i-1];
        }

        array[0] = x;
        n++;
        }


    public void inserirFim(Serie6 x) throws Exception {

        //validar insercao
        if(n >= array.length){
            throw new Exception("Erro ao inserir!");
        }

        array[n] = x;
        n++;
        }

        public void inserir(Serie6 x, int pos) throws Exception {

        //validar insercao
        if(n >= array.length || pos < 0 || pos > n){
            throw new Exception("Erro ao inserir!");
        }
        //levar elementos para o fim do array
        for(int i = n; i > pos; i--){
            array[i] = array[i-1];
        }
        array[pos] = x;
        n++;
        }

    public Serie6 removerInicio() throws Exception {

        //validar remocao
        if (n == 0) {
            throw new Exception("Erro ao remover!");
        }
        Serie6 resp = array[0];
        n--;

        for(int i = 0; i < n; i++){
            array[i] = array[i+1];
        }
        return resp;
        }

        public Serie6 removerFim() throws Exception {

        //validar remocao
        if (n == 0) {
            throw new Exception("Erro ao remover!");
        }

        return array[--n];
        }

        public Serie6 remover(int pos) throws Exception {

        //validar remocao
        if (n == 0 || pos < 0 || pos >= n) {
            throw new Exception("Erro ao remover!");
        }
        Serie6 resp = array[pos];
        n--;
        for(int i = pos; i < n; i++){
            array[i] = array[i+1];
        }

        return resp;
        }
    public void mostrar (){
        for(int i = 0; i < n; i++){
			array[i].printClass();
		}
        
    }
    
}
public class tp02q5 {
    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }
    public static void main(String[] args){
        String entrada = MyIO.readLine();
        Serie6[] ser = new Serie6[10000];
        Serie6 serie = new Serie6();   
        Lista4 lista = new Lista4();
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
            try {
                lista.inserirFim(ser[j]);
            } catch (Exception e) {
            }
    }

        int n = MyIO.readInt();
        for(int m=0; m < n; m++){

            entrada = MyIO.readLine();
            if(entrada.charAt(0)=='I' && entrada.charAt(1)=='I'){
                //insere no inicio a serie desejada
                entrada = entrada.replace("II", "");
                entrada=entrada.trim();
                serie = new Serie6();
                try{
                serie.readClass(entrada);
                }
                catch(Exception e){}
                try {
                    lista.inserirInicio(serie);
                } catch (Exception e) {
                }
            }
            else if(entrada.charAt(0)=='I' && entrada.charAt(1)=='F'){
                //insere no fim a serie desejada
                entrada = entrada.replace("IF", "");
                entrada=entrada.trim();
                serie = new Serie6();
                try{
                serie.readClass(entrada);
                }
                catch(Exception e){}
                try {
                    lista.inserirFim(serie);
                } catch (Exception e) {
                }
            }
            else if(entrada.charAt(0)=='I' && entrada.charAt(1)=='*'){
            entrada = entrada.replace("I*", "");
            entrada=entrada.trim();
            char[] vet = new char[2];
            int posicao=0;
            vet[0]=entrada.charAt(0);
            vet[1]=entrada.charAt(1);
            posicao=Integer.parseInt(new String(vet));
            entrada=entrada.replaceAll("[0-4]", "");
            entrada=entrada.trim();
            serie = new Serie6(); 
            try{serie.readClass(entrada);}
            catch(Exception e){}
            try {
                lista.inserir(serie, posicao);
            } catch (Exception e) {
            }
            }
            else if(entrada.charAt(0)=='R' && entrada.charAt(1)=='I'){
                serie = new Serie6();
                try {
                    serie = lista.removerInicio();
                } catch (Exception e) {
                }   
                MyIO.println("(R) " + serie.getName());
            }
            else if(entrada.charAt(0)=='R' && entrada.charAt(1)=='*'){
                // transforma em innteiro, remove de uma posicao digitada e imprime o nome da serie
                int posicao;
                entrada = entrada.replace("R*", "");
                entrada=entrada.trim();
                posicao=Integer.parseInt(entrada);
                serie = new Serie6();
                try {
                    serie = lista.remover(posicao);
                } catch (Exception e) {
                }    
                MyIO.println("(R) " + serie.getName());
            }

            else if(entrada.charAt(0)=='R' && entrada.charAt(1)=='F'){
                // remove do fim e imprime o nome da serie
                serie = new Serie6();
                try {
                    serie = lista.removerFim();
                } catch (Exception e) {
                }
                MyIO.println("(R) " + serie.getName());
            }
        }
        lista.mostrar();
        serie = new Serie6();
    }
}