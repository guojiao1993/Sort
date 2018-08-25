package HeapSort;

public class HeapSort {
    public static void main(String[] args) {
        int[] array = {0, 27, 30, 39, 24, 6, 3, 12, 18, 42, 14, 22, 1, 43};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
        sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }

    public static void sort(int[] array) {
        if (array == null || array.length < 3) {
            return;
        }
        int n = array.length - 1;
        // 下沉调整堆
        for (int i = n / 2; i >= 1; i--) {
            sink(array, i, n);
        }
        // 交换并下沉堆顶元素
        while (n > 1) {
            exch(array, 1, n--);
            sink(array, 1, n);
        }
    }

    private static void exch(int[] array, int i, int n) {
        int temp = array[i];
        array[i] = array[n];
        array[n] = temp;
    }

    private static void sink(int[] array, int i, int n) {
        while (2 * i <= n) {
            int j = 2 * i;
            if (j < n && array[j] < array[j + 1]) {
                j++;
            }
            if (array[i] >= array[j]) {
                break;
            }
            exch(array, i, j);
            i = j;
        }
    }
}
