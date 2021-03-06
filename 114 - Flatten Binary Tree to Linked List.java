/*  114 - Flatten Binary Tree to Linked List - From @ LeetCode.com
    
    Given a binary tree, flatten it to a linked list in-place.

    For example, given the following tree:

        1
       / \
      2   5
     / \   \
    3   4   6

    The flattened tree should look like:

    1
     \
      2
       \
        3
         \
          4
           \
            5
             \
              6

    Solution by @ Davis Ching, 2019
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    private TreeNode t;
    
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        
        root.right = t;
        root.left = null;
        t = root;
    }
}
