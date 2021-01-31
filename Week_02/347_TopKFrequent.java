class Solution {
    //堆排序，使用优先队列
    // public int[] topKFrequent(int[] nums, int k) {
    //     //遍历数组频率
    //     Map<Integer,Integer> counter = IntStream.of(nums).boxed().collect(Collectors.toMap(v -> v,v -> 1, Integer::sum));
    //     //构造小顶堆,根据数字频率从小到大排序
    //     Queue<Integer> dq = new PriorityQueue<Integer>((a , b) -> counter.get(a) - counter.get(b));
    //     //取map中数，当小于k个时，直接加入小顶堆；否则与堆顶元素比较，若当前元素频率>堆顶元素，将堆顶元素删除，将当前元素加入堆中。
    //     counter.forEach((num, cnt) -> {
    //         if (dq.size() < k) {
    //             dq.offer(num);
    //         }
    //         else if (cnt > counter.get(dq.peek())) {
    //             dq.poll();
    //             dq.offer(num);
    //         }
    //     });
    //     int[] res = new int[k];
    //     int i = 0;
    //     for(int n : dq) {
    //         res[i++] = n;
    //     }
    //     return res;
    // }


    //计数排序（桶排序）---对数据量小的情况适用
    public int[] topKFrequent(int[] nums, int k) {
        //遍历数组频率
        Map<Integer,Integer> counter = IntStream.of(nums).boxed().collect(Collectors.toMap(v -> v,v -> 1, Integer::sum));
        //构造频次数组, 最大频率的情况就是nums.length，因此构造一个频次数组，将freq[i]存 出现频率为i的所有数
        List<Integer>[] freq = new List[nums.length + 1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList();
        }
        counter.forEach((num, cnt) -> {
            freq[cnt].add(num);
        });
        //取频次数组中前k个频率的值
        int[] res = new int[k];
        int i = 0;
        for (int cnt = freq.length -1; cnt > 0; cnt --) {
            for (int num : freq[cnt]) {
                res[i++] = num;
                if (k == i) {
                    return res;
                }
            }
        }
        return res;
    }


    //还有两种，二叉搜索数，快排优化

}