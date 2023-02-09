import java.util.Random;
import java.util.Scanner;

public class ejercicio16 {

    public static void rellenararray(int[] nrandom, int maximo) {
       for(int i = 0; i< nrandom.length; i++) {
           nrandom[i] = new Random().nextInt(maximo);
       }
    }
    public static void main(String[] args) {
        System.out.print("Introduce la cantidad de numeros random que quieres mostrar: ");
        int cantidad = new Scanner(System.in).nextInt();
        int[] nrandom = new int[cantidad];
        rellenararray(nrandom, cantidad);
        for(int numero: nrandom) {
            System.out.println(numero);
        }
    }
}
