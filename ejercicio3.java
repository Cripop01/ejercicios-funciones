import java.util.Scanner;

public class ejercicio3 {
    public static int minimo(int a, int b) {
        if(a < b) {
            return a;
        } else {
            return b;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Introduce un numero entero: ");
        int a = in.nextInt();
        System.out.print("Introduce otro numero entero");
        int b = in.nextInt();
        System.out.println(" El menor entre " + a + " y " + b + " es: " + minimo(a, b));
    }
}
