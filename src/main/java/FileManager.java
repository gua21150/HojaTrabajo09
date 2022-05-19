import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Vector;

public class FileManager {
    /**
     * Lee el nombre de un archivo y los datos los simula como pacientes
     * @param name Archivo
     * @return Vector con datos de tipo Paciente
     */
    public void readFile() {
        // Vector<Paciente> data = new Vector<>(); // Vector con objetos de tipo paciente; son los pacientes
        File file;          // archivo de texto
        FileReader fr;      // objeto que asegura la lectura del archivo
        BufferedReader bf;  // objeto similar al cursor

        // se coloca try-catch para que trate de realizar la lectura, si se levanta una excepción será tomada con el catch.
        try {
            file = new File("guategrafo.txt");        // se especifica el archivo
            fr = new FileReader(file);      // se asigna a qué archivo se leerá
            bf = new BufferedReader(fr);    // se agrega un cursor de lectura
            String bfRead;                  // linea utilizada para el condicional
            int i=0;
            while ((bfRead = bf.readLine()) != null) {
                String[] dato = bfRead.split(","); // la línea leída se convierte en un array string
                //data.add(new Paciente(dato[0].strip(), dato[1].strip(), dato[2].strip())); // se agrega al vector un nuevo paciente
            }
            bf.close(); // se cierra el cursor
            fr.close(); // se cierra el archivo
        } catch(Exception e){
            System.out.println("No se ha encontrado el texto " + "guategrafo.txt"); // excepción
        }
        // return data; // retorno de la lista de pacientes con los elementos leídos.
    }
}
