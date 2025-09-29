class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0, n = intervals.length;

        // 1️⃣ Add all intervals that end before newInterval starts
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        // 2️⃣ Merge all overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);

        // 3️⃣ Add all intervals that start after newInterval ends
        while (i < n) {
            res.add(intervals[i]);
            i++;
        }

        // 4️⃣ Convert back to int[][]
        return res.toArray(new int[res.size()][]);
    }
}

// 1st version: with Binary Search:
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][]{newInterval};
        // binary search:
        int l = 0, r = intervals.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (intervals[m][0] > newInterval[0]) r = m;
            else l = m + 1; // avoid stuck in loop 
        }

        int insertIdx = l;
        List<int[]> ordered = new ArrayList<>(intervals.length + 1);
        for (int i = 0; i < insertIdx; i++) ordered.add(intervals[i]);
        ordered.add(newInterval);
        for (int i = insertIdx; i < intervals.length; i++) ordered.add(intervals[i]);


        // merge:
        List<int[]> merged = new ArrayList<>();
        for (int[] cur : ordered) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < cur[0]) {
                merged.add(new int[] {cur[0], cur[1]});
            } else {
                int[] last = merged.get(merged.size() - 1);
                last[1] = Math.max(last[1], cur[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
