class Solution {

    //两种方法：常规栈：先找到所有可以匹配的索引号，然后排序求最长连续数列，时间复杂度来自排序O(nlogn).
    //        栈优化：省略排序的过程，在弹栈时候进行操作，降到时间复杂度O(n).

    //        第二种 dp方法：用dp[i]表示以i结尾的最长有效括号：
    //1，当s[i]为(,dp[i]必然等于0，因为不可能组成有效的括号。
    //2，那么s[i]为),
    //2.1 当s[i-1]为(,那么dp[i]=dp[i-2]+2;
    //2.2 当s[i-1]为) 且 s[i-dp[i-1]-1]为(,那么dp[i]=dp[i-1]+2+dp[i-dp[i-1]-2];
    // 时间复杂度为O(n).

    //直接用dp
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] + 2 : 2);
                } else if (s.charAt(i - 1) == ')' && i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}