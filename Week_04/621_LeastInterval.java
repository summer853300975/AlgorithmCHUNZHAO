class Solution {

    // 思路：完成所有任务的最短时间取决于“出现次数最多的任务数量”。
    // 对于tasks = ["A","A","A","B","B","B"], n = 2
    // 容易观察到，前面两个A任务一定会固定跟着2个单位时间的间隔。最后一个A之后是否还有任务跟随取决于“是否存在与任务A出现次数相同的任务”。
    // 因此整体步骤：
    // 1，计算每个任务出现的次数
    // 2，找出出现次数最多的任务，假设出现次数为x
    // 3，计算除了最后一个A之外，至少需要的时间min_time=(x-1)*(n+1)
    // 4，计算出现次数为x的任务总数count，计算最终结果为min_time+count.
    //然而存在一种特殊情况，当“出现次数最多的任务数量”中间的间隔不足以填满其他所有任务时，应该返回“数组长度”为最终结果。

    public int leastInterval(char[] tasks, int n) {
        int[] charCount = new int[26];
        int max = 0,maxCount = 0;
        for (char task : tasks) {
            ++charCount[task - 'A'];
        }
        for (int num : charCount) {
            if (num > max) {
                max = num;
                maxCount = 1;
            } else if (num == max) {
                ++maxCount;
            }
        }
        //判断间隔内的空间能不能放下除了 第一个 最多 次数字母以外的字母
        int space = n * (max - 1) - (maxCount - 1) - (tasks.length - maxCount * max);
        //如果放不下，说明原数组长度就是结果
        if (space < 0) {
            return tasks.length;
        }
        //如果放得下，就是第一个最多次数字母的长度，再加上和他次数相等的字母数量
        return n * (max - 1) + max + maxCount - 1;
    }
}