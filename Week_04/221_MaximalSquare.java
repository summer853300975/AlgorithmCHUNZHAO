class Solution {

    //思路：理解min(上，左，左上) + 1
    // 若某格子值为1，则以此为右下角的正方形的最大边长为：上面的正方形/左面的正方形/左上的正方形中，最小的那个，在加上此格。
    // 即 若形成正方形（非单1）：以当前为右下角的视角看，则需要：当前格/上/左/左上都是1.
    // 或者换个角度：当前格/上/左/左上 都不能受0的限制，才能成为正方形。
    // 演进：从二维数组--->一维数组，且在整个图形的最左边和最上边加了一行/列全0 处理

    //直接写终版
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;
        int height = matrix.length;
        int width = matrix[0].length;
        int maxSide = 0;

        int[] dp = new int[width + 1];

        for (char[] chars : matrix) {
            int northwest = 0;
            for (int col = 0; col < width; col++) {
                int nextNorthwest = dp[col + 1];
                if (chars[col] == '1') {
                    dp[col + 1] = Math.min(Math.min(dp[col], dp[col + 1]), northwest) + 1;
                    maxSide = Math.max(maxSide, dp[col + 1]);
                } else dp[col + 1] = 0;
                northwest = nextNorthwest;
            }
        }
        return maxSide * maxSide;
    }
}