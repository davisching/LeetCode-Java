/*  113 - Path Sum II - From @ LeetCode.com
    
    Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

    Note: A leaf is a node with no children.

    Example:
    Given the below binary tree and sum = 22,

          5
         / \
        4   8
       /   / \
      11  13  4
     /  \    / \
    7    2  5   1

    Return:
    [
       [5,4,11,2],
       [5,8,4,5]
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
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        pathSum(root, sum, new ArrayList());
        return ans;
    }
    
    private void pathSum(TreeNode node, int sum, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        if (node.val == sum && node.left == null && node.right == null) {
            ans.add(list);
            return;
        }
        pathSum(node.left, sum-node.val, list);
        pathSum(node.right, sum-node.val, list);
    }
}
