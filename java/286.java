/**
286. Walls and Gates
You are given a m x n 2D grid initialized with these three possible values.
  1. -1 - A wall or an obstacle.
  2. 0 - A gate.
  3. INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

Example: 
Given the 2D grid:

INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
  
After running your function, the 2D grid should be:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
*/

// Optimized BFS from all gates:
// Time & Space complexity: O(m*n)
class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int ROWS = grid.length;
        int COLS = grid[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0 ; c < COLS; c++){
                if (grid[r][c] == 0) {
                    q.offer(new int[]{r, c});
                }
            }
        }    
        if (q.isEmpty()) return;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nc >= 0 && nr < ROWS && nc < COLS && grid[nr][nc] == Integer.MAX_VALUE) {
                    grid[nr][nc] = grid[r][c] + 1;
                    q.add(new int[] {nr, nc});
                }
            }
        }

    }
}
