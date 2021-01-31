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
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     if (root == null) return nodes;
    //     inorderTraversal(root.left);
    //     nodes.add(root.val);
    //     inorderTraversal(root.right);
    //     return nodes;
    // }


    //迭代法,模拟递归的方法
    //时间复杂度：O（N）N为节点个数
    //空间复杂度：O（H）H为树的高度
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> nodes = new ArrayList();
    //     Stack<TreeNode> stack = new Stack();
    //     if (root == null) return nodes;
    //     while(stack.size() != 0 || root != null) {
    //         //一直找左节点，并每次把当前元素压栈；
    //         if (root != null) {
    //             stack.push(root);
    //             root = root.left;
    //         }
    //         //当没有左节点，就把当前元素弹栈，加入结果集；root=root.right，重复找找找左节点的动作
    //         else {
    //             TreeNode node = stack.pop();
    //             nodes.add(node.val);
    //             root = node.right;
    //         }
    //     }
    //     return nodes;
    // }


    //莫里斯遍历----花了好久，好几次看题解，这方法要多做几遍
    //--改变树为链表结构；优点是 空间复杂度为O（1），不用新开栈；时间复杂度一样为O（N）
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList();
        //将根节点及右子树 一起放到 根节点的左节点的最右子节点的右侧
        //而画图可知，根节点原本有一个指针指向其左节点，因此需要将该指针断开，否则会形成环路
        TreeNode pre = null;
        //只要节点非空就需要遍历
        while (root != null) {
            //只要左节点非空，就将当前节点及右子树一起放到 根节点的左节点的最右子节点的右侧
            if (root.left != null) {
                pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root;
                //而画图可知，根节点原本有一个指针指向其左节点，因此需要将该指针断开，否则会形成环路
                TreeNode tmp = root;
                //向左遍历
                root = root.left;
                tmp.left = null;
            }
            //否则就打印当前节点，并向右遍历
            else {
                nodes.add(root.val);
                root = root.right;
            }
        }
        return nodes;
    }
}
