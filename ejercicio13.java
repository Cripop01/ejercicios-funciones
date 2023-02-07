import java.util.Scanner;

public class ejercicio13 {
    public static int calculadescuento (int total , int descuento) {
        return (total * descuento) / 100;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Introduce el precio sin descuento");
        int descuento = in.nextInt();
        System.out.println("Introduce el precio con descuento");
        int total = in.nextInt();

        System.out.println("El descuento aplicado es de " + calculadescuento(total, descuento) + "%");
    }
}
