/*  349 - Intersection of Two Arrays - From @ LeetCode.com
    
    Given two arrays, write a function to compute their intersection.

    Example 1:

    Input: nums1 = [1,2,2,1], nums2 = [2,2]
    Output: [2]

    Example 2:

    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    Output: [9,4]

    Note:

        Each element in the result must be unique.
        The result can be in any order.
 
    
    Solution by @ Davis Ching, 2019
 */
 
 // USE BUILD IN RETAINALL
 class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1)
            set1.add(num);
        for (int num : nums2)
            set2.add(num);
        set1.retainAll(set2);
        int[] res = new int[set1.size()];
        int i = 0;
        for (int n : set1)
            res[i++] = n;
        return res;
    }
}

// USE BINARY SEARCH
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
 
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < nums2.length; i++) {
            if (i != 0 && nums2[i-1] == nums2[i]) continue;
            if (Arrays.binarySearch(nums1, nums2[i]) >= 0)
                list.add(nums2[i]);
        }
        
        int[] res = new int[list.size()];
        int i = 0;
        for (int n : list)
            res[i++] = n;
        return res;
    }
}
