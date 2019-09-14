/*  061 - Rotate List - From @ LeetCode.com
    
    Given a linked list, rotate the list to the right by k places, where k is non-negative.

    Example 1:
    Input: 1->2->3->4->5->NULL, k = 2
    Output: 4->5->1->2->3->NULL
    Explanation:
    rotate 1 steps to the right: 5->1->2->3->4->NULL
    rotate 2 steps to the right: 4->5->1->2->3->NULL

    Example 2:
    Input: 0->1->2->NULL, k = 4
    Output: 2->0->1->NULL
    Explanation:
    rotate 1 steps to the right: 2->0->1->NULL
    rotate 2 steps to the right: 1->2->0->NULL
    rotate 3 steps to the right: 0->1->2->NULL
    rotate 4 steps to the right: 2->0->1->NULL
    
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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode root = head;
        if (head == null) return head;
        int len = 1;
        while (head.next != null) {
            head = head.next;
            len += 1;
        }
        head.next = root;
        for (k = len - k%len - 1; k > 0; k--) 
            root = root.next;
        ListNode ans = root.next;
        root.next = null;
        return ans;
    }
}
