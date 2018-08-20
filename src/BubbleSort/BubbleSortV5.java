package BubbleSort;

import java.util.Arrays;
import java.util.Formatter;

public class BubbleSortV5 {
    public static int[] sort(int[] array) {
        // 0：比较次数 1：交换次数
        int[] operateNum = new int[2];
        if (array == null || array.length <= 1) {
            return operateNum;
        }
        // 记录右边最后一次交换的位置
        int rightLastSwapIndex = 0;
        // 记录右边有序区的边界
        int rightSortedBorder = array.length - 1;
        // 记录左边最后一次交换的位置
        int leftLastSwapIndex = 0;
        // 记录左边有序区的边界
        int leftSortedBorder = 0;
        for (int i = 0; i < array.length / 2; i++) {
            boolean isSorted = true;
            for (int j = i; j < rightSortedBorder; j++) {
                // j就是往上冒的气泡
                operateNum[0]++;
                if (array[j] > array[j + 1]) {
                    array[j] = array[j] + array[j + 1];
                    array[j + 1] = array[j] - array[j + 1];
                    array[j] = array[j] - array[j + 1];
                    isSorted = false;
                    operateNum[1]++;
                    rightLastSwapIndex = j;
                }
            }
            if (isSorted) {
                break;
            }
            rightSortedBorder = rightLastSwapIndex;
            for (int j = (array.length - 1 - 1) - i; j > leftSortedBorder; j--) {
                // j就是往下冒的气泡
                operateNum[0]++;
                if (array[j] < array[j - 1]) {
                    array[j] = array[j] + array[j - 1];
                    array[j - 1] = array[j] - array[j - 1];
                    array[j] = array[j] - array[j - 1];
                    isSorted = false;
                    operateNum[1]++;
                    leftLastSwapIndex = j;
                }
            }
            if (isSorted) {
                break;
            }
            leftSortedBorder = leftLastSwapIndex;
        }
        return operateNum;
    }

    public static void main(String[] args) {
        Formatter formatter = new Formatter(System.out);
        int[] array = null;
        int[] result = null;

        array = new int[]{20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.print(Arrays.toString(array));
        result = sort(array);
        formatter.format("    [%3d, %3d]    ", result[0], result[1]);
        System.out.println(Arrays.toString(array));

        array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        System.out.print(Arrays.toString(array));
        result = sort(array);
        formatter.format("    [%3d, %3d]    ", result[0], result[1]);
        System.out.println(Arrays.toString(array));

        array = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        System.out.print(Arrays.toString(array));
        result = sort(array);
        formatter.format("    [%3d, %3d]    ", result[0], result[1]);
        System.out.println(Arrays.toString(array));

        array = new int[] {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 1};
        System.out.print(Arrays.toString(array));
        result = sort(array);
        formatter.format("    [%3d, %3d]    ", result[0], result[1]);
        System.out.println(Arrays.toString(array));

        array = new int[] {1, 2, 3, 4, 5, 6, 7, 13, 12, 11, 10, 9, 8, 14, 15, 16, 17, 18, 19, 20};
        System.out.print(Arrays.toString(array));
        result = sort(array);
        formatter.format("    [%3d, %3d]    ", result[0], result[1]);
        System.out.println(Arrays.toString(array));
    }
}
