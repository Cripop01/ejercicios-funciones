public class ejercicio15 {

    public static int suma(int[] numeros) {
        int suma = 0;
        for(int numero: numeros) {
            suma += numero;
        }

        return suma;
    }

    public static int media(int[] numeros) {
        return suma(numeros) / numeros.length;
    }
    public static void main(String[] args) {
        int[] numeros = new int[100];

        for(int i = 0; i< numeros.length; i++ ) {
            numeros[i] = i + 1;
        }

        System.out.println("La suma de  todos los numeros naturales del 1 al 100 es: " + suma(numeros));
        System.out.println("La media de todos los numeros natures del 1 al 100 es: " + media(numeros));
    }
}
