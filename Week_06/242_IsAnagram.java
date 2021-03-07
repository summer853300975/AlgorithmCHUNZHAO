class Solution {

    //遍历26个字母表，对s中存在的元素+1，t中存在的元素-1，最后字母表中只要有元素不为0就返回false。
    //时间复杂度：O（26）+O（字符串长度）
    //空间复杂度：O（26）
    //不足：需要遍历完整的 26个字母表
    // public boolean isAnagram(String s, String t) {
    //     if (s.length() != t.length()) return false;
    //     int[] alpha = new int[26];
    //     for (int i = 0; i < s.length(); i++) {
    //         alpha[s.charAt(i) - 'a']++;
    //         alpha[t.charAt(i) - 'a']--;
    //     }
    //     //花了5ms
    //     // for (int i = 0; i < 26; i++) {
    //     //     if (alpha[i] != 0) {
    //     //         return false;
    //     //     }
    //     // }
    //     // return true;

    //     //也可以简单把后半部分简写成
    //     //花了8ms；可见流的方式并不见得会提升性能
    //     return Arrays.stream(alpha).noneMatch(num ->  num != 0);
    // }

    // //字母异位词==两个字符串排序后相等
    // // public boolean isAnagram(String s, String t) {
    // //     if (s.length() != t.length()) return false;
    // //     char[] schar = s.toCharArray();
    // //     char[] tchar = t.toCharArray();
    // //     Arrays.sort(schar);
    // //     Arrays.sort(tchar);
    // //     return schar == tchar;
    // // }

    //字母异位词==两个字符串中每个元素出现的次数和元素均相等
    //时间复杂度：O（字符串长度）
    //空间复杂度：O（26）
    //优点：不用遍历26个字母表，只需遍历字符串长度
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] alpha = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'a']++;

        }
        for (int i = 0; i < s.length(); i++) {
            alpha[t.charAt(i) - 'a']--;
            //为什么是小于0，因为只有小于0的时候才表明t中有而s中没有该元素，可结束；否则当大于0时表示t中没有而s中有，需要再往后遍历t
            if (alpha[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
