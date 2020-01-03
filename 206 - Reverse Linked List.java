/*  206 - Reverse Linked List - From @ LeetCode.com
    
    Reverse a singly linked list.

    Example:

    Input: 1->2->3->4->5->NULL
    Output: 5->4->3->2->1->NULL

    Follow up:

    A linked list can be reversed either iteratively or recursively. Could you implement both?
 
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
 
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode t = null, last = null, l = head;
        while (l != null) {
            t = l.next;
            l.next = last;
            last = l;
            l = t;
        }
        return last;
    }
}

    /*
        LAST = NULL;

        T = L.NEXT; 2 -> 3 -> NULL
        L.NEXT = LAST; 1 -> NULL
        LAST = L; 1 -> NULL
        L = T; 2 -> 3 -> NULL

        T = L.NEXT; 3 -> NULL
        L.NEXT = LAST; 2 -> 1 -> NULL
        LAST = L; 2 -> 1 -> NULL
        L = T; 3 -> NULL

        T = L.NEXT; NULL
        L.NEXT = LAST; 3 -> 2 -> 1 -> NULL
        LAST = L; 3 -> 2 -> 1 -> NULL
        L = T; NULL

        IF L == NULL ? RETURN LAST
        
    */
