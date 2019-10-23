/*  107 - Binary Tree Level Order Traversal II - From @ LeetCode.com
    
    Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
    (ie, from left to right, level by level from leaf to root).

    For example:
    Given binary tree [3,9,20,null,null,15,7],

        3
       / \
      9  20
        /  \
       15   7

    return its bottom-up level order traversal as:

    [
      [15,7],
      [9,20],
      [3]
    ]

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
    
    private List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        traversal(root, 0);
        return ans;
    }
    
    private void traversal(TreeNode node, int level) {
        if (node == null) return;
        if (ans.size() == level)
            ans.add(0, new ArrayList());
        ans.get(ans.size()-level-1).add(node.val);
        traversal(node.left, level+1);
        traversal(node.right, level+1);
    }
}
