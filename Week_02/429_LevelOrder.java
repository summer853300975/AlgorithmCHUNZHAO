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

    //递归法---将遍历每一层的过程看成重复的
    // List<List<Integer>> result = new ArrayList();
    // public List<List<Integer>> levelOrder(Node root) {
    //     if (root == null) return result;
    //     traverse(root, 0);
    //     return result;
    // }
    // public void traverse(Node root, int level) {
    //     if (result.size() <= level) {
    //         result.add(new ArrayList());
    //     }
    //     result.get(level).add(root.val);
    //     for (Node node : root.children) {
    //         traverse(node, level + 1);
    //     }
    // }


    //简化的广度优先搜索
    //重点是要创建3个list，存当前层的所有节点，当前层的所有值；然后跳到下一层
    // public List<List<Integer>> levelOrder(Node root) {
    //     List<List<Integer>> result = new ArrayList();
    //     if (root == null) return result;

    //     List<Node> preLay = Arrays.asList(root);
    //     while(!preLay.isEmpty()) {
    //         List<Integer> preList = new ArrayList();
    //         List<Node> currentLay = new ArrayList();
    //         for (Node node : preLay) {
    //             preList.add(node.val);
    //             currentLay.addAll(node.children);
    //         }
    //         result.add(preList);
    //         preLay = currentLay;
    //     }
    //     return result;
    // }


    //栈应用于深度优先搜索。
    //队列可以用于广度优先搜索
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList();
        if (root == null) return result;
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> preList = new ArrayList();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                preList.add(node.val);
                queue.addAll(node.children);
            }
            result.add(preList);
        }
        return result;
    }

}