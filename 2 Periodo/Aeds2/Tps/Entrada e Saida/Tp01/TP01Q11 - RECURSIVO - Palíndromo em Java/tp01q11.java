/**
 * TP - Algoritmos e Estruturas de Dados II
 * @author - Milena Soares Barreira
 * 2021 - 2o. Semestre
 */
import java.util.*;
class tp01q11
    {
public static Scanner sc =
new Scanner(System.in);
// termina o programa apenas com a palavra FIM
public static boolean isFim(String s){
    return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
}
    public static boolean isPalindrome(String str){
        return isPalindrome(str,0);
    }
    // recursividade, ve se é palindromo pela posicao
    private static boolean isPalindrome(String str, int pos){
if(pos >= str.length()-1-pos)
    return true;
return(str.charAt(pos) == str.charAt(str.length()-1-pos)) && isPalindrome(str,pos + 1);
    }
    public static void main(String[] args) {

    


String[] entrada = new String[1000];
int numEntrada = 0;



do {
entrada[numEntrada] = MyIO.readLine();
} while (isFim(entrada[numEntrada++]) == false);
       numEntrada--;   //Desconsiderar a palavra FIM

       //Para cada linha de entrada, gerando uma de saida contendo o numero de letras maiusculas da entrada
for(int i = 0; i < numEntrada; i++){

isPalindrome(entrada[i]);
if(isPalindrome(entrada[i]) == true){
            MyIO.println("SIM");
}
else if(isPalindrome(entrada[i]) == false)
MyIO.println("NAO");
        }

    }
}

