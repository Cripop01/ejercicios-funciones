import java.util.Scanner;

public class ejercicio14 {

    /* Metodo para imprimir la piramide por pantalla
    Argumentos(Numero de lineas, caracter con el que se va a construir la piramide)
     */

    public static void whitespaces(int num_lineas , int f) {
        int huecos = num_lineas -f;
        for(int i = 1; i<= huecos; i++) {
            System.out.print(" ");
        }
    }
    public static void piramide(int num_lineas, char caracter) {
        /*Bucle que itera el numero de filas que va a tener la piramide*/
        for(int i = 1; i <= num_lineas; i++) {
            /* Calcula el numero de caracteres en la linea correspondiente*/
            int c = 2 * i -1;
            whitespaces(num_lineas, i);
            /* Bucle que muestra el caracter c veces.*/
            for(int f = 1; f<= c; f++) {
                System.out.print(caracter);
            }
            whitespaces(num_lineas, i);
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
