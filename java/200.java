// BFS: 
// Time: O(mn), Space: O(min(m,n))
class Solution {
    private static final int[][] directions = {{-1,0}, {1,0}, {0, -1}, {0, 1}};

    public int numIslands(char[][] grid) {
        int islandCount = 0;
        int ROWS = grid.length;
        int COLS = grid[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == '1') {
                    bfs(grid, r, c);
                    islandCount++;
                }
            }
        }
        return islandCount; 
    }

    private void bfs(char[][] grid, int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {r, c});
        grid[r][c] = '0'; // mark as visited

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int row = cell[0];
            int col = cell[1];

            for (int[] dir : directions) {
                int nr = row + dir[0];
                int nc = col + dir[1];
                if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == '1') {
                    q.offer(new int[]{nr, nc});
                    grid[nr][nc] = '0';
                }
            }
        }
    }
}


// DFS: 
// Time & Space: O(mn)
class Solution {
    private static final int[][] directions = {{-1,0}, {1,0}, {0, -1}, {0, 1}};

    public int numIslands(char[][] grid) {
        int islandCount = 0;
        int ROWS = grid.length;
        int COLS = grid[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0 ; c < COLS; c++){
                if (grid[r][c] == '1') {
                    dfs(grid, r, c);
                    islandCount++;
                }
            }
        }
        return islandCount; 
    }

    private void dfs(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0') return;

        grid[r][c] = '0';
        for (int[] dir : directions) {
            dfs(grid, r + dir[0], c + dir[1]);
        }
    }
}
