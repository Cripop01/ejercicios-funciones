import java.util.Scanner;
import java.util.regex.Pattern;

public class ejercicio10 {
    public static boolean valid(int a, int max) {
        if(a <= max) {
            return true;
        } else {
            return false;
        }
    }


    public static boolean valid(int a, int max, int min) {
        if(a <= max && a >= min) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Pattern formato_fecha = Pattern.compile("^(?:3[01]|[12][0-9]|0?[1-9])([\\-/.])(0?[1-9]|1[1-2])\\1\\d{4}$");

        String in_fecha;
        boolean valid_format = false;
        String txt1 = "Introduce la fecha(DD/MM/AAA). Año minimo 2000: ";
        do {
            System.out.println(txt1);
            txt1 = "La fecha debe seguir el formato DD/MM/AAA. Intentalo de nuevo:";
            in_fecha = in.nextLine();
            if(formato_fecha.matcher(in_fecha).find()) {
                valid_format = true;
            }
        } while(!valid_format);


        String[] fecha = in_fecha.split("/", 0);
        int dia = Integer.parseInt(fecha[0]);
        int mes = Integer.parseInt(fecha[1]);
        int anyo = Integer.parseInt(fecha[2]);


        int dias_febrero;
        if(anyo % 4 == 0) {
            dias_febrero = 29;
        } else {
            dias_febrero = 28;
        }

        int[] max_dias = {31, dias_febrero, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};



        if(valid(dia, max_dias[mes -1]) && valid(mes, 12) && valid(anyo, 2023, 2000)) {
            System.out.println("La fecha es valida");
        } else {
            System.out.println("La fecha no es valida");
        }


        
        
    }
}
