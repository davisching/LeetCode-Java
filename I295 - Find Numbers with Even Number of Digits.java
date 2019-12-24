/*  1295 - Find Numbers with Even Number of Digits - From @ LeetCode.com
    
    Given an array nums of integers, return how many of them contain an even number of digits.
    
    Example 1:

    Input: nums = [12,345,2,6,7896]
    Output: 2
    Explanation: 
    12 contains 2 digits (even number of digits). 
    345 contains 3 digits (odd number of digits). 
    2 contains 1 digit (odd number of digits). 
    6 contains 1 digit (odd number of digits). 
    7896 contains 4 digits (even number of digits). 
    Therefore only 12 and 7896 contain an even number of digits.

    Example 2:

    Input: nums = [555,901,482,1771]
    Output: 1 
    Explanation: 
    Only 1771 contains an even number of digits.
    
    Solution by @ Davis Ching, 2019
 */
 
 // FASTEST
 class Solution {
    public int findNumbers(int[] nums) {
        int counter = 0;   
        for (int num : nums)
           if (isEven(num))
               counter += 1;
        return counter;
    }
    
    private boolean isEven(int num) {
        int digits = 0;
        while (num != 0) {
            digits += 1;
            num /= 10;
        }
        return digits%2 == 0;
    }
}

// SECOND
class Solution {
    public int findNumbers(int[] nums) {
        Arrays.sort(nums);
        int counter = 0, cur = 10;
        boolean isEven = false;
        for (int num : nums) {
            while (num >= cur) {
                cur *= 10;
                isEven = !isEven;
            }
            if (isEven) counter++;
        }
        return counter;
    }
}

//THIRD
class Solution {
    public int findNumbers(int[] nums) {
        return Arrays.stream(nums).map(num ->  1-String.valueOf(num).length()%2).sum();
    }
}
