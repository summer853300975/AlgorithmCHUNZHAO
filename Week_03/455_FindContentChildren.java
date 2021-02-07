class Solution {

    //贪心
    // 贪心策略： 每次尽可能用更小的饼干去满足更小的孩子
    //思路：对g,s数组升序排序。之后遍历g，s；只要当前g[i] > s[j],说明饼干j不满足小孩i，j++；如果g[i] <= s[j],说明满足了，将计数+1，遍历完返回计数。
    //证明 为什么能用贪心？反证法。
    //假设前面的s[j-1]已满足了g[i-1]。对于j<s.length，若g[i] <= s[j]，此时有两种方式选择：1 g[i] <= s[j]，g[i+1] <= s[j]时，让j满足i+1，让j+1去满足i，此时满足的小孩数不会更多。2 g[i] <= s[j]，g[i+1] > s[j]时，让j+1去满足i，而j满足不了i+1，此时会少一块饼干，而满足的小孩有可能少一个。
    //时间复杂度：O(NlogN+MlogM)，排序产生O(NlogN+MlogM)，遍历产生O(N+M)。
    //空间复杂度：O(logN+LogM),排序产生的。
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int glen = g.length;
        int slen = s.length;
        int count = 0;
        for (int i = 0,j = 0; i < glen && j < slen; i++, j++) {
            while (j < slen && g[i] > s[j]) j++;
            if (j < slen) count++;
        }
        return count;
    }
}