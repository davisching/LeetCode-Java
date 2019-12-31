/*  414 - Third Maximum Number - From @ LeetCode.com
    
    Given a non-empty array of integers, return the third maximum number in this array. 
    If it does not exist, return the maximum number. The time complexity must be in O(n).

    Example 1:

    Input: [3, 2, 1]

    Output: 1

    Explanation: The third maximum is 1.

    Example 2:

    Input: [1, 2]

    Output: 2

    Explanation: The third maximum does not exist, so the maximum (2) is returned instead.

    Example 3:

    Input: [2, 2, 3, 1]

    Output: 1

    Explanation: Note that the third maximum here means the third maximum distinct number.
    Both numbers with value 2 are both considered as second maximum.

    
    Solution by @ Davis Ching, 2019
 */
 
 //SOLUTION ONE
 class Solution {
    public int thirdMax(int[] nums) {
        Integer first = null, second = null, third = null;
        for (Integer num : nums) {
            if (num.equals(first) || num.equals(second) || num.equals(third)) continue;
            if (first == null || num > first) {
                third = second;
                second = first;
                first = num;
            } else if (second == null || num > second) {
                third = second;
                second = num;
            } else if (third == null || num > third){
                third = num;
            }
        }
        return third != null ? third : first;
    }
}


//SOLUTION TWO
class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            if (!queue.contains(num))
                queue.offer(num);
            if (queue.size() > 3)
                queue.poll();
        }
        
        if (queue.size() < 3)
            while (queue.size() != 1)
                queue.poll();
        
        return queue.peek();
    }
}
