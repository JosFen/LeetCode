class Solution {
    public int orangesRotting(int[][] grid) {
        // to record the mininum number of minutes, 
        // the first while loop iteration represents the start of the spread, not a full minute yet, so -1
        int maxStep = -1;  
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int freshNum = 0;

        Queue<int[]> q = new ArrayDeque<>();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0 ; c < COLS; c++) {
                if (grid[r][c] == 2) {
                    q.offer(new int[] {r, c});
                }
                else if (grid[r][c] == 1) freshNum++;
            }
        }
        if (freshNum == 0) return 0;
        if (q.isEmpty()) return -1;

        int[][] directions = {{-1, 0}, {1, 0}, { 0, -1}, { 0, 1}};
        
        while (!q.isEmpty()) { // Each while loop iteration = 1 minute passed.
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cell = q.poll();
                int r = cell[0];
                int c = cell[1];
                
                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr >= 0 && nc >= 0 && nr < ROWS && nc < COLS && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        freshNum--;
                        q.offer(new int[] {nr, nc});
                    }
                }
            }
            maxStep++;
        }

        return (freshNum == 0) ? maxStep : -1;
    }
}
