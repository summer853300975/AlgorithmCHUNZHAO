class Solution {

    //暴力搜索，贪心，动态规划

    //暴力搜索----超出时间限制
    //画一个状态树就知道
    // private int res = 0;
    // public int maxProfit(int[] prices) {
    //     if (prices.length < 2)
    //         return 0;
    //     int len = prices.length;
    //     this.res = 0;
    //     dfs(prices, 0, len, 0, this.res);
    //     return this.res;

    // }

    // /**
    // prices：股票数组
    // index：当前第几天
    // length：数组长度
    // status：0表示卖出，1表示持有
    // profit：当前收益
    // */
    // public void dfs(int[] prices, int index, int length, int status, int profit) {
    //     //终止条件
    //     if (index == length) {
    //         res = Math.max(res, profit);
    //         return;
    //     }
    //     // 为什么 index + 1 ？
    //     dfs(prices, index + 1, length, status, profit);

    //     //下探一层
    //     //是否改变方向
    //     if (status == 0) {
    //         dfs(prices, index + 1, length, 1, profit - prices[index]);
    //     }
    //     else {
    //         dfs(prices, index + 1, length, 0, profit + prices[index]);
    //     }
    // }





    //贪心算法
    // 直觉：只要今天价格比昨天高，就交易
    // 贪心的策略：「今天价格-昨天价格」只可能有3种情况：为正数，为负数，为0.而贪心决策是 只取正数。
    // 证明：为什么能用贪心算法？ 反证法，根据「今天价格-昨天价格」的3种情况，每一种都找不到比贪心更多的收益。
    public int maxProfit(int[] prices) {
        int res = 0;
        if (prices.length < 2) return 0;
        for (int i = 1; i < prices.length; i++) {
            res += Math.max(prices[i] - prices[i-1], 0);
        }
        return res;
    }

}