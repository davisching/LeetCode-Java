/*  042 - Trapping Rain Water - From @ LeetCode.com
    
    Given n non-negative integers representing an elevation map where the width of each bar is 1, 
    compute how much water it is able to trap after raining.

    The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
    In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

    Example:
    Input: [0,1,0,2,1,0,1,3,2,1,2,1]
    Output: 6
 
    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length-1, ans = 0;
        int l_max = 0, r_max = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                if (height[l] < l_max)
                    ans += l_max - height[l];
                else
                    l_max = height[l];
                l += 1;
            } else {
                if (height[r] < r_max)
                    ans += r_max - height[r];
                else
                    r_max = height[r];
                r -= 1;
            }
        }
        return ans;
    }
}
