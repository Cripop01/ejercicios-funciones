import java.util.Scanner;

public class ejercicio19 {

    public static boolean pitagoras(int x, int y, int z) {
        if((Math.pow(x, 2) + Math.pow(y, 2)) == Math.pow(z, 2)) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Calulo equacion de pitagoras. x ^ 2 + y ^ 2 = z ^ 2");
        System.out.print("Introduce x: ");
        int x = in.nextInt();
        System.out.println("Introduce y: ");
        int y = in.nextInt();
        System.out.println("Introduce z: ");
        int z = in.nextInt();

        if(pitagoras(x, y, z)) {
            System.out.println("Los valores se ajustan a la ecuacion de pitagoras");
        } else {
            System.out.println("Los valores no se ajustan a la ecuacion de pitagoras");
        }
    }
}
