import java.util.Scanner;

public class ejercicio4 {

    public static int signo(int num) {
        if(num > 0) {
            return 1;
        } else if(num < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    public static String respuesta(int signo) {
        switch (signo) {
            case 0:
                return "Es 0";
            case 1:
                return "positivo";
            case -1:
                return "negativo";
        }
        
        return null;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Introduce un numero entero");
        int num = in.nextInt();
        System.out.println(" El numero " + num + " es" + respuesta(signo(num)));
        
    }
}
