/*  148 - Sort List - From @ LeetCode.com
    
    Sort a linked list in O(n log n) time using constant space complexity.

    Example 1:

    Input: 4->2->1->3
    Output: 1->2->3->4

    Example 2:

    Input: -1->5->3->4->0
    Output: -1->0->3->4->5
    
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
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head.next == null) return head;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;
        return merge(mergeSort(head), mergeSort(fast));
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(-1);
        ListNode l = root;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                l.next = l1;
                l1 = l1.next;
            } else {
                l.next = l2;
                l2 = l2.next;
            }
            l = l.next;
        }
        if (l1 == null) l.next = l2;
        if (l2 == null) l.next = l1;
        return root.next;
    } 
}
