/*  024 - Swap Nodes in Pairs - From @ LeetCode.com
    
    Given a linked list, swap every two adjacent nodes and return its head.
    You may not modify the values in the list's nodes, only nodes itself may be changed.

    Example:
    Given 1->2->3->4, you should return the list as 2->1->4->3.

    Solution by @ Davis Ching, 2019
 */
 
 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode t = head.next;
        head.next = swapPairs(t.next);
        t.next = head;
        return t;
    }
}
