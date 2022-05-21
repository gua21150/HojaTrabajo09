import java.util.ArrayList;
import java.util.Arrays;

public class MatrixAd {
    private float[][] weightMatrix;
    private ArrayList<String> ciudadesDisponibles;
    private ArrayList<Vertice> ciudades;
    private int vertices;
    private float infinito = 999999;

    public MatrixAd() {
        this.ciudades = new ArrayList<>();
        this.ciudadesDisponibles = new ArrayList<>();
    }

    public int getVertices(){ return this.vertices; }

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

    public void crearMatrizPeso() {
        int row=0; int col=0;
        this.weightMatrix = new float[vertices][vertices];
        // se llena la matriz con valores infinitos y cero en la diagonal
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

    public float[][] getWeightMatrix() {
        return this.weightMatrix;
    }

    public boolean isEmpty() {
        return this.ciudades.isEmpty();
    }

    public ArrayList<String> getCiudadesDisponibles() {
        return ciudadesDisponibles;
    }

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
