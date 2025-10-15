class Solution {
    public int[][] merge(int[][] intervals) {
            if (intervals == null || intervals.length == 0) {
                return intervals;
            }

            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

            List<int[]> result = new ArrayList<>();

            for (int[] each: intervals) {
                if (result.isEmpty() || result.get(result.size() - 1)[1] < each[0]) {
                    result.add(each);
                } else {
                    result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], each[1]);
                }
            }

            int[][] merged = new int[result.size()][];
            for (int i = 0; i < result.size(); i++) {
                merged[i] = result.get(i);
            }

            return merged;
        }
}
