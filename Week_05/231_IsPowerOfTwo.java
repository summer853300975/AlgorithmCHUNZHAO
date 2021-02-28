class Solution {
    public boolean isPowerOfTwo(int n) {

        // 获取二进制中最右边的1
        // if (n == 0) return false;
        // long x = (long) n;
        // return (x & (-x)) == x;


        //移除二进制最右边的1
        if (n == 0) return false;
        long x = (long) n;
        return (x & (x - 1)) == 0;

    }
}