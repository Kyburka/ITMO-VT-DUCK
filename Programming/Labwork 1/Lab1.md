26591 вариант.
# Задание

1. Создать одномерный массив w типа short. Заполнить его числами от 6 до 16 включительно в порядке убывания.
2. Создать одномерный массив x типа float. Заполнить его 10-ю случайными числами в диапазоне от -4.0 до 6.0.
3. Создать двумерный массив w размером 11x10. Вычислить его элементы по следующей формуле (где $x = x[j]$):
  - если $w[i] = 6$, то $w_{1}[i][j] =(\pi*(\cos(x)-1))^{\frac{2}{\arcsin(\frac{1}{|x|})}}$;
  - если $w[i] \in \{9, 10, 11, 12, 15\}$, то $w_{1}[i][j] =\tan(\frac{1}{4}/\frac{x}{1}/3)$;
  - для остальных значений $w[i]: w_{1}[i][j] = \frac{1-\arctan(\frac{\pi}{4}*\sin(x))}{2}/3$
4. Напечатать полученный в результате массив в формате с четырьмя знаками после запятой.

# Код

```java
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
            x[i] = MAX_RANDOM * random.nextFloat() + MIN_RANDOM; // random.nextFloat() - от 0.0 до 1.0. Умножая на MAX_RANDOM, становится от 0.0 до MAX_RANDOM. Прибавляя MIN_RANDOM, становится от MIN_RANDOM до MAX_RANDOM-MIN_RANDOM. 
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
```

# Результаты вычислений

| Столбец 1 | Столбец 2 | Столбец 3 | Столбец 4 | Столбец 5 | Столбец 6 | Столбец 7 | Столбец 8 | Столбец 9 | Столбец 10 |
| --------- | --------- | --------- | --------- | --------- | --------- | --------- | --------- | --------- | ---------- |
| 0,2032    | 0,2761    | 0,2775    | 0,2242    | 0,2746    | 0,1785    | 0,0731    | 0,0970    | 0,2734    | 0,2763     |
| 0,0139    | 0,0184    | 0,0175    | 0,0230    | 0,0188    | -0,0273   | 0,0377    | 0,1396    | 0,0166    | 0,0184     |
| 0,2032    | 0,2761    | 0,2775    | 0,2242    | 0,2746    | 0,1785    | 0,0731    | 0,0970    | 0,2734    | 0,2763     |
| 0,2032    | 0,2761    | 0,2775    | 0,2242    | 0,2746    | 0,1785    | 0,0731    | 0,0970    | 0,2734    | 0,2763     |
| 0,0139    | 0,0184    | 0,0175    | 0,0230    | 0,0188    | -0,0273   | 0,0377    | 0,1396    | 0,0166    | 0,0184     |
| 0,0139    | 0,0184    | 0,0175    | 0,0230    | 0,0188    | -0,0273   | 0,0377    | 0,1396    | 0,0166    | 0,0184     |
| 0,0139    | 0,0184    | 0,0175    | 0,0230    | 0,0188    | -0,0273   | 0,0377    | 0,1396    | 0,0166    | 0,0184     |
| 0,0139    | 0,0184    | 0,0175    | 0,0230    | 0,0188    | -0,0273   | 0,0377    | 0,1396    | 0,0166    | 0,0184     |
| 0,2032    | 0,2761    | 0,2775    | 0,2242    | 0,2746    | 0,1785    | 0,0731    | 0,0970    | 0,2734    | 0,2763     |
| 0,2032    | 0,2761    | 0,2775    | 0,2242    | 0,2746    | 0,1785    | 0,0731    | 0,0970    | 0,2734    | 0,2763     |
| NaN       | NaN       | NaN       | NaN       | NaN       | NaN       | NaN       | NaN       | NaN       | NaN        |
# Вывод

В данной работе я научился работать с библиотекой $java.util.Random$, а также прочитал конвенции кода Java. Научился собирать JAR, а также отправлять их на сервера используя $SCP$.

# Компилирование и перевод в JAR и запуск

Компилируем наш файл $main.java$ в git bash командой:
```bash
javac --release 21 main.java
```

Далее, переводим $Main.class$ в JAR:
```bash
jar cfe Main.jar Main *.class
```

Отправляем на Гелиос через $scp$:
```bash
scp -P 2222 Main.jar s501591@se.ifmo.ru:~/
#Вводим пароль
```

Запускаем JAR на Гелиосе:
```bash
java -jar Main.jar
```

# Код после допчика😈😈😈

Текст дополнительного задания к Лабораторной работе №1:
- Сделай так, чтобы твоя программа читала массивы из входного файла и выводила его в другой созданный файл. По желанию можешь еще сделать генератор для скрипта, чтобы ручками не считать (т.е вынести логику рандомности массива в отдельную программу).

- Если хочется чуть сложнее, можно еще прикрутить команду help которая будет выводить все возможности твоего приложения, а именно генерацию скрипта и просчета функции🤔 например:
	пишу help - выводит
	`~~ generate_massives {название файла} - сгенерировать массивы для вычислений и записать в файл`
	`~~ calculate_func {входной файл} {выходной файл}`

Ну и собственно сам код:

```java
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
            System.out.println("Error!");
            error.printStackTrace();
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
            System.out.println("Error!");
            error.printStackTrace();
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
                System.out.println("Error!");
                error.printStackTrace();
            }
        }
        catch (IOException error) {
            System.out.println("Error!");
            error.printStackTrace();
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
            System.out.println("Error!");
            error.printStackTrace();
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
            System.out.println("Error!");
            error.printStackTrace();
        }
    }
}

```
