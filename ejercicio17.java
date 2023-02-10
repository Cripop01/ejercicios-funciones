import java.util.Scanner;



public class ejercicio17 {

    public static boolean primo(int numero) {
        boolean res = false;
        int cont = 0;
        if(numero <= 1) {
            res = false;
        } else {
            for(int i = 1; i<= numero; i++) {
                if(numero % i == 0) {
                    cont++;
                }
            }
            if(cont > 2) {
                res = false;
            } else {
                res = true;
            }

        }

        return res;
    }
    public static void main(String[] args) {
        int numero;
        System.out.println("Introduce numeros hasta que introduzcas un 0");

        do {
            System.out.print("Introduce un numero: ");
            numero = new Scanner(System.in).nextInt();
            if (primo(numero)) {
                System.out.println(numero + " es un numero primo");
            } else {
                System.out.println(numero + " no es un numero primo");
            }
        } while (numero != 0);
    }
}
