import java.util.Scanner;

public class ejercicio11 {

    public static void tabla(int a ) {
        System.out.println("Tabla de multiplicar de " + a);
        for(int i = 1; i<= a; i++) {
            System.out.println(i + " * " + a + "= " + (i * a));
        }
    }
    public static void main(String[] args) {
        System.out.println("Introduce un numero: ");
        int a = new Scanner(System.in).nextInt();
        tabla(a);
    }
}
