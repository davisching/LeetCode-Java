/*  234 - Palindrome Linked List - From @ LeetCode.com
    
    Given a singly linked list, determine if it is a palindrome.

    Example 1:

    Input: 1->2
    Output: false

    Example 2:

    Input: 1->2->2->1
    Output: true

    Follow up:
    Could you do it in O(n) time and O(1) space?

    Solution by @ Davis Ching, 2020.
 */
 
 
 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
// REVERSE HALF OF THE LIST - 1ms

class Solution {
    public boolean isPalindrome(ListNode head) {
        
        if (head == null || head.next == null) return true;
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode l1 = head;
        ListNode l2 = slow.next;
        slow.next = null;
        
        l2 = reverse(l2);
                
        while (l2 != null) {
            if (l1.val != l2.val)
                return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        return l1 == null || l1.next == null;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode l = head, prev = null, t = null;
        while (l != null) {
            t = l.next;
            l.next = prev;
            prev = l;
            l = t;
        }
        return prev;
    }
}


// REVERSE THE WHOLE LIST - 2ms
class Solution {
      public boolean isPalindrome(ListNode head) {
          ListNode l = head, t = null, last = null;
          ListNode root = new ListNode(0), l0 = root;
          while (l != null) {
              l0.next = new ListNode(l.val);
              l0 = l0.next;

              t = l.next;
              l.next = last;
              last = l;
              l = t;
          }

          head = root.next;

          while (head != null) {

              if (head.val != last.val)
                  return false;
              head = head.next;
              last = last.next;
          }
          return true;
      }
  }
