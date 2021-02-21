class Solution {

    //动态规划-需注意分情况讨论
    //dp[i]为str[0...i]的译码方法总数
    //分情况讨论：（建立最优子结构）
    // 若s[i]='0',那么若s[i-1]='1' or '2',则dp[i]=dp[i-1],否则return 0.
    //    解释：s[i-1]+s[i]唯一被译码，不增加情况
    // 若s[i-1]='1',则dp[i]=dp[i-1]+dp[i-2].
    //    解释：s[i-1]与s[i]分开译码，为dp[i-1];合并译码，为dp[i-2].
    // 若s[i-1]='2' and '1'<=s[i]<='6',则dp[i]=dp[i-1]+dp[i-2]
    //    解释：同上
    //由分析可知，dp[i]仅可能与前两项有关，故可以用单变量代替dp[]数组，将空间复杂度从O(N)降到O(1).

    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        //dp[-1]=dp[0]=1
        int pre = 1,curr = 1;
        for (int i = 1; i < s.length(); i++) {
            int tem = curr;
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') curr = pre;
                else return 0;
            }
            else if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6')) {
                curr = curr + pre;
            }
            pre = tem;
        }
        return curr;
    }
}
