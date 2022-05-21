import static org.junit.jupiter.api.Assertions.*;

class MatrixAdTest {
    MatrixAd matrixAd = new MatrixAd();
    float[][] matrixCo = new float[7][7]; // hay 7 ciudades en guategrafo.txt
    float[][] matrixCo2 = new float[7][7]; // hay 7 ciudades en guategrafo.txt
    @org.junit.jupiter.api.BeforeEach
     void preparar(){
        float inf = 999999;
        //mixco
        matrixCo[0][0] = 0; matrixCo[0][1] = 20; matrixCo[0][2] = inf; matrixCo[0][3] = 20;
        matrixCo[0][4] = inf; matrixCo[0][5] = inf; matrixCo[0][6] = inf;
        // antigua
        matrixCo[1][0] = inf; matrixCo[1][1] = 0; matrixCo[1][2] = 30; matrixCo[1][3] = inf;
        matrixCo[1][4] = inf; matrixCo[1][5] = inf; matrixCo[1][6] = inf;
        // escuintla
        matrixCo[2][0] = inf; matrixCo[2][1] = inf; matrixCo[2][2] = 0; matrixCo[2][3] = 15;
        matrixCo[2][4] = inf; matrixCo[2][5] = inf; matrixCo[2][6] = inf;
        // santalucia
        matrixCo[3][0] = inf; matrixCo[3][1] = inf; matrixCo[3][2] = inf; matrixCo[3][3] = 0;
        matrixCo[3][4] = inf; matrixCo[3][5] = inf; matrixCo[3][6] = inf;
        // santiago
        matrixCo[4][0] = inf; matrixCo[4][1] = inf; matrixCo[4][2] = inf; matrixCo[4][3] = inf;
        matrixCo[4][4] = 0; matrixCo[4][5] = 100; matrixCo[4][6] = inf;
        // guatemala
        matrixCo[5][0] = inf; matrixCo[5][1] = inf; matrixCo[5][2] = inf; matrixCo[5][3] = inf;
        matrixCo[5][4] = inf; matrixCo[5][5] = 0; matrixCo[5][6] = 75;
        // peten
        matrixCo[6][0] = inf; matrixCo[6][1] = inf; matrixCo[6][2] = inf; matrixCo[6][3] = 10;
        matrixCo[6][4] = inf; matrixCo[6][5] = inf; matrixCo[6][6] = 0;

        //mixco
        matrixCo2[0][0] = 0; matrixCo2[0][1] = 20; matrixCo2[0][2] = inf; matrixCo2[0][3] = 20;
        matrixCo2[0][4] = inf; matrixCo2[0][5] = inf; matrixCo2[0][6] = inf;
        // antigua
        matrixCo2[1][0] = inf; matrixCo2[1][1] = 0; matrixCo2[1][2] = 30; matrixCo2[1][3] = inf;
        matrixCo2[1][4] = inf; matrixCo2[1][5] = inf; matrixCo2[1][6] = inf;
        // escuintla
        matrixCo2[2][0] = inf; matrixCo2[2][1] = inf; matrixCo2[2][2] = 0; matrixCo2[2][3] = inf;
        matrixCo2[2][4] = inf; matrixCo2[2][5] = inf; matrixCo2[2][6] = inf;
        // santalucia
        matrixCo2[3][0] = inf; matrixCo2[3][1] = inf; matrixCo2[3][2] = inf; matrixCo2[3][3] = 0;
        matrixCo2[3][4] = inf; matrixCo2[3][5] = inf; matrixCo2[3][6] = inf;
        // santiago
        matrixCo2[4][0] = inf; matrixCo2[4][1] = inf; matrixCo2[4][2] = inf; matrixCo2[4][3] = inf;
        matrixCo2[4][4] = 0; matrixCo2[4][5] = 100; matrixCo2[4][6] = inf;
        // guatemala
        matrixCo2[5][0] = inf; matrixCo2[5][1] = inf; matrixCo2[5][2] = inf; matrixCo2[5][3] = inf;
        matrixCo2[5][4] = inf; matrixCo2[5][5] = 0; matrixCo2[5][6] = 75;
        // peten
        matrixCo2[6][0] = inf; matrixCo2[6][1] = inf; matrixCo2[6][2] = inf; matrixCo2[6][3] = 10;
        matrixCo2[6][4] = inf; matrixCo2[6][5] = inf; matrixCo2[6][6] = 0;
    }

    @org.junit.jupiter.api.Test
    void crearMatrizPeso() {
        matrixAd = FileManager.readFile("src/guategrafo.txt");
        matrixAd.crearMatrizPeso();
        assertArrayEquals(matrixCo, matrixAd.getWeightMatrix());
    }

    @org.junit.jupiter.api.Test
    void deleteVertice() {
        matrixAd = FileManager.readFile("src/guategrafo.txt");
        assertFalse(matrixAd.deleteVertice("escuintla","antigua")); // no existe el vertice, por lo cual debe de dar resultado negativo
        matrixAd.crearMatrizPeso();
        assertArrayEquals(matrixCo, matrixAd.getWeightMatrix()); // la matriz de peso es igual a la de matrixCo con todos los elementos
        assertTrue(matrixAd.deleteVertice("escuintla","santalucia")); // si existe el vertice
        matrixAd.crearMatrizPeso(); // debera de haber en la fila de escuintla (2) con valores inf en sus entradas
        assertArrayEquals(matrixCo2, matrixAd.getWeightMatrix());
        System.out.println(matrixAd.toString());
    }
}