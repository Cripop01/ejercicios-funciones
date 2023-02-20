import java.util.Scanner;

/* Supuesto practico calculadora- Tema 5 funciones*/
public class calculadora {
    // Funcion que devuelve la suma de dos valores Double
    public static Double suma(Double a, Double b) {
        return a + b;
    }
    
    //Funcion que  devuelve la resta dos valores Double
    public static Double resta(Double a, Double b) {
        return a - b;
    }
    
    //Funcion que devuelve el producto de dos valores Double
    public static Double prod(Double a, Double b) {
        return a * b;
    }
    
    //Funcion que devuelve el coeficiente de dos valores Double
     
    public static Double coef(Double a, Double b) {
        return a / b;
    }
    
    //Metodo que muestra el menu principal y recoge la seleccion del usuario
    public static int c() {
        System.out.println("1 - Suma");
        System.out.println("2 - Resta");
        System.out.println("3 - Multiplicación");
        System.out.println("4 - División");
        System.out.println("5 - Área de un rectangulo");
        System.out.println("6 - Área de un triangulo equilatero");
        System.out.println("7 - Área de un circulo");
        System.out.println("8 - Seno, coseno y tangente de x");
        System.out.println("9 - Salir");
        int opcion = new Scanner(System.in).nextInt();
        pedirvalores(opcion);
        return opcion;
    }

    //Metodo que comprueba si el valor es valido
    public static boolean comprobar(Double num, Double min, Double max) {
        if(num <= max && num >= min) {
            return true;
        } else {
            return false;
        }
    }

    
    public static Double pedirvalor(Double min, Double max) {
        Double res = null;
        boolean valido;
        String texto = "Introduce un valor entre " + min + " y " + max;
        do {
            System.out.println(texto);
            res = pedirvalor(false);
            valido = comprobar(res, min, max);
            texto = "Numero incorrecto. Debe ser entre " + min + " y " + max;
        } while(!valido);

        return res;
    }

    //Metodo que  tiene un scanner para introducir un valor double
    public static Double pedirvalor(boolean txt) {
        if(txt) {
            System.out.println("Introduce un numero: ");
        }
        return new Scanner(System.in).nextDouble();
    }

    //Metodo que pide valores segun la opcion
    public static void pedirvalores(int opcion) {
        if(opcion == 8) {
            calculo(opcion, pedirvalor(-360.0 , 360.0), null);
        } else if(opcion == 9) {
            calculo(opcion, null, null);
        } else if(opcion == 7) {
            calculo(opcion, pedirvalor(0.0, 1000000.0), null);
        } else if(opcion >= 5) {
            calculo(opcion, pedirvalor(0.0, 1000000.0), pedirvalor(0.0, 1000000.0));
        } else if(opcion == 4) {
            calculo(opcion, pedirvalor(1.0, 1000000.0), pedirvalor(1.0, 1000000.0));
        } else {
            calculo(opcion, pedirvalor(true), pedirvalor(true));
        }
    }


    public static void calculo(int opcion, Double a, Double b) {
        switch (opcion) {
            case 1:
                System.out.println(a + " + " + b + " = " + suma(a, b));
                break;
            case 2:
                System.out.println(a + " - " + b + " = " + resta(a, b));
                break;
            case 3:
                System.out.println(a + " * " + b + " = " + prod(a, b));
                break;
            case 4:
                System.out.println(a + "/" + b + " = " + coef(a, b));
                break;
            case 5:
                System.out.println("Area del rectangulo: " + prod(b, a));
                break;
            case 6:
                System.out.println("Area del triangulo equilatero: " + coef(prod(b, a), 2.0));
                break;
            case 7:
                System.out.println("Area del ciruclo: " + prod(Math.PI, Math.pow(a, 2)));
                break;

            case 8:
                System.out.println(Math.sin(a) + " " + Math.cos(a));
                break;
            case 9:
                System.out.println("Saliste del menu");
                break;
            default:
                System.out.println("Debes de seleccionar una opcion del 1 al 9");
                break;
                
        }

        if(opcion != 9) {
            c();
        }
    }

    public static void main(String[] args) {
        c();
    }
}
