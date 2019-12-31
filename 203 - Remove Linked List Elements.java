/*  203 - Remove Linked List Elements - From @ LeetCode.com
    
    Remove all elements from a linked list of integers that have value val.

    Example:

    Input:  1->2->6->3->4->5->6, val = 6
    Output: 1->2->3->4->5
    
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
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val)
            head = head.next;
        
        ListNode l = head;
        
        while (l != null && l.next != null) {
            if (l.next.val == val) 
                l.next = l.next.next;
            else
                l = l.next;
        }
        
        return head;
    }
}
