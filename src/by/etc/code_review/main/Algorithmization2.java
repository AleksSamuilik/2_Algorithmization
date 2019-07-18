package by.etc.code_review.main;

import java.util.Arrays;
import java.util.Scanner;

public class Algorithmization2 {

    private static String readInput(String nameInput) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the " + nameInput + ": ");
        String input;
        while (true) {
            input = scanner.nextLine();
            try {
                if (input != null) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Try again.");
            }
        }
        return input;
    }

    private static void createMatrixConsistingOfZeroAndOne(int[][] arr) {
        for (int i = 0; i < arr[0].length; i++) {
            int countOne = i;
            for (int j = 0; j < arr.length; j++) {
                if (countOne != 0) {
                    arr[j][i] = 1;
                    countOne--;
                } else {
                    arr[j][i] = 0;
                }
            }
        }

    }

    private static void sortLineMoreToLess(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            boolean valid = true;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[j + 1]) {
                    valid = false;
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
            if (valid) {
                break;
            }
        }
    }

    private static void sortColumnMoreToLess(int[][] arr) {
        int count = 0;
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            if (maxLength < arr[i].length) {
                maxLength = arr[i].length;
            }
        }
        while (count < maxLength) {
            for (int i = arr[count].length - 1; i > 0; i--) {
                boolean valid = true;
                for (int j = 0; j < i; j++) {
                    if (arr[j][count] < arr[j + 1][count]) {
                        valid = false;
                        int tmp = arr[j][count];
                        arr[j][count] = arr[j + 1][count];
                        arr[j + 1][count] = tmp;
                    }
                }
                if (valid) {
                    break;
                }
            }
            count++;
        }
    }

    private static void printArrayOfArrays(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + ", ");
            }
            System.out.println();
        }
    }

    private static void printArrayOfArrays(double[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + ", ");
            }
            System.out.println();
        }
    }

    private static void fillingIntArray(int[] array, double n) {
        int a = 0;
        int b = (int) Math.round(10 * n + 1);
        for (int i = 0; i < array.length; i++) {
            array[i] = a + (int) (Math.random() * (b));
        }
    }

    private static void fillingNegIntArray(int[] array, double n) {
        int b = (int) Math.round(10 * n + 1);
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
        System.out.println();

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
        System.out.println();

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
        System.out.println();

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
        System.out.println();

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
        System.out.println();

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
        System.out.println();

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
        System.out.println();

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
        System.out.println();

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
        System.out.println();

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
        System.out.println();

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
            printArrayOfArrays(arrayArrays4);
            System.out.println();
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
                    if (j >= sizeOrder5 - i) {
                        arrayArrays5[i][j] = 0;
                    } else {
                        arrayArrays5[i][j] = i + 1;
                    }
                }
            }
            printArrayOfArrays(arrayArrays5);
            System.out.println();
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
                int countLength6 = arrayArrays6.length;
                if (i < arrayArrays6.length / 2) {
                    countZero6 = i;
                } else if (i == arrayArrays6.length / 2) {
                } else {
                    countZero6--;
                }
                countLength6 -= countZero6;
                for (int j = 0; j < arrayArrays6[i].length; j++) {
                    if (j < countZero6 || j >= countLength6) {
                        arrayArrays6[i][j] = 0;
                    } else {
                        arrayArrays6[i][j] = 1;
                    }
                }
            }
            printArrayOfArrays(arrayArrays6);
            System.out.println();
        } else {
            System.out.println("Sorry. Invalid input.");
        }

        //7. Сформировать квадратную матрицу порядка N по правилу:
        // A[I,J] = sin ((I^2-J^2)/N)
        System.out.println("Task 7 array of arrays: ");
        int sizeOrder7 = 5;
        int scale = 1000;
        double[][] arraySquare = new double[sizeOrder7][sizeOrder7];
        for (int i = 0; i < arraySquare.length; i++) {
            for (int j = 0; j < arraySquare[i].length; j++) {
                arraySquare[i][j] = (double) Math.round(Math.sin(Math.toRadians((Math.pow(i, 2) - Math.pow(j, 2)) / sizeOrder7)) * scale) / scale;
            }
        }
        printArrayOfArrays(arraySquare);
        System.out.println();

        //8.   В числовой матрице поменять местами два столбца  любых столбца. Номера столбцов вводит пользователь с клавиатуры.
        System.out.println("Task 8 array of arrays: ");
        int firstColumn = Integer.parseInt(readInput("Number first column"));
        int secondColumn = Integer.parseInt(readInput("Number second column"));
        int sizeOrder8 = 6;
        int[][] arrayArrays8 = new int[sizeOrder8][sizeOrder8];
        for (int i = 0; i < arrayArrays8.length; i++) {
            fillingIntArray(arrayArrays8[i], 10);
        }
        if (firstColumn <= sizeOrder8 && secondColumn <= sizeOrder8 && firstColumn >= 0 && secondColumn >= 0) {
            for (int i = 0; i < arrayArrays8.length; i++) {
                int template = arrayArrays8[i][firstColumn];
                arrayArrays8[i][firstColumn] = arrayArrays8[i][secondColumn];
                arrayArrays8[i][secondColumn] = template;
            }
        } else {
            System.out.println("Sorry. Try again");
        }
        printArrayOfArrays(arrayArrays8);
        System.out.println();

        //9. Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце. Определить, какой столбец содержит максимальную сумму.
        System.out.println("Task 9 array of arrays: ");
        int[][] arrayArrays9 = {{1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11, 12}, {13, 14, 15, 16, 17, 55}};
        int numberColumn9 = 0;
        int bigSum = 0;
        int sum;
        int maxLength = 0;
        for (int i = 0; i < arrayArrays9.length; i++) {
            if (maxLength < arrayArrays9[i].length) {
                maxLength = arrayArrays9[i].length;
            }
        }
        for (int i = 0; i < maxLength; i++) {
            sum = 0;
            for (int j = 0; j < arrayArrays9.length; j++) {
                if (arrayArrays9[j].length > i) {
                    sum += arrayArrays9[j][i];
                }
            }
            if (bigSum < sum) {
                bigSum = sum;
                numberColumn9 = i;
            }
        }
        printArrayOfArrays(arrayArrays9);
        System.out.println("Big sum: " + bigSum + ". Number column: " + numberColumn9);
        System.out.println();

        //10. Найти положительные элементы главной диагонали квадратной матрицы
        System.out.println("Task 10 array of arrays: ");
        int sizeSquare10 = 4;
        int[][] arrayArrays10 = new int[sizeSquare10][sizeSquare10];
        for (int i = 0; i < arrayArrays10.length; i++) {
            fillingNegIntArray(arrayArrays10[i], 10);
        }
        printArrayOfArrays(arrayArrays10);
        for (int i = 0; i < arrayArrays10.length; i++) {
            if (arrayArrays10[i][i] > 0) {
                System.out.print(arrayArrays10[i][i] + ", ");
            }
        }
        System.out.println();

        //11. Матрицу 10x20 заполнить случайными числами от 0 до 15. Вывести на экран саму матрицу и номера строк, в
        //которых число 5 встречается три и более раз.
        System.out.println("Task 11 array of arrays: ");
        int[][] arrayArrays11 = new int[10][20];
        for (int i = 0; i < arrayArrays11.length; i++) {
            fillingIntArray(arrayArrays11[i], 1.5);
        }
        printArrayOfArrays(arrayArrays11);
        System.out.print("Strings that contain the number 5, 3 or more times: ");
        for (int i = 0; i < arrayArrays11.length; i++) {
            int countFive = 0;
            for (int j = 0; j < arrayArrays11[i].length; j++) {
                if (arrayArrays11[i][j] == 5) {
                    countFive++;
                } else if (countFive >= 3) {
                    break;
                }
            }
            if (countFive >= 3) {
                System.out.print(i + ", ");
            }
        }

        //12. Отсортировать строки матрицы по возрастанию и убыванию значений элементов.
        System.out.println("Task 12 array of arrays: ");
        int sizeSquare12 = 4;
        int[][] arrayArrays12 = new int[sizeSquare12][sizeSquare10];
        for (int i = 0; i < arrayArrays12.length; i++) {
            fillingNegIntArray(arrayArrays12[i], 5);
        }
        printArrayOfArrays(arrayArrays12);
        for (int i = 0; i < arrayArrays12.length; i++) {
            sortLineMoreToLess(arrayArrays12[i]);
        }
        System.out.println();
        printArrayOfArrays(arrayArrays12);
        System.out.println();


        //13. Отсотрировать столбцы матрицы по возрастанию и убыванию значений эементов.
        System.out.println("Task 13 array of arrays: ");
        int sizeSquare13 = 4;
        int[][] arrayArrays13 = new int[sizeSquare13][sizeSquare13];
        for (int i = 0; i < arrayArrays13.length; i++) {
            fillingNegIntArray(arrayArrays13[i], 10);
        }
        printArrayOfArrays(arrayArrays13);
        sortColumnMoreToLess(arrayArrays13);
        System.out.println();
        printArrayOfArrays(arrayArrays13);

        //14.   Сформировать случайную матрицу m  x  n, состоящую из нулей и единиц, причем в каждом столбце число
        //единиц равно номеру столбца
        System.out.println("Task 14 array of arrays: ");
        int sizeColumn14 = 7;
        int sizeString14 = 5;
        if (sizeColumn14 >= sizeString14) {
            int[][] arrayArrays14 = new int[sizeColumn14][sizeString14];
            createMatrixConsistingOfZeroAndOne(arrayArrays14);
            for (int[] xxx : arrayArrays14) {
                System.out.println(Arrays.toString(xxx));
            }
        } else {
            System.out.println("Invalid input");
        }
        System.out.println();

        //15. Найдите наибольший элемент матрицы и заменить все нечетные элементы на него.
        System.out.println("Task 15 array of arrays: ");
        int sizeOrder15 = 5;
        int[][] arrayArrays15 = new int[sizeOrder15][sizeOrder15];
        for (int i = 0; i < arrayArrays15.length; i++) {
            fillingIntArray(arrayArrays15[i], 5);
        }
        int maxValue = 0;
        printArrayOfArrays(arrayArrays15);
        System.out.println();
        for (int i = 0; i < arrayArrays15.length; i++) {
            for (int j = 0; j < arrayArrays15[i].length; j++) {
                if (maxValue < arrayArrays15[i][j]) {
                    maxValue = arrayArrays15[i][j];
                }
            }
        }
        for (int i = 0; i < arrayArrays15.length; i++) {
            for (int j = 0; j < arrayArrays15[i].length; j++) {
                if (arrayArrays15[i][j] % 2 != 0) {
                    arrayArrays15[i][j] = maxValue;
                }
            }
        }
        printArrayOfArrays(arrayArrays15);

        //16. Магический квадрат. Перебором всех возможных вариантов.
        System.out.println("Task 16 array of arrays: ");
        MagicSquare magicSquare = new MagicSquare();
        magicSquare.start(magicSquare.readUserInput());
        System.out.println();

        //One-dimensional arrays Sorting
        //1.  Заданы два одномерных массива с различным количеством элементов и натуральное число k. Объединить их в
        //один  массив,  включив  второй  массив  между  k-м  и  (k+1)  -  м  элементами  первого,  при  этом  не  используя дополнительный массив.
        System.out.println("Task 1 One-dimensional arrays Sorting: ");
        int[] arrayTaskSorting1_1 = {1, 2, 3, 4, 5, 10, 11, 12, 13};
        int[] arrayTaskSorting1_2 = {6, 7, 8, 9};
        int indexInsert = 4;
        if (true) {
            countIndex = 0;
            int[] tmp = new int[arrayTaskSorting1_1.length + arrayTaskSorting1_2.length];
            for (int i = 0; i < tmp.length; i++) {
                if (i == indexInsert + 1) {
                    for (int j = 0; j < arrayTaskSorting1_2.length; j++) {
                        tmp[i] = arrayTaskSorting1_2[j];
                        i++;
                    }
                    i--;
                } else {
                    tmp[i] = arrayTaskSorting1_1[countIndex];
                    countIndex++;
                }
            }
            arrayTaskSorting1_1 = tmp;
        }
        System.out.println(Arrays.toString(arrayTaskSorting1_1));
        System.out.println();

        //2. Даны две последовательности. Образовать из них новую последовательность чисел так, чтобы она тоже была неубывающей. Примечание. Дополнительный массив не использовать.
        System.out.println("Task 2 One-dimensional arrays Sorting: ");
        int[] arrayTaskSorting2_1 = {2, 4, 6, 8, 10, 12, 13};
        int[] arrayTaskSorting2_2 = {1, 4, 5, 9, 14, 18};
        indexInsert = 0;
        int countIndexFirstArray = 0;
        int countIndexSecondArray = 0;
        int[] tmp = new int[arrayTaskSorting2_1.length + arrayTaskSorting2_2.length];
        while (true) {
            if (countIndexFirstArray != arrayTaskSorting2_1.length && countIndexSecondArray != arrayTaskSorting2_2.length) {
                if (arrayTaskSorting2_1[countIndexFirstArray] >= arrayTaskSorting2_2[countIndexSecondArray]) {
                    tmp[indexInsert++] = arrayTaskSorting2_2[countIndexSecondArray++];
                } else if ((arrayTaskSorting2_1[countIndexFirstArray] < arrayTaskSorting2_2[countIndexSecondArray])) {
                    tmp[indexInsert++] = arrayTaskSorting2_1[countIndexFirstArray++];
                }
            } else {
                if (countIndexFirstArray != arrayTaskSorting2_1.length) {
                    for (int i = countIndexFirstArray; i < arrayTaskSorting2_1.length; i++) {
                        tmp[indexInsert++] = arrayTaskSorting2_1[i];
                    }
                } else {
                    for (int i = countIndexSecondArray; i < arrayTaskSorting2_2.length; i++) {
                        tmp[indexInsert++] = arrayTaskSorting2_2[i];
                    }
                }
            }
            if (indexInsert == tmp.length) {
                arrayTaskSorting2_1 = tmp;
                break;
            }
        }
        System.out.println(Arrays.toString(arrayTaskSorting2_1));
        System.out.println();

        /*3.  Сортировка выбором. Дана последовательность чисел ai<an. Требуется переставить элементы так,
        чтобы они были расположены по убыванию. Для этого в массиве, начиная с первого, выбирается наибольший
        элемент и ставится на первое место, а первый - на место наибольшего. Затем, начиная со второго, эта процедура
        повторяется. Написать алгоритм сортировки выбором.*/
        System.out.println("Task 3 One-dimensional arrays Sorting: ");
        Sorter sorter = new Sorter();
        int[] arrayTaskSorting3 = {2, 3, 5, 7, 9, 12, 15, 20, 25};
        sorter.selectionSort(arrayTaskSorting3);
        System.out.println(Arrays.toString(arrayTaskSorting3));
        System.out.println();

        /*4. Сортировка  обменами.  Дана  последовательность  чисел ai<an. Требуется  переставить  числа  в
        порядке  возрастания.  Для  этого  сравниваются  два  соседних  числа
        ai > ai+1 то  делается
        перестановка. Так продолжается до тех пор, пока все элементы не станут расположены в порядке возрастания.
        Составить алгоритм сортировки, подсчитывая при этом количества перестановок.*/
        System.out.println("Task 4 One-dimensional arrays Sorting: ");
        int[] arrayTaskSorting4 = {2, 3, 5, 7, 9, 12, 15, 20, 25};
        sorter.swapSorting(arrayTaskSorting4);
        System.out.println(Arrays.toString(arrayTaskSorting3));
        System.out.println();

        /* 5. Сортировка вставками. Дана последовательность чисел ai...an. Требуется переставить числа в порядке
        возрастания.  Делается  это  следующим  образом.  Пусть ai...an -  упорядоченная  последовательность, т.е.
       ai<an. Берется  следующее  число ai+1 и  вставляется  в  последовательность  так,  чтобы  новая
        последовательность была тоже возрастающей. Процесс производится до тех пор, пока все элементы от  i+1 до n
        не будут перебраны. Примечание. Место помещения очередного элемента в отсортированную часть производить
        с помощью двоичного поиска. Двоичный поиск оформить в виде отдельной функции*/
        System.out.println("Task 5 One-dimensional arrays Sorting: ");
        int[] arrayTaskSorting5 = {7, 6, 14, 8, 16, 9, 13, 15, 2, 1, 12, 4, 3, 11, 5, 10};
        sorter.insertionBinarySort(arrayTaskSorting5);
        System.out.println(Arrays.toString(arrayTaskSorting5));
        System.out.println();

        /* 6. Сортировка  Шелла.  Дан  массив  n  действительных  чисел.  Требуется  упорядочить  его  по  возрастанию.
Делается это следующим образом: сравниваются два соседних элемента ai и ai+1. Если ai<=ai+1, то продвигаются
на  один  элемент  вперед.  Если ai>ai+1, то  производится  перестановка  и  сдвигаются  на  один  элемент  назад.
Составить алгоритм этой сортировки. */
        System.out.println("Task 6 One-dimensional arrays Sorting: ");
        int[] arrayTaskSorting6 = {7, 6, 14, 8, 16, 9, 13, 15, 2, 1, 12, 4, 3, 11, 5, 10};
        sorter.shellSort(arrayTaskSorting6.length, arrayTaskSorting6);
        System.out.println(Arrays.toString(arrayTaskSorting6));
        System.out.println();
       /* 7.  Пусть  даны  две  неубывающие  последовательности  действительных  чисел ai<an и bi<bn    Требуется указать те места,
        на которые нужно вставлять элементы последовательности bi<bn в первую последовательность так, чтобы новая последовательность оставалась возрастающей. */
        System.out.println("Task 7 One-dimensional arrays Sorting: ");
        int[] arrayTaskSorting7_1 = {4, 7, 8, 10, 12, 13, 17, 20};
        int[] arrayTaskSorting7_2 = {1, 2, 3, 5, 6, 9, 14, 18};
        count = 0;
        int countIndexFirstArray7 = 0;
        int countIndexSecondArray7 = 0;
        int[] tmp7 = new int[arrayTaskSorting7_1.length + arrayTaskSorting7_2.length];
        while (count != tmp7.length) {
            if (countIndexSecondArray7 < arrayTaskSorting7_2.length && countIndexFirstArray7 < arrayTaskSorting7_1.length) {
                indexInsert = sorter.binSearch(arrayTaskSorting7_1, 0, arrayTaskSorting7_1.length, arrayTaskSorting7_2[countIndexSecondArray7]);

                if (indexInsert <= countIndexFirstArray7) {
                    tmp7[count] = arrayTaskSorting7_2[countIndexSecondArray7++];
                } else {
                    tmp7[count] = arrayTaskSorting7_1[countIndexFirstArray7++];
                }
                count++;
            } else {
                if (countIndexFirstArray7 != arrayTaskSorting7_1.length) {
                    for (int i = countIndexFirstArray7; i < arrayTaskSorting7_1.length; i++) {
                        tmp7[count++] = arrayTaskSorting7_1[i];
                    }
                } else {
                    for (int i = countIndexSecondArray7; i < arrayTaskSorting7_2.length; i++) {
                        tmp7[count++] = arrayTaskSorting7_2[i];
                    }
                }
            }
        }
        arrayTaskSorting7_1 = tmp7;
        System.out.println(Arrays.toString(arrayTaskSorting7_1));
        System.out.println();

       /* 8.Даны дроби -  натуральные). Составить программу, которая приводит эти дроби к общему
        знаменателю и упорядочивает их в порядке возрастания. */
        System.out.println("Task 8 One-dimensional arrays Sorting: ");


    }
}