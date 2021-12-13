/**
 * TP - Algoritmos e Estruturas de Dados II
 * @author - Milena Soares Barreira
 * 2021 - 2o. Semestre
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
class Serie2{
    String nome;
    Serie2(){    
        nome = "";
    }
    public Serie2 clone(){
        Serie2 resp = new Serie2();
        resp.nome = this.nome;
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

        return newline;

    }
    String removeExtra(String str){
        String newline = "";
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                newline += str.charAt(i);
            }
        }
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
    public void ler(String nomeArquivo) throws Exception {
        InputStreamReader isr = new InputStreamReader(new FileInputStream(nomeArquivo));
    
        BufferedReader br = new BufferedReader(isr);

        while(!br.readLine().contains("infobox_v2"));
        br.readLine();
        this.nome = removeTags(br.readLine());

        br.close();

    }
    void setNome(String nome) {
        this.nome = nome;
    }
    // Getters (get)
    String getNome() {
        return nome;
    }
}
public class tp02q3 {
    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }
    public static void main (String []args){  
        Arq.openWrite("matrícula_sequencial.txt");
        Arq.println("727541");
        Arq.close();
        Arq.openRead("exemplo.txt");
        Serie2[] serie = new Serie2[1000];      
        String entrada = "";
        String entrada2 = "";
        int i =0;
        entrada = MyIO.readLine();
        do {
            serie[i]= new Serie2();
            entrada2 = "/tmp/series/" + entrada;
                try{ 
                    serie[i].ler(entrada2);
                }  catch (Exception e){}
            i++;
            entrada = MyIO.readLine();
        } while (isFim(entrada) != true);

        entrada2 = MyIO.readLine();
        do {
            Pesquisa(serie, entrada2, i);
            entrada2 = MyIO.readLine();
        } while (isFim(entrada2) != true);
        entrada = "";
    }
    public static void Pesquisa(Serie2[] serie2, String entrada, int aux){
        int i= 0;
        boolean result = false;
        for(i=0; i < aux; i++){
            if (entrada.equals(serie2[i].getNome())){
                //Se encontrou o elemento, imprime ele na tela e para a pesquisa.
                System.out.println("SIM");
                result=true;
                i=aux;
            }
            else{
                result=false;
            }
        }
        if (result==false)
        System.out.println("NÃO");
    }

}