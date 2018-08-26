### 挖坑填坑写法
算法思想如下：
  
挖坑是将一个数据项暂存或另存他处，然后它就变成一个坑了，可以被合适的数据项来填。  

有四种情况：
1. 基准项暂存，然后基准项的位置就变成坑了。
1. 从后向前遍历时，将小于基准项的数据填入上一个坑中，该坑可能是基准项，也可能是前面比基准项大的值另存他处所留的坑。
1. 从前向后遍历时，将大于基准项的数据填入上一个坑中，该坑只可能是后面比基准项小的值另存他处所留的坑。
1. 最后的结果必然是i == j，并且该位置的数据项已经另存他处，所以可以用暂存的基准项来填坑。

手写代码加强记忆：
- 时刻判断i < j，共有五处，外面的总循环是一处，从后向前遍历和填坑时各一处，从前向后遍历和填坑时也各一处。
- 由于有时刻判断i < j，所以不会出现越界访问的情况，也就可以使用“大于等于”或“小于等于”的判断条件来遍历。
- 最后的结果必然是i == j，并且该位置的数据项已经另存他处，所以可以用暂存的基准项来填坑。
- 每次填完坑后，要顺便使反向遍历的下标指向下一处。
```java
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
```
### 两头交换写法
这种写法的关键思想是前后双向遍历，找到不符合顺序的两个数据项，直接进行交换，这样减少了交换次数。

手写代码加强记忆：  
- 外层循环的判断条件是i <= j，终止循环后，必定存在i与j不交叉。
- 内层循环中，前后遍历的条件不包括==，也不必判断i和j边界。
- 在i <= j时，i要后移，j要前移。并且在i < j时，交换两者。
- 循环终止后，left和j为小于基准值的无序区，i和right为大于基准值的无序区，需要再次递归排序。
```java
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
```