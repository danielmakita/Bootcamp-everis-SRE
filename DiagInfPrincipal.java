import java.io.IOException;
import java.util.Scanner;

public class DiagInfPrincipal{
	
    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);
        double soma = 0;
        char O = leitor.next().toUpperCase().charAt(0);
        double[][] M = new double[12][12];
        int i, j;
        for (i=0; i<M[0].length; i++) {
        	for (j=0; j<M[0].length; j++) {
        		M[i][j] = leitor.nextDouble();
        	}
        }
        
        for (i=0; i<M[0].length; i++) {
        	for (j=0; j<M[0].length; j++) {
        		if (j < i) soma += M[i][j];
        	}
        }

        if (O == 'M') soma /= ((M.length * M.length) - 12) / 2; // 66
    	System.out.println(String.format("%.1f", soma));
    }
	
}
