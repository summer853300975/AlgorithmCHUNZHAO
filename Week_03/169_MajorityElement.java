class Solution {
    //三种方法：计数法/排序法/摩尔投票法

    //计数法
    // 思路：遍历一遍数组，用hashmap记录元素个数，最后输出 大于 ⌊ n/2 ⌋ 的元素。
    // 涉及Java8基本功,多加练习
    // public int majorityElement(int[] nums) {
    //     Map<Integer,Long> map = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    //     long limit = nums.length >> 1;
    //     for(Map.Entry<Integer,Long> entry : map.entrySet()) {
    //         if (entry.getValue() > limit) {
    //             return entry.getKey();
    //         }
    //     }
    //     return -1;
    // }

    //排序法
    //思路：只有一个元素次数会大于 ⌊ n/2 ⌋；也就是说当排好序后，占多数位置的元素就是要找的元素；也就是说最中间的那个元素一定是要找的元素
    // public int majorityElement(int[] nums) {
    //     Arrays.sort(nums);
    //     return nums[nums.length >> 1];
    // }

    //摩尔投票法
    //理念：两两抵消。只有一个元素次数会大于 ⌊ n/2 ⌋；即其他所有元素次数之和<=⌊ n/2 ⌋;相当于每个多数元素和其他元素两两相互抵消，抵消到最后至少还剩一个多数元素。
    //思路：设置一个初始票数count=1，初始候选人nums_candidate=nums[0]
    //     每次遍历一个元素，若当前元素=候选人,count + 1;否则 count - 1；
    //     当票数count = 0时，更换候选人,并重新设置count = 1
    public int majorityElement(int[] nums) {
        int count = 1;
        int candidate = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            }
            else if (--count == 0) {
                candidate = nums[i];
                count = 1;
            }
        }
        return candidate;
    }

}