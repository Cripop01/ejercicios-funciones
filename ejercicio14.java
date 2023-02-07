import java.util.Scanner;

public class ejercicio14 {

    public static void piramide(int num_lineas, char caracter) {
        for(int i = 1; i <= num_lineas; i++) {
            int c = 2 * i -1;
            
            for()

            for(int f = 1; f<= c; f++) {
                System.out.print(caracter);
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Introduce el caracter para la piramide: ");
        char caracter = in.next().charAt(0);
        System.out.println("Introduce cuantas lineas quieres que tenga la piramide");
        int num_lineas = in.nextInt();
        piramide(num_lineas, caracter);
    }
}
