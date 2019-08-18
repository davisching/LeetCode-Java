/*  032 - Longest Valid Parentheses - From @ LeetCode.com
    
    Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

    Example 1:
    Input: "(()"
    Output: 2
    Explanation: The longest valid parentheses substring is "()"

    Example 2:
    Input: ")()())"
    Output: 4
    Explanation: The longest valid parentheses substring is "()()"

    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    ans = Math.max(ans, i-stack.peek());
                }
            }
        }
        return ans;
    }
}
