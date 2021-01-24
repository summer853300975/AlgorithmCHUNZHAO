学习笔记
作业1：
public static void dequeTest() {
    Deque<String> deque = new LinkedList<String>();
    deque.addFirst("a");
    deque.addFirst("b");
    deque.addFirst("c");
    System.out.println(deque);
    String str = deque.peekFirst();
    System.out.println(str);
    System.out.println(deque);
    while (deque.size() > 0) {
        System.out.println(deque.removeFirst());
    }
    System.out.println(deque);
}

作业2：
分析 Queue 和 Priority Queue 的源码。

这边因为Queue是一个接口，所以就只分析了Priority Queue 的源码。

在Java 8 中 Priority Queue 是用小顶堆实现的，而且是线程不安全的。
主要有这几个方法：建堆，堆操作。

建堆有一个小的优化，因为 SortedSet 是有序的，那么就直接把SortedSet和PriorityQueue分开处理，
当数据有序时，可以直接用SortedSet，然后直接用`es = Arrays.copyOf(es, len, Object[].class);` 放到数组中存起来。
`    public PriorityQueue(Collection<? extends E> c) {
         if (c instanceof SortedSet<?>) {
             SortedSet<? extends E> ss = (SortedSet<? extends E>) c;
             this.comparator = (Comparator<? super E>) ss.comparator();
             initElementsFromCollection(ss);
         }
         else if (c instanceof PriorityQueue<?>) {
             PriorityQueue<? extends E> pq = (PriorityQueue<? extends E>) c;
             this.comparator = (Comparator<? super E>) pq.comparator();
             initFromPriorityQueue(pq);
         }
         else {
             this.comparator = null;
             initFromCollection(c);
         }
     }`

否则对于PriorityQueue类，需要建堆。
`private void heapify() {
         final Object[] es = queue;
         int n = size, i = (n >>> 1) - 1;
         final Comparator<? super E> cmp;
         if ((cmp = comparator) == null)
             for (; i >= 0; i--)
                 siftDownComparable(i, (E) es[i], es, n);
         else
             for (; i >= 0; i--)
                 siftDownUsingComparator(i, (E) es[i], es, n, cmp);
     }`
     
     
     
堆操作实际就是 siftUp和siftDown，一个是向上调整堆，一个是向下调整堆。
siftUp：用作插入新元素。
siftDown：用于调整堆和删除元素。     