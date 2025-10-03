26591 вариант.
# Задание

1. - Создать одномерный массив w типа short. Заполнить его числами от 6 до 16 включительно в порядке убывания.
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
javac main.java
```

Далее, переводим $Main.class$ в JAR:
```bash
jar cfe -source 21 -target 21 main *.class
```

Отправляем на Гелиос через $scp$:
```bash
scp -P 2222 s501591@se.ifmo.ru:~ main.jar
#Вводим пароль
```

Запускаем JAR на Гелиосе:
```bash
java -jar main.jar
```
