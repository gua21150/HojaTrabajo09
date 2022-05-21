import java.util.ArrayList;
/**
* Clase que realiza las operaciones de la matriz de adyacencia de un grafo
* @author Mariel Guamuche
* */
public class MatrixAd {
    private float[][] weightMatrix;     // matriz de peso de las operaciones
    private ArrayList<String> ciudadesDisponibles; // lista de ciudades en las que se encuentran los centros
    private ArrayList<Vertice> ciudades; // vertices
    private int vertices;   // cantidad de vertices, sirve para determinar el tamaño de la matriz de nXn
    private float infinito = 999999; // valor de infinito

    /**
     * Constructor
     * */
    public MatrixAd() {
        this.ciudades = new ArrayList<>();
        this.ciudadesDisponibles = new ArrayList<>();
    }

    /**
     * Obtiene la cantidad de vertices o ciudades
     * @return Integer
     */
    public int getVertices(){ return this.vertices; }

    /**
     * Agrega un nuevo vertice a la colección de datos
     * @param vertice Vertice
     */
    public void addRow(Vertice vertice) {
        if(!ciudades.contains(vertice.getCiudad())) {
            ciudades.add(vertice);
        }
        if(!ciudadesDisponibles.contains(vertice.getCiudad()))
            ciudadesDisponibles.add(vertice.getCiudad());
        if(!ciudadesDisponibles.contains(vertice.getDestino()))
            ciudadesDisponibles.add(vertice.getDestino());
        this.vertices = ciudadesDisponibles.size();
    }

    /**
     * Creación de la matriz de peso del grafo
     */
    public void crearMatrizPeso() {
        int row=0; int col=0;
        this.weightMatrix = new float[vertices][vertices];
        // se llena la matriz con valores infinitos fuera de la diagonal y cero en la diagonal
        for(int i=0;i<vertices;i++) {
            for(int j=0; j<vertices;j++) {
                if(i==j)
                    weightMatrix[i][j] = 0;
                else
                    weightMatrix[i][j] = infinito;
            }
        }
        // se comienza a llenar la matriz con los valores indicados
        for (Vertice vertice: this.ciudades) {
            if(this.ciudadesDisponibles.contains(vertice.getCiudad()) && this.ciudadesDisponibles.contains(vertice.getDestino())) {
                row = this.ciudadesDisponibles.indexOf(vertice.getCiudad());
                col = this.ciudadesDisponibles.indexOf(vertice.getDestino());
                this.weightMatrix[row][col] = vertice.getDistancia();
            } else
                System.out.println("Una de las ciudades no existe");
        }
    }

    /**
     * Elimina la conexión entre dos vértices
     * @param from String origen del vértice
     * @param to String del destino del vértice
     * @return False-> No se eliminó el dato, True-> se eliminó el dato
     */
    public boolean deleteVertice(String from, String to) {
        boolean success=false;
        int fromDelete = 0; int toDelete = 0;
        from = from.toUpperCase(); to = to.toUpperCase();
        Vertice toDeleteVertice = new Vertice(from);
        if(ciudadesDisponibles.contains(from)&&ciudadesDisponibles.contains(to)) {
            for (Vertice vertice: ciudades) {
                if(vertice.getCiudad().equals(from) && vertice.getDestino().equals(to)) {
                    toDeleteVertice = vertice;
                    success = true;
                }
                if(vertice.getCiudad().equals(from))
                    fromDelete++;
                if (vertice.getDestino().equals(to))
                    toDelete++;
            }
            if(success==true) {
                ciudades.remove(toDeleteVertice); // se borra el elemento de los vertices obtenido
                // en caso que las ciudades solo hayan estado conectadas entre si, se eliminan de ciudades disponibles
                if(fromDelete==0)
                    ciudadesDisponibles.remove(ciudadesDisponibles.indexOf(from));
                if(toDelete==0)
                    ciudadesDisponibles.remove(ciudadesDisponibles.indexOf(to));
            }
        }
        return success;
    }

    /***
     * Obtener la matriz de pesos
     * @return Float[][]
     */
    public float[][] getWeightMatrix() {
        return this.weightMatrix;
    }

    /**
     * Indica si está vacía la matriz
     * @return
     */
    public boolean isEmpty() {
        return this.ciudades.isEmpty();
    }

    /***
     * Obtener las ciudades que se han encontrado para la matriz
     * @return ArrayList<String>
     */
    public ArrayList<String> getCiudadesDisponibles() {
        return ciudadesDisponibles;
    }

    /***
     * Mostrar los datos de la matriz de adyacencia de pesos
     * @return String
     */
    public String toString(){
        StringBuilder str = new StringBuilder();
        System.out.print("\n\t\t\t");
        for (int i = 0; i < this.vertices; i++) {
            str.append(ciudadesDisponibles.get(i)+"\t");
        }
        str.append("\n");
        for (int i = 0; i < this.vertices*15; i++) {
            str.append("-");
        }
        str.append("\n");
        for (int i = 0; i < this.vertices; i++) {
            str.append(ciudadesDisponibles.get(i)+" \t|\t");
            for (int j = 0; j < this.vertices; j++) {
                if(this.weightMatrix[i][j]==infinito)
                    str.append("INF");
                else
                    str.append(this.weightMatrix[i][j]);

                str.append("\t\t");
            }
            str.append("\n");
        }
        str.append("\n");
        return str.toString();
    }
}
