/*  117 - Populating Next Right Pointers in Each Node II - From @ LeetCode.com
    
    Given a binary tree

    struct Node {
      int val;
      Node *left;
      Node *right;
      Node *next;
    }

    Populate each next pointer to point to its next right node. If there is no next right node, 
    the next pointer should be set to NULL.

    Initially, all next pointers are set to NULL.
    
    Solution by @ Davis Ching, 2019
 */
 
 /*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        Node t = new Node();
        Node head = t;
        Node _root = root;
        while (root != null) {
            if (root.left != null) {
                t.next = root.left;
                t = t.next;
            }
            if (root.right != null) {
                t.next = root.right;
                t = t.next;
            }
            root = root.next;
            if (root == null) {
                t = head;
                root = head.next;
                head.next = null;
            }
        }
        return _root;
    }
}
