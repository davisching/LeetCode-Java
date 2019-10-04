/*  082 - Remove Duplicates from Sorted List II - From @ LeetCode.com
    
    Given a sorted linked list, delete all nodes that have duplicate numbers, 
    leaving only distinct numbers from the original list.

    Example 1:

    Input: 1->2->3->3->4->4->5
    Output: 1->2->5

    Example 2:

    Input: 1->1->1->2->3
    Output: 2->3

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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        if (head.val != head.next.val) {
            head.next = deleteDuplicates(head.next);
            return head;
        } else {
            while (head.next != null && head.val == head.next.val)
                head = head.next;
            return deleteDuplicates(head.next);
        }
    }
}
