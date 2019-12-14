/*  412 - Fizz Buzz - From @ LeetCode.com
    
    Write a program that outputs the string representation of numbers from 1 to n.

    But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. 
    For numbers which are multiples of both three and five output “FizzBuzz”.

    Example:

    n = 15,

    Return:
    [
        "1",
        "2",
        "Fizz",
        "4",
        "Buzz",
        "Fizz",
        "7",
        "8",
        "Fizz",
        "Buzz",
        "11",
        "Fizz",
        "13",
        "14",
        "FizzBuzz"
    ]
    
    Solution by @ Davis Ching, 2019
 */
 
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            ans.add(getFizzBuzzOf(i)); 
        return ans;
    }

    private String getFizzBuzzOf(int n) {
        StringBuilder ans = new StringBuilder();
        if (n % 3 == 0) ans.append("Fizz");
        if (n % 5 == 0) ans.append("Buzz");
        if (ans.length() == 0) ans.append(n);
        return ans.toString();
    }
}
