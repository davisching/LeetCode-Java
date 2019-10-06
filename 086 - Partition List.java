/*  086 - Partition List - From @ LeetCode.com
    
    Given a linked list and a value x, partition it such that all nodes less than x come before nodes 
    greater than or equal to x.

    You should preserve the original relative order of the nodes in each of the two partitions.

    Example:

    Input: head = 1->4->3->2->5->2, x = 3
    Output: 1->2->2->4->3->5
    
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
    public ListNode partition(ListNode head, int x) {
        ListNode root1 = new ListNode(0);
        ListNode l1 = root1;
        ListNode root2 = new ListNode(0);
        ListNode l2 = root2;
        while (head != null) {
            if (head.val < x) {
                l1.next = new ListNode(head.val);
                l1 = l1.next;
            } else {
                l2.next = new ListNode(head.val);
                l2 = l2.next;
            }
            head = head.next;
        }
        l1.next = root2.next;
        return root1.next;
    }
}
