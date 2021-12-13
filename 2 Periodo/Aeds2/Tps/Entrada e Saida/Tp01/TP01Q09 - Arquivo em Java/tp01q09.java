/**
 * TP - Algoritmos e Estruturas de Dados II
 * @author - Milena Soares Barreira
 * 2021 - 2o. Semestre
 */
import java.io.IOException;
import java.io.RandomAccessFile;
public class tp01q09 {
    public static void main(String [] args) throws IOException{
        // metodo pedido na questao
        RandomAccessFile arq = new RandomAccessFile("exercicio.txt", "rw");
        //Leitura inteiros
        int num = MyIO.readInt();       
        for(int i = 0; i < num; i++){       
            arq.seek(i * 8);
            // salva no arquivo
            arq.writeDouble(MyIO.readDouble());
        }
        // fecha o arquivo igual nos exericicios de matricula.txt
        arq.close(); 
        RandomAccessFile arqN = new RandomAccessFile("exercicio.txt", "r");
        // essa parte daqui inverte os números
        for(int i = num - 1; i > 0; i--){      
            arqN.seek(i * 8);
            // numeros reais
            double numero = arqN.readDouble();
            if (numero % 1 != 0){
                System.out.println(numero);
            }
            else
                System.out.println((int)numero);
        }

        arqN.close();
    }
}
