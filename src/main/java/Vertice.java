public class Vertice {
    private String ciudad = "";
    private String destino = "";
    private float distancia = 0;

    public Vertice(String name, String destino, float dist) {
        this.ciudad = name;
        this.destino = destino;
        this.distancia = dist;
    }

    public Vertice (String name) {
        this.ciudad = name;
    }

    public String getCiudad() {
        return ciudad;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float dist) {
        this.distancia = dist;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
}
