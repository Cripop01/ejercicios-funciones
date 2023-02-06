import java.util.Scanner;


//Ejercicio para saber si es o no mayor de edad
public class ejercicio2 {
    public static boolean ismayoredad(int edad) {
        if(edad >= 18) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Introduce tu edad: ");
        if(ismayoredad(in.nextInt())) {
            System.out.println("Eres mayor de edad");
        } else {
            System.out.println("No eres mayor de edad");
        }
        in.close();
    }
}
