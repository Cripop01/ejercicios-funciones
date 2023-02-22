import java.util.Scanner;

public class contactos {

     static String[][] agenda = new String[100][3];
     static int contador = 0;


     //Metodo que muestra todos los contactos
    public static void mostrar() {
        for(int i = 0; i<contador; i++) {
            mostrar(i);
        }
    }

    //Metodo que muestra los datos de un contacto(fila) en concreto

    public static void mostrar(int fila) {
        System.out.println("Id " + "\t" + "Nombre" + "\t\t" + "Telefono " + "\t" + "Email");
        System.out.print(fila + "\t");
        for(int i = 0; i< agenda[fila].length; i++) {
            System.out.print(agenda[fila][i] + "\t");
        }
        System.out.println();
    }

    //Metodo que muestra el menu y devuelve la opcion seleccionada
    public static int menu() {
        System.out.println("1. Ver contactos");
        System.out.println("2. Agregar contacto");
        System.out.println("3. Eliminar contacto");
        System.out.println("4. Buscar por nombre");
        System.out.println("5. Buscar por telefono");
        System.out.println("6. Buscar por correo");
        System.out.println("7. Busqueda global");
        int opcion = new Scanner(System.in).nextInt();
        solinfo(opcion);
        return opcion;
    }

    //Metodo que solicita la informacion necesaria en funcion de la opcion
    public static void solinfo(int opcion) {
        if(opcion == 1) {
            manejar(opcion, " ");
        } else if(opcion == 2) {
            manejar(opcion, pidestring("Introduce la informacion del contacto"));
        } else {
            manejar(opcion, pidestring("Introduce busqueda: "));
        }
    }

    
    //Metodo que realiza la busqueda de un string en la columna especificada
    public static void buscar(String busqueda, int col, String txt) {
        if(col > 3) {
            col -= 4;
        }

        if(txt == null) {
            txt = "Resultado de la busqueda";
        }

        System.out.println(txt);

        for(int f = 0; f<contador; f++) {
            if(agenda[f][col].toUpperCase().contains(busqueda.toUpperCase())) {
                mostrar(f);
            }

        }
    }

    public static void buscar(String busqueda) {
        for(int i = 0; i < agenda[0].length; i++) {
            String txt = new String();
            switch(i) {
                case 0:
                    txt = "Nombre";
                    break;
                case 1:
                    txt = "Telfono";    
                    break;
                case 2:
                    txt = "Email";
                    break;    
            }
            buscar(busqueda, i, "Concactos cuyo " + txt + " es " + busqueda );
        }
    }

    public static void eliminar(int pos) {
        //Acabar eliminacion
    }

    public static void manejar(int opcion, String valor) {
        switch(opcion) {
            //Mostrar contactos
            case 1:
                if(contador == 0) {
                    System.out.println("No hay contactos que mostrar");
                } else {
                    mostrar();
                }
                break;
                //Agregar contacto
            case 2:
                String[] valores = valor.split(" ");
                //Bucle que itera valores para añadir el valor correspondiente a la agenda
                for(int i = 0; i<valores.length; i++) {
                    agenda[contador][i] = valores[i];
                }
                contador++;
                break;
            case 3:
                System.out.println("Selecciona la id de cuenta que quieres eliminar: ");
                buscar(valor);
                eliminar(new Scanner(System.in).nextInt());
                contador--;
                break;
                //Buscar por nombre, telefono o correo
            case 4: case 5: case 6:
                buscar(valor, opcion, null);
                break;
                //Busqueda total
            case 7:
                buscar(valor);
                break;
                //Salir del menu
            case 8:
                System.out.println("Saliste del menu");        
                break;
            default:
                System.out.println("Debes seleccionar una opcion del 1 al 8");
                break;    
        }
    }

    public static String pidestring(String texto) {
        System.out.print(texto);
        return new Scanner(System.in).nextLine();
    }

    public static void main(String[] args) {
       int opcion = menu();
       while(opcion != 8 && opcion <= 7) {
        menu();
       }
    }
}
