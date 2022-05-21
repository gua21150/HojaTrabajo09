import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FloydTest {
    float[][] floydC = new float[7][7];
    Floyd floyd;

    @BeforeEach
    void preparar(){
        MatrixAd mat = FileManager.readFile("guategrafo.txt");
        mat.crearMatrizPeso();
        floyd = new Floyd(mat);
        // estos resultados fueron sacados de https://algorithms.discrete.ma.tum.de/graph-algorithms/spp-floyd-warshall/index_en.html
        float inf = 999999;
        //mixco
        floydC[0][0] = 0; floydC[0][1] = 20; floydC[0][2] = 50; floydC[0][3] = 20;
        floydC[0][4] = inf; floydC[0][5] = inf; floydC[0][6] = inf;
        // antigua
        floydC[1][0] = inf; floydC[1][1] = 0; floydC[1][2] = 30; floydC[1][3] = 45;
        floydC[1][4] = inf; floydC[1][5] = inf; floydC[1][6] = inf;
        // escuintla
        floydC[2][0] = inf; floydC[2][1] = inf; floydC[2][2] = 0; floydC[2][3] = 15;
        floydC[2][4] = inf; floydC[2][5] = inf; floydC[2][6] = inf;
        // santalucia
        floydC[3][0] = inf; floydC[3][1] = inf; floydC[3][2] = inf; floydC[3][3] = 0;
        floydC[3][4] = inf; floydC[3][5] = inf; floydC[3][6] = inf;
        // santiago
        floydC[4][0] = inf; floydC[4][1] = inf; floydC[4][2] = inf; floydC[4][3] = 185;
        floydC[4][4] = 0; floydC[4][5] = 100; floydC[4][6] = 175;
        // guatemala
        floydC[5][0] = inf; floydC[5][1] = inf; floydC[5][2] = inf; floydC[5][3] = 85;
        floydC[5][4] = inf; floydC[5][5] = 0; floydC[5][6] = 75;
        // peten
        floydC[6][0] = inf; floydC[6][1] = inf; floydC[6][2] = inf; floydC[6][3] = 10;
        floydC[6][4] = inf; floydC[6][5] = inf; floydC[6][6] = 0;
    }

    @Test
    void testRutaCalculada() {
    }

    @Test
    void testConstrucPath() {

    }

    // con este se evalua que se ha calculado correctamente floyd
    @Test
    void getMatrixD() {
        float[][] floydMe= floyd.getMatrixD();
        assertArrayEquals(floydC, floydMe);
    }
}