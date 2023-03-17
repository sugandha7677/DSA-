// Brute force dfs logic

class Solution {
    public int shortestBridge(int[][] grid) {
        
        Queue<pair> q = new LinkedList<>();

        int [][]visited = new int [grid.length][grid[0].length];
        boolean flag = false;
        for(int i = 0; i < grid.length && !flag; i++){
            for(int j = 0; j < grid[i].length && !flag; j++){
                if(grid[i][j] == 1){
                    dfs(i, j, q, grid, visited );
                    flag = true;
                }
            }
        }

        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();

            while(size-- > 0){
                pair p = q.remove();
                for(int i = 0; i < 4; i++){
                    int newRow = p.row + di[i];
                    int newCol = p.col + dj[i];

                    if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && visited[newRow][newCol] != 1) {

                        if(grid[newRow][newCol] == 1) return level;
                        q.add(new pair(newRow, newCol));

                        visited[newRow, newCol] = 1;
                        
                    }
                }
            }
            level++;
        }

        return -1;
    }

    int []di = {-1, 0 , 1, 0};
    int []dj = {0, -1, 0, 1};

    void dfs(int row , int col, Queue<pair>q, int [][]grid, int [][]visited){
        visited[row][col] = 1;
        q.add(new pair(row, col));

        for(int i = 0; i < 4; i++){
            int newRow = row + di[i];
            int newCol = col + dj[i];

            if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == 1) {
                if(visited[newRow][newCol] != 1) {
                        dfs(newRow, newCol, q, grid, visited);
                }
            }
        }
        
    }
}

class pair{
    int row;
    int col;

    pair(int row, int col){
        this.row = row;
        this.col = col;
    }

}

// TC: O(n * m ) + o (n^2)
//SC: O(n*m )+ O(n*m)

