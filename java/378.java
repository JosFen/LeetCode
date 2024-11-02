class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (k == 1) return matrix[0][0];

        int n = matrix.length;
        int l = matrix[0][0];
        int h = matrix[n-1][n-1];

        while (l < h) {
            int m = l + (h - l) / 2; // Since (h - l) is smaller than l + h, this method is safer in terms of preventing overflow.
            int count = findTotalSmaller(matrix, m);
            if (count < k) l = m + 1;
            else h = m;
        }
        return h;
    }

    private int findTotalSmaller(int[][] matrix, int m) {
        int count = 0;
        int r = matrix[0].length - 1;

        for (int[] row : matrix) {
            while (r >= 0 && row[r] > m) r--;
            count += (r+1);
        }
        return count;
    }
}
