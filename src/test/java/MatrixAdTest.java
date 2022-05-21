import static org.junit.jupiter.api.Assertions.*;

class MatrixAdTest {
    MatrixAd matrixAd = new MatrixAd();
    float[][] matrixCo = new float[7][7]; // hay 7 ciudades en guategrafo.txt

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
    }

    @org.junit.jupiter.api.Test
    void addRow() {
    }

    @org.junit.jupiter.api.Test
    void crearMatrizPeso() {
        matrixAd = FileManager.readFile("guategrafo.txt");
        assertArrayEquals(matrixCo,matrixAd.getWeightMatrix());
    }
}