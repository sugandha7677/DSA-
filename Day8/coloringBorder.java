class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        dfs(grid, row ,col , grid[row][col]);

        for(int i =0; i < grid.length; i++){
            for(int j =0; j < grid[i].length; j++) {
                if(grid[i][j] < 0) grid[i][j] = color;
            }
        }

        return grid;
    }

    int [] di = {-1, 0, 1, 0};
    int [] dj = {0, -1, 0, 1};

    public void dfs(int [][]grid, int row, int col , int val){

        grid[row][col] = -val;
        int count = 0;
        for(int i = 0; i < 4; i++){
            int newRow = row + di[i];
            int newCol = col + dj[i];

            if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol  < grid[0].length && Math.abs(grid[newRow][newCol]) == val){
                count++;
                if(grid[newRow][newCol] == val){
                    dfs(grid, newRow, newCol, val);
                }

            }
        }

        if(count == 4) grid[row][col] = val;
    }
   
}

// tc: O(V+ E) + O (V x E) or  (n + m) + (m * n)
// scc : O(1)