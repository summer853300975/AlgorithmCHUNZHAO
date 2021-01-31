/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    //递归法
    // List<Integer> nodes = new ArrayList();
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     if (root == null) return nodes;
    //     nodes.add(root.val);
    //     preorderTraversal(root.left);
    //     preorderTraversal(root.right);
    //     return nodes;
    // }

    //迭代法
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     List<Integer> nodes = new ArrayList();
    //     Stack<TreeNode> stack = new Stack();
    //     if (root == null) return nodes;
    //     stack.push(root);
    //     while (!stack.isEmpty()) {
    //         TreeNode node = stack.pop();
    //         nodes.add(node.val);
    //         if (node.right != null) {
    //             stack.push(node.right);
    //         }
    //         if(node.left != null) {
    //             stack.push(node.left);
    //         }
    //     }
    //     return nodes;
    // }


    //莫里斯遍历---不改变树结构，只增加指针
    //又花了很久，看了好几遍题解，下次需要多练习
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList();
        if (root == null) return nodes;
        TreeNode cur1 = root; //当前节点
        TreeNode cur2 = null; //当前节点的左节点
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                //一直去找左节点的最右节点
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                //说明找到了左节点的最右节点
                if (cur2.right == null) {
                    //将当前节点及其右子树挂载到其 左节点的左右节点
                    cur2.right = cur1;
                    //因为是前序遍历，中左右，需要先打印出根节点
                    nodes.add(cur1.val);
                    //继续向左遍历
                    cur1 = cur1.left;
                    //跳出循环
                    continue;
                }
                //否则说明当前节点已访问过，需要切断环路
                else {
                    cur2.right = null;
                }
            }
            //中左右，已经到了最左边了（链表的头节点），将当前节点打印
            else {
                nodes.add(cur1.val);
            }
            // 没懂为什么 每一次大循环中都要cur1 = cur1.right;，比如为什么cur2.right = null;之后也要cur1 = cur1.right
            cur1 = cur1.right;
        }
        return nodes;
    }
}