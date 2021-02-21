class Solution {

    // 典型的动态规划题
    // 转移方程：grid[i][j] = min(grid[i-1][j],grid[i][j-1]) + grid[i][j]
    // 直接遍历原矩阵修改即可，因为原grid矩阵元素中被覆盖为dp元素后（都处于当前遍历点的左上方），不会再被使用到。---没太懂！
    // 时间复杂度：O(M * N),遍历整个grid矩阵元素。
    // 空间复杂度O(1),直接修改原矩阵，不使用额外空间。
    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) continue;
                else if (i == 0) grid[i][j] = grid[i][j-1] + grid[i][j];
                else if (j == 0) grid[i][j] = grid[i - 1][j] + grid[i][j];
                else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j-1]) + grid[i][j];
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}