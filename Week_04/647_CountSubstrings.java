class Solution {
    // 两种方法：动态规划法，中心扩展法

    // 动态规划法
    // 状态：dp[i][j]表示字符串s在[i,j]区间的子串是否是一个回文串。
    // 状态转移方程：当s[i]==s[j] && (j - i < 2 || dp[i+1][j-1])时，dp[i][j]=true,否则为false
    // 解释：1，当只有一个字符时，比如a自然是一个回文串。
    //      2，当有两个字符时，如果是相等的，比如aa，也是一个回文串。
    //      3，当有三个及以上字符时，比如ababa这个字符记作串1，把两边的a去掉，也就是bab记作串2，可以看出只要串2是一个回文串，那么左右各多了一个a的串1必定也是回文串。所以当s[i]==s[j]时，自然要看dp[i+1][j-1]是不是一个回文串。

    //动态规划-时间复杂度O(N*N),空间复杂度O(N*N)
    // public int countSubstrings(String s) {
    //     boolean[][] dp = new boolean[s.length()][s.length()];
    //     int ans = 0;
    //     for (int j = 0; j < s.length(); j++) {
    //         for (int i = 0; i <= j; i++) {
    //             if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
    //                 dp[i][j] = true;
    //                 ans++;
    //             }
    //         }
    //     }
    //     return ans;
    // }

    // 中心扩展法时间复杂度O(N*N),空间复杂度O(1)
    // 比如对一个字符串ababa，选择最中间的a作为中心点，往两边扩展，第一次扩展发现left指向的是b，right指向的也是b，所以是回文串；继续扩散，同理ababa也是回文串。
    //这个是确定了一个中心点后的寻找路径，然后只要找到所有的中心点，问题就解决了。
    //中心点一共有多少个呢？比如abab，就可以有中心点ab扩展一次得到，所以最终的中心点有2*len-1个，分别是len个单字符和len-1个双字符。
    public int countSubstrings(String s) {
        int ans = 0;
        for (int center = 0; center < 2 * s.length() - 1;center++) {
            //left和right指针和中心点的关系是？
            //left很明显有一个2倍的关系，right可能和left指向同一个（偶数时），也可能往后移动一个（奇数）
            //这句话没懂！
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < s.length() && s.charAt(left)== s.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }


}