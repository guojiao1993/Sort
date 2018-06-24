public class SelectionSort {
    public static void upSort(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        for (int i = 0; i < a.length - 1; i++) {
            // 无序区的最小数据数组下标
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                //在无序区中找到最小数据并保存其数组下标
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            // 将最小元素放到本次循环的前端
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }

    public static void downSort(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        for (int i = 0; i < a.length - 1; i++) {
            // 记录本次循环的前端下标
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                // 在无序区中找到最大数据并保存其数组下标
                if (a[j] > a[minIndex]) {
                    minIndex = j;
                }
            }
            // 交换最大元素与本次循环的前端元素
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = null;
        int[] b = new int[]{};
        int[] c = new int[]{2,9,3,1,5,7,8,4,6,0};
        SelectionSort.printArray(a,"排序前：");
        SelectionSort.upSort(a);
        SelectionSort.printArray(a,"升序后：");
        SelectionSort.downSort(a);
        SelectionSort.printArray(a,"降序后：");
        System.out.println();
        SelectionSort.printArray(b,"排序前：");
        SelectionSort.upSort(b);
        SelectionSort.printArray(b,"升序后：");
        SelectionSort.downSort(b);
        SelectionSort.printArray(b,"降序后：");
        System.out.println();
        SelectionSort.printArray(c,"排序前：");
        SelectionSort.upSort(c);
        SelectionSort.printArray(c,"升序后：");
        SelectionSort.downSort(c);
        SelectionSort.printArray(c,"降序后：");
    }

    public static void printArray(int[] a, String pre) {
        System.out.print(pre);
        System.out.print("[");
        for (int i = 0; i < (a == null ? 0: a.length); i++) {
            if(i != 0) {
                System.out.print(", ");
            }
            System.out.print(a[i]);
        }
        System.out.println("]");
    }

}
