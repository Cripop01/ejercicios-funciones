import java.util.Scanner;

public class calculadora {
    
    public static Double suma(Double a, Double b) {
        return a + b;
    }

    public static Double resta(Double a, Double b) {
        return  a -b;
    }

    public static Double producto(Double a, Double b) {
        return a * b;
    }

    public static Double division(Double a, Double b) {
        return a / b;
    }

    public static boolean check(Double n) {
        return check(n,0.0,1000000.0);
    }

    public static boolean check(Double n, Double min, Double max) {
        if(n >= min && n<= max) {
            return true;
        } else {
            return false;
        }
    }

    public static void Calculo(int opcion, Double a, Double b) {
        switch(opcion) {
            case 1:

        }
    }


    public static void PedirValores(int opcion) {
        Scanner in = new Scanner(System.in);
        if(opcion < 8) {
            System.out.println("Introduce un valor");
            Calculo(opcion, in.nextDouble(), in.nextDouble());
            System.out.println("Introduce otro valor");
            Calculo(opcion, in.nextDouble(), in.nextDouble());
        } else if(opcion != 9) {
            System.out.println("Introduce un valor");
            check(in.nextDouble());
        }
    }


    public static void mostrarmenu() {
        int opcion;
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicacion");
        System.out.println("4. Division");
        System.out.println("5. Area de rectangulo");
        System.out.println("6. Area de un triangulo equilatero");
        System.out.println("7. Area de un circulo");
        System.out.println("8. Seno, coseno y tangente de x");
        System.out.println("9. Salir");
        opcion = new Scanner(System.in).nextInt();

    }
  
    public static void main(String[] args) {
        
    }
}
