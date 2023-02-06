import java.util.Scanner;

public class ejercicio9 {

    public static int mayor(int a, int b) {
        if(a > b) {
            return a;
        } else {
            return b;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Introduce el primer numero: ");
        int a = in.nextInt();
        System.out.println("Introduce el segundo numero: ");
        int b = in.nextInt();
        System.out.println("Introduce el tercer numero: ");
        int c = in.nextInt();

        int mayor = mayor(a, b);

        if(c > mayor) {
            System.out.println("El mayor es " + c);
        } else {
            System.out.println("El mayor es " + mayor);
        }

    }
}
