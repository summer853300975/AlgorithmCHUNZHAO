学习笔记

第二周总结

# 树的定义

```
public class TreeNode {
    public int val;
    public TreeNode left,right;
    public TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
```

# 二叉搜索树

二叉搜索树 ： 左子树上所有结点的值均小于它的根结点的值；
            右子树上所有结点的值均大于它的根结点的值；
            以此类推，左/右子树也分别为二叉查找树。（这就是重复性！）

中序遍历：升序排列

常见操作：1，查询 2，插入新结点（创建）3，删除
Demo: https://visualgo.net/zh/bst

# 复杂度分析

学习笔记
第二周总结

# 树的定义

```
public class TreeNode {
    public int val;
    public TreeNode left,right;
    public TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
```

# 二叉搜索树

二叉搜索树 ： 左子树上所有结点的值均小于它的根结点的值；
            右子树上所有结点的值均大于它的根结点的值；
            以此类推，左/右子树也分别为二叉查找树。（这就是重复性！）

中序遍历：升序排列

常见操作：1，查询 2，插入新结点（创建）3，删除
Demo: https://visualgo.net/zh/bst

# 复杂度分析

![image-20210320162041891](/Users/xiatiantian/Library/Application Support/typora-user-images/image-20210320162041891.png)



# 树的遍历解法一般是递归

示例代码

```
def preorder(self,root):
	if root:
  	self.traverse_path.append(root.val)
  	self.preorder(root.left)
  	self.preorder(root.right)
  	
def inorder(self,root):
	if root:
		self.inorder(root.left)
		self.traver_path.append(root.val)
		self.inorder(root.right)
		
def postorder(self,root):
	if root:
		self.postorder(root.left)
		self.postorder(root.right)
		self.traverse_path.append(root.val)
```



# 泛型递归、树的递归



## java代码模板

```
public void recur(int level, int param) {
	// terminator
	if (level > MAX_LEVEL) {
		// process result
		return;
	}
	// process current logic
	process(level, param);
	// drill down
	recur(level: level + 1, newParam);
	// restore current status
}
```



## 练习题

\1. https://leetcode-cn.com/problems/climbing-stairs/
 \2. https://leetcode-cn.com/problems/generate-parentheses/



1. https://leetcode-cn.com/problems/invert-binary-tree/description/
2. https://leetcode-cn.com/problems/validate-binary-search-tree
3. https://leetcode-cn.com/problems/maximum-depth-of-binary- tree
4. https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
5. https://leetcode-cn.com/problems/serialize-and-deserialize- binary-tree/



1. https://leetcode-cn.com/problems/lowest-common-ancestor- of-a-binary-tree/
2. https://leetcode-cn.com/problems/construct-binary-tree-from- preorder-and-inorder-traversal

\3. https://leetcode-cn.com/problems/combinations/

\4. https://leetcode-cn.com/problems/permutations/ https://leetcode-cn.com/problems/permutations-ii/



​			 		 		 		 		 	

# 堆heap和二叉堆binary heap

## 堆的定义

heap：可以迅速找到一堆数中的最大或最小值的数据结构。

将根节点 最大的堆叫做大顶推或大根堆，根节点最小的堆叫做小顶堆或小根堆。

常见的堆有二叉堆，斐波那契堆等。

假设是大顶堆，则常见操作（API）：‘

find-max: O(1)

Delete-max: O(1)

Insert(create): O(logN) or O(1)

不同实现的比较：https://en.wikipedia.org/wiki/Heap_(data_structure)



## 二叉堆性质

通过完全二叉树来实现（注意不是二叉搜索树）。

二叉堆（大顶）它满足下列性质：

1 是一颗完全树。

2 树中任意节点的值总是 >= 其子节点的值。



## 二叉堆实现细节

1，二叉堆一般通过“数组”来实现。

2，假设“第一个元素”在数组中的索引为0的话，则父节点和子节点的位置关系如下：

1）索引为i的左孩子的索引是（2*i+1）；

2）索引为i的右孩子的索引是（2*i+2）；

3）索引为i的父节点的索引是floor((i-1)/2) ；



## insert插入操作

1. 新元素一律先插入到堆的尾部

2. 依次向上调整整个堆的结构（一直到根即可）---（若插入的元素大于父节点，将它和父节点交换）

   heapifyUp



## delete max删除堆顶操作

1. 将堆尾元素替换到顶部（即堆顶被替代删除掉）

2. 依次从根部向下调整整个堆的结构（一直到堆尾即可）---（若换上来的新元素小于子节点，选取较大的子节点和它交换）

   heapifyDown



注意：二叉堆是堆（优先队列priority_queue）的一种常见且简单的实现，但并不是最优实现。

https://en.wikipedia.org/wiki/Heap_(data_structure)





# 图

## 图的属性和分类

Graph(V, E)

V -vertex: 点

1 度 - 入度和出度

2 点与点之间：连通与否



E- edge：边

1 有向和无向（单行线）

2 权重 （边长）



图分为：无权无向图，有向无权图，无向有权图



## 图相关的算法

### DFS代码模板-递归写法

```python
visited = set() # 和树中的DFS最大区别
def dfs(node, visited):
	if node in visited:   # teminator
	 # already visited
	 return
	
  visited.add(node)
  
  #process current node here
  ...
  
  for next_node in node.children():
  	if not next_node in visited:
  		dfs(next_node, visited)
```



### BFS代码模板

```python
def BFS(graph, start, end):
	queue = []
  queue.append([start])
  
  visited = set() # 和树中的BFS的最大区别
  
  while queue:
    node = queue.pop()
    visited.add(node)
    
    process(node)
    nodes = generate_related_nodes(nodes)
    queue.push(nodes)
```



### 图的高级算法

1. 连通图个数

   https://leetcode-cn.com/problems/number-of-islands/

2. 拓扑排序（topological sorting)

   https://zhuanlan.zhihu.com/p/34871092

3. 最短路径(shortest path)

   https://www.bilibili.com/video/av25829980?from=search&seid=13391343514095937158

4. 最小生成树（minimum spanning tree)

   https://www.bilibili.com/video/av84820276?from=search&seid=17476598104352152051