import java.util.Arrays;
import java.util.Scanner;

public class banco {
    static double[] saldo = new double[100];//Vector que almacena el saldo de la cuenta
    static String[] nombre = new String[100];//Vector que almacena el nombre de la cuenta
    static int contador = 0;//Contador del numero de cuentas creadas

    /**
     * Metodo que pide un string al usuario
     * @param texto Texto que se le muestra al usuario cuando se le pide el string
     * @return Devuelve el string que introduce el usuario
     */
    public static String PideString(String texto) {
        System.out.print(texto + ": ");
        return new Scanner(System.in).nextLine();
    }

    /**
     * Metodo que pide un numero enterro al usuario
     * @param texto Texto que se le muestra al usuario cuando se le pide el numero entero
     * @return Devuelve el entero que ha introducido el usuario
     */
    public static int pideint(String texto) {
        System.out.print(texto + ": ");
        return new Scanner(System.in).nextInt();
    }


    /***
     * Metodo que muestra todas las cuentas en caso de haberlas
     */
    public static void mostrar() {
        for(int i = 0; i<contador; i++) {
            mostrar_cuenta(i);
        }
    }

    /***
     * Metodo  que verifica si el contador es mayor a 0
     * @return Devuelve true si hay cuentas creadas o false si no hay
     */
    public static boolean comprobar_cuentas() {
        if(contador > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Muestra la informacion de una cuenta en concrreto
     * @param cuenta Se le pasa el numero de cuenta que se quiere mostrar
     */
    public static void mostrar_cuenta(int cuenta) {
        System.out.println("Nombre" + "\t" + "Saldo" + "\t");
        System.out.println(nombre[cuenta] + "\t" + saldo[cuenta] +"\t");
    }


    /**
     * Metodo que dado el nombre de una cuenta busca dicha cuenta en el vector de nombres
     * @param nombre_buscado Nombre de la cuenta que se quiere buscar
     */
    public static boolean buscar_cuenta(String nombre_buscado) {
        boolean found = false;
        for(int i = 0; i<contador; i++) {
            if(nombre[i].equalsIgnoreCase(nombre_buscado)) {
                mostrar_cuenta(i);
                found = true;
            }
        }
        if(!found) {
            System.out.println("No se han encontrado cuentas con el nombre" + nombre_buscado);
        }
        return found;
    }

    /**
     * Metodo que busca las cuentas cuyo saldo es menor a 0
     */
    public static void mostrar_morosos()  {
        for(int i = 0; i<contador; i++) {
            if(saldo[i] < 0) {
                mostrar_cuenta(i);
            }
        }
    }


    /**
     * Metodo que mueve una cuenta usando un bucle para reescribir posiciones en un  vector
     * @param cuenta Se le pasa la posicion en la que se encuentra la cuenta que queremos buscar en el vector
     */
    public static void eliminarcuenta(int cuenta) {
        String nombre_anterior = nombre[cuenta]; //Se guarda el nombre de la cuenta que se quiere borrar
        for(int i = contador - 1; i>cuenta; i--) {
            nombre[i - 1] = nombre[i];
            saldo[i - 1] = saldo[i];
        }
        contador--;

        /**
         * Si realmente se ha borrado la cuenta mostrara un texto o mostrara otro texto
         */
        if(comprobarborrado(nombre_anterior, cuenta)) {
            System.out.println("Se ha borrado la  cuenta " + cuenta + " correctamente"
                    + " con el nombre" + nombre_anterior);
        } else {
            System.out.println("Ha ocurrido un error y no se ha borrado la cuenta " + cuenta
                    + " con el nombre " + nombre_anterior);
        }
    }

    /**
     * Metodo que comprueba si realmente se ha eliminado devolviendo true si es asi o false si no lo es
     * @param nombre_anterior Nombre que tenia la cuenta supuestamente borrada
     * @param cuenta Numero de la posicon en la que se  encontrraba la cuenta que borramos
     * @return
     */
    public static boolean comprobarborrado(String nombre_anterior, int cuenta) {
        if(nombre[cuenta].equalsIgnoreCase(nombre_anterior)) {
            return false;
        } else {
            return true;
        }
    }

    /***
     * Metodod que  suma una cantidad especifica al saldo de una cuenta especifica
     * @param cuenta Posicion en la que se encuentra la cuenta a la que queremos ingresar saldo
     * @param cantidad Cantidad que queremos ingresar
     */
    public static void ingresar(int cuenta, double cantidad) {
        saldo[cuenta] += cantidad;
    }

    /**
     * Metodo que resta una cantidad especifica al saldo de una cuenta especifica
     * @param cuenta Posicion en la que se encuentra la cuenta
     * @param cantidad Cantidad que se quiere retirar
     */
    public static void retirar(int cuenta, double cantidad) {
        saldo[cuenta] -= cantidad;
    }


    public static void agregar_cuenta() {
        nombre[contador] = PideString("Introduce el nommbre de la cuenta");
        saldo[contador] = pideint("Introduce el saldo inicial de la cuenta");
        contador++;
    }

    /**
     * Metodo que muestra el menu
     * @return Devuelve la opcion escogida por el usuario
     */
    public static int menu() {
        System.out.println("1. Ver cuentas");
        System.out.println("2. Ingresar dinero");
        System.out.println("3. Retirar dinero");
        System.out.println("4. Agregar cuenta");
        System.out.println("5. Eliminar cuenta");
        System.out.println("6. Buscar cuenta");
        System.out.println("7. Mostrar morosos");
        System.out.println("8. Salir");
        int opcion = pideint("Selecciona una opcion de la 1 a la 8");
        manejar(opcion);
        return opcion;
    }

    public static void manejar(int opcion) {
        boolean cuentas = comprobar_cuentas();
        if(!cuentas && opcion != 4) {
            menu();
            System.out.println("Actualmente no hay ninguna cuenta con la que hacer esta operacion");
        }  else {
            manejando_opcion(opcion);
        }
    }

    public static void manejando_opcion(int opcion) {
        switch(opcion) {
            case 1:
                mostrar();
                break;
            case 2:
                if(buscar_cuenta(PideString("Introduce el nombre de la cuenta en la que quieres ingresar"))) {
                    retirar(pideint("Selecciona la id de la cuenta en la que quieres ingresar"), pideint("Introduce la cantidad que quieres ingresar"));
                }
                break;
            case 3:
                if(buscar_cuenta(PideString("Introduce el nombre de la cuenta de la que quieres retirar saldo"))) {
                    ingresar(pideint("Selecciona la id de la cuenta en la que quieres retirar"), pideint("Introduce la cantidad que quieres retirar"));
                }
                break;
            case 4:
                agregar_cuenta();
                break;
            case 5:
                if(buscar_cuenta(PideString("Introduce el nombre de la cuenta que quieres eliminar"))) {
                    eliminarcuenta(pideint("Selecciona la id de la cuenta que quieres eliminar"));
                }
                break;
            case 6:
                buscar_cuenta(PideString("Introduce el noombre de la cuenta que buscas"));
                break;
            case 7:
                mostrar_morosos();
                break;
            case 8:
                System.out.println("Saliste");
                break;
            default:
                System.out.println("Debes escoger una opcion de la 1 a la 8");
                break;
        }
    }

    public static void main(String[] args) {
        int opcion = menu();
        while(opcion != 8) {
            menu();
        }
    }
}
