import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        boolean proceed = false;
        MatrixAd data = new MatrixAd();
        Floyd floydGraph;

        System.out.println("Bienvenido Floyd's Rute");
        System.out.println("Ingrese el path del archivo de su grafo");
        String nombreArchivo = scanner.nextLine();
        data = FileManager.readFile(nombreArchivo);

        if(!data.isEmpty()) {
            proceed = true;
            data.crearMatrizPeso();
            System.out.println(data.toString());
        } else {
            proceed = false;
            System.out.println("El archivo de texto se encuentra vacío. Se cerrará el programa.");
        }

        if(proceed == true) {
            floydGraph = new Floyd(data);
            while(opcion!=5) {
                System.out.println("¿Qué deseas realizar?");
                System.out.println("1. Calcular ruta entre dos ciudades \n2. Conocer ciudad en centro del grafo");
                System.out.println("3. Modificar el grafo debido a interrupción de tráfico\n4.  Modificar el grafo debido a nueva conexión. \5.Finalizar programa");
                opcion = isNumberC(scanner);

                switch (opcion) {
                    case 1: // ruta entre ciudades
                        System.out.println("Ingrese el nombre de la ciudad de origen");
                        String inicio = scanner.nextLine();
                        System.out.println("Ingrese el nombre de la ciudad de destino");
                        String destino = scanner.nextLine();
                        System.out.println(floydGraph.rutaCalculada(inicio, destino));
                        break;
                    case 2: // centro del grafo`
                        System.out.println(floydGraph.graphCenter());
                        break;
                    case 3: // modificar por interrupcion
                        System.out.println("Ingrese el nombre de la ciudad de origen que se ha interrumpido su conexion");
                        inicio = scanner.nextLine();
                        System.out.println("Ingrese el nombre de la ciudad de destino que se ha interrumpido su conexion");
                        destino = scanner.nextLine();
                        floydGraph.interrupcion(inicio, destino);
                        System.out.println("Se ha recalculado el centro del grafo y las rutas");
                        System.out.println(floydGraph.graphCenter());
                        break;
                    case 4: // modificar por nueva ruta
                        System.out.println("Ingrese el nombre de la ciudad de origen");
                        inicio = scanner.nextLine();
                        System.out.println("Ingrese el nombre de la ciudad de destino");
                        destino = scanner.nextLine();
                        floydGraph.interrupcion(inicio, destino);
                        System.out.println("Ingrese la distancia en kilometros entre las ciudades");
                        float number = isFloatNumber(scanner);
                        floydGraph.nuevaConexion(inicio, destino, number);
                        System.out.println("Se ha recalculado el centro del grafo y las rutas");
                        System.out.println(floydGraph.graphCenter());
                        break;
                    default:
                        System.out.println("Opción no válida. Nos vemos pronto");
                        break;
                }
                System.out.println("Vista general de rutas");
                System.out.println(floydGraph.toString());
            }
        }
        System.out.println("Feliz dia :D");
        scanner.close();
    }

    /**
     * Valida que el número ingresado sea un entero
     * @param scanner
     * @return Entero
     */
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

    /**
     * Valida que el número ingresado sea un float valido
     * @param scanner
     * @return Float
     */
    public static float isFloatNumber(Scanner scanner) {
        boolean correct=false;
        float num = 0;
        while(correct==false) {
            try{
                num = Float.parseFloat(scanner.nextLine());
                correct=true;
            } catch(NumberFormatException e) {
                System.out.println("Ingrese una opción valida");
            }
        }
        return num;
    }
}
