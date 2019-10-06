/*  088 - Merge Sorted Array - From @ LeetCode.com
    
    Given two sorted integer arrays nums1 and nums2, 
    merge nums2 into nums1 as one sorted array.

    Note:
    The number of elements initialized in nums1 and nums2 are m and n respectively.
    You may assume that nums1 has enough space (size that is greater or equal to m + n) 
    to hold additional elements from nums2.

    Example:
    Input:
    nums1 = [1,2,3,0,0,0], m = 3
    nums2 = [2,5,6],       n = 3
    Output: [1,2,2,3,5,6]

    Solution by @ Davis Ching, 2019
 */
 
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        for (int i = 1; i <= n; i++) {
            int x = (int)Math.pow(2,i-1);
            for (int j = ans.size()-1; j >= 0; j--)
                ans.add(ans.get(j)+x);
        }
        return ans;
    }
}