/*  299 - Bulls and Cows - From @ LeetCode.com
    
    You are playing the following Bulls and Cows game with your friend: 
    You write down a number and ask your friend to guess what the number is. 
    Each time your friend makes a guess, 
    you provide a hint that indicates how many digits in said guess match your secret number 
    exactly in both digit and position (called "bulls") 
    and how many digits match the secret number but locate in the wrong position (called "cows"). 
    Your friend will use successive guesses and hints to eventually derive the secret number.

    Write a function to return a hint according to the secret number and friend's guess, 
    use A to indicate the bulls and B to indicate the cows. 

    Please note that both secret number and friend's guess may contain duplicate digits.

    Example 1:

    Input: secret = "1807", guess = "7810"

    Output: "1A3B"

    Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.

    Example 2:

    Input: secret = "1123", guess = "0111"

    Output: "1A1B"

    Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.

    Note: You may assume that the secret number and your friend's guess only contain digits, 
    and their lengths are always equal.

    Solution by @ Davis Ching, 2020.
 */
 
 class Solution {
    public String getHint(String secret, String guess) {
        int A = 0, B = 0;
        
        int[][] matches = new int[2][10];
        
        for (int i = 0; i < secret.length(); i++) {
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            if (c1 == c2) {
                A += 1;
            } else {
                matches[0][c1-'0'] += 1;
                matches[1][c2-'0'] += 1;
            }
        }
        
        for (int i = 0; i <= 9; i++)
            if (matches[0][i] > 0 && matches[1][i] > 0)
                B += Math.min(matches[0][i], matches[1][i]);
        
        StringBuilder sb = new StringBuilder();
        sb.append(A).append('A').append(B).append('B');
        return sb.toString();
    }
}
