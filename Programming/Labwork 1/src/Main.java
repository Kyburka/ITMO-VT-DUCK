import java.util.Random;

class Main {
    static final int W_LENGTH = 11;
    static final int X_LENGTH = 10;
    static final int MAX_RANDOM = 10;
    static final int MIN_RANDOM = -4;
    static final int W1_ROWS = 11;
    static final int W1_COLS = 10;
    public static void main(String[] args) {
        short w[] = new short[W_LENGTH];
        int counter = 0;
        for (short i = 16; i >= 6; i--) {
            w[counter] = i;
            counter++;
        }
        float x[] = new float[X_LENGTH];
        Random random = new Random();
        for (int i = 0; i < x.length; i++) {
            x[i] = MAX_RANDOM * random.nextFloat() + MIN_RANDOM; // random.nextDouble() - от 0.0 до 1.0. Умножая на 8, становится от 0.0 до 8.0. Отнимая два, становится от -2.0 до 6.0.
        }
        float[][] w1 = new float[W1_ROWS][W1_COLS];
        for (int i = 0; i < w1.length; i++) {
            for (int j = 0; j < w1[i].length; j++) {
                w1[i][j] = calculateMatrix(w[i], x[j]);
            }
        }
        printMatrix(w1);
    }

    private static float calculateMatrix(short wi, float xj) {
        if (wi == 6) {
            return (float) Math.pow(Math.PI * (Math.cos(xj) - 1), (2 / (Math.asin(1 / Math.pow(Math.E, Math.abs(xj))))));
        }
        else if ((wi >= 9 && wi <= 12) || wi == 15) {
            return (float) Math.tan(((1.0 / 4.0) / (xj / 1.0)) / 3.0);
        }
        else {
            return (float) (((1 - Math.atan(Math.PI / 4.0 * Math.sin(xj))) / 2.0) / 3.0);
        }
    }

    private static void printMatrix(float[][] mtx) {
        for (int i = 0; i < mtx.length; i++) {
            for (int j = 0; j < mtx[i].length; j++) {
                System.out.printf("%10.4f", mtx[i][j]);
            }
            System.out.printf("\n");
        }
    }
}
