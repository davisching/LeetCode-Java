/*  056 - Merge Intervals - From @ LeetCode.com
    
    Given a collection of intervals, merge all overlapping intervals.

    Example 1:
    Input: [[1,3],[2,6],[8,10],[15,18]]
    Output: [[1,6],[8,10],[15,18]]
    Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

    Example 2:
    Input: [[1,4],[4,5]]
    Output: [[1,5]]
    Explanation: Intervals [1,4] and [4,5] are considered overlapping. 
    
    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> result = new ArrayList<>();
        int[] t = intervals[0];
        result.add(t);
        for (int[] i : intervals) {
            if (t[1] >= i[0]) {
                t[1] = Math.max(t[1], i[1]);
            } else {
                t = i;
                result.add(t);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}


////// 在Leetcode里面调用Comparator的静态方法反而会使用更多时间和空间，所以自己重写方法可以降低开销。

class Solution {
    
    private class IntervalComperator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return Integer.compare(a[0], b[0]);
        }
    }
    
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals, new IntervalComperator());
        List<int[]> result = new ArrayList<>();
        int[] t = intervals[0];
        result.add(t);
        for (int[] i : intervals) {
            if (t[1] >= i[0]) {
                t[1] = Math.max(t[1], i[1]);
            } else {
                t = i;
                result.add(t);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
