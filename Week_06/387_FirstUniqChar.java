class Solution {

    //1使用哈希表存储频数
    //对字符串两次遍历
    //34ms
    //为什么charAt(i)方法很慢？
    // public int firstUniqChar(String s) {
    //     Map<Character,Integer> map = new HashMap();
    //     for(int i = 0; i < s.length();i++) {
    //         char ch = s.charAt(i);
    //         map.put(ch, map.getOrDefault(ch, 0) + 1);
    //     }
    //     for(int i = 0; i < s.length();i++) {
    //         if (map.get(s.charAt(i)) == 1) {
    //             return i;
    //         }
    //     }
    //     return -1;
    // }



    //因为题目限定了只包含小写字母。所以可以创建一个只有26个字母的字母表。
    //为避免长时间的charAt(), 提前将字符串转成字符数组
    //4ms
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[] alpha = new int[26];
        for(int i = 0; i < chars.length; i++) {
            alpha[chars[i] - 'a']++;
        }
        for(int i = 0; i < chars.length; i++) {
            if (alpha[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
