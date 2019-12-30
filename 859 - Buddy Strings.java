/*  859 - Buddy Strings - From @ LeetCode.com
    
    Given two strings A and B of lowercase letters, 
    return true if and only if we can swap two letters in A so that the result equals B.


    Example 1:

    Input: A = "ab", B = "ba"
    Output: true

    Example 2:

    Input: A = "ab", B = "ab"
    Output: false

    Example 3:

    Input: A = "aa", B = "aa"
    Output: true

    Example 4:

    Input: A = "aaaaaaabc", B = "aaaaaaacb"
    Output: true

    Example 5:

    Input: A = "", B = "aa"
    Output: false


Note:

    0 <= A.length <= 20000
    0 <= B.length <= 20000
    A and B consist only of lowercase letters.


    
    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.equals(B)) {
            Set<Character> set = new HashSet<>();
            for (char a : A.toCharArray()) {
                if (set.contains(a))
                    return true;
                set.add(a);
            }
            return false;
        }
        
        char a = ' ', b = ' ';
        int counter = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                if (counter == 0) {
                    a = A.charAt(i);
                    b = B.charAt(i);
                } else if (counter == 1) {
                    if (!(A.charAt(i) == b && B.charAt(i) == a))
                        return false;
                } else return false;
                counter++;
            }
        }
        return counter == 2;
    }
}
