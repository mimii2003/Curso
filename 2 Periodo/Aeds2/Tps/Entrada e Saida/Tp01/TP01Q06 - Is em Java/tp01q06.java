/**
 * TP - Algoritmos e Estruturas de Dados II
 * @author - Milena Soares Barreira
 * 2021 - 2o. Semestre
 */
import java.util.*;
class tp01q06 {
    public static Scanner sc =
    new Scanner(System.in);
    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
     }

     public static boolean Vogais (String str){
        boolean resp = true;
        for (int i = 0; i < str.length(); i++){
            // verifica se é uma vogal de a a u
        if ((str.charAt(i) == 'a' || str.charAt(i) == 'e' ||  str.charAt(i) == 'i' ||  str.charAt(i) == 'o' ||  str.charAt(i) == 'u'|| str.charAt(i) == 'A' || str.charAt(i) == 'E' || str.charAt(i) == 'I' || str.charAt(i) == 'O' ||str.charAt(i) == 'U' ) == false){
        resp = false;
        i = str.length(); }
        }
        return resp;
    }

    public static boolean Consoantes (String str){
        boolean resp2 = true;
    for (int i = 0; i < str.length(); i++){
        // verfica se é consoante
    if ((str.charAt(i) != 'a' && str.charAt(i) != 'e' &&  str.charAt(i) != 'i' &&  str.charAt(i) != 'o' &&  str.charAt(i) != 'u'&& str.charAt(i) != 'A' && str.charAt(i) != 'E' && str.charAt(i) != 'I' && str.charAt(i) != 'O' && str.charAt(i) != 'U' && str.charAt(i) != '0' && str.charAt(i) != '9'&& str.charAt(i) != '2' && str.charAt(i) != '3' && str.charAt(i) != '1' && str.charAt(i) != '4'&& str.charAt(i) != '5' && str.charAt(i) != '6'&& str.charAt(i) != '7' && str.charAt(i) != '8') == false){
    resp2 = false;
    i = str.length(); }
    }
    return resp2;
}
public static boolean Inteiros (String str){
    boolean resp3 = true;
    for (int i = 0; i < str.length(); i++){
        // verifica se é inteiro
        if ((str.charAt(i) >= '0' && str.charAt(i) <= '9') == false){
        resp3 = false;
        i = str.length(); }
        }
return resp3;

}
public static boolean Real(String str){
    boolean Inteiro = false;
    boolean Real = false;
    for(int i=0; i<str.length(); i++){
        // ve se é um numero 
        if((str.charAt(i) >= '0' && str.charAt(i) <= '9') || str.charAt(i) == '.' || str.charAt(i) == ','){ 
            Inteiro = true;
            //verifica se possui ponto ou virgula para ser real
            if((str.charAt(i) == '.' ||str.charAt(i) == ',' ) && i>0 && i<str.length()-1){ 
                if(!Real) 
                    Real = true;
                else
                    return false;
            }
        }else{
            return false;
        }
    }
    if(Inteiro || Real) //verifica se é mesmo real
        return true;
    else
    return false;
}
    public static void main (String[] args){

    String[] entrada = new String[1000];
    int numEntrada = 0;

        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
       numEntrada--;   //Desconsiderar a palavra FIM
 
        
    for(int i = 0; i < numEntrada; i++){


        if(Vogais(entrada[i]) == true){
        MyIO.print("SIM\t");
        }
        else if(Vogais(entrada[i]) == false)
        MyIO.print("NAO\t");


        if(Consoantes(entrada[i]) == true){
        MyIO.print("SIM\t");
        }
        else if(Consoantes(entrada[i]) == false)
        MyIO.print("NAO\t");
     

        if(Inteiros(entrada[i]) == true){
        MyIO.print("SIM\t");
        }
        else if(Inteiros(entrada[i]) == false)
        MyIO.print("NAO\t");

        if(Real(entrada[i]) == true){
        MyIO.print("SIM\n");
        }
        else if(Real(entrada[i]) == false)
        MyIO.print("NAO\n");
    }
}
}


