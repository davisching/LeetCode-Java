/*  167 - Two Sum II - Input array is sorted - From @ LeetCode.com
    
    Given an array of integers that is already sorted in ascending order, 
    find two numbers such that they add up to a specific target number.

    The function twoSum should return indices of the two numbers such that they add up to the target, 
    where index1 must be less than index2.

    Note:

        Your returned answers (both index1 and index2) are not zero-based.
        You may assume that each input would have exactly one solution and you may not use the same element twice.

    Example:

    Input: numbers = [2,7,11,15], target = 9
    Output: [1,2]
    Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.

    
    Solution by @ Davis Ching, 2020.
 */
 
 class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0, j = numbers.length-1; i < j;) {
            if (i != 0 && numbers[i] == numbers[i-1]) { i++; continue; }
            if (j != numbers.length-1 && numbers[j] == numbers[j+1]) {j--; continue;}
            if (numbers[i]+numbers[j] > target)
                j--;
            else if (numbers[i]+numbers[j] < target) 
                i++;
            else return new int[] {i+1, j+1};  
        }
        return null;
    }
}
