class Solution {

    //模拟 + 贪心
    // 这里贪心策略：当收20时，需要优先找零10美元。因为要尽量保留5美元，10美元使用场景比5美元少。
    // 思路：用five，ten表示5美元，10美元的数量
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five ++;
            }
            else if (bill == 10) {
                if (five > 0) {
                    five --;
                    ten ++;
                }
                else {
                    return false;
                }
            }
            else {
                if (ten > 0 && five > 0) {
                    ten --;
                    five --;
                }
                else if (five >= 3) {
                    five = five -3;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}