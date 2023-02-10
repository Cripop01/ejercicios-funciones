import java.util.Scanner;

public class ejercicio18 {
    
    public static char calculanif(int dni) {
        char[] nifs = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z',
    'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

    return nifs[dni % 23];
    }
    public static void main(String[] args) {
        System.out.print("Introduce el DNI: ");
        System.out.println(calculanif(new Scanner(System.in).nextInt()));
    }
}
