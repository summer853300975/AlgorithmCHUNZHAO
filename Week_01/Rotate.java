//复制数组
//反转数组
//环形旋转



class Solution {
    // public void rotate(int[] nums, int k) {
    //     //复制数组
    //     k = k % nums.length;
    //     int[] temp = new int[nums.length];
    //     for (int i = 0; i < nums.length; i ++) {
    //         temp[i] = nums[i];
    //     }
    //     for (int i = 0; i < nums.length; i ++) {
    //         nums[(i + k) % nums.length ] = temp[i];
    //     }
    // }


    // public void rotate(int[] nums, int k) {
    //     //反转数组
    //     //心得-注意reverse函数一定要写正确
    //     k = k % nums.length;
    //     reverse(nums, 0, nums.length - 1);
    //     reverse(nums, 0, k - 1);
    //     reverse(nums, k, nums.length - 1);
    // }

    // public void reverse(int[] nums, int start, int end) {
    //     int temp = 0;
    //     while(start < end) {
    //         temp = nums[start];
    //         nums[start] = nums[end];
    //         nums[end] = temp;
    //         start ++;
    //         end --;
    //     }
    // }


    public void rotate(int[] nums, int k) {
        //环形旋转-有点难理解
        //描述：对于遇到重复下标就指针往下走；否则将当前值暂存
        //心得-注意不能遍历到重复的下标
        k = k % nums.length;
        int hold = nums[0];
        int index = 0;
        boolean[] isVisited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            // 这一步的index已经是下一个要放的下标
            index = (index + k) % nums.length;
            if (isVisited[index]) {
                index = (index + 1) % nums.length;
                hold = nums[index];
                //这一步是当出现k % nums.length = 0 时，执行“当前值移到下一个位置”的操作失效，比如将nums[0]移到nums[0],因此会跳过当前值的处理。
                //最难想，半天没想明白
                i --;

            } else {
                //说明没有遇到重复下标，将当前值移到下一个位置，并在移动之前先保存下一个位置
                isVisited[index] = true;
                int temp = nums[index];
                nums[index] = hold;
                hold = temp;
            }
        }
    }
}