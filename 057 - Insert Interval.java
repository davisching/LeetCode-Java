/*  057 - Insert Interval - From @ LeetCode.com
    
    Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
    You may assume that the intervals were initially sorted according to their start times.

    Example 1:
    Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
    Output: [[1,5],[6,9]]

    Example 2:
    Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
    Output: [[1,2],[3,10],[12,16]]
    Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
    
    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList(Arrays.asList(intervals));
        if (list.size() == 0) list.add(newInterval);
        for (int i = 0; i <= list.size(); i++) {
            if (i == list.size() || newInterval[0] <= list.get(i)[0]) {
                list.add(i, newInterval);
                break;
            }
        }
        List<int[]> ans = new ArrayList<>();
        int[] last = list.get(0);
        for (int[] cur : list) {
            if (last[1] >= cur[0]) {
              last[1] = Math.max(last[1], cur[1]);  
            } else {
                ans.add(last);
                last = cur;
            }
        }
        ans.add(last);
        return ans.toArray(new int[ans.size()][]);
    }
}
