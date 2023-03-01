import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Programa que hace un juego de ahorcado en el que se toma una palabra de un vector de 50 palabras. Va pidiendo
 * al usuario que introduzca una letra, comprueba si la letra esta en la palabra escogida y si es asi lo muestra
 * junto con un vector que muestra las letras que ha ido utilizando el usuario.
 * El usuario tiene 5 vidas en el momento en el que adivina la palbra o en el momento en el que se le agotan las
 * vidas el juego termina
 */
public class ahorcado_final {
    static int vidas = 5; //Vidas que tiene el jugador. Incialmente 5.

    //Vector que contiene 50 palabras. Desde el cual se escogera una palabra de forma aleatoria
    static String[] Banco_Palabras = {"Amor", "Felicidad", "Tristeza", "Esperanza", "Libertad", "Justicia", "Sueño", "Realidad", "Pasion", "Coraje", "Creatividad", "Sabiduria", "Conocimiento", "Belleza", "Fortaleza", "Humildad", "Honestidad", "Respeto", "Tolerancia", "Compasion", "Generosidad", "Gratitud", "Paciencia", "Confianza", "Seguridad", "Aventura", "Riesgo", "Curiosidad", "Integridad", "Lealtad", "Ambicion", "Exito", "Fracaso", "Soledad", "Comunidad", "Solidaridad", "Voluntad", "Sacrificio", "Responsabilidad", "Perseverancia", "Esperanza", "Poder", "Conexion", "Empatia", "Inclusion", "Diversidad", "Igualdad", "Equidad", "Transformacion", "Renacimiento"};

    //Vector de caracteres en el cual se almacenan los caracteres de  la palabra escogida
    static char[] palabra = Banco_Palabras[new Random().nextInt(49)].toUpperCase().toCharArray();
     //Se declara un vector en el cual se van a almacenar las letras que se van descubriendo
     static char[] jugando = new char[palabra.length];

    static char[] usadas = new char[palabra.length + vidas];  //Vector que contiene las letras que ha utilizado el usuario

    public static Scanner in = new Scanner(System.in); // Objeto scanner que se puede utilizar en toda la clase

    static int letras_usadas = 0; //Contador de las letras que se han acertado
    /**
     *@param array array de chars
     * Se hace un bucle que itera el array y va mostrando el mismo de forma ordenada para el usuario
     */
    public static void mostrar_array(String txt, char[] array) {
        System.out.print(txt + " :" );
        for(int i = 0; i<array.length; i++) {
            if(array[i] != 0) {
                System.out.print(array[i] + "\t");
            }
        }
    }

    /**
     * Funcion que muestra las letras adivinadas y las letras utilizadas, llamando a mostrar_array.
     * @param txt Texto que se va a mostrar al mostrar el tablero de juego
     */
    public static void mostrar(String txt) {
        System.out.println(txt);
        mostrar_array("Palabra", jugando);
        System.out.println();
        mostrar_array("Letras usadas", usadas);
        System.out.println();
        System.out.println("Vidas: " + vidas);
    }

    /**
     * Metodo que comprueba si la letra es valida, es decir, si esta entre la A a la Z.
     * si no lo es llama a mostrar con el texto indicado de lo contrario
     * @param letra Letra introducida por el usuario
     */
    public static void resultado(char letra) {
        Pattern l = Pattern.compile("[A-Za-z]");
        if(l.matcher(letra + "").matches()) { //Si es de la A a la Z
            if(comprobar(letra, usadas)) { //Si la letra ya ha sido utilizada
                mostrar("LA LETRA INDICADA YA HA SIDO UTILIZADA");
            } else { //Si la letra no ha sido utilizada
                if(comprobar(letra, palabra)) { //Si la letra esta en la palabra
                    mostrar("HAS ACERTADO");
                } else { //Si la letra no esta en la palabra
                    mostrar("HAS FALLADO");
                    vidas--;
                }
                //Continua, si la letra no ha sido utilizada utilizando la letra al vector usadas
                usadas[letras_usadas] = letra;
                letras_usadas++;
            }
            //Si la letra no es de la A a la Z
        } else {
            mostrar("DEBES USAR UNA LETRA DE LA A a LA Z");
        }
    }

    /**
     * Metodo que pide un string y se lo pasa al metodo resultado
     */
    public static void pideletra() {
        System.out.println("Introduce una letra de la A a la Z");
        resultado(in.nextLine().toUpperCase().charAt(0));
    }

    /**
     * Metood que comprueba si una letra se encuentra en un vector de caracteres
     * @param letra //Letra que se busca en el vector
     * @param array //Vector en el que se busca la letra
     * @return Devuelve un booleano verdadero si encuentra la letra o un booleano falso si no 
     */
    public static boolean comprobar(char letra, char[] array) {
        boolean res = false;
        for(int i = 0; i<array.length; i++) {
            if(letra == array[i]) {
                //Si encuentra la letra devuelve true y añade la letra a jugando
                res = true;
                jugando[i] = letra;
            }
        }
        return res;
    }

    /**
     * Metodo que comprueba si palabra es igual a jugando de este modo determina si el jugador
     * a ganaod la partida
     * @return Devuelve un booleano que indica si el jugador a ganado o no 
     */
    public static boolean ganador() {
        if(Arrays.toString(palabra).equals(Arrays.toString(jugando))) {
            return true;
        } else {
            return false;
        }
    }

    
    /** 
     * @param args
     */
    public static void  main(String[] args) {
        Arrays.fill(jugando, '-');
        while(vidas > 0 && !ganador()) {
            pideletra();
        }

        //Si el jugador a ganado llama a  mostrar con el texto has ganado
        if(ganador()) {
            mostrar("HAS  GANADO");
        } else {
            //Si el jugador ha perdido llama a mostrar con has perdido y llama a mostrar array
            //con palabra para mostrar la palbra correcta
            mostrar("HAS PERDIDO");
            mostrar_array("LA PALABRA CORRECTA ES", palabra);
        }
    }
}