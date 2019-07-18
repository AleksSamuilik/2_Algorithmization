package by.etc.code_review.main;

public class Sorter {

    public void swapSorting(int[] arr) {
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

    public void selectionSort(int[] numbers) {
        for (int index = 0; index < numbers.length - 1; index++) {
            int maxDigit = index;
            for (int scan = index + 1; scan < numbers.length; scan++) {
                if (numbers[scan] > numbers[maxDigit])
                    maxDigit = scan;
            }
            int tmp = numbers[maxDigit];
            numbers[maxDigit] = numbers[index];
            numbers[index] = tmp;
        }
    }


    public void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j;
            int buf = array[i];
            for (j = i - 1; j >= 0; j--) {
                if (array[j] < buf) {
                    break;
                }
                array[j + 1] = array[j];
            }
            array[j + 1] = buf;
        }
    }


    public void insertionBinarySort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int buf = array[i];
            int index = binSearch(array, 0, i, array[i]);
            for (int j = i - 1; j >= index; j--) {
                if (array[j] < buf) {
                    break;
                }
                array[j + 1] = array[j];
            }
            array[index] = buf;
        }
    }


    public int binSearch(int[] array, int low, int high, int key) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            Comparable midVal = array[mid];
            int cmp = midVal.compareTo(key);
            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid;
        }
        return low;
    }

    public void shellSort(int n, int[] array) {
        int i, j, step;
        int tmp;
        for (step = n / 2; step > 0; step /= 2)
            for (i = step; i < n; i++) {
                tmp = array[i];
                for (j = i; j >= step; j -= step) {
                    if (tmp < array[j - step])
                        array[j] = array[j - step];
                    else
                        break;
                }
                array[j] = tmp;
            }
    }


}
