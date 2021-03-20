学习笔记

第四周总结



# 动态规划



## 分治 + 回溯 + 递归 + 动态规划



分治 Divide & Conquer

分治代码模板

```python
def divide_conquer(problem, param1, param2, ...):
  # recursion terminator
  if problem is None:
    print_result
    return
  
  # prepare data
  data = prepare_data(problem)
  subproblems = split_problem(problem, data)
  
  # conquer subproblems
  subresult1 = self.divide_conquer(subproblems[0], p1, ...)
  subresult2 = self.divide_conquer(subproblems[1], p1, ...)
  subresult3 = self.divide_conquer(subproblems[2], p1, ...)
  ...
  
  # process and generate the final result
  result = process_result(subresult1, subresult2, subresult3, ...)
  
  # revert the current level states
```

本质：寻找重复性 ---> 计算机指令集



## 动态规划 dynamic programming 定义

1 wiki 定义 https://en.wikipedia.org/wiki/Dynamic_programming

2 “Simplifying a complicated problem by breaking it down into simpler sub-problems”.  (In a recursive manner)

3 Divide & Conquer + Optimal substructure (分治 + 最优子结构)



## 关键点

动态规划 和 递归或者分治 没有根本上的区别 （关键看有无最优的子结构）

共性：**找到重复子问题**

差异性：最优子结构，中途可以**淘汰**次优解



1. 最优子结构
2. 储存中间状态
3. 递归公式（状态转移方程/DP方程）



### MIT algorithm course

B 站搜索: mit 动态规划

https://www.bilibili.com/video/av53233912?from=search&seid=2847395688604491997



### 实战题目

\1. https://leetcode-cn.com/problems/climbing-stairs/description/

\2. https://leetcode-cn.com/problems/triangle/description/
 ( https://leetcode.com/problems/triangle/discuss/38735/Python-easy-to-understand-solutions-(top-down-bottom-up). )

\3. https://leetcode-cn.com/problems/maximum-subarray/

https://leetcode-cn.com/problems/maximum-product-subarray/description/

\4. https://leetcode-cn.com/problems/coin-change/description/



1. https://leetcode-cn.com/problems/house-robber/

2. https://leetcode-cn.com/problems/house-robber-ii/description/

3. https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/#/description https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/ https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/ https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/ https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/ https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/

   https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/



\1. https://leetcode-cn.com/problems/perfect-squares/
 \2. https://leetcode-cn.com/problems/edit-distance/ (重点) 

3. https://leetcode-cn.com/problems/jump-game/
   \4. https://leetcode-cn.com/problems/jump-game-ii/
    \5. https://leetcode-cn.com/problems/unique-paths/
    \6. https://leetcode-cn.com/problems/unique-paths-ii/
    \7. https://leetcode-cn.com/problems/unique-paths-iii/
    \8. https://leetcode-cn.com/problems/coin-change/
    \9. https://leetcode-cn.com/problems/coin-change-2/



1.https://leetcode-cn.com/problems/longest-valid-parentheses/ 

2.https://leetcode-cn.com/problems/minimum-path-sum/ 

3.https://leetcode-cn.com/problems/edit-distance/ 

4.https://leetcode-cn.com/problems/decode-ways 

5.https://leetcode-cn.com/problems/maximal-square/ 

6.https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/ 

7.https://leetcode-cn.com/problems/frog-jump/ 

8.https://leetcode-cn.com/problems/split-array-largest-sum 

9.https://leetcode-cn.com/problems/student-attendance-record-ii/ 

10.https://leetcode-cn.com/problems/task-scheduler/ 

11.https://leetcode-cn.com/problems/palindromic-substrings/ 

12.https://leetcode-cn.com/problems/minimum-window-substring/ 

13.https://leetcode-cn.com/problems/burst-balloons/