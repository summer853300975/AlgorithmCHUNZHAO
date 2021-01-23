/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    //迭代
    //这里做了一个巧妙处理，就是新建一个目标链表的prev节点，然后用这个节点去指向给定的两个链表，最后返回时从目标链表的prev的下一个节点开始
    // public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    //     ListNode l3 = new ListNode(-1);
    //     if (l1 == null) return l2;
    //     if (l2 == null) return l1;
    //     ListNode prev = l3;

    //     while (l1 != null & l2 != null) {
    //         if (l1.val <= l2.val) {
    //             prev.next = l1;
    //             l1 = l1.next;
    //         }
    //         else {
    //             prev.next = l2;
    //             l2 = l2.next;
    //         }
    //         prev = prev.next;
    //     }
    //     prev.next = l1 == null ? l2 : l1;
    //     return l3.next;
    // }


    //递归
    //递归条件：较小节点的next指向剩余的合并结果
    //终止条件：任意一个链表为null
    //每一个递归进去的方法都需要return，因为有了递归，每一个方法都只是一个片段了
    //一开始还没写对
    //时间复杂度：O（m+n）每次操作只是移动一次指针，共有（m+n）次操作
    //空间复杂度：O（m+n）共有（m+n）次进出栈帧
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }
}