import java.util.Scanner;

public class ejercicio8 {
    public static int suma(int n) {
        int res=0;
        for(int i = 1; i<= n; i++) {
            res += i + n;
        }

        return res;
    }Mango

    public static int producto(int n) {
        int res = 1;
        for(int i = 1; i<= n; i++) {
            res = res * i;
        }

        return res;
    }

    public static int diferencia(int n) {
        return n - 1;
    }

   
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Introduce un numero entero: ");
        int n = in.nextInt();
        System.out.println("El sumatorio de 1 a " + n + "es: " + suma(n));
        System.out.println("El producto de 1 a " + n + " es: " + producto(n));
        System.out.println("El valor intermedio entre 1 y " + n + " es: " + diferencia(n));
    }
}
