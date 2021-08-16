import java.io.IOException;
import java.util.Scanner;

public class AMudanca{

    public static void main(String[] args) throws IOException {
    	Scanner leitor = new Scanner(System.in);
    	while (leitor.hasNext()) {
    		int graus = leitor.nextInt();
    		if (graus >= 90 && graus < 180) System.out.println("Boa Tarde!!");
    		else if (graus >= 180 && graus < 270) System.out.println("Boa Noite!!");
    		else if(graus >= 270 && graus < 360) System.out.println("De Madrugada!!");
    		else System.out.println("Bom Dia!!");
    	}
    }
    
}


// 360 Bom Dia
// 0 - 89 Bom Dia
// 90  Boa Tarde
// 91 - 179 Boa Tarde
// 180 - 269 Boa Noite
// 270 - 359 De Madrugada
