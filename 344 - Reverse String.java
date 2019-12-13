/*  344 - Reverse String - From @ LeetCode.com
    
    Write a function that reverses a string. The input string is given as an array of characters char[].

    Do not allocate extra space for another array, you must do this by modifying the input array 
    in-place with O(1) extra memory.

    You may assume all the characters consist of printable ascii characters.

    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public void reverseString(char[] s) {
        for (int i = 0, j = s.length-1; i < j; i++, j--)
                swap(s, i, j);
    }

    private void swap(char[] s, int i, int j) {
        char t = s[i];
        s[i] = s[j];
        s[j] = t;
    }
}
