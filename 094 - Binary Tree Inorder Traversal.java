/*  094 - Binary Tree Inorder Traversal - From @ LeetCode.com
    
    Given a binary tree, return the inorder traversal of its nodes' values.

    Example:

    Input: [1,null,2,3]
    1
        \
        2
        /
    3

    Output: [1,3,2]

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
    
    private List<Integer> ans = new ArrayList<>();
    
    public List<Integer> inorderTraversal(TreeNode root) {
        traversal(root);
        return ans;
    }
    
    private void traversal (TreeNode root) {
        if (root != null) {
            traversal(root.left);
            ans.add(root.val);
            traversal(root.right);
        }
    }
}