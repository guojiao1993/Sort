package QuickSort;

import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = null;
        array = new int[]{23, 33, 44, 88, 11, 9, 22, 55, 77, 66, 99};
        printArray(array, "排序前：");
        quickSort1(array, 0, array == null ? 0 : array.length - 1);
        printArray(array, "排序后：");
        array = new int[]{23, 33, 44, 88, 11, 9, 22, 55, 77, 66, 99};
        printArray(array, "排序前：");
        quickSort2(array, 0, array == null ? 0 : array.length - 1);
        printArray(array, "排序后：");
        new Scanner(System.in).next();
    }

    public static void quickSort1(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int base = array[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && array[j] >= base) {
                j--;
            }
            if (i < j) {
                array[i++] = array[j];
            }
            while (i < j && array[i] <= base) {
                i++;
            }
            if (i < j) {
                array[j--] = array[i];
            }
        }
        array[i] = base;
        quickSort1(array, left, i - 1);
        quickSort1(array, i + 1, right);
    }

    public static void quickSort2(int[] array, int left, int right) {
        while (left >= right) {
            return;
        }
        int base = array[left];
        int i = left;
        int j = right;
        while (i <= j) {
            while (array[i] < base) {
                i++;
            }
            while (array[j] > base) {
                j--;
            }
            if(i <= j) {
                if(i < j) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
                i++;
                j--;
            }
        }
        quickSort2(array, left, j);
        quickSort2(array, i, right);
    }

    public static void printArray(int[] a, String pre) {
        System.out.print(pre);
        System.out.print("[");
        for (int i = 0; i < (a == null ? 0 : a.length); i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(a[i]);
        }
        System.out.println("]");
    }
}
