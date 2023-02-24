import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ahorcado {
    static int vidas = 5; //Contador de vidas que tiene el jugador
    //Vector que contiene palabras random
    static String[] Banco_Palabras = {"Mango", "Pijas", "Bello", "Salsa", "Jugar", "Kárate", "Barco", "Zanja", "Chico", "Fiera","Tumba", "Hongo", "Juzgo", "Helio", "Vozes", "Pizar", "Quema", "Roque", "Sello", "Verde","Horno", "Vuelo", "Grito", "Fiesta", "Rumba", "Tonto", "Nubes", "Corso", "Amigo", "Cenar","Punto", "Lunes", "Tocar", "Forro", "Cebra", "Pelea", "Ratas", "Tijas", "Yagua", "Cajas","Zafra", "Dolor", "Gusan", "Ondas", "Mente", "Feudo", "Mecas", "Zorro", "Sonar", "Pista"}; 
    //Vector de caracteres que almacena los caracteres de una palabra seleccionada aleatoriamente
    //del vector Banco_Palabras                  
    static char[] palabra = Banco_Palabras[new Random().nextInt(49)].toUpperCase().toCharArray(); 
    static char[] jugando = new char[5]; //Array que va mostrando las letras
    static char[] usadas = new char[vidas];
    static boolean ganador = false;

    public static void mostrar(String texto) {
        System.out.println(texto);
        System.out.println(Arrays.toString(jugando));
        System.out.print("Letras usuadas: " + Arrays.toString(usadas));
    }

    //Metodo que pide una letra al usuario
    public static void pideletra() {
        System.out.print("Introduce una letra: ");
        resultado(new Scanner(System.in).nextLine().toUpperCase().charAt(0));
    }

    //Metodo qu llama a mostrar indicando el resultado si ha acertado o no
    public static void resultado(char letra) {
        if(comprobar(usadas, letra, 0)) {
            mostrar("La letra que has escogido ya la has utilizado antes");
        } else {
            if(comprobar(palabra, letra, 1)) {
                if(comprobar(jugando, '-', 0)) {
                    mostrar("Has acertado");
                } else {
                    mostrar("Has ganado");
                    ganador = true;
                }
            } else {
                mostrar("No has acertado");
            }
            vidas--;
        }
    }

    
    //Metodo que itera un array en busca de la letra especificada si la encuentra devuelve true 
    //Si no devuelve  fasle
    public static boolean comprobar(char[] array, char letra, int tipo) {
        boolean res = false;
        for(int i = 0; i<array.length; i++) {
            if(array[i] == letra) {
                res = true;
                if(tipo == 1) {
                    jugando[i] = letra;
                    
                } else {
                    break;
                }
            } else {
                res = false;
            }
        }

        if(res) {
            usadas[vidas - 5] = letra;
        }

        return res;
    }


    public static void main(String[] args) {
        Arrays.fill(jugando, '-');
        Arrays.fill(usadas, '-');
        while(vidas > 0 && !ganador) {
            pideletra();
        }
        if(!ganador) {
            mostrar("Has perdido");
        }

    }
}
