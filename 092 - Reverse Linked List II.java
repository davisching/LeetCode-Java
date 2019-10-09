/*  092 - Reverse Linked List II - From @ LeetCode.com
    
    Reverse a linked list from position m to n. Do it in one-pass.

    Note: 1 ≤ m ≤ n ≤ length of list.

    Example:

    Input: 1->2->3->4->5->NULL, m = 2, n = 4
    Output: 1->4->3->2->5->NULL

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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode root = new ListNode(-1);
        ListNode l = root;
        
        ListNode l1 = new ListNode(-1);
        ListNode tail = l1;
        
        int cur = 1;
        while (cur <= n) {
            if (cur < m) {
                l.next = new ListNode(head.val);
                l = l.next;
            } else if (cur == m) {
                l1.val = head.val;
            } else if (cur > m && cur <= n) {
                ListNode t = l1;
                l1 = new ListNode(head.val);
                l1.next = t;
            }
            head = head.next;
            cur += 1;
        }
        
        tail.next = head;
        l.next = l1;
        
        return root.next;
    }
}