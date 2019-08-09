/*  019 - Remove Nth Node From End of List - From @ LeetCode.com
    
    Given a linked list, remove the n-th node from the end of list and return its head.

    Example:
    Given linked list: 1->2->3->4->5, and n = 2.
    After removing the second node from the end, the linked list becomes 1->2->3->5.

    Note:
    Given n will always be valid.

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode l = head, root = head;
        for (int i = 0; i < n; i++)
            head = head.next;
        if (head == null)
            return l.next;
        while (head.next != null) {
            head = head.next;
            l = l.next;
        }
        l.next = l.next.next;
        return root;
    }
}
