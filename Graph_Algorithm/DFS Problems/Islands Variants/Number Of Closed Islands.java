class Solution {

    boolean dfs(int[][] grid, int i, int j) {
        // Base case: if boundary of Matrix is crossed
        if(i < 0 || i >= grid.length || j < 0 || j>= grid[0].length) {
            return false;
        } 
        
        // Target condition
        if(grid[i][j] == 1) { // already closed by water 1
            return true;
        }
        
        // mark visited
        grid[i][j] = 1;

        // check all 4 direction closed or not
        boolean left_closed = dfs(grid, i, j-1);
        boolean down_closed = dfs(grid, i+1, j);
        boolean right_closed = dfs(grid, i, j+1);
        boolean up_closed = dfs(grid, i-1, j);

        return left_closed && down_closed && right_closed && up_closed;
    }

    public int closedIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int count = 0;

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(grid[i][j] == 0) {
                    if(dfs(grid, i, j) == true) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
