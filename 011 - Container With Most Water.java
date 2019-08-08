/*  011 - Container With Most Water - From @ LeetCode.com
    
    Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). 
    n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
    Find two lines, which together with x-axis forms a container, such that the container contains the most water.

    Note: You may not slant the container and n is at least 2. 
    
    Example:
    Input: [1,8,6,2,5,4,8,3,7]
    Output: 49
    
    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length-1, ans = 0;
        while (l < r) {
            int h = (height[l] < height[r]) ? height[l++] : height[r--];
            ans = Math.max(ans, h *(r-l+1));
        }
        return ans;
    }
}
