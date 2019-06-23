package by.etc.code_review.main;

import java.util.Arrays;

public class Algorithmization2 {

    private static void fillingIntArray(int[] array, int n) {
        int a = 0;
        int b = 10 * n;
        for (int i = 0; i < array.length; i++) {
            array[i] = a + (int) (Math.random() * b);
        }
    }

    private static void fillingNegIntArray(int[] array, int n) {
        int b = 10 * n;
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) ((Math.random() * (2 * b) - b));
        }
    }

    private static void fillingDoubleArray(double[] array, int n) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (double) Math.round((Math.random() * (2 * n + 1) - n) * 100d) / 100d; //for ease of readability, round up to hundredths.
        }
    }

    public static boolean isSimple(int n) {
        if (n >= 2) {
            int i = 2;
            while (i * i <= n) {
                if (n % i == 0) {
                    return false;
                }
                i += 1;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //one-dimensional arrays
        //1.В массив A [N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному К
        System.out.println("Task 1 one-dimensional arrays: ");
        int sizeN = 20;
        int multiplicity = 3;
        int[] arrayA = new int[sizeN];
        int sum1 = 0;
        fillingIntArray(arrayA, sizeN);
        for (int i = 0; i < arrayA.length; i++) {
            if (arrayA[i] % multiplicity == 0) {
                sum1 += arrayA[i];
            }
        }
        System.out.println(sum1);

        //2. Дана последовательность действительных чисел  а1 ,а2 ,..., ап.  Заменить все ее члены, большие данного Z, этим числом. Подсчитать количество замен.
        System.out.println("Task 2 one-dimensional arrays: ");
        int replaceValue = 100;
        int countReplace = 0;
        for (int i = 0; i < arrayA.length; i++) {
            if (replaceValue < arrayA[i]) {
                arrayA[i] = replaceValue;
                countReplace++;
            }
        }
        System.out.println(countReplace);

        //3.Дан  массив  действительных  чисел,  размерность  которого  N.  Подсчитать,  сколько  в  нем  отрицательных, положительных и нулевых элементов.
        System.out.println("Task 3 one-dimensional arrays: ");
        int size3 = 15;
        int countPositive = 0;
        int countNegative = 0;
        int countZero = 0;
        double arrayDouble[] = new double[size3];
        fillingDoubleArray(arrayDouble, 100);
        for (int i = 0; i < arrayDouble.length; i++) {
            if (arrayDouble[i] == 0) {
                countZero++;
            } else if (arrayDouble[i] > 0) {
                countPositive++;
            } else {
                countNegative++;
            }
        }
        System.out.println("Negative element: " + countNegative + ". Positive element: " + countPositive + ". Zero element: " + countZero + ".");

        //4. Даны действительные числа а1 ,а2 ,..., аn . Поменять местами наибольший и наименьший элементы.
        System.out.println("Task 4 one-dimensional arrays: ");
        double smallestElement = 0;
        double largestElement = 0;
        int indexSmallElem = 0;
        int indexLargeElem = 0;
        double temp;
        for (int i = 0; i < arrayDouble.length; i++) {
            if (arrayDouble[i] > largestElement) {
                largestElement = arrayDouble[i];
                indexLargeElem = i;
            }
            if (arrayDouble[i] < smallestElement) {
                smallestElement = arrayDouble[i];
                indexSmallElem = i;
            }
        }
        temp = arrayDouble[indexLargeElem];
        arrayDouble[indexLargeElem] = arrayDouble[indexSmallElem];
        arrayDouble[indexSmallElem] = temp;
        System.out.println(Arrays.toString(arrayDouble));

        //5. Даны целые числа а1 ,а2 ,..., аn . Вывести на печать только те числа, для которых аi > i
        System.out.println("Task 5 one-dimensional arrays: ");
        int size5 = 10;
        int[] array5 = new int[size5];
        fillingIntArray(array5, size5);
        for (int i = 0; i < array5.length; i++) {
            if (array5[i] > (i + 1)) {
                System.out.print(array5[i] + ", ");
            }
        }
        System.out.println();

        //6.Задана  последовательность  N  вещественных  чисел.  Вычислить  сумму  чисел,  порядковые  номера  которых являются простыми числами.
        System.out.println("Task 6 one-dimensional arrays: ");
        int size6 = 15;
        double sum6 = 0;
        double arrayDouble6[] = new double[size6];
        fillingDoubleArray(arrayDouble6, size6 * 2);
        for (int i = 0; i < arrayDouble6.length; i++) {
            if (isSimple(i)) {
                sum6 += arrayDouble6[i];
            }
        }
        sum6 = Math.round(sum6 * 100d) / 100d; // for ease of readability, round up to hundredths.
        System.out.println(sum6);

        //7. Даны действительные числа (a1,a2,....an) max(a1+a2n,a2+a2n-1,an+an+1)
        System.out.println("Task 7 one-dimensional arrays: ");
        int size7 = 20;
        double[] arrayDouble7 = new double[size7];
        fillingDoubleArray(arrayDouble7, 10);
        double max = Double.MIN_VALUE;
        for (int i = 0; i < size7 / 2; i++) {
            if (arrayDouble7[i] + arrayDouble7[size7 - i - 1] > max) {
                max = arrayDouble7[i] + arrayDouble7[size7 - i - 1];
            }
        }
        System.out.println("Max : " + Math.round(max * 100d) / 100d);

        //8. Дана  последовательность  целых  чисел (a1,a2,...,an). Образовать  новую  последовательность,  выбросив  из исходной те члены, которые равны min(a1,a2,...,an)
        System.out.println("Task 8 one-dimensional arrays: ");
        int size8 = 20;
        int[] array8 = new int[size8];
        int count = 0;
        int min = Integer.MAX_VALUE;
        fillingNegIntArray(array8, 1);
        for (int i = 0; i < array8.length; i++) {
            if (array8[i] < min) {
                min = array8[i];
                count = 1;
                continue;
            }
            if (min == array8[i]) {
                count++;
            }
        }
        int[] newArray8 = new int[size8 - count];
        int countIndex = 0;
        for (int i = 0; i < array8.length; i++) {
            if (array8[i] != min) {
                newArray8[countIndex] = array8[i];
                countIndex++;
            }
        }
        System.out.println(Arrays.toString(newArray8));

        //9.В массиве целых чисел с количеством элементов  n  найти наиболее часто встречающееся число. Если таких чисел несколько, то определить наименьшее из них.
        System.out.println("Task 9 one-dimensional arrays: ");
        int countElement = 30;
        int[] array9 = new int[countElement];
        fillingNegIntArray(array9, 1);
        int countFirstNumber;
        int countSecondNumber = 0;
        int firstNumber;
        int secondNumber = 0;
        for (int i = 0; i < array9.length; i++) {
            firstNumber = array9[i];
            countFirstNumber = 0;
            for (int j = 0; j < array9.length; j++) {
                if (array9[j] == firstNumber) {
                    countFirstNumber++;
                }
            }
            if (countFirstNumber > countSecondNumber) {
                countSecondNumber = countFirstNumber;
                secondNumber = firstNumber;
            } else if (countFirstNumber == countSecondNumber) {
                if (firstNumber < secondNumber) {
                    countSecondNumber = countFirstNumber;
                    secondNumber = firstNumber;
                }
            }
        }
        System.out.println(secondNumber);

        //10.  Дан  целочисленный  массив  с  количеством  элементов  п.  Сжать  массив,  выбросив  из  него  каждый  второй элемент (освободившиеся элементы заполнить нулями). Примечание. Дополнительный массив не использовать.
        System.out.println("Task 10 one-dimensional arrays: ");
        int size10 = 30;
        int[] array10 = new int[size10];
        fillingIntArray(array10, 2);
        for (int i = 0; i < array10.length; i++) {
            if (i % 2 != 0) {
                array10[i] = 0;
            }
        }
        System.out.println(Arrays.toString(array10));

        //Array of arrays
        //1. Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент больше последнего.
        System.out.println("Task 1 array of arrays: ");
        int sizeLine1 = 3;
        int sizeColumn1 = 7;
        int[][] arrayArrays1 = new int[sizeLine1][sizeColumn1];
        for (int i = 0; i < arrayArrays1.length; i++) {
            fillingIntArray(arrayArrays1[i], 1);
        }
        for (int i = 0; i < arrayArrays1[0].length; i++) {
            if (arrayArrays1[0][i] > arrayArrays1[arrayArrays1.length - 1][i]) {
                for (int j = 0; j < arrayArrays1.length; j++) {
                    System.out.print(arrayArrays1[j][i] + ", ");
                }
                System.out.println();
            }
        }

        //2. Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали.
        System.out.println("Task 2 array of arrays: ");
        int sizeSquare = 7;
        int[][] arrayArrays2 = new int[sizeSquare][sizeSquare];
        for (int i = 0; i < arrayArrays2.length; i++) {
            fillingIntArray(arrayArrays2[i], 1);
        }
        for (int i = 0; i < arrayArrays2.length; i++) {
            System.out.print(arrayArrays2[i][i] + ", ");
        }
        System.out.println();
        int count2 = arrayArrays2.length - 1;
        for (int i = 0; i < arrayArrays2.length; i++) {
            System.out.print(arrayArrays2[i][count2--] + ", ");
        }
        System.out.println();

        //3. Дана матрица. Вывести k-ю строку и p-й столбец матрицы.
        System.out.println("Task 3 array of arrays: ");
        int lineNumber = 3;
        int columnNumber = 5;
        System.out.println(Arrays.toString(arrayArrays2[lineNumber]));
        for (int i = 0; i < arrayArrays2.length; i++) {
            System.out.print(arrayArrays2[i][columnNumber] + ", ");
        }
        System.out.println();

        //4. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
        System.out.println("Task 4 array of arrays: ");
        int sizeOrder = 16;
        if (sizeOrder % 2 == 0) {
            int[][] arrayArrays4 = new int[sizeOrder][sizeOrder];
            for (int i = 0; i < arrayArrays4.length; i++) {
                int countLength = arrayArrays4[i].length;
                for (int j = 0; j < arrayArrays4[i].length; j++) {
                    if (i % 2 != 0) {
                        arrayArrays4[i][j] = countLength--;
                    } else {
                        arrayArrays4[i][j] = j + 1;
                    }
                }
            }
            for (int i = 0; i < arrayArrays4.length; i++) {
                for (int j = 0; j < arrayArrays4[i].length; j++) {
                    System.out.print(arrayArrays4[i][j] + ", ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Sorry. Invalid input.");
        }

        //5. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
        System.out.println("Task 5 array of arrays: ");
        int sizeOrder5 = 14;
        if (sizeOrder5 % 2 == 0) {
            int[][] arrayArrays5 = new int[sizeOrder5][sizeOrder5];
            for (int i = 0; i < arrayArrays5.length; i++) {
                for (int j = 0; j < arrayArrays5[i].length; j++) {
                    arrayArrays5[i][j] = i + 1;
                }
            }
            for (int i = 0; i < arrayArrays5.length; i++) {
                for (int j = 0; j < arrayArrays5[i].length; j++) {
                    System.out.print(arrayArrays5[i][j] + ", ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Sorry. Invalid input.");
        }

        //6. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
        System.out.println("Task 6 array of arrays: ");
        int sizeOrder6 = 14;
        if (sizeOrder6 % 2 == 0) {
            int[][] arrayArrays6 = new int[sizeOrder6][sizeOrder6];
            int countZero6 = 0;
            for (int i = 0; i < arrayArrays6.length; i++) {
                int countLength6=arrayArrays6.length;
                if (i < arrayArrays6.length / 2) {
                    countZero6 = i;
                } else if (i == arrayArrays6.length / 2) {
                } else {
                    countZero6--;
                }
                countLength6-=countZero6;
                for (int j = 0; j < arrayArrays6[i].length; j++) {
                    if (j < countZero6 || j>= countLength6  ) {
                        arrayArrays6[i][j] = 0;
                    } else {
                        arrayArrays6[i][j] = 1;
                    }
                }
            }
            for (int i = 0; i < arrayArrays6.length; i++) {
                for (int j = 0; j < arrayArrays6[i].length; j++) {
                    System.out.print(arrayArrays6[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Sorry. Invalid input.");
        }

        //7. Сформировать квадратную матрицу порядка N по правилу:
        int sizeOrder7 = 5;
        double [][] arrayArraysDouble7 = new double [sizeOrder7][sizeOrder7];




    }

}