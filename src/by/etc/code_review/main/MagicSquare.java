package by.etc.code_review.main;

import java.util.Scanner;

public class MagicSquare {
    private int[][] arrayOfArrays;

    public static int readUserInput() {
        System.out.println("Enter the size of the magic square from 2: ");
        Scanner scanner = new Scanner(System.in);
        int sizeSquare = 0;
        while (true){
            try {
               sizeSquare = Integer.parseInt(scanner.nextLine());
               if (sizeSquare>2){
                   return sizeSquare;
               } else {
                   throw new  RuntimeException();
               }
            } catch (RuntimeException e){
                System.out.println("Try again.");
            }
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();// проверим за какое время проходит создание магического квадрата.
        int digit =readUserInput();
        MagicSquare magicSquare = new MagicSquare();
        magicSquare.start(digit);
        long elapsedTimeMillis = System.currentTimeMillis() - start;
        float elapsedTimeSec = elapsedTimeMillis / 1000F;
        System.out.println("Program working time: " + elapsedTimeSec + " sec.");
    }

    private void swap(int[] array, int firstElem, int secondElem) {
        int temp = array[firstElem];
        array[firstElem] = array[secondElem];
        array[secondElem] = temp;
    }

    private boolean nextSet(int[] array, int digit) {
        int firstElem = digit - 2;
        while (firstElem != -1 && array[firstElem] >= array[firstElem + 1]) {
            firstElem--;
        }
        if (firstElem == -1) {
            return false; // больше перестановок нет
        }
        int secondElem = digit - 1;
        while (array[firstElem] >= array[secondElem]) {
            secondElem--;
        }
        swap(array, firstElem, secondElem);
        int firstResidue = firstElem + 1; // сортируем оставшуюся часть последовательности
        int secondResidue = digit - 1;
        while (firstResidue < secondResidue) {
            swap(array, firstResidue++, secondResidue--);
        }
        return true;
    }

    private void print() { // вывод Массива
        for (int i = 0; i < arrayOfArrays.length; i++) {
            for (int j = 0; j < arrayOfArrays[i].length; j++) {
                System.out.print(arrayOfArrays[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int start(int digit) {
        int[] array;
        int sizeNumbers = (int) Math.pow(digit, 2);
        array = new int[sizeNumbers];
        arrayOfArrays = new int[digit][digit];
        for (int i = 0; i < sizeNumbers; i++) {
            array[i] = i + 1;
        }
        if (checkSum(array, digit)) {
            createArrayOfArrays(array);
        }
        while (nextSet(array, sizeNumbers)) {
            if (checkSum(array, digit)) {
                createArrayOfArrays(array);
                print();
            }
        }
        return 0;
    }

    private static boolean checkSum(int[] array, int digit) {
        int rightSum = digit * ((int) Math.pow(digit, 2) + 1) / 2;


        return checkDiagonal(array, digit, rightSum) ? checkHorizontalLine(array, digit, rightSum) ? checkVerticalLine(array, digit, rightSum) ? true : false : false : false;
        // чтобы не писать слишком много if else использовали тернарный оператор. Проверка начинается с диагоналей, т.к. это быстрее всего происходит
    }

    private static boolean checkDiagonal(int[] array, int digit, int rightSum) {
        int sum = 0;
        boolean valid;
        for (int i = 0; i < digit; i++) {
            sum += array[(i * digit) + i];
        }
        if (sum == rightSum) {
            valid = true;
        } else {
            valid = false;
        }
        sum = 0;
        if (valid) {
            for (int i = 1; i <= digit; i++) {
                sum += array[(i * digit) - i];
            }
            if (sum == rightSum) {
                valid = true;

            } else {
                valid = false;
            }
        }
        return valid;
    }

    private static boolean checkVerticalLine(int[] array, int digit, int rightSum) {
        int sum = 0;
        boolean valid = false;
        for (int i = 0; i < digit; i++) {
            for (int j = 0; j < digit; j++) {
                sum += array[(j * digit) + i];
            }
            if (sum == rightSum) {
                valid = true;
                sum = 0;
            } else {
                valid = false;
                break;
            }
        }
        return valid;
    }

    private static boolean checkHorizontalLine(int[] array, int digit, int rightSum) {
        boolean valid = false;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if ((i + 1) % digit != 0) {
                sum += array[i];
            } else if ((i + 1) % digit == 0) {
                sum += array[i];
                if (sum == rightSum) {
                    valid = true;
                } else {
                    valid = false;
                    break;
                }
                sum = 0;
            }
        }
        return valid;
    }

    private void createArrayOfArrays(int[] array) {
        int count = 0;
        for (int i = 0; i < arrayOfArrays.length; i++) {
            for (int j = 0; j < arrayOfArrays[i].length; j++) {
                arrayOfArrays[i][j] = array[count++];
            }
        }
    }
}