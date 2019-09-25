/*  83 - Remove Duplicates from Sorted List - From @ LeetCode.com
    
    Given a sorted linked list, delete all duplicates such that each element appear only once.

    Example 1:

    Input: 1->1->2
    Output: 1->2

    Example 2:

    Input: 1->1->2->3->3
    Output: 1->2->3
    
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
        ListNode list = head;
        while (list != null && list.next != null) {
            if (list.val == list.next.val)
                list.next = list.next.next;
            else list = list.next;
        }
        return head;
    }
}
