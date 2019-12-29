
/*  475 - Heaters - From @ LeetCode.com
    
    Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    
    Example:
    Given nums = [2, 7, 11, 15], target = 9,
    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].  
    
    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int r = 0;
        for (int house : houses) {
            int idx = Arrays.binarySearch(heaters, house);
            if (idx < 0) idx = -idx - 1;
            int r1 = (idx > 0) ? house - heaters[idx-1] : Integer.MAX_VALUE;
            int r2 = (idx < heaters.length) ? heaters[idx] - house : Integer.MAX_VALUE;
            r = Math.max(r, Math.min(r1, r2));
        }
        return r;
    }
}
