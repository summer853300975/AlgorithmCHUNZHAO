class Solution {

    //计数排序
    //时间复杂度O（m+n+upper）
    //空间复杂度O（upper）
    //用一个frequency[]表示arr1中每个数出现的次数；用一个全局index，遍历arr2,将每一个arr2中的x<frequency[x]的元素复制到新数据ans[]，且将frequency[x]置为0；再将arr1中剩下的未在arr2中出现的元素按照x<frequency[x]的顺序复制到ans[]。
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int upper = 0;
        for(int x : arr1) {
            upper = Math.max(upper, x);
        }
        int[] frequency = new int[upper+1];
        for(int x : arr1) {
            ++frequency[x];
        }
        int index = 0;
        int[] ans = new int[arr1.length];
        for(int x : arr2) {
            for(int i = 0;i < frequency[x]; i++) {
                ans[index++] = x;
            }
            frequency[x] = 0;
        }
        for(int x = 0; x <= upper; x++) {
            for(int i = 0;i < frequency[x]; i++) {
                ans[index++] = x;
            }
        }
        return ans;
    }
}