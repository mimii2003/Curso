/**
 * TP - Algoritmos e Estruturas de Dados II
 * @author - Milena Soares Barreira
 * 2021 - 2o. Semestre
 */
import java.util.*;
// não deu 100% só 81%
class tp01q15{
    public static Scanner sc =
    new Scanner(System.in);

    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
}

public static boolean Vogais(String str){
        return Vogais(str,0);
    }

private static boolean Vogais (String str, int pos){
        boolean resp = true;
        pos=0;

        if( pos < str.length()) {

            pos ++;
            // verifica se é uma vogal de a a u
        if ((str.charAt(pos) == 'a' || str.charAt(pos) == 'e' ||  str.charAt(pos) == 'i' ||  str.charAt(pos) == 'o' ||  str.charAt(pos) == 'u'|| str.charAt(pos) == 'A' || str.charAt(pos) == 'E' || str.charAt(pos) == 'I' || str.charAt(pos) == 'O' ||str.charAt(pos) == 'U' ) == false){

            resp = false;
        pos = str.length(); 
    
        
}
        return resp;
}

return(str.charAt(pos) == str.charAt(str.length()-1-pos)) && Vogais(str,pos + 1);
    }

    public static boolean Consoante(String str){
        return Consoante(str,0);
    }

    private static boolean Consoante (String str, int pos){
        boolean resp2 = true;
        pos=0;
        if( pos< str.length()){

        // verfica se é consoante
    if ((str.charAt(pos) != 'a' && str.charAt(pos) != 'e' &&  str.charAt(pos) != 'i' &&  str.charAt(pos) != 'o' &&  str.charAt(pos) != 'u'&& str.charAt(pos) != 'A' && str.charAt(pos) != 'E' && str.charAt(pos) != 'I' && str.charAt(pos) != 'O' && str.charAt(pos) != 'U' && str.charAt(pos) != '0' && str.charAt(pos) != '9'&& str.charAt(pos) != '2' && str.charAt(pos) != '3' && str.charAt(pos) != '1' && str.charAt(pos) != '4'&& str.charAt(pos) != '5' && str.charAt(pos) != '6'&& str.charAt(pos) != '7' && str.charAt(pos) != '8') == false){
    resp2 = false;
    pos = str.length(); }
    return resp2;
    }

    return(str.charAt(pos) == str.charAt(str.length()-1-pos)) && Consoante(str,pos + 1);
}

public static boolean Inteiros(String str){
    return Inteiros(str,0);
}

private static boolean Inteiros (String str, int pos){
    boolean resp3 = true;
    pos=0;
    if( pos< str.length()){
        
        // verifica se é inteiro
        if ((str.charAt(pos) >= '0' && str.charAt(pos)<= '9') == false){
        resp3 = false;
        pos = str.length(); }
        return resp3;
        }
        return(str.charAt(pos) == str.charAt(str.length()-1-pos)) && Inteiros(str,pos + 1);

}


public static boolean Real(String str){
    return Real(str,0);
}

private static boolean Real(String str, int pos){
    boolean Inteiro = false;
    boolean Real = false;
    pos=0;
    if( pos< str.length()){
        // ve se é um numero 
        if((str.charAt(pos) >= '0' && str.charAt(pos) <= '9') || str.charAt(pos) == '.' || str.charAt(pos) == ','){ 
            Inteiro = true;
            //verifica se possui ponto ou virgula para ser real
            if((str.charAt(pos) == '.' ||str.charAt(pos) == ',' ) && pos>0 && pos<str.length()-1){ 
                if(!Real) 
                    Real = true;
                else
                    return false;
            }
        }else{
            return false;
        }
    }
    
    if(Inteiro || Real){ //verifica se é mesmo real
        return true;}
        return(str.charAt(pos) == str.charAt(str.length()-1-pos)) && Real(str,pos + 1);
    


}

    public static void main (String[] args){



String[] entrada = new String[1000];
int numEntrada = 0;

do {
entrada[numEntrada] = MyIO.readLine();
} while (isFim(entrada[numEntrada++]) == false);
       numEntrada--;   //Desconsiderar a palavra FIM

        
for(int i = 0; i < numEntrada; i++){

    Vogais(entrada[i]);
if(Vogais(entrada[i]) == true){
MyIO.print("SIM\t");
}
else if(Vogais(entrada[i]) == false)
MyIO.print("NAO\t");

if(Consoante(entrada[i]) == true){
        MyIO.print("SIM\t");
}
else if(Consoante(entrada[i]) == false)
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



