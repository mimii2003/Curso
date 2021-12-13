/**
 * Créditos da classe Série a João Augusto 
 * TP - Algoritmos e Estruturas de Dados II
 * @author - Milena Soares Barreira
 * 2021 - 2o. Semestre
 */
import java.io.*;
import java.io.FileReader;
import java.io.BufferedReader;
class Serie2{
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
    public Serie2(){
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
    public Serie2(String name, String format, String duration, String country, String language, String broadcaster, String streaming, int seasons, 
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
    public Serie2 clone(){
        Serie2 resp = new Serie2();
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
class No {
    public boolean cor;
    public Serie2 elemento;
    public No esq, dir;

	public No(Serie2 elemento){
        this(elemento, false, null, null);
    }
    public No(Serie2 elemento, boolean cor){
        this(elemento, cor, null, null);
    }


	public No (Serie2 elemento, boolean cor, No esq, No dir){
        this.cor = cor;
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
      }
    
}
class Alvinegra {
	private No raiz; // Raiz da arvore.
    int movimentacoes;
    int comparacoes=0;

	public Alvinegra() {
		raiz = null;
	}
	public boolean pesquisar(String elemento) {
		return pesquisar(elemento, raiz);
	}

	private boolean pesquisar(String elemento, No i) {
        boolean resp=false;
	    if (i==raiz){
        System.out.print(" raiz ");  
        }
		if (i == null) {
            comparacoes++;
            resp = false;
        }
        else if (elemento.equals(i.elemento.getName())) {
            resp = true;
            comparacoes++;
            movimentacoes++;
        } else if ((elemento.compareTo(i.elemento.getName())) < 0) {
            System.out.print("esq ");
            comparacoes++;
            movimentacoes++;
            resp = pesquisar(elemento, i.esq);            
        } else {
            System.out.print("dir ");
              comparacoes++;
            movimentacoes++;
            resp = pesquisar(elemento, i.dir); 
        }
        return resp;
	}

	public void inserir(Serie2 elemento) throws Exception {

        //Se a arvore estiver vazia
        if(raiz == null){
            movimentacoes++;
            raiz = new No(elemento);
        //Senao, se a arvore tiver um elemento 
        } else if (raiz.esq == null && raiz.dir == null){
            if (elemento.getName().compareTo(raiz.elemento.getName()) < 0){
                comparacoes++;
                movimentacoes++;
                raiz.esq = new No(elemento);
            } else {
                raiz.dir = new No(elemento);
            }
        //Senao, se a arvore tiver dois elementos (raiz e dir)
    } else if (raiz.esq == null){

        if(elemento.getName().compareTo(raiz.elemento.getName()) < 0){
            raiz.esq = new No(elemento);
            comparacoes++;
            movimentacoes++;
        } else if (elemento.getName().compareTo(raiz.dir.elemento.getName()) < 0 ){
            raiz.esq = new No(raiz.elemento);
            raiz.elemento = elemento;
            comparacoes++;
            movimentacoes++;

        } else {
            raiz.esq = new No(raiz.elemento);
            raiz.elemento = raiz.dir.elemento;
            raiz.dir.elemento = elemento;
            comparacoes++;
            movimentacoes++;
        }

        raiz.esq.cor = raiz.dir.cor = false;
        
     //Senao, se a arvore tiver dois elementos (raiz e esq)
    } else if (raiz.dir == null){

            if(elemento.getName().compareTo(raiz.elemento.getName()) > 0){
                raiz.dir = new No(elemento);
                comparacoes++;
                movimentacoes++;
            } else if (elemento.getName().compareTo(raiz.esq.elemento.getName()) > 0){
                raiz.dir = new No(raiz.elemento);
                comparacoes++;
                movimentacoes++;
                raiz.elemento = elemento;
            } else {
                    raiz.dir = new No(raiz.elemento);
                raiz.elemento = raiz.esq.elemento;
                comparacoes++;
                raiz.esq.elemento = elemento;
            }

            raiz.esq.cor = raiz.dir.cor = false;

        //Senao, a arvore tem tres ou mais elementos
        } else {
                inserir(elemento, null, null, null, raiz);
        }
        raiz.cor = false;
    }
    private void inserir(Serie2 elemento, No bisavo, No avo, No pai, No i) throws Exception {
		if (i == null) {

         if(elemento.getName().compareTo(pai.elemento.getName()) < 0){
            i = pai.esq = new No(elemento, true);
            comparacoes++;
            movimentacoes++;
         } else {
            i = pai.dir = new No(elemento, true);
         }

         if(pai.cor == true){
            balancear(bisavo, avo, pai, i);
         }

      } else {

        //Achou um 4-no: eh preciso fragmeta-lo e reequilibrar a arvore
         if(i.esq != null && i.dir != null && i.esq.cor == true && i.dir.cor == true){
            i.cor = true;
            comparacoes++;
            i.esq.cor = i.dir.cor = false;
            if(i == raiz){
               i.cor = false;
            }else if(pai.cor == true){
               balancear(bisavo, avo, pai, i);
            }
         }

         if (elemento.getName().compareTo(i.elemento.getName()) < 0) {
            inserir(elemento, avo, pai, i, i.esq);
            movimentacoes++;
         } else if (elemento.getName().compareTo(i.elemento.getName()) > 0) {
            inserir(elemento, avo, pai, i, i.dir);
            movimentacoes++;
         } else {
            throw new Exception("Erro inserir (elemento repetido)!");
         }
      }
	}

	
    private void balancear(No bisavo, No avo, No pai, No i){

        //Se o pai tambem e preto, reequilibrar a arvore, rotacionando o avo
        if(pai.cor == true){
  
           //4 tipos de reequilibrios e acoplamento
           if(pai.elemento.getName().compareTo(avo.elemento.getName()) > 0 ){ // rotacao a esquerda ou direita-esquerda
              if(i.elemento.getName().compareTo(pai.elemento.getName()) > 0){
                 avo = rotacaoEsq(avo);
                 comparacoes++;
            movimentacoes++;
              } else {
                comparacoes++;
                 avo = rotacaoDirEsq(avo);
              }
  
           } else { // rotacao a direita ou esquerda-direita
              if(i.elemento.getName().compareTo(pai.elemento.getName()) < 0){
                 avo = rotacaoDir(avo);
                 comparacoes++;
            movimentacoes++;
              } else {
                comparacoes++;
                 avo = rotacaoEsqDir(avo);
              }
           }
  
           if (bisavo == null){
              raiz = avo;
           } else if(avo.elemento.getName().compareTo(bisavo.elemento.getName()) < 0){
              bisavo.esq = avo;
              comparacoes++;
            movimentacoes++;
           } else {
            comparacoes++;
              bisavo.dir = avo;
           }
  
           //reestabelecer as cores apos a rotacao
           avo.cor = false;
           avo.esq.cor = avo.dir.cor = true;
        } //if(pai.cor == true)
     }
     private No rotacaoDir(No no) {
        No noEsq = no.esq;
        No noEsqDir = noEsq.dir;
  
        noEsq.dir = no;
        no.esq = noEsqDir;
  
        return noEsq;
     }
  
     private No rotacaoEsq(No no) {
        No noDir = no.dir;
        No noDirEsq = noDir.esq;
  
        noDir.esq = no;
        no.dir = noDirEsq;
        return noDir;
     }
  
     private No rotacaoDirEsq(No no) {
        no.dir = rotacaoDir(no.dir);
        return rotacaoEsq(no);
     }
  
     private No rotacaoEsqDir(No no) {
        no.esq = rotacaoEsq(no.esq);
        return rotacaoDir(no);
     }
	
}

class tp04q04 {
    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }
    public static void main (String []args){  
        long start = System.nanoTime();
        String entrada = MyIO.readLine();
        Serie2 serie = new Serie2();   
        Alvinegra arvore = new Alvinegra();
        do{
            serie = new Serie2();
            try{
                serie.readClass(entrada);
            }catch(Exception e){}
            try {
                arvore.inserir(serie);
            } catch (Exception e) {
            }
            entrada = MyIO.readLine();
        }while(isFim(entrada)!=true);

        int n = MyIO.readInt();
        for(int m=0; m < n; m++){
            entrada = MyIO.readLine();
            if(entrada.charAt(0)=='I'){
                //insere no inicio a serie desejada
                entrada = entrada.replace("I", "");
                entrada=entrada.trim();
                serie = new Serie2();
                try{
                serie.readClass(entrada);
                }
                catch(Exception e){}
                try {
                    arvore.inserir(serie);
                } catch (Exception e) {
                
                }

            }
        }
        String entrada2 = "";
        do {
            entrada2 = MyIO.readLine(); 
            if(isFim(entrada2) != true){
            if(arvore.pesquisar(entrada2)==true)
            System.out.print("SIM");
            else
            System.out.print("NAO");
            }
            System.out.print("\n");
        } while (isFim(entrada2) != true);
        entrada = "";
        long end = System.nanoTime();

        long elapsedTime = end - start;

        // 1 second = 1_000_000_000 nano seconds
        double elapsedTimeInSecond = (double) elapsedTime / 1_000_000_000;
        Arq.openWrite("matricula_alvinegra.txt");
        Arq.println("727541" + "\t" + elapsedTimeInSecond+ "\t" +arvore.comparacoes+ "\t" + arvore.movimentacoes );
        Arq.close();
        Arq.openRead("matricula_alvinegra.txt");
    }
}
