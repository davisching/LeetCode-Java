/*  023 - Merge k Sorted Lists - From @ LeetCode.com
    
    Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

    Example:
    Input:
    [
      1->4->5,
      1->3->4,
      2->6
    ]
    Output: 1->1->2->3->4->4->5->6

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
    public ListNode mergeKLists (ListNode[] lists) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (ListNode l : lists)
            while (l != null) {
                queue.add(l.val);
                l = l.next;
            }
        ListNode l = new ListNode(0), root = l;
        while (!queue.isEmpty()) {
            l.next = new ListNode(queue.poll());
            l = l.next;
        }
        return root.next;
    }
}
