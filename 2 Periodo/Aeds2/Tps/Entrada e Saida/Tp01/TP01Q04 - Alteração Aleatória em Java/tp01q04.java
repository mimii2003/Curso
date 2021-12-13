/**
 * TP - Algoritmos e Estruturas de Dados II
 * @author - Milena Soares Barreira
 * 2021 - 2o. Semestre
 */
import java.util.*;

class tp01q04 {

  public static boolean isFim(String s) {
    return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
  }
  public static String Aleat(String str, char c, char c2) {
    String aux = " ";
    for (int i=0; i<str.length(); i++){
      if (str.charAt(i)==c)
      aux += c2;
      else 
      aux += str.charAt(i);
  }
  return aux;

  }

  public static void main(String[] args) {

    int i = 0;
    String[] entrada = new String[1000];
    int numEntrada = 0;
    char var1 = 0;
    char var2 = 0;
    Random gerador = new Random();
    gerador.setSeed(4);
    var1 = ((char) ('a' + (Math.abs(gerador.nextInt()) % 26)));
    // sorteia segunda
    Random gerador2 = new Random();
    gerador2.setSeed(4);
    var2 = ((char) ('a' + (Math.abs(gerador2.nextInt()) % 26)));

    do {
      entrada[numEntrada] = MyIO.readLine();
    } while (isFim(entrada[numEntrada++]) == false);
    numEntrada--; // Desconsiderar a palavra FIM

    // Para cada linha de entrada, gerando uma de saida contendo o numero de letras
    // maiusculas da entrada
    for (i = 0; i < numEntrada; i++) {
      MyIO.print(Aleat(entrada[i], var1, var2));
      MyIO.print("\n");
    }
  }
}