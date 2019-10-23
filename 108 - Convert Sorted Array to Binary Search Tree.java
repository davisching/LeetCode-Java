/*  108 - Convert Sorted Array to Binary Search Tree - From @ LeetCode.com
    
    Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

    For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of 
    the two subtrees of every node never differ by more than 1.

    Example:

    Given the sorted array: [-10,-3,0,5,9],

    One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

          0
         / \
       -3   9
       /   /
     -10  5

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
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length-1);
    }
    
    private TreeNode sortedArrayToBST(int[] nums, int from, int to) {
        if (from > to) return null;
        if (from == to) return new TreeNode(nums[from]);
        int m = (from+to+1)/2;
        TreeNode cur = new TreeNode(nums[m]);
        cur.left = sortedArrayToBST(nums, from, m-1);
        cur.right = sortedArrayToBST(nums, m+1, to);
        return cur;
    }
}
