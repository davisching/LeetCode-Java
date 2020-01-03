/*  257 - Binary Tree Paths - From @ LeetCode.com
    
    Given a binary tree, return all root-to-leaf paths.

    Note: A leaf is a node with no children.

    Example:

    Input:

       1
     /   \
    2     3
     \
      5

    Output: ["1->2->5", "1->3"]

    Explanation: All root-to-leaf paths are: 1->2->5, 1->3

    Solution by @ Davis Ching, 2020.
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null) return ans;
        drawTree(root, String.valueOf(root.val), ans);
        return ans;
    }
    
    private void drawTree(TreeNode node, String str, List<String> ans) {
        
        if (node.left == null && node.right == null) {
            ans.add(str); return;
        }
        
        if (node.left != null)
            drawTree(node.left, str+"->"+node.left.val, ans);
        if (node.right != null)
            drawTree(node.right, str+"->"+node.right.val, ans);
    }
}



// SOLUTION TWO

/// Using StringBuilder
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null) return ans;
        drawTree(root, new StringBuilder(String.valueOf(root.val)), ans);
        return ans;
    }
    
    private void drawTree(TreeNode node, StringBuilder sb, List<String> ans) {
        
        if (node.left == null && node.right == null) {
            ans.add(sb.toString()); return;
        }
        int len = sb.length();
        if (node.left != null)
            drawTree(node.left, sb.append("->").append(node.left.val), ans);
        sb.delete(len, sb.length());
        if (node.right != null)
            drawTree(node.right, sb.append("->").append(node.right.val), ans);
    }
}
