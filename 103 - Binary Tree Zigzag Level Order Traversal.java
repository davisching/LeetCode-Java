/*  103 - Binary Tree Zigzag Level Order Traversal - From @ LeetCode.com
    
    Given a binary tree, return the zigzag level order traversal of its nodes' values. 
    (ie, from left to right, then right to left for the next level and alternate between).

    For example:
    Given binary tree [3,9,20,null,null,15,7],

        3
    / \
    9  20
        /  \
    15   7

    return its zigzag level order traversal as:

    [
    [3],
    [20,9],
    [15,7]
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
    
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        traversal(root, 0);
        return ans;
    }
    
    private void traversal(TreeNode node, int level) {
        if (node == null) return;
        if (ans.size() <= level)
            ans.add(new ArrayList());
        if (level % 2 == 0)
            ans.get(level).add(node.val);
        else
            ans.get(level).add(0, node.val);
        traversal(node.left, level+1);
        traversal(node.right, level+1);
    }
}