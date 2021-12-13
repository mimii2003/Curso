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
	public char elemento; // Conteudo do no.
	public No esq, dir;  // Filhos da esq e dir.
    public No2 outro;

	No(char elemento) {
		this.elemento = elemento;
		this.esq = this.dir = null;
      this.outro = null;
	}

	public No(char elemento, No esq, No dir) {
		this.elemento = elemento;
		this.esq = esq;
		this.dir = dir;
        this.outro = null;
	}
}
class No2 {
	public String elemento; // Conteudo do no.
	public No2 esq; // No da esquerda.
	public No2 dir; // No da direita.
	
   /**
	 * Construtor da classe.
	 * @param elemento Conteudo do no.
	 */
	No2(String elemento) {
		this.elemento = elemento;
		this.esq = this.dir = null;
	}

	/**
	 * Construtor da classe.
	 * @param elemento Conteudo do no.
	 * @param esq No2 da esquerda.
	 * @param dir No2 da direita.
	 */
	No2(String elemento, No2 esq, No2 dir) {
		this.elemento = elemento;
		this.esq = esq;
		this.dir = dir;
	}
}

class ArvoreArvore {
	private No raiz; // Raiz da arvore.
    int movimentacoes;
    int comparacoes=0;

	/**
	 * Construtor da classe.
	 * @throws Exception
	 */
	public ArvoreArvore() throws Exception {
		raiz = null;
            inserir('D');
            inserir('R');
            inserir('Z');
            inserir('X');
            inserir('V');
            inserir('B');
            inserir('F');
            inserir('P');
            inserir('U');
            inserir('I');
            inserir('G');
            inserir('E');
            inserir('J');
            inserir('L');    
            inserir('H');       
            inserir('T');
            inserir('A');
            inserir('W');
            inserir('S');
            inserir('O');
            inserir('M');
            inserir('N');
            inserir('K');
            inserir('C');
            inserir('Y');
            inserir('Q');
      //os outros 23 caracteres.
	}
    public void inserir(char letra) throws Exception {
        raiz = inserir(letra, raiz);
    }
    private No inserir(char x, No i) throws Exception {
		if (i == null) {
            movimentacoes++;
            // acho q isso ta deixando o pesquisa nao 
            i = new No(x);

        } else if (x < i.elemento) {
            comparacoes++;
            movimentacoes++;
            i.esq = inserir(x, i.esq);

        } else if (x > i.elemento) {
            comparacoes++;
            movimentacoes++;
            i.dir = inserir(x, i.dir);

        } else {
            throw new Exception("Erro ao inserir!");
        }

		return i;
	}

    public void inserir(String c) throws Exception {
		inserir(c, raiz);
	}


    public void inserir(String s, No i) throws Exception {
		if (i == null) {
            movimentacoes++;
            throw new Exception("Erro ao inserir: caractere invalido!");

        } else if (s.charAt(0) < i.elemento) {
            comparacoes++;
            inserir(s, i.esq);

        } else if (s.charAt(0) > i.elemento) {
            comparacoes++;
            inserir(s, i.dir);

        } else {
            i.outro = inserir(s, i.outro);
        }
    }


	private No2 inserir(String s, No2 i) throws Exception {
		if (i == null) {
            movimentacoes++;
            i = new No2(s);

        } else if (s.compareTo(i.elemento) < 0 ) {
            comparacoes++;
            movimentacoes++;
            i.esq = inserir(s, i.esq);

        } else if (s.compareTo(i.elemento) > 0) {
            comparacoes++;
            movimentacoes++;
            i.dir = inserir(s, i.dir);

        } else {
            throw new Exception("Erro ao inserir: elemento existente!");
        }

		return i;
	}
    public boolean mostrar(String c){
        return mostrar(raiz, c);
    }
    public boolean mostrar(No i, String c){
        if (i==raiz){
            movimentacoes++;
            System.out.print("raiz ");  
            }
        boolean aux = false;
        if (i != null){

            if(mostrar(i.outro, c) == true){
                movimentacoes++;
                aux = true;
                return aux;
            }
            if(aux == false){
                MyIO.print("esq ");
                movimentacoes++;
                aux = mostrar(i.esq, c);

                if(aux == false){
                    movimentacoes++;
                    MyIO.print("dir ");
                    aux = mostrar(i.dir, c);

                }
        }
    }
    return aux;
}
// mostrar dois assim como o primeiro mas em letra maiscula
    public boolean mostrar(No2 i, String c){
        boolean aux = false;
        if (i != null){
            if(c.compareTo(i.elemento) == 0){
                movimentacoes++;
                aux = true;
                return aux;
            }
            if(aux == false){
                MyIO.print("ESQ ");
                movimentacoes++;
                aux = mostrar(i.esq, c);

                if(aux == false){
                    movimentacoes++;
                    MyIO.print("DIR ");
                    aux = mostrar(i.dir, c);

                }
            }
        }
    
        return aux;
    }
    public boolean hasStringTam10(){
        return hasStringTam10(raiz);
    }
    public boolean hasStringTam10(No i){
        boolean resp = false;
            if(i != null){
            resp = hasStringTam10(i.outro) || hasStringTam10(i.esq) || hasStringTam10(i.dir);
        }
        return resp;
    }
    public boolean hasStringTam10(No2 i){
        boolean resp = false;
        if(i != null){
            resp = ((CharSequence) i.elemento).length() == 10 || hasStringTam10(i.esq) || hasStringTam10(i.dir);
        }
        return resp;
    }
    public boolean hasStringTam10(char c){
        return hasStringTam10(raiz, c);
    }
    public boolean hasStringTam10(No i, char c){
        boolean resp;
		if (i == null) { 
            movimentacoes++;
            resp = false;

        } else if (c < i.elemento) { 
            comparacoes++;
            resp = hasStringTam10(i.esq, c); 

        } else if (c > i.elemento) { 
            comparacoes++;
            resp = hasStringTam10(i.dir, c); 
            
        } else { 
            comparacoes++;
            resp = hasStringTam10(i.outro); 
            }
        return resp;
    } 


	public boolean pesquisar(String elemento) {
		return pesquisar(raiz, elemento);
	}
	private boolean pesquisar(No no, String x) {
        boolean resp;
		if (no == null) { 
            movimentacoes++;
            resp = false;

        } else if (x.charAt(0) < no.elemento) { 
            comparacoes++;
            resp = pesquisar(no.esq, x); 

        } else if (x.charAt(0) > no.elemento) { 
            comparacoes++;
            resp = pesquisar(no.dir, x); 
            
        } else { 
            resp = pesquisarSegundaArvore(no.outro, x); 
        }
        return resp;
	}

	private boolean pesquisarSegundaArvore(No2 no, String x) {
        boolean resp;
		if (no == null) { 
            resp = false;

        } else if (x.charAt(0)>no.elemento.charAt(0)) { 
            comparacoes++;
        System.out.print("ESQ ");
        resp = pesquisarSegundaArvore(no.esq, x); 

        } else if (x.charAt(0) < no.elemento.charAt(0)){
            comparacoes++; 
        System.out.print("DIR ");
        resp = pesquisarSegundaArvore(no.dir, x); 

        } else { 
            resp = true; 
        }
        return resp;
	}

    public int contPalavra(char letra) throws Exception{
        return contPalavra(letra, raiz);
    }

    public int contPalavra(char letra, No i) throws Exception {
        int resp = 0;

		if (i == null) {
            throw new Exception("Erro ao pesquisar: caractere invalido!");

        } else if (letra < i.elemento) {
            comparacoes++;
            resp = contPalavra(letra, i.esq);

        } else if (letra > i.elemento) {
            comparacoes++;
            resp = contPalavra(letra, i.dir);

        } else {
            movimentacoes++;
            resp = contPalavra(i.outro);
        }

        return resp;
    }

    public int contPalavra(No2 i){
        int resp = 0;
        if(i != null){
            movimentacoes++;
            resp = 1 + contPalavra(i.esq) + contPalavra(i.dir);
        }
        return resp;
    }
}
class tp04q02 {
    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }
    public static void main (String []args) throws Exception{  
        long start = System.nanoTime();
        String entrada = MyIO.readLine();
        Serie2 serie = new Serie2();   
        ArvoreArvore arvore = new ArvoreArvore();
        do{
            serie = new Serie2();
            try{
                serie.readClass(entrada);
            }catch(Exception e){}
            try {
                arvore.inserir(serie.getName());
            } catch (Exception e) {
            }
            entrada = MyIO.readLine();
        }while(isFim(entrada)!=true);

        String entrada2 = "";
        do {
            entrada2 = MyIO.readLine(); 
            if(isFim(entrada2) != true){
            if(arvore.mostrar(entrada2)==true)
            System.out.print(" SIM");
            else
            System.out.print(" NAO");
            }
            System.out.print("\n");
        } while (isFim(entrada2) != true);
        entrada = "";
        long end = System.nanoTime();

        long elapsedTime = end - start;

        // 1 second = 1_000_000_000 nano seconds
        double elapsedTimeInSecond = (double) elapsedTime / 1_000_000_000;
        Arq.openWrite("matricula_arvoreArvore.txt");
        Arq.println("727541" + "\t" + elapsedTimeInSecond+ "\t" +arvore.comparacoes+ "\t" + arvore.movimentacoes );
        Arq.close();
        Arq.openRead("matricula_arvoreArvore.txt");
    }
}
// faltando raiz