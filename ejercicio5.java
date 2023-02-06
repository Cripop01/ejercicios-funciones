import java.util.Scanner;


public class ejercicio5 {

    public static Double kilometros(Double millas) {
        return millas * 1.60934;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Introduce una distnacia en millas: ");
        Double millas = in.nextDouble();
        System.out.println(millas + " millas son " + kilometros(millas));
        in.close();
    }
}
