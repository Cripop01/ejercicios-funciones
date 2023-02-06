import java.util.Scanner;

public class ejercicio7 {

    public static int area(int alto, int ancho) {
        return alto * ancho;
    }

    public static int perimtro(int alto, int ancho) {
        return (alto * 2) + (ancho * 2);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Introduce el alto: ");
        int alto = in.nextInt();
        System.out.println("Introduce el ancho: ");
        int ancho = in.nextInt();

        System.out.println("El area del rectangulo es: " + area(alto, ancho));
        System.out.println("El permitro del rectangulo es: " + perimtro(alto, ancho));
        in.close();
    }
}
