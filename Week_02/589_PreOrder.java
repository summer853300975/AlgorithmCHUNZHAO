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

class Solution {

    //递归法
    // List<Integer> nodes = new ArrayList();
    // public List<Integer> preorder(Node root) {
    //     if (root == null) return nodes;
    //     nodes.add(root.val);
    //     for (Node node : root.children) {
    //         preorder(node);
    //     }
    //     return nodes;
    // }

    //迭代法
    public List<Integer> preorder(Node root) {
        LinkedList<Integer> nodes = new LinkedList();
        LinkedList<Node> deque = new LinkedList();
        if (root == null) return nodes;
        deque.add(root);
        while (!deque.isEmpty()) {
            Node currentNode = deque.pollLast();
            //以上有两步add，poll是准备操作
            nodes.add(currentNode.val); //将最后结果list的新增操作放入循环中，不要放在外面
            Collections.reverse(currentNode.children);
            for (Node node : currentNode.children) {
                deque.add(node);
            }
        }
        return nodes;



    }
}