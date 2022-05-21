import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Clase que modela el funcionamiento del grafo utilizando la logica del algoritmo de Floyd.
 * El codigo de las clases initialise, calculeRoutes,printPath y printSolution fueron adaptadas de https://www.techiedelight.com/pairs-shortest-paths-floyd-warshall-algorithm/
 * @author Mariel Guamuche
 * **/
public class Floyd {
    private MatrixAd mat;    // Objeto de tipo MatrixAd, permite conectar la informacion entre clases
    private int[][] matrixP; // matriz P en algoritmo proporcionado, corresponde a la ruta
    private float[][] matrixD; // matriz D en algoritmo proporcionado, corresponde a distancia
    private float[][] matrixW; // Matriz W en algoritmo proporcionado, corresponde a matriz de peso
    private int ciudades;   // cantidad de ciudades para matriz de nxn

    /**
     * Constructor
     * @param mat
     */
    public Floyd(MatrixAd mat) {
        this.mat = mat;
        this.matrixW = mat.getWeightMatrix();
        this.ciudades = mat.getVertices();
        this.matrixD = new float[ciudades][ciudades];
        this.matrixP = new int[ciudades][ciudades];
        calculateRoutes();
    }

    /**
     * Obtiene la matriz de rutas más cortas
     * @return float[][]
     */
    public float[][] getMatrixD() {
        return  this.matrixD;
    }

    /**
     * Inicializa los valores de la matriz de rutas y matriz de distancia
     */
    private void initialise() {
        for (int i = 0; i < this.ciudades; i++) {
            for (int j = 0; j < this.ciudades; j++) {
                matrixD[i][j] = matrixW[i][j];
                if(i==j)
                    matrixP[i][j] = 0; // la diagonal se llena de ceros
                else{
                    if(matrixD[i][j]!=999999)
                        matrixP[i][j] = i; // se coloca el valor de i en la matriz de rutas para indicar que si hay conexión entre vértices
                    else
                        matrixP[i][j] = -1; // no hay conexión entre vértices
                }
            }
        }
    }

    /**
     * Aplicacion del algoritmo de floyd
     * */
    private void calculateRoutes(){
        initialise();
        float inf = 999999;
        for (int k = 0; k < this.ciudades; k++) {
            for (int i = 0; i < this.ciudades; i++) {
                for (int j = 0; j < this.ciudades; j++) {

                    if (matrixD[i][k] != Integer.MAX_VALUE
                            && matrixD[k][j] != Integer.MAX_VALUE
                            && (matrixD[i][k] + matrixD[k][j] < matrixD[i][j]))
                    {
                        matrixD[i][j] = matrixD[i][k] + matrixD[k][j];
                        matrixP[i][j] = matrixP[k][j];
                    }
                }
            }
        }
    }

    /**
     * Recursive function to print path of given vertex `u` from source vertex `v
     * @param v origen
     * @param u destino
     * @param route se almacena las rutas realizadas
     */
    private void printPath(int v, int u, List<Integer> route) {
        if(matrixP[v][u]==v)
            return;
        printPath(v, matrixP[v][u], route);
        route.add(matrixP[v][u]);
    }

    /**
     * Obtiene el resumen de los datos de la ruta entre dos vértices
     * @param from Inicio
     * @param to Destino
     * @return
     */
    private List<Integer> printSolution(int from, int to)
    {
        List<Integer> route = new ArrayList<>();
        route.add(from);
        printPath(from, to, route);
        route.add(to);
        return route;
    }

    /**
     * Retorna la ruta más corta entre dos vértices, indicando distancia y recorrido
     * @param from Inicio
     * @param to Destino
     * @return
     */
    public String rutaCalculada(String from, String to) {
        calculateRoutes();
        from = from.toUpperCase(); to = to.toUpperCase();
        StringBuilder str = new StringBuilder();
        if(mat.getCiudadesDisponibles().contains(from) && mat.getCiudadesDisponibles().contains(to)) {
            int row = mat.getCiudadesDisponibles().indexOf(from.toUpperCase());
            int col = mat.getCiudadesDisponibles().indexOf(to.toUpperCase());
            if(matrixD[row][col]<999999.0)  {
                str.append("La distancia de "); str.append(from); str.append(" hasta "); str.append(to);
                str.append(" es de: "); str.append(matrixD[row][col]); str.append(" KM.\n");
                str.append(" La ruta es ");
               List<Integer> route = printSolution(row,col);
                int n = route.size();
                for (int i = 0; i < n; i++) {
                    str.append(mat.getCiudadesDisponibles().get(route.get(i)));
                    if(i!=(n-1))
                        str.append(" -> ");
                }
            }
        }
        else
            str.append("No existe alguna de las ciudades ingresadas");
        return str.toString();
    }

    /**
     * Indica el centro del grafo
     * @return
     */
    public String graphCenter() {
        calculateRoutes(); // se realiza el algoritmo de floyd
        float min=0;
        ArrayList<Float> e = new ArrayList<Float>(); // se almacenan las excentricidades de las columnas
        // se obtiene la máxima excentricidad de la columna
        for(int col=0; col<this.ciudades; col++) {
            e.add((float) -1);
            for(int fila=0; fila<this.ciudades; fila++) {
                if(matrixD[fila][col]>e.get(col))
                    e.set(col,matrixD[fila][col]);
            }
        }

        min = e.get(0);
        // se obtiene el mínimo valor entre las columnas
        for (int i = 1; i < this.ciudades; i++)
            if(e.get(i) < min)
                min = e.get(i);

        return "El centro del grafo está en " + mat.getCiudadesDisponibles().get(e.indexOf(min)) + " con un valor de "+min+" KM.";
    }

    /**
     * Cuando se alteran las rutas, este proceso se repite por el cual fue colocado en una función
     */
    private void reDo() {
        this.mat.crearMatrizPeso();
        this.matrixW = this.mat.getWeightMatrix();
        this.ciudades = mat.getVertices();
        this.matrixD = new float[ciudades][ciudades];
        this.matrixP = new int[ciudades][ciudades];
        calculateRoutes();
    }

    /**
     * Se elimina conexión entre rutas
     * @param from
     * @param to
     */
    public void interrupcion(String from, String to) {
        if(mat.deleteVertice(from, to)==true) {
            System.out.println("Se ha eliminado correctamente esta conexion de ciudades");
            reDo();
        }
        else
            System.out.println("No se ha encontrado alguna de las ciudades indicadas, verifica de nuevo");
    }

    /**
     * Se agrega una nueva conexión o ruta
     * @param from
     * @param to
     * @param dis
     */
    public void nuevaConexion(String from, String to, float dis) {
        this.mat.addRow(new Vertice(from, to, dis));
        reDo();
    }

    /**
     * Se imprimen los datos
     * @return
     */
    public String toString(){
        StringBuilder str = new StringBuilder();
        System.out.print("\n\t\t\t");
        for (int i = 0; i < this.ciudades; i++) {
            str.append(mat.getCiudadesDisponibles().get(i)+"\t");
        }
        str.append("\n");
        for (int i = 0; i < this.ciudades*15; i++) {
            str.append("-");
        }
        str.append("\n");
        for (int i = 0; i < this.ciudades; i++) {
            str.append(mat.getCiudadesDisponibles().get(i)+" \t|\t");
            for (int j = 0; j < this.ciudades; j++) {
                if(this.matrixD[i][j]==999999.0)
                    str.append("INF");
                else
                    str.append(this.matrixD[i][j]);

                str.append("\t\t");
            }
            str.append("\n");
        }
        str.append("\n");
        return str.toString();
    }
}
