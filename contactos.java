import java.util.Scanner;

public class contactos {

     static String[][] agenda = new String[100][3];
     static int contador = 0;

    public static void mostrar() {

        for(int i = 0; i<agenda.length; i++) {
            for(int j = 0; j<agenda[i].length; j++) {
                System.out.println(agenda[i][j]);
            }
        }
    }

    public static void mostrar(int fila) {
        for(int c = 0; c < agenda[fila].length; c++) {
            System.out.println(agenda[fila][c]);
        }
    }

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

    public static void solinfo(int opcion) {
        if(opcion == 1 || opcion == 3) {
            manejar(opcion, " ");
        } else if(opcion == 2) {
            manejar(opcion, pidestring("Introduce la informacion del contacto"));
        } else {
            manejar(opcion, pidestring("Introduce la informacion a buscar"));
        }
    }

    public static void buscar(String busqueda, int col) {
        for(int f = 0; f<agenda.length; f++) {
            if(agenda[f][col] == busqueda ) {
                mostrar(f);
            }
        }
    }

    public static void manejar(int opcion, String valor) {
        switch(opcion) {
            case 1:
                if(contador == 0) {
                    System.out.println("No hay contactos que mostrar");
                } else {
                    mostrar();
                }

               
                break;
            case 2:
                String[] valores = valor.split(" ");
                for(int  i = 0; i<= valores.length; i++) {
                    agenda[contador][i] = valores[i];
                }
                break;
            case 4:
                buscar(valor, (opcion - 4));
                break;           
            case 5:
                buscar(valor, (opcion - 4));
                break;
            case 6:
                buscar(valor, (opcion - 4));
        }
    }

    public static String pidestring(String texto) {
        System.out.print(texto);
        return new Scanner(System.in).nextLine();
    }

    

    public static void main(String[] args) {
        while(menu() != 8) {
            menu();
        }
    }
}
