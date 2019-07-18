package by.etc.code_review.main;

import java.util.Arrays;

public class Decomposition {

    public int findNODTwoNumber(int fitstNumber, int secondNumber) {
        if (fitstNumber == 0 || secondNumber == 0) {
            System.out.println("Invalid input.");
            return -1;
        }
        int greaterNumber, lowerNumber;
        if (fitstNumber >= secondNumber) {
            greaterNumber = fitstNumber;
            lowerNumber = secondNumber;
        } else {
            greaterNumber = secondNumber;
            lowerNumber = fitstNumber;
        }
        int result = lowerNumber;
        while (greaterNumber - lowerNumber != 0) {
            result = greaterNumber - lowerNumber;
            if (result >= lowerNumber) {
                greaterNumber = result;
            } else {
                greaterNumber = lowerNumber;
                lowerNumber = result;
            }
        }
        return result;
    }

    public int findNOK(int fitstNumber, int secondNumber) {
        int numberNOD = findNODTwoNumber(fitstNumber, secondNumber);
        if (numberNOD > 0) {
            return ((fitstNumber * secondNumber) / numberNOD);
        } else {
            return -1;
        }
    }

    public int findNODFourNumber(int firstNumber, int secondNumber, int thirdNumber, int fourthNumber) {
        int numberNOD1 = findNODTwoNumber(firstNumber, secondNumber);
        int numberNOD2 = findNODTwoNumber(thirdNumber, fourthNumber);
        if (numberNOD1 > 0 && numberNOD2 > 0) {
            return findNODTwoNumber(numberNOD1, numberNOD2);
        } else {
            return -1;
        }
    }

    public double findAreaOfRegularPolygon(int length, int numberSides) {
        double result = (numberSides * (Math.pow(length, 2))) / (4 * Math.tan(Math.toRadians(360) / (2 * numberSides)));
        return Math.round(result * 1000d) / 1000d;
    }

    public double[] calculateDistance(int[][] array) {
        int count = 0;
        double distance = 0;
        double[] pairCoordinate = new double[0];
        while (count < array.length) {
            for (int i = count + 1; i < array.length; i++) {
                double calculate = calculateLength(array[count][0], array[count][1], array[i][0], array[i][1]);
                if (calculate > distance) {
                    distance = calculate;
                    pairCoordinate = new double[]{array[count][0], array[count][1], array[i][0], array[i][1]};
                }
            }
            count++;
        }
        return pairCoordinate;
    }

    public double calculateLength(int firstX, int firstY, int secondX, int secondY) {
        return Math.sqrt(Math.pow((firstX - secondX), 2) + Math.pow((firstY - secondY), 2));
    }

    public int findSecondMax(int[] array) {
        int firstMax = 0;
        int secondMax = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > firstMax) {
                secondMax = firstMax;
                firstMax = array[i];
            }
        }
        return secondMax;
    }

    public boolean isMutualSimplicityNumbers(int firstNumber, int secondNumbers, int thirdNumbers) {
        if (findNODTwoNumber(findNODTwoNumber(firstNumber, secondNumbers), thirdNumbers) == 1) {
            return true;
        } else {
            return false;
        }
    }

    private int factorial(int n) {
        int result = 1;
        if (n == 1 || n == 0) return result;
        result = n * factorial(n - 1);
        return result;
    }

    public int findOddFactorial(int maxNumbers) {
        int result = 0;
        for (int i = maxNumbers; i > 0; i--) {
            if (i % 2 != 0) {
                result += factorial(i);
            }
        }
        return result;
    }

    public void findSumThreeNumber(int startInterval, int finishInterval, int[] array) {
        if ((finishInterval - startInterval) % 3 != 0) {
            System.out.println("Invalid input");
        } else {
            int result = 0;
            int count = 1;
            for (int i = startInterval; i < finishInterval; i++) {
                result += array[i];
                if (count % 3 == 0) {
                    System.out.println("Sum " + result);
                    result = 0;
                }
                count++;
            }
        }
    }

    public double getAreaArbitraryRectangle(int firstSide, int secondSide, int thirdSide, int fourthSide) {
        double semiPerimeter = (firstSide + secondSide + thirdSide + fourthSide) / 2;
        return Math.sqrt((semiPerimeter - firstSide) * (semiPerimeter - secondSide) * (semiPerimeter - thirdSide) * (semiPerimeter - fourthSide));
    }


    public int[] createArrayDigitsContainedNumber(int number) {
        int size = (int) Math.ceil(Math.log10(number));
        int[] array = new int[size];
        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = number % 10;
            number /= 10;
        }
        return array;
    }

    public int getComparison(int firstNumber, int secondNumber) {
        if (firstNumber > secondNumber) {
            return 0;
        } else if (firstNumber == secondNumber) {
            return 1;
        } else {
            return 2;
        }
    }

    public void getComparisonNumber(int firstNumber, int secondNumber) {
        int first = (int) Math.ceil(Math.log10(firstNumber));
        int second = (int) Math.ceil(Math.log10(secondNumber));
        switch (getComparison(first, second)) {
            case 0:
                System.out.println("Number length " + firstNumber + " greater, than " + secondNumber);
                break;
            case 1:
                System.out.println("Number length " + firstNumber + " equals " + secondNumber);
                break;
            case 2:
                System.out.println("Number length " + secondNumber + " greater, than " + firstNumber);
                break;
            default:
                System.out.println("Invalid input");
        }
    }

    public int[] getArray(int K, int N) {
        int[] tmp = new int[N];
        int count = 0;
        for (int i = 1; i <= tmp.length; i++) {
            if (getNumeralsSum(i) == K) {
                tmp[count] = i;
                count++;
            }
        }
        int[] array = new int[count];
        count = 0;
        while (count < array.length) {
            array[count] = tmp[count];
            count++;
        }
        return array;
    }

    public int getNumeralsSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public void getNumbersTwins(int start, int finish) {
        if ((finish - start) < 2) {
            System.out.println("Invalid input");
        } else {
            System.out.print("The pair twins: ");
            for (int i = start; i <= finish; i++) {
                if (i + 2 <= finish) {
                    System.out.print("[" + i + ", " + (i + 2) + "] ");
                } else {
                    break;
                }
            }
        }
    }

    public void getArmstrongNumbers(int intervalNumbers) {
        System.out.print("The Armstrong numbers: ");
        for (int i = 1; i <= intervalNumbers; i++) {
            if (isArmstrongNumber(i)) {
                System.out.print(i + ", ");
            }
        }
        System.out.println();
    }

    public boolean isArmstrongNumber(int number) {
        int degree = (int) Math.ceil(Math.log10(number));
        int result = 0;
        int digit = number;
        for (int i = 0; i < degree; i++) {
            result += Math.pow((digit % 10), degree);
            digit /= 10;
        }
        if (result == number) {
            return true;
        } else {
            return false;
        }
    }

    public void getIncreasingSequence(int decimal) {
        int startSequence = (int) Math.pow(10, decimal - 1);
        int finishSequence = (int) Math.pow(10, decimal);
        System.out.print("Number with increasing sequence: ");
        for (int i = startSequence; i < finishSequence; i++) {
            if (isIncreasingSequence(i)) {
                System.out.print(i + ", ");
            }
        }
        System.out.println();
    }

    public boolean isIncreasingSequence(int number) {
        int old = -1;
        while (number > 0) {
            int n = number % 10;
            if (old != -1) {
                if (old <= n) {
                    return false;
                }
            }
            old = n;
            number /= 10;
        }
        return true;
    }

    public boolean isOddDigit(int number) {
        while (number > 0) {
            int digit = number % 10;
            if (digit % 2 == 0) {
                return false;
            }
            number /= 10;
        }
        return true;
    }

    public int countEvenDigit(int number) {
        int count = 0;
        while (number > 0) {
            int digit = number % 10;
            if (digit % 2 == 0) {
                count++;
            }
            number /= 10;
        }
        return count;
    }

    public void getEvenDigit(int decimal) {
        int sum = 0;
        int startSequence = (int) Math.pow(10, decimal - 1);
        int finishSequence = (int) Math.pow(10, decimal);
        System.out.print("Number sum: ");
        for (int i = startSequence; i < finishSequence; i++) {
            if (isOddDigit(i)) {
                sum += i;
            }
        }
        System.out.print(sum);
        System.out.println();
        int countEvensDigit = countEvenDigit(sum);
        System.out.println("Quantity evens digit: " + countEvensDigit);
    }

    public int sumDigit(int number) {
        int sum = 0;
        while (number > 0) {
            int digit = number % 10;
            sum += digit;
            number /= 10;
        }
        return sum;
    }

    public int digitSubstraction(int number) {
        int count = 0;
        while (number > 0) {
            number -= sumDigit(number);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        //1. Написать метод(методы) для нахождения наибольшего общего делителя и наименьшего общего кратного двух
        //натуральных чисел: НОК (А,В) = (А*В)/НОД(А,В)
        System.out.println("Task 1 Decomposition: ");
        Decomposition decomposition = new Decomposition();
        System.out.println(decomposition.findNODTwoNumber(462, 1071));
        System.out.println(decomposition.findNODTwoNumber(320, 320));
        System.out.println(decomposition.findNODTwoNumber(320, 0));
        System.out.println(decomposition.findNOK(462, 1071));
        System.out.println(decomposition.findNOK(320, 320));
        System.out.println(decomposition.findNOK(320, 0));
        System.out.println();


        //2. Написать метод(методы) для нахождения наибольшего общего делителя четырех натуральных чисел
        System.out.println("Task 2 Decomposition: ");
        System.out.println(decomposition.findNODFourNumber(462, 1071, 1701, 1575));
        System.out.println(decomposition.findNODFourNumber(462, 462, 1701, 1575));
        System.out.println(decomposition.findNODFourNumber(462, 0, 1701, 1575));
        System.out.println();

        //3. Вычислить  площадь  правильного  шестиугольника  со  стороной  а,  используя  метод  вычисления  площади треугольника.
        System.out.println("Task 3 Decomposition: ");
        System.out.println(decomposition.findAreaOfRegularPolygon(5, 6));
        System.out.println(decomposition.findAreaOfRegularPolygon(5, 2));
        System.out.println(decomposition.findAreaOfRegularPolygon(5, 3));
        System.out.println();

        //4. На плоскости заданы своими координатами  n  точек.  Написать метод(методы), определяющие, между какими
        //из пар точек самое большое расстояние. Указание. Координаты точек занести в массив.
        System.out.println("Task 4 Decomposition: ");
        int[][] arrayTask4 = {{15, 15}, {2, 4}, {7, 12}, {9, 3}, {9, 15}, {14, 4}, {1, 14}};
        System.out.println(Arrays.toString(decomposition.calculateDistance(arrayTask4)));
        System.out.println();

        //5. Составить программу, которая в массиве  A[N] находит второе по величине число (вывести на печать число,
        //которое меньше максимального элемента массива, но больше всех других элементов).
        System.out.println("Task 5 Decomposition: ");
        int[] arrayTask5 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Second max: " + decomposition.findSecondMax(arrayTask5));
        System.out.println();

        //6. Написать метод(методы), проверяющий, являются ли данные три числа взаимно простыми.
        System.out.println("Task 6 Decomposition: ");
        System.out.println(decomposition.isMutualSimplicityNumbers(2, 13, 5));
        System.out.println(decomposition.isMutualSimplicityNumbers(2, 8, 16));
        System.out.println();

        //7. Написать метод(методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9.
        System.out.println("Task 7 Decomposition: ");
        System.out.println(decomposition.findOddFactorial(9));
        System.out.println();

        //8. Задан массив D. Определить следующие суммы: D[l] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] +D[5] +D[6].
        //Пояснение. Составить  метод(методы)  для вычисления суммы трех последовательно расположенных элементов
        //массива с номерами от k до m.
        System.out.println("Task 8 Decomposition: ");
        int[] arrayTask6 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        decomposition.findSumThreeNumber(2, 11, arrayTask6);
        System.out.println();

        //9. Даны числа X, Y, Z, Т — длины сторон четырехугольника. Написать метод(методы) вычисления его площади,
        //если угол между сторонами длиной X и Y— прямой.
        System.out.println("Task 9 Decomposition: ");
        int firstSide = 10;
        int secondSide = 12;
        int thirdSide = 14;
        int fourthSide = 16;
        System.out.println("Area arbitrary rectangle: " + decomposition.getAreaArbitraryRectangle(firstSide, secondSide, thirdSide, fourthSide));
        System.out.println();

        //10.  Дано  натуральное  число  N.  Написать  метод(методы)  для  формирования  массива,  элементами  которого
        //являются цифры числа N.
        System.out.println("Task 10 Decomposition: ");
        int numberTask10 = 2348921;
        System.out.println(Arrays.toString(decomposition.createArrayDigitsContainedNumber(numberTask10)));
        System.out.println();

        //11. Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр.
        System.out.println("Task 11 Decomposition: ");
        int numberTask11_1 = 2345678;
        int numberTask11_2 = 123456789;
        decomposition.getComparisonNumber(numberTask11_1, numberTask11_2);
        System.out.println();

        //12. Даны  натуральные числа К  и  N.  Написать метод(методы)  формирования массива  А, элементами  которого
        //являются числа, сумма цифр которых равна К и которые не большее N.
        System.out.println("Task 12 Decomposition: ");
        int numberTask12_1 = 12;
        int numberTask12_2 = 250;
        System.out.println(Arrays.toString(decomposition.getArray(numberTask12_1, numberTask12_2)));
        System.out.println();

        //13. Два простых числа называются «близнецами», если они отличаются друг от друга на 2 (например, 41 и 43).
        //Найти и напечатать все пары «близнецов» из отрезка [n,2n], где  n  -  заданное натуральное число больше 2.  Для
        //решения задачи использовать декомпозицию.
        System.out.println("Task 13 Decomposition: ");
        int start13 = 15;
        int finish13 = 33;
        decomposition.getNumbersTwins(start13, finish13);
        System.out.println();
        System.out.println();

        //14.  Натуральное  число,  в  записи  которого  n  цифр,  называется  числом  Армстронга,  если  сумма  его  цифр,
        //возведенная  в  степень  n,  равна  самому  числу.  Найти  все  числа  Армстронга  от  1  до  k.  Для  решения  задачи
        //использовать декомпозицию.
        System.out.println("Task 14 Decomposition: ");
        int numberTask14 = 8208;
        decomposition.getArmstrongNumbers(numberTask14);
        System.out.println();

        //15.  Найти  все  натуральные  n-значные  числа,  цифры  в  которых  образуют  строго  возрастающую
        //последовательность (например, 1234, 5789). Для решения задачи использовать декомпозицию.
        System.out.println("Task 15 Decomposition: ");
        int numberTask15 = 4;
        decomposition.getIncreasingSequence(numberTask15);
        System.out.println();

        //16.  Написать  программу,  определяющую  сумму  n  -  значных  чисел,  содержащих  только  нечетные  цифры.
        //Определить также, сколько четных цифр в найденной сумме. Для решения задачи использовать декомпозицию.
        System.out.println("Task 16 Decomposition: ");
        int numberTask16 = 4;
        decomposition.getEvenDigit(numberTask16);
        System.out.println();

        //17. Из заданного числа вычли сумму его  цифр. Из результата вновь вычли сумму его цифр и т.д. Сколько таких
        //действий надо произвести, чтобы получился нуль? Для решения задачи использовать декомпозицию.
        System.out.println("Task 17 Decomposition: ");
        int numberTask17 = 123456789;
        System.out.println("To get zero, it took the " + decomposition.digitSubstraction(numberTask17) + " subtraction operations");


    }
}
