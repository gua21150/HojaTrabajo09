import java.util.Vector;

public class Floyd {
    private MatrixAd mat;
    private int[][] matrixP; // matriz P en algoritmo proporcionado, corresponde a la ruta
    private float[][] matrixD; // matriz D en algoritmo proporcionado, corresponde a distancia
    private float[][] matrixW; // Matriz W en algoritmo proporcionado, corresponde a matriz de peso
    private int ciudades;
    
    public Floyd(MatrixAd mat) {
        this.mat = mat;
        this.matrixW = mat.getWeightMatrix();
        this.ciudades = mat.getVertices();
        this.matrixD = new float[ciudades][ciudades];
        this.matrixP = new int[ciudades][ciudades];
        calculateRoutes();
    }
    
    public String rutaCalculada(String from, String to) {
        calculateRoutes();
        from = from.toUpperCase(); to = to.toUpperCase();
        StringBuilder str = new StringBuilder();
        if(mat.getCiudadesDisponibles().contains(from) && mat.getCiudadesDisponibles().contains(to)) {
            int row = mat.getCiudadesDisponibles().indexOf(from.toUpperCase());
            int col = mat.getCiudadesDisponibles().indexOf(to.toUpperCase());
            if(matrixD[row][col]<999999.0)  {
                str.append("La distancia de "); str.append(from); str.append(" hasta "); str.append(to);
                str.append(" es de "); str.append(matrixD[row][col]);
                str.append(" La ruta es ");
                Vector<Integer> path = construcPath(row, col);

                int n = path.size();
                for (int i = 0; i < n-1; i++) {
                    str.append(" -> ");
                    str.append(mat.getCiudadesDisponibles().get(path.get(i)));
                    str.append(" -> "); str.append(mat.getCiudadesDisponibles().get(path.get(n-1)));

                }
            }
        }
        else
            str.append("No existe alguna de las ciudades ingresadas");
        return str.toString();
    }

    private void initialise() {
        for (int i = 0; i < this.ciudades; i++) {
            for (int j = 0; j < this.ciudades; j++) {
                matrixD[i][j] = matrixW[i][j];
                if(matrixD[i][j]==999999)
                    matrixP[i][j] = -1;
                else
                    matrixP[i][j] = j;
            }
        }
    }

    private Vector<Integer> construcPath(int u, int v) {
        if(matrixP[u][v]==-1)
            return null;

        Vector<Integer> path = new Vector<>();
        path.add(u);
        while(u!=v) {
            u = matrixP[u][v];
            path.add(u);
        }
        return path;
    }

    private void calculateRoutes(){
        initialise();
        float inf = 999999;
        for (int k = 0; k < this.ciudades; k++) {
            for (int i = 0; i < this.ciudades; i++) {
                for (int j = 0; j < this.ciudades; j++) {
                    if (matrixD[i][k] == inf || matrixD[k][j] == inf)
                        continue;

                    if(matrixD[i][j]>matrixD[i][k]+matrixD[k][j]){
                        matrixD[i][j] = matrixD[i][k]+matrixD[k][j];
                        //matrixP[i][j] = matrixP[i][k];
                        matrixP[i][j] = k;
                    }
                }
            }
        }
    }

    public float[][] getMatrixD() {
        return  this.matrixD;
    }
}
