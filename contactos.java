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

    public static Scanner in = new Scanner(System.in);

    //Metodo que pide un entero por pantalla
    public static int PideInt() {
        int eleccion=in.nextInt();
        in.nextLine();
        return eleccion;
    }

    //Metodo que muestra el menu y devuelve la opcion
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
    //Metodo que recibe como parametro la opcion y hace uso de los metodos necasarios en funcion de la opcion
    //seleccionada
    public static void manejar(int opcion, String dato) {
        switch (opcion) {
            //Muestra los contactos de la agenda
            case 1:
                if(comprobar(opcion)) {
                    mostrar();
                }
                break;
            case 2:
                //Añade un contacto a la agenda
                if(comprobar(opcion)) {
                    String arrdatos[] = dato.split(" ");
                    //Si el nombre no existe y el correo tampoco añade el contacto a la agenda
                    if(!buscar(arrdatos[0], 0) && !buscar(arrdatos[1], 1)) { 
                        for(int i = 0; i<arrdatos.length; i++) {
                            agenda[contador][i] = arrdatos[i];
                        }
                        //Aumenta el contador al añadir un contacto a la agenda
                        contador++;
                        //Mensaje que se muestra si no se añade el contacto a la agedna
                    } else {
                        System.out.println("El nombre o el correo que has indicado ya existe");
                    }


                }
                break;
            case 3:
                //Busca la cuenta con el dato introducido en busqueda general si encuentra algo sigue
                if(buscar(dato)) {
                    //Si encuentra algo hace el bucle para eliminar la cuenta
                    System.out.print("Selecciona la id de la cuenta que quieres eliminar: ");
                    //in.nextLine(); //Evita que el scanner se queda pillado
                    int n_cuenta = PideInt(); // Numero de cuenta que quieres eliminar
                    for(int i = contador - 1; i>= n_cuenta; i--) {
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

    //Metodo que controla el texto que se le muestra al usuario al realizar las busquedas
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

    //Metodo que sirve para buscar un dato en concreto de un contacto haciendo uso de la columna de la matriz
    //que corresponde al dato que se quiere buscar
    //Devuelve un boleano que indica o no si se ha encontrado lo que se  estaba buscando
    public static boolean buscar(String busqueda, int col) {
        //Si el dato es mayor o igual que cuatro se le resta cuatro ya que 4 5 y 6 restandole cuatro respectivamente
        //devuelven las posiciones de la matriz 0 1 y 2 que es donde queremos buscar. Si no es 4 5 o 6 buscara en
        //el parametro inicial que se le pasa a la funcion

        boolean texto = false;
        if(col >= 4) {
            col -= 4;
            texto = true;
        }

        boolean found = false;
        //Busca en la columna que coincide con la variable col si el texto que contienen los datos en la matriz
        //contiene alguna cadena de la cadena de busqueda
        for(int i = 0; i<contador; i++) {
            if(agenda[i][col].toUpperCase().contains(busqueda.toUpperCase())) {
                System.out.println(mostrar(i));
                found = true;
            }
        }

        //Si no se encuentra ninguna coincidencia muestra el siguiente mensaje con un salto de linea
        if(!found && texto) {
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

    //Metodo que itera las filas del bucle
    public static void mostrar() {
        for(int i = 0; i<contador; i++) {
            //Por cada fila llama a mostrar con el parametro de fila
            System.out.println(mostrar(i));
        }
    }

    //Metodo que mustra los datos de un contacto, o fila de la matriz
    public static  String  mostrar(int fila) {
        //Cabecera de todos los contactos
        System.out.println("Id" + "\t" + "Nombre" + "\t" + "Telefono" + "\t" + "Correo");
        System.out.print(fila +"\t");
        String texto = new String();
        //Coge los tres datos y los añade a la matriz en la columna correspondiente del 0 al 2
        for(int i = 0; i<3; i++) {
            texto += agenda[fila][i] + "\t";
        }

        //Devuelve el texto en el que ha guardado los datos para mostrarselos al usuario
        return texto;
    }

    //Metodo que comprueba si no hay contactos en la agenda  o si la agenda ya esta llena
    //Devuelve un booleano que devuelve false si se cumple alguna de esas dos condiciones de lo contrario devolvera
    //true
    //Se le pasa como parametro opcion para comprobar que al seleccionar la opcion 2 no compruebe si el contador esta
    //a cero y tambien  que no comprueba si se ha llegado al maximo de  contactos  si se selecciona la opcion 0
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

    //Metodo que pide los datos y los manda al metodo manejar que ya se encargara de hacer algo con estos
    public static void pidedatos(int opcion) {
        if(opcion == 1) {
            manejar(opcion, "");
        } else if(opcion == 2) {
            manejar(opcion, pidestring(" Introduce los datos del contacto: "));
        } else {
            manejar(opcion, pidestring("Introduce la busqueda"));
        }
    }

    //Metodo que pide un string y se le pasa otro string para que sea visible para el usuario
    public static String pidestring(String text) {
        System.out.print(text + ": ");
        return in.nextLine();
    }

    //Metodo principal del programa
    public static void main(String[] args) {
        //Si la opcion seleccionada no sea 8 se seguira mostrando el menu en bucle
        int opcion = menu();
        while(opcion != 8) {
            menu();
        }
    }
}
