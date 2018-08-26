### 优先队列
利用二叉堆，可以实现优先队列。  
主要有两个操作：
1. 插入元素  
插入元素时，要插到结尾，增加堆的大小，然后将这个节点向上浮动，直到调整到合适的位置。
2. 取出最大值  
堆顶就是最大值，可以直接取出，减小堆的大小，然后将结尾的节点移动到堆顶，再将堆顶元素下沉到合适的位置。

可以使用数组来盛放堆，如果规定数组从下标1开始，那么父节点i的左右子节点的下标分别是2i和2i+1，方便计算。  

上浮操作：
```java
private void swim(int k) {
    while (k > 1 && less(k/2, k)) {
        exch(k, k/2);
        k = k/2;
    }
}
```
下沉操作：
```java
private void sink(int k) {
    while (2 * k <= n) {
        int j = 2 * k;
        if (j < n && less(j, j + 1)) {
            j++;
        }
        if (!less(k, j)) {
            break;
        }
        exch(k, j);
        k = j;
    }
}
```

辅助操作有：

比较操作：  
```java
private boolean less(int i, int j) {
    if (comparator == null) {
        return ((Comparable<Key>) pq[i]).compareTo(pq[j]) < 0;
    }
    else {
        return comparator.compare(pq[i], pq[j]) < 0;
    }
}
```
这里用到了自定义的比较器（有两种方式）。

交换操作：
```java
private void exch(int i, int j) {
    Key swap = pq[i];
    pq[i] = pq[j];
    pq[j] = swap;
}
```
这里用到了泛型（Key）。
### 堆排序
升序用大根堆，降序用小根堆
1. 堆的构造  
使用下沉操作，只需扫描数组中的一半元素（跳过大小为1的子堆）。
1. 下沉排序  
交换堆顶和无序区的结尾元素，再对堆顶进行下沉，直至全部有序。
