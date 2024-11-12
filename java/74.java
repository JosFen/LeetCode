// use the upper right entry as the checkpoint
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0, col = n - 1;

        while (row < m && col >=0) {
            if (target == matrix[row][col]) return true;
            else if (target < matrix[row][col]) col--;
            else row++;
        }
        return false;
    }
}

// Binary Search
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0, r = m * n;
        while (l < r) {
            int mid = (l + r) >>> 1;
            int i = mid / n;
            int j = mid % n;

            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}
