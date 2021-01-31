/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

//递归法
//后序遍历-  N叉树：子节点，根
class Solution {
    // List<Integer> nodes = new ArrayList();
    // public List<Integer> postorder(Node root) {
    //     traverse(root);
    //     return nodes;
    // }

    // public void traverse(Node root) {
    //     if (root == null) return;
    //     for (Node node : root.children) {
    //         traverse(node);
    //     }
    //     nodes.add(root.val);
    // }


    //迭代法
    //两种方法--1，用LinkedList头插法实现； 时间复杂度O(M),空间复杂度O(M)（M指节点个数）
    //2，用deque双端队列实现，最后再反转数组
    public List<Integer> postorder(Node root) {
        List<Integer> nodes = new ArrayList();
        Stack<Node> stack = new Stack();
        if (root == null) return nodes;
        stack.push(root);
        while(!stack.isEmpty()) {
            Node node = stack.pop();
            nodes.add(node.val);
            for (Node children : node.children) {
                stack.push(children);
            }
        }
        Collections.reverse(nodes);
        return nodes;
    }
}