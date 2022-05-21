import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Manejo de los datos con los que funcionará el programa
 * @author Mariel Guamuche
 */
public class FileManager {
    private void FileManger(){ }

    /**
     * Lee el nombre de un archivo y los datos para los vertices
     * @param fileName String nombre del archivo
     * @return Vector con datos de tipo Paciente
     */
    public static MatrixAd readFile(String fileName) {

        File file;          // archivo de texto
        FileReader fr;      // objeto que asegura la lectura del archivo
        BufferedReader bf;  // objeto similar al cursor
        MatrixAd matrixAd  = new MatrixAd();  // matriz objeto de la matriz
        // se coloca try-catch para que trate de realizar la lectura, si se levanta una excepción será tomada con el catch.
        try {
            file = new File(fileName);        // se especifica el archivo
            fr = new FileReader(file);      // se asigna a qué archivo se leerá
            bf = new BufferedReader(fr);    // se agrega un cursor de lectura
            String bfRead;                  // linea utilizada para el condicional
            int i=0;
            while ((bfRead = bf.readLine()) != null) {
                String[] dato = bfRead.split(" "); // la línea leída se convierte en un array string
                matrixAd.addRow(new Vertice(dato[0].toUpperCase(), dato[1].toUpperCase(), Float.parseFloat(dato[2])));
            }
            bf.close(); // se cierra el cursor
            fr.close(); // se cierra el archivo
        }  catch (NumberFormatException f) {
            System.out.println("El dato de distancia no se encuentra en un formato valido");
        } catch(Exception e){
            System.out.println("No se ha encontrado el texto " + fileName); // excepción
        }
        return matrixAd; // retorno de la lista con los elementos leídos.
    }
}
