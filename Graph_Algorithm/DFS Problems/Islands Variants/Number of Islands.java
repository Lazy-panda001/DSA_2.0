class Solution {
    // Variation 1
    void dfs(char[][] grid, int i, int j) {
        // Base case : If Boundry of the grid/matrix is crossed
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') {
            return;
        } 

        // Process the current coordinate
        grid[i][j] = '0';

        //Recursive calls for Neighbours
        dfs(grid, i+1,j);
        dfs(grid, i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int count_islands = 0;

        // Go through the Grid and find land : 1
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count_islands++;
                }
            }
        }

        return count_islands;

    }
}
