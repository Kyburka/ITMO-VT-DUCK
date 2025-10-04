import java.io.File;
import java.util.Random;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Locale;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = "";
        while (true) {
            input = in.nextLine();
            if(input.equals("exit")) {
                break;
            }
            String[] parts = input.split("\\s+");
            switch (parts[0]) {
                case "help":
                    System.out.printf("""
                            Вот список доступных команд:
                            randomArray (Имя файла без .txt) (Длина) (Минимальное случайное) (Максимальное случайное) - создать массив с случайными данными типа float
                            descendingArray (Имя файла без .txt) (Длина) (Максимальное число) - создать массив с данными типа short, где последующий элемент меньше предыдущего на 1
                            calculateMatrix (Имя файла без .txt) (Имя файла с массивом short'ов без .txt) (Имя файла с массивом float'ов без .txt) (Количество столбов матрицы) (Количество строк матрицы) - посчитать матрицу исходя из заданных условий и записать её в заданный файл
                            printMatrix (Имя файла без .txt) - вывести матрицу из файла в консоль
                            exit - закончить выполнение программы
                            """);
                    break;
                case "randomArray":
                    if(parts.length != 5) {
                        System.out.println("Неверный ввод!");
                        break;
                    }
                    String fileName = parts[1];
                    int length = Integer.parseInt(parts[2]);
                    int minRandom = Integer.parseInt(parts[3]);
                    int maxRandom = Integer.parseInt(parts[4]);
                    randomArray(fileName, length, minRandom, maxRandom);
                    break;
                case "descendingArray":
                    if(parts.length != 4) {
                        System.out.println("Неверный ввод!");
                        break;
                    }
                    fileName = parts[1];
                    length = Integer.parseInt(parts[2]);
                    short firstNumber = Short.parseShort(parts[3]);
                    descendingArray(fileName, length, firstNumber);
                    break;
                case "calculateMatrix":
                    if(parts.length != 6) {
                        System.out.println("Неверный ввод!");
                        break;
                    }
                    fileName = parts[1];
                    String fileW = parts[2];
                    String fileX = parts[3];
                    int w1Rows = Integer.parseInt(parts[4]);
                    int w1Cols = Integer.parseInt(parts[5]);
                    calculateMatrix(fileName, fileW, fileX, w1Rows, w1Cols);
                    break;
                case "printMatrix":
                    if(parts.length != 2) {
                        System.out.println("Неверный ввод!");
                        break;
                    }
                    fileName = parts[1];
                    printMatrix(fileName);
                    break;
                default:
                    System.out.println("Я не знаю такой команды!");
                    break;
            }
        }
    }

    private static void randomArray(String fileName, int length, int minRandom, int maxRandom) {
        try {
            if (minRandom > maxRandom) {
                System.out.println("minRandom > maxRandom!");
            }
            else {
                FileWriter fileWriter = new FileWriter(fileName + ".txt");
                Random random = new Random();
                for (int i = 0; i < length; i++) {
                    fileWriter.write(String.format(Locale.US, "%.1f", (maxRandom - minRandom) * random.nextFloat() + minRandom));
                    if (i != length - 1) {
                        fileWriter.write(" ");
                    }
                }
                fileWriter.flush();
                fileWriter.close();
                System.out.println("Done!");
            }
        }
        catch (IOException error) {
            System.out.println("Error!" + error.getMessage());
        }
    }

    private static void descendingArray(String fileName, int length, short firstNumber) {
        try {
            FileWriter fileWriter = new FileWriter(fileName + ".txt");
            short counter = firstNumber;
            for (int i = 0; i < length; i++) {
                fileWriter.write(String.valueOf(counter));
                if (i != length - 1) {
                    fileWriter.write(" ");
                }
                counter--;
            }
            fileWriter.flush();
            fileWriter.close();
            System.out.println("Done!");
        }
        catch (IOException error) {
            System.out.println("Error!" + error.getMessage());
        }
    }

    private static void calculateMatrix(String fileName, String fileW, String fileX, int w1Rows, int w1Cols) {
        try {
            FileReader fileReader = new FileReader(fileW + ".txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] parts;
            short[] w = {};
            if ((line = bufferedReader.readLine()) != null) {
                parts = line.split("\\s+");
                w = new short[parts.length];
                for (int i = 0; i < parts.length; i++) {
                    w[i] = Short.parseShort(parts[i]);
                }
            }
            try {
                FileReader fileReader1 = new FileReader(fileX + ".txt");
                BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
                String line1;
                String[] parts1;
                float[] x = {};
                if ((line1 = bufferedReader1.readLine()) != null) {
                    parts1 = line1.split("\\s+");
                    x = new float[parts1.length];
                    for (int i = 0; i < parts1.length; i++) {
                        x[i] = Float.parseFloat(parts1[i]);
                    }
                }
                float[][] w1 = new float[w1Rows][w1Cols];
                for (int i = 0; i < w1Rows; i++) {
                    for (int j = 0; j < w1Cols; j++) {
                        if (w[i] == 6) {
                            w1[i][j] = (float) Math.pow(Math.PI * (Math.cos(x[j]) - 1),
                                    (2 / (Math.asin(1 / Math.pow(Math.E, Math.abs(x[j]))))));
                        }
                        else if ((w[i] >= 9 && w[i] <= 12) || w[i] == 15) {
                            w1[i][j] = (float) Math.tan(((1.0 / 4.0) / (x[j] / 1.0)) / 3.0);
                        }
                        else {
                            w1[i][j] = (float) (((1 - Math.atan(Math.PI / 4.0 * Math.sin(x[j]))) / 2.0) / 3.0);
                        }
                    }
                }
                writeMatrix(w1, fileName);
            }
            catch (IOException error) {
                System.out.println("Error!" + error.getMessage());
            }
        }
        catch (IOException error) {
            System.out.println("Error!" + error.getMessage());
        }
    }

    private static void writeMatrix(float[][] matrix, String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName+".txt");
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    fileWriter.write(String.format("%10.4f", matrix[i][j]));
                }
                fileWriter.write("\n");
            }
            fileWriter.flush();
            fileWriter.close();
            System.out.println("Done!");
        }
        catch (IOException error) {
            System.out.println("Error!" + error.getMessage());
        }

    }

    private static void printMatrix(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName+".txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] parts = {"0"};
            int lineCounter = 0, colsCounter = 0;
            while((line = bufferedReader.readLine()) != null) {
                parts = line.split("\\s+");
                for (int i = 0; i < parts.length; i++) {
                    System.out.printf(parts[i] + " ");
                }
                System.out.printf("\n");
            }
            bufferedReader.close();
            fileReader.close();
        }
        catch (IOException error) {
            System.out.println("Error!" + error.getMessage());
        }
    }
}
