/*  060 - Permutation Sequence - From @ LeetCode.com
    
    GThe set [1,2,3,...,n] contains a total of n! unique permutations.
    By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
        "123"
        "132"
        "213"
        "231"
        "312"
        "321"
    Given n and k, return the kth permutation sequence.

    Note:
        Given n will be between 1 and 9 inclusive.
        Given k will be between 1 and n! inclusive.

    Example 1:
    Input: n = 3, k = 3
    Output: "213"

    Example 2:
    Input: n = 4, k = 9
    Output: "2314"

    Solution by @ Davis Ching, 2019
 */
 
 // 这题可以用数学来解决，但我还是喜欢用nextPermutation，写起来比较舒爽
 
 class Solution {
    public String getPermutation(int n, int k) {
        int[] nums = getNums(n);
        for (int i = 1; i < k; i++)
            nextPermutation(nums);
        return toString(nums);
    }
    
    private int[] getNums(int n) {
        int[] ans = new int[n];
        for (int i = 1; i <= n; i++)
            ans[i-1] = i;
        return ans;
    }
    
    private void nextPermutation(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                for (int j = nums.length - 1; j > i; j--) {
                    if (nums[i] < nums[j]) {
                        swap(nums, i, j);
                        reverse(nums, i + 1);
                        return;
                    }
                }
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int t = nums[i]; nums[i] = nums[j]; nums[j] = t;
    }
    
    private void reverse(int[] nums, int l) {
        int r = nums.length - 1;
        while (l < r) swap(nums, l++, r--);
    }
    
    private String toString(int[] nums) {
        StringBuilder ans = new StringBuilder();
        for (int i : nums)
            ans.append(i);
        return ans.toString();
    }
}
