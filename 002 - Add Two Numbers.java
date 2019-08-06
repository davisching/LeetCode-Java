/*  002 - Add Two Numbers - From @ LeetCode.com
    
    You are given two non-empty linked lists representing two non-negative integers. 
    The digits are stored in reverse order and each of their nodes contain a single digit. 
    Add the two numbers and return it as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    
    Example:
    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
    Explanation: 342 + 465 = 807.  
    
    Class Definition:
    Definition for singly-linked list.
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    
    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public ListNode addTwoNumbers (ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode l = root;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int val = x + y + carry;
            carry = val / 10;
            l.next = new ListNode(val%10);
            l = l.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0)
            l.next = new ListNode(1);
        return root.next;
    }
}
