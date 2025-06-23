// DFS: 
// Time & Space complexity: O(m*n)
class Solution {
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private void dfs(int r, int c, boolean[][] ocean, int[][] heights) {
        ocean[r][c] = true; // the current cell should be included in the water flow path

        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            // check whether to include the neighbor cell in the water flow path (true):
            boolean isWithinBoundary = nr >= 0 && nc >= 0 && nr < heights.length && nc < heights[0].length;
            if (!isWithinBoundary) continue; // out of bound: go check other neighbor cells;
            // if visited (true), there is path to the ocean, no need to revisit it:
            boolean isCellVisited = ocean[nr][nc]; 
            boolean isCellHigherOrEqual = heights[nr][nc] >= heights[r][c];
            if (!isCellVisited && isCellHigherOrEqual) {
                dfs(nr, nc, ocean, heights);
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;

        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];

        for (int c = 0; c < COLS; c++) {
            dfs(0, c, pacific, heights);
            dfs(ROWS - 1, c, atlantic, heights);
        }

        for (int r = 0; r < ROWS; r++) {
            dfs(r, 0, pacific, heights);
            dfs(r, COLS - 1, atlantic, heights);
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }
}
