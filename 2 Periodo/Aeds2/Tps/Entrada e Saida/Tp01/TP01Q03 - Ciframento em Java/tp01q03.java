/**
 * TP - Algoritmos e Estruturas de Dados II
 * @author - Milena Soares Barreira
 * 2021 - 2o. Semestre
 */
import java.util.*;
class tp01q03 {
   public static Scanner sc =
   new Scanner(System.in);

   public static boolean isFim(String s){
      return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
   }
   public static String Ciframento (String str){
      String auxil = new String();
      for ( int i  = 0; i < str.length(); i++){
            auxil = auxil+ (char)(str.charAt(i) + 3);
      }
      return auxil;
   }
   public static void main (String[] args){
      String[] entrada = new String[1000];
      int numEntrada = 0;

   do {
      entrada[numEntrada] = MyIO.readLine();
   } while (isFim(entrada[numEntrada++]) == false);
 numEntrada--;   //Desconsiderar a palavra FIM

 //Para cada linha de entrada, gerando uma de saida contendo o numero de letras maiusculas da entrada
   for(int i = 0; i < numEntrada; i++){
      MyIO.println(Ciframento(entrada[i]));
   }
   }
}