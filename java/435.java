class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[1] - i2[1]);

        int result = 0, cEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++){
            if (intervals[i][0] < cEnd) result++;
            else cEnd = intervals[i][1];
        }
        return result;
    }
}
/**
keep the one that ends first, because:

It leaves more room for future intervals to fit without overlapping.

It never blocks an interval that starts later.

This local choice (keeping earliest-end) never hurts future decisions — that’s the hallmark of a valid greedy strategy.
  */
