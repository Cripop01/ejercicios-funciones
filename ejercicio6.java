import java.util.Scanner;

public class ejercicio6 {

    public static Double calcualriva(Double siniva) {
        return siniva * 1.21;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Double[] precios = new Double[5];

        for(int i = 0; i<precios.length; i++) {
            System.out.println("Introduce el precio " + (i + 1)  + " sin iva: ");
            precios[i] = in.nextDouble();
        }

        for(int i = 0; i<precios.length; i++) {
            System.out.println(precios[i] + " + iva = " + calcualriva(precios[i]));
        }
    }
}
