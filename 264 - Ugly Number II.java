/*  264 - Ugly Number II - From @ LeetCode.com
    
    Write a program to find the n-th ugly number.

    Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

    Example:

    Input: n = 10
    Output: 12
    Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

    Note:  

        1 is typically treated as an ugly number.
        n does not exceed 1690.
 
    Solution by @ Davis Ching, 2020.
 */
 
 class Solution {
    public int nthUglyNumber(int n) {
        if (n == 1) return 1;
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.add(1);
        for (int i = 1; i < n; i++) {
            long cur = queue.poll();
            while (!queue.isEmpty() && cur == queue.peek()) queue.poll();
            queue.offer(2*cur);
            queue.offer(3*cur);
            queue.offer(5*cur);
        }
        return queue.peek();
    }
}
