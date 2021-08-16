import java.io.IOException;
import java.util.Scanner;

public class FibonacciVetor{
	
    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);
        int T = leitor.nextInt();
        int i, count;
        for (i=0;i<T;i++) {
        	int N = leitor.nextInt();
            long anterior = 0, atual = 1, proximo = 1;
	        for (count=0; count<N; count++) {
	        	proximo = atual + anterior;
	        	anterior = atual;
	        	atual = proximo;
	        }
	        System.out.println("Fib("+ N +") = " + anterior);
        }
    }
	
}

// 0, 1, 1, 2, 3, 5, 8, 13
// a  a  p
//    a  a  p
//       a  a  p 
//          a  a  p  
