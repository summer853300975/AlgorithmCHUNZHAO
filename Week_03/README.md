学习笔记

学习总结
使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方。同学们可以将自己的思路、代码写在学习总结中。

取自leetcode原文的定义：153. 寻找旋转排序数组中的最小值
升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为 [4,5,6,7,0,1,2] ）。

提示：
1 <= nums.length <= 5000
-5000 <= nums[i] <= 5000
nums 中的所有整数都是 唯一 的
nums 原来是一个升序排序的数组，但在预先未知的某个点上进行了旋转




那么假设数组为升序排列的整数数组在某个点上进行了旋转，变成给定的半有序数组。

那么最大值一定被旋转在了中间位置，且最小值一定与最大值相邻。
我们不妨计算最小值的位置。

class Solution {
    public int searchMinIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] > nums[right]) left = mid + 1;
            else right = min;
        }
        return left;
    }
}