import java.util.Scanner;

//Ejercicio para hacer un producto entre dos enteros
public class ejercicio {
    public static int producto(int a, int b) {
        return a * b;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Introduce un numero entero: ");
        int a = in.nextInt();
        System.out.print("Introduce otro numero entero: ");
        int b = in.nextInt();
        System.out.println(a +" * " + b + " = " + producto(a, b));
    }
}
