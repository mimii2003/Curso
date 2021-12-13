/**
 * TP - Algoritmos e Estruturas de Dados II
 * @author - Milena Soares Barreira
 * 2021 - 2o. Semestre
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
class Serie{
    String nome;
    String formato;
    String duracao; 
    String pais;
    String idioma;
    String emissora;
    String transmissora;
    int temporadas;
    int episodios;
    Serie(){    
        nome = "";
        formato = "";
        duracao = "";
        pais = "";
        idioma = "";
        emissora = "";
        transmissora = "";
        temporadas = 0;
        episodios = 0;
        
    }
    public Serie clone(){
        Serie resp = new Serie();
        resp.nome = this.nome;
        resp.formato = this.formato;
        resp.duracao = this.duracao;
        resp.pais = this.pais;
        resp.idioma = this.idioma;
        resp.emissora = this.emissora;
        resp.transmissora= this.transmissora;
        resp.temporadas= this.temporadas;
        resp.episodios= this.episodios;
        return resp;
    }
    
    String removeTags(String line){
        String newline = "";
        int i=0;
        while(i<line.length()){
            if(line.charAt(i) == '<'){
                i++;
                while(line.charAt(i) != '>')  i++;
                
            } else{
                newline += line.charAt(i);
            }
            i++;
        }
        System.out.print(newline + " ");

        return newline;

    }
    String removeExtra(String str){
        String newline = "";
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                newline += str.charAt(i);
            }
        }
        System.out.print(newline + " ");
        newline= "";
        return newline;

    }
    String removeImag(String str){
        
        String newline = "";
        String abcd = "";
        String fim = "";
        String fim2 = "";
        String fim3 = "";
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) != '0' && str.charAt(i) != '9' && str.charAt(i) != '1' && str.charAt(i) != '2' && str.charAt(i) != '3'  && str.charAt(i) != '4'  && str.charAt(i) != '5'  && str.charAt(i) != '6' && str.charAt(i) != '7'  && str.charAt(i) != '8')) {
                newline += str.charAt(i);
                fim = newline.replaceAll("\\&","");;
                fim2 = fim.replaceAll("\\#","");;
                fim3 = fim2.replaceAll("\\;","");;
            }
        }
        abcd = removeTags(fim3);

        newline= "";
        return abcd;

    }
    String removeErros(String str){
        
        String newline = "";
        String abcd = "";
        String fim = "";
        String fim2 = "";
        for (int i = 0; i < str.length(); i++) {
                newline += str.charAt(i);
                fim = newline.replace("&#160;", "");;
                fim2 = fim.replace("&nbsp;", "");;

        }
        abcd = removeTags(fim2);

        newline= "";
        return abcd;

    }

    public void Imprimir(){
        System.out.println(nome+ " " + formato + " " +duracao + " " +pais +" " +idioma +" " +emissora +" " +transmissora + " " +temporadas +" " + episodios);
    }

    public void ler(String nomeArquivo) throws Exception {
        InputStreamReader isr = new InputStreamReader(new FileInputStream(nomeArquivo));
    
        BufferedReader br = new BufferedReader(isr);

        while(!br.readLine().contains("infobox_v2"));
        br.readLine();
        this.nome = removeTags(br.readLine());

        while(!br.readLine().contains("Formato"));
        this.formato = removeTags(br.readLine());

        while(!br.readLine().contains("Duração"));
        this.duracao = removeTags(br.readLine());

        while(!br.readLine().contains("País de origem"));{
        this.pais = removeImag(br.readLine());}
        

        while(!br.readLine().contains("Idioma original"));
        this.idioma = removeTags(br.readLine());

        while(!br.readLine().contains("Emissora de televisão original"));
        this.emissora = removeTags(br.readLine());

        while(!br.readLine().contains("Transmissão original"));
        this.transmissora=removeErros(br.readLine());
        
        while(!br.readLine().contains("N.º de temporadas"));
        this.temporadas = Integer.parseInt(removeTags(br.readLine()));

        while(!br.readLine().contains("N.º de episódios"));
        this.episodios = Integer.parseInt(removeExtra(br.readLine()));
        

        br.close();

    }
    void setNome(String nome) {
        // this.dia -> Atributo 
        // dia -> parâmetro formal
        this.nome = nome;
    }

    void setFormato(String f) {
        // mes -> Atributo 
        // m -> parâmetro formal
        formato = f;
    }

    void setDuracao(String d) {
        // ano -> Atributo 
        // a -> parâmetro forma
        duracao = d;
    }
    void setPais(String p) {
        // ano -> Atributo 
        // a -> parâmetro forma
        pais = p;
    }
    void setIdioma(String i) {
        // ano -> Atributo 
        // a -> parâmetro forma
        idioma= i;
    }
    void setEmissora(String e) {
        // ano -> Atributo 
        // a -> parâmetro forma
        emissora = e;
    }

    void setTransmissao(String t) {
        transmissora = t;
    }
    void setNum(int num) {
        temporadas = num;
    }
    void setEpisod(int episod) {
        episodios = episod;
    }
    // Getters (get)
    String getNome() {
        return nome;
    }

    String getFormato() {
        return formato;
    }

    String getDuracao() {
        return duracao;
    }

    String getPais() {
        return pais;
    }
    String getIdioma() {
        return idioma;
    }
    String getEmissora() {
        return emissora;
    }
    String getTransmissao() {
        return transmissora;
    }
    int getNum() {
        return temporadas;
    }
    int getEpisod() {
        return episodios;
    }

    // Métodos gerais
    public void printData()
    {
        System.out.println( nome + formato +duracao + pais + idioma + emissora + transmissora + temporadas + episodios);
    }
}


public class tp02q01 {
    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }
    public static void main (String []args){        
        Serie serie = new Serie();
        String[] entrada = new String[1000];
int numEntrada = 0;



do {
entrada[numEntrada] = MyIO.readLine();
} while (isFim(entrada[numEntrada++]) == false);
        numEntrada--;   

for(int i = 0; i < numEntrada; i++){
        try{ 
            serie.ler("/tmp/series/" + entrada[i]);
        }  catch (Exception e){
        }

        System.out.print( "\n");
        
}

    }
}
