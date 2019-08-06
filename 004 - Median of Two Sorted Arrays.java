/*  004 - Median of Two Sorted Arrays - From @ LeetCode.com
    
    There are two sorted arrays nums1 and nums2 of size m and n respectively.
    Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
    You may assume nums1 and nums2 cannot be both empty.

    Example 1:
    nums1 = [1, 3]
    nums2 = [2]
    The median is 2.0

    Example 2:
    nums1 = [1, 2]
    nums2 = [3, 4]
    The median is (2 + 3)/2 = 2.5

    Solution by @ Davis Ching, 2019
 */
 
 /*
    此題難在必須要在O(log (m+n))的時間複雜度内完成。説明必須使用二分法查找來處理這個問題。
    那麽存在以下關係：
    nums1: |0|1|.|.|.|m1-1|m1|.|.|.|m-1| where m is nums1.length
    nums2: |0|1|.|.|.|n1-1|n1|.|.|.|n-1| where n is nums2.length
    k = (m+n+1)/2 = m1+n1
    二分法查找直到 nums1[m1-1] <= nums2[n1] && nums2[n1-1] <= nums1[m1]
    那麽可以得到：c1 = MAX(nums1[m1-1], nums2[n1-1])
                c2 = MIN(nums1[m1], nums2[n1])
    假設兩數組總長度為奇數： ans = c1, 如果是偶數的話 ans = AVERAGE(c1,c2).
 */
 class Solution {
    public double findMedianSortedArrays (int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int k = (m+n+1)/2;
        if (m > n) {
            int[] ts = nums1; nums1 = nums2; nums2 = ts;
            int t = m; m = n; n = t;
        }
        int l = 0, r = m;
        while (l <= r) {
            int m1 = (l+r)/2, n1 = k - m1;
            if (m1 < r && nums2[n1-1] > nums1[m1])
                l = m1 + 1;
            else if (m1 > l && nums1[m1-1] > nums2[n1])
                r = m1 - 1;
            else {
                int c1 = 0, c2 = 0;
                if (m1 <= 0) c1 = nums2[n1-1];
                else if (n1 <= 0) c1 = nums1[m1-1];
                else c1 = Math.max(nums1[m1-1], nums2[n1-1]);
                if ((m+n)%2 == 1) return c1;
                if (m1 >= m) c2 = nums2[n1];
                else if (n1 >= n) c2 = nums1[m1];
                else c2 = Math.min(nums1[m1], nums2[n1]);
                return (c1+c2)/2.0;
            }
        }
        return 0.0;
    }
}
