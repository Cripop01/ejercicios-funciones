import java.util.Scanner;

public class ejercicio21 {

    public static Double calculo(Double radio, int opcion) {
        Double resultado = 0.0;
        switch(opcion) {
            case 1:
                resultado = Math.PI * 2 * radio;
                break;
            case 2:
                resultado = Math.pow(radio, opcion);
                break;    
        }

        return resultado;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Selecciona una de las siguientes opciones: ");
            System.out.println("1) Calcula la circunferencia");
            System.out.println("2) Calcula el radio");
            System.out.println("3) Salir");

            opcion = in.nextInt();

            System.out.println("Introduce el radio");
            Double radio = in.nextDouble();
            System.out.println("Resultado: " + Math.round(calculo(radio, opcion)));
        } while (opcion != 3);
    }
}
