/*  046 - Permutations - From @ LeetCode.com
    
    Given a collection of distinct integers, return all possible permutations.
    Example:
    Input: [1,2,3]
    Output:
    [
      [1,2,3],
      [1,3,2],
      [2,1,3],
      [2,3,1],
      [3,1,2],
      [3,2,1]
    ]
    Solution by @ Davis Ching, 2019
 */
 
 //Using Next Permutation
 
 class Solution {
    public List<List<Integer>> permute (int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(asList(nums));
        List<Integer> list = null;
        while ((list = nextPermutation(nums)) != null)
            ans.add(list);
        return ans;
    }
    
    private List<Integer> nextPermutation (int[] nums) {
        for (int i = nums.length-2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                for (int j = nums.length-1; j > i; j--) {
                    if (nums[j] > nums[i]) {
                        swap(nums, i, j);
                        reverse(nums, i+1);
                        return asList(nums);
                    }
                }
            }
        }
        return null;
    }
    
    private List<Integer> asList (int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums)
            list.add(num);
        return list;
    }
    
    private void swap (int[] nums, int i, int j) {
        int t = nums[i]; nums[i] = nums[j]; nums[j] = t;
    }
    
    private void reverse (int[] nums, int i) {
        int l = i, r = nums.length-1;
        while (l < r) swap(nums, l++, r--);
    }
}
