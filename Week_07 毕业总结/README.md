学习笔记

毕业总结



# 数据结构

* 一维
  * 基础：数组 array(string), 链表 linked list
  * 高级：栈 stack，队列 queue，双端队列 deque，集合 set，映射 map，etc



* 二维
  * 基础：树 tree，图 graph
  * 高级：二叉搜索树 binary search tree(rer-black tree, AVL)，堆 heap，并查集 disjoint set，字典树 trie，etc



* 特殊

  位运算 bitwise，布隆过滤器 bloomfilter

​         LRU cache



# 时间复杂度



![image-20210320175839765](/Users/xiatiantian/Library/Application Support/typora-user-images/image-20210320175839765.png)

![image-20210320175903878](/Users/xiatiantian/Library/Application Support/typora-user-images/image-20210320175903878.png)





https://www.bigocheatsheet.com/







# 算法

* If-else, switch ---> branch
* For,while loop ---> iteration
* 递归 Recursion （Divide & Conquer，Backtrace）
* 搜素search：深度优先搜索 Depth first search，广度优先搜索 Breadth first search，A*，etc
* 动态规划 Dynamic Programming
* 二分查找 Binary search
* 贪心 Greedy
* 数学 Math，几何 Geometry



注意:在头脑中回忆上面每种算法的思想和代码模板

# 脑图

https://naotu.baidu.com/file/4b8342e268fb206c10c2f57efcb9ebc4

https://naotu.baidu.com/file/55aaf2116e6d67607ca1018d8cd514d6



# 化繁为简的思想

1. 人肉递归低效，很累
2. 找到最近最简方法，将其拆解成可重复解决的问题
3. 数学归纳法思维



本质：寻找重复性 ----> 计算机指令集



# 经典习题

爬楼梯，硬币兑换

括号匹配，括号生成，直方图最大面积，滑动窗口

二叉树遍历，分层输出树，判断二叉排序树

股票买卖，偷房子，字符串编辑距离，最长上升子序列，最长公共子序列

异位词（判断和归类），回文串（最大回文串），regex和通配符匹配

高级数据结构（Trie，BloomFilter，LRU cache，etc）



# 学习要点

* 基本功是区别业余和职业选手的根本。深厚功底来自于 --- 过遍数
* 最大的误区：只做一遍
* 五毒神掌
* 刻意练习 - 练习缺陷弱点地方，不舒服，枯燥
* 反馈 - 看题解，看国际版的高票回答



## 五毒神掌

第一遍：不要死磕，要看代码学习（一定要看国际版的高票回答）

第二遍：自己写

第三遍：24小时后

第四遍：一周后

第五遍：面试前



## 面试技巧

1. Clarification：明确题目意思，边界，数据规模

2. Possible solutions：穷尽所有可能的解法

   compare time / space

   optimal solution

3. Coding：代码简洁，高性能，美感  https://shimo.im/docs/rHTyt8hcpT6D9Tj8/read

4. Test cases
