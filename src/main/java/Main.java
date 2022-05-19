import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        boolean proceed = false;

        System.out.println("Bienvenido Floyd's Rute");
        while(opcion!=4) {
            System.out.println("¿Qué deseas realizar?");
            System.out.println("1. Calcular ruta entre dos ciudades \n2. Conocer ciudad en centro del grafo");
            System.out.println("3. Modificar el grafo \n4. Finalizar programa");
            opcion = isNumberC(scanner);
            ArrayList<String> papa= new ArrayList<>();
            if(opcion>=1 && opcion<=3) {
                if(!papa.isEmpty()) {
                    proceed = true;
                } else {
                    proceed = false;
                    System.out.println("El archivo de texto se encuentra vacío");
                }
            }

            if(proceed == true) {
                boolean input = true;
                switch (opcion) {
                    case 1:
                    break;
                    case 2:
                    break;
                    default: System.out.println("Opción no válida. Nos vemos pronto"); break;
                }
            } else System.err.println("Su archivo no fue encontrado.");
        }
        System.out.println("Feliz dia :D");
        scanner.close();
    }
    public static int isNumberC(Scanner scanner) {
        boolean correct=false;
        int num = 0;
        while(correct==false) {
            try{
                num = Integer.parseInt(scanner.nextLine());
                correct=true;
            } catch(NumberFormatException e) {
                System.out.println("Ingrese una opción valida");
            }
        }
        return num;
    }
}
