class Solution {

    int numberOfEnclaves(int[][] grid) {

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(i == 0 || j == 0 || i == grid.length - 1 || j == grid[i].length - 1){
                    if(grid[i][j] == 1) {
                        dfs(i, j , grid);
                    }
                }
            }
        }
        
        int count = 0;
        for(int i = 0 ; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) count++;
            }
        }
        
        return count;
    }
    
    int []di = {-1, 0, 1, 0 };
    int []dj = {0, 1, 0 ,-1 };
    
    void dfs(int row, int col , int [][]grid){
        grid[row][col] = 0;
        
        for(int i = 0; i < 4; i++){
            int newRow = row + di[i];
            int newCol = col + dj[i];
            
            if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length){
                if(grid[newRow][newCol] == 1) dfs(newRow, newCol, grid);
            }
        }
    }
}

//TC: O(n * m ) * o (v + e)
//SC : O (1)

// in case of 2d matrix v == e == n^2
