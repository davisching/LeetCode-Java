/*  137 - Single Number II - From @ LeetCode.com
    
    Given a non-empty array of integers, every element appears three times except for one, 
    which appears exactly once. Find that single one.

    Note:

    Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

    Example 1:

    Input: [2,2,3,2]
    Output: 3

    Example 2:

    Input: [0,1,0,1,0,1,99]
    Output: 99
    
    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public int singleNumber(int[] nums) {
       Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0)+1);
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            if (entry.getValue() == 1)
                return entry.getKey();
        return 0;
    }
}
