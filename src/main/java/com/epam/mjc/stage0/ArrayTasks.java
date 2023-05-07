package com.epam.mjc.stage0;

/**
 * Here are the tasks for working with the arrays.
 * <p>
 * The usage of any additional packages (such as java.util.*) is forbidden.
 */
public class ArrayTasks {

    /**
     * Return a String[] array that will list all the seasons of the year, starting with winter.
     */
    public String[] seasonsArray() {
        return new String[]{"Winter", "Spring", "Summer", "Autumn"};
    }

    /**
     * Generate an int[] array of consecutive positive integers
     * starting at 1 of the given length (length parameter > 0).
     * <p>
     * Example:
     * <p>
     * length = 1  -> [1]
     * length = 3  -> [1, 2, 3]
     * length = 5  -> [1, 2, 3, 4, 5]
     */
    public int[] generateNumbers(int length) {
        int[] arrayOfNumbers = new int[length];
        for (int i = 0; i < length; i++) {
            arrayOfNumbers[i] = i + 1;
        }
        return arrayOfNumbers;
    }

    /**
     * Find the sum of all elements of the int[] array.
     * <p>
     * Example:
     * <p>
     * arr = [1, 3, 5]   -> sum = 9
     * arr = [5, -3, -4] -> sum = -2
     */
    public int totalSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    /**
     * Return the index of the first occurrence of number in the arr array.
     * If there is no such element in the array, return -1.
     * <p>
     * Example:
     * <p>
     * arr = [99, -7, 102], number = -7    ->   2
     * arr = [5, -3, -4],   number = 10    ->  -1
     */
    public int findIndexOfNumber(int[] arr, int number) {
        int result = 0;
        int counterNoEqual = 0;
        for (int i = 0; i < arr.length; i++) {
            if (number == arr[i]) {
                result = i;
                break;
            } else {
                counterNoEqual++;
            }

        }
        if (counterNoEqual == arr.length) {
            result = -1;
        }
        return result;
    }

    /**
     * Return the new String[] array obtained from the arr array
     * by reversing the order of the elements.
     * <p>
     * Example:
     * <p>
     * arr = ["Bob", "Nick"]               -> ["Nick", "Bob"]
     * arr = ["pineapple", "apple", "pen"] -> ["pen", "apple", "pineapple"]
     */
    public String[] reverseArray(String[] arr) {
        String[] reverseArray = new String[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            reverseArray[arr.length - i - 1] = arr[i];
        }
        return reverseArray;
    }

    /**
     * Return new int[] array obtained from arr int[] array
     * by choosing positive numbers only.
     * P.S. 0 is not a positive number =)
     * <p>
     * Example:
     * <p>
     * arr = [1,-2, 3]      -> [1, 3]
     * arr = [-1, -2, -3]   -> []
     * arr = [1, 2]         -> [1, 2]
     */
    public int[] getOnlyPositiveNumbers(int[] arr) {
        int counterLength = 0;
        for (int j : arr) {
            if (j > 0) {
                counterLength++;
            }
        }
        int[] array = new int[counterLength];
        for (int x = 0, i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                array[x++] = arr[i];
            }
        }
        return array;
    }

    /**
     * Return a sorted, ragged, two-dimensional int[][] array following these rules:
     * Incoming one-dimensional arrays must be arranged in ascending order of their length;
     * numbers in all one-dimensional arrays must be in ascending order.
     * <p>
     * Example:
     * <p>
     * arr = [[3, 1, 2,], [3,2]] -> [[2, 3], [1, 2, 3]]
     * arr = [[5, 4], [7]]       -> [[7], [4, 5]]
     */
    public int[][] sortRaggedArray(int[][] arr) {
        // Sort the numbers in all one-dimensional arrays in ascending order
        for (int[] innerArr : arr) {
            for (int i = 0; i < innerArr.length; i++) {
                for (int j = i + 1; j < innerArr.length; j++) {
                    if (innerArr[i] > innerArr[j]) {
                        int temp = innerArr[i];
                        innerArr[i] = innerArr[j];
                        innerArr[j] = temp;
                    }
                }
            }
        }
        // Sort the one-dimensional arrays in ascending order of their length
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j-1].length > arr[j].length) {
                    int[] temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        ArrayTasks a=new ArrayTasks();
        int[][] arr = {

                {-187,20},
                {52, 340, 649,831},
                {-705,-699,770},
                {-943, -633,198},
                {-725,-261,537,975}
        };
        a.sortRaggedArray(arr);
    }
}
