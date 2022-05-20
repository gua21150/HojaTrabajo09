import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Manejo de los datos con los que funcionará el programa
 */
public class FileManager {
    /**
     * Lee el nombre de un archivo y los datos para los vertices
     * @return Vector con datos de tipo Paciente
     */
    public void readFile() {
        File file;          // archivo de texto
        FileReader fr;      // objeto que asegura la lectura del archivo
        BufferedReader bf;  // objeto similar al cursor

        // se coloca try-catch para que trate de realizar la lectura, si se levanta una excepción será tomada con el catch.
        try {
            file = new File("src/main/guategrafo.txt");        // se especifica el archivo
            fr = new FileReader(file);      // se asigna a qué archivo se leerá
            bf = new BufferedReader(fr);    // se agrega un cursor de lectura
            String bfRead;                  // linea utilizada para el condicional
            int i=0;
            while ((bfRead = bf.readLine()) != null) {
                String[] dato = bfRead.split(","); // la línea leída se convierte en un array string
            }
            bf.close(); // se cierra el cursor
            fr.close(); // se cierra el archivo
        } catch(Exception e){
            System.out.println("No se ha encontrado el texto " + "src/main/guategrafo.txt"); // excepción
        }
        // return data; // retorno de la lista con los elementos leídos.
    }
}
