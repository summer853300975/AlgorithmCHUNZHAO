class Solution {
    //暴力求解
    //终于自己做出了一题
    // public int[] twoSum(int[] nums, int target) {
    //     int[] targetNums = new int[2];
    //     if (nums == null) return null;
    //     for (int i = 0; i < nums.length - 1; i++) {
    //         for (int j = i + 1; j < nums.length; j++) {
    //             if (nums[j] == target - nums[i]) {
    //                 targetNums[0] = i;
    //                 targetNums[1] = j;
    //                 return targetNums;
    //             }
    //         }
    //     }
    //     return targetNums;
    // }

    //hashmap降低时间复杂度为O(n)
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) return null;
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no exist");
    }
}