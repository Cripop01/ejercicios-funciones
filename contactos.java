import java.util.Scanner;

public class contactos {
    /**
     * Programa modular que sirve de aplicacion de contactos. Una matriz bidimensional almacena los contactos
     * donde en y0, y1, y2 corresponde respectivamente al nombre del contacto, numero de telefono y email
     *Ejemplo de contacto
     * Id Nombre    Telefono    Email
     * 0  Cristian  2323323     correo@email.com
     */

    //Parametros de la clase
    static int max_contactos = 100; //Numero maximo de contactos que se pueden almacenar
    static String[][] agenda = new String[max_contactos][3]; //Matriz que almacena los contactos
    static int contador = 0; //Contador de las posiciones utilizadas en la matriz

    public static int PideInt() {
        return new Scanner(System.in).nextInt();
    }
    public static int menu() {
        System.out.println("1. Ver contactos");
        System.out.println("2. Agregar contacto");
        System.out.println("3. Eliminar contacto");
        System.out.println("4. Buscar por nombre");
        System.out.println("5. Buscar por telefono");
        System.out.println("6. Buscar por correo");
        System.out.println("7. Busqueda global");
        System.out.println("8. Salir");
        int opcion = PideInt();
        pidedatos(opcion);
        return opcion;
    }
    public static void manejar(int opcion, String dato) {
        switch (opcion) {
            case 1:
                if(comprobar(opcion)) {
                    mostrar();
                }
                break;
            case 2:
                if(comprobar(opcion)) {
                    String arrdatos[] = dato.split(" ");
                    for(int i = 0; i<arrdatos.length; i++) {
                        agenda[contador][i] = arrdatos[i];
                    }
                    contador++;
                }
                break;
            case 3:
                if(buscar(dato)) {
                    System.out.print("Selecciona la id de la cuenta que quieres eliminar: ");
                    for(int i = contador - 1; i>= PideInt(); i--) {
                        for(int c = 0; c < agenda[i].length; c++) {
                            agenda[i + 1][c] = agenda[i][c];
                        }
                    }
                    contador--;
                    System.out.println("Se ha eliminado la cuenta correctamente");
                }
                break;
            case 4: case 5: case 6:
                buscar(dato, opcion);
                break;
            case 7:
                buscar(dato);
                break;
            case 8:
                System.out.println("Saliste del menu");
                break;
            default:
                System.out.println("Debes de seleccionar una opcion del 1 al 8.");
                break;
        }
    }

    public static String txtBusqueda(int col) {
        String txt = new String();
        switch (col) {
            case 0:
                txt = "nombre";
                break;
            case 1:
                txt = "telefono";
                break;
            case 2:
                txt = "correo";
                break;
        }
        return txt;
    }

    public static boolean buscar(String busqueda, int col) {
        if(col >= 4) {
            col -= 4;
        }

        boolean found = false;
        for(int i = 0; i<contador; i++) {
            if(agenda[i][col].toUpperCase().contains(busqueda.toUpperCase())) {
                System.out.println(mostrar(i));
                found = true;
            }
        }

        if(!found) {
            System.out.println("No se ha nencontrado contactos con el " + txtBusqueda(col) + " " + busqueda);
        }
        return found;
    }

    public static boolean buscar(String busqueda) {
        boolean res = false;
        for(int i = 0; i<agenda[0].length; i++) {
            if(buscar(busqueda, i))
                res = true;
        }

        return res;
    }
    public static void mostrar() {
        for(int i = 0; i<contador; i++) {
            System.out.println(mostrar(i));
        }
    }

    public static  String  mostrar(int fila) {
        System.out.println("Nombre" + "\t" + "Telefono" + "\t" + "Correo");
        String texto = new String();
        for(int i = 0; i<3; i++) {
            texto += agenda[fila][i] + "\t";
        }

        return texto;
    }

    public static boolean comprobar(int opcion) {
        boolean res = true;
        if(contador == 0 && opcion != 2) {
            System.out.println("No hay contactos en la agenda actualmente");
            res = false;
        } else if(contador == max_contactos +1 && opcion != 0) {
            System.out.println("La agenda esta llena. Considera eliminar un contacto.");
            res = false;
        }
        return res;
    }

    public static void pidedatos(int opcion) {
        if(opcion == 1) {
            manejar(opcion, "");
        } else if(opcion == 2) {
            manejar(opcion, pidestring(" Introduce los datos del contacto: "));
        } else {
            manejar(opcion, pidestring("Introduce la busqueda"));
        }
    }
    public static String pidestring(String text) {
        System.out.print(text + ": ");
        return new Scanner(System.in).nextLine();
    }

    public static void main(String[] args) {
        int opcion = menu();
        while(opcion >= 0 && opcion <= 8) {
            menu();
        }
    }
}
