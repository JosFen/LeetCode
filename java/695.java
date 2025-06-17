class Solution {
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        int ROWS = grid.length;
        int COLS = grid[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1) {
                    int area = dfs(grid, r, c);  //slightly faster runtime
                    // int area = bfs(grid, r, c);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

  // DFS:
    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0) return 0;

        grid[r][c] = 0;
        int count = 1;

        for (int[] dir : directions) {
            count += dfs(grid, r + dir[0], c + dir[1]);
        }
        return count;
    }
  
  // BFS:
    private int bfs(int[][] grid, int r, int c) {
        int count = 1;

        grid[r][c] = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});

        while(!q.isEmpty()) {
            int[] cell = q.poll();
            for (int[] dir : directions) {
                int nr = cell[0] + dir[0];
                int nc = cell[1] + dir[1];

                if (nr >= 0 && nc >=0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1) {
                    count++;
                    grid[nr][nc] = 0;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return count;
    }
}
