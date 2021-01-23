class Solution {
    //用一个全局指针记录所有非0的位置
    //用赋值操作代替交换操作
    //当i > j 时，只需要把 i 的值赋值给j 并把原位置的值置0。
    public int j = 0;
    public void moveZeroes(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i > j) {
                    nums[j] = nums[i];
                    nums[i] = 0;     //这是关键。要想办法在一个循环里面搞定 0的位置；不要重新开循环，会超时
                }
                j++;    //另外记住只要当前指针是非0值，就要把全局指针位置++
            }
        }
    }
}