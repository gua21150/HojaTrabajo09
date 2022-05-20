/**
 * Clase que simula el objeto de un vértice en las rutas por calcular.
 * @author Mariel Guamuche
 * */
public class Vertice {
    private String ciudad; // nombre de ciudad inicial
    private String destino; // nombre de la ciudad a la que está dirigdo el grafo
    private float distancia; // distancia entre ciudades

    /**
     * Constructor
     * @param name String con nombre de la ciudad actual
     * @param destino String con nombre de ciudad de destino
     * @param dist Float de distancia entre ciudades
     */
    public Vertice(String name, String destino, float dist) {
        this.ciudad = name;
        this.destino = destino;
        this.distancia = dist;
    }

    /**
     * Constructor en caso de no estar conectado con una ciudad por el momento
     * @param name String
     */
    public Vertice (String name) {
        this.ciudad = name;
    }

    /**
     * Obtiene el nombre de la ciudad actual
     * @return String
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Obtiene la distancia entre la ciudad de destino y la actual
     * @return float
     */
    public float getDistancia() {
        return distancia;
    }

    /**
     * Cambia la distancia entre las ciudades
     * @param dist Float Nueva distancia
     */
    public void setDistancia(float dist) {
        this.distancia = dist;
    }

    /**
     * Obtiene el nombre de la ciudad de destino del grafo
     * @return String
     */
    public String getDestino() {
        return destino;
    }

    /**
     * Cambia la ciudad de destino en caso de una emergencia en la ruta
     * @param destino String de nueva conexión
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }
}
