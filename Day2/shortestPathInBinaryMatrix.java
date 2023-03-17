class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        if(grid[0][0] == 1) return -1;

        
        int [] source = {0, 0};
        int [] destination =  {grid.length - 1, grid.length -1};

        int [][]distance = new int [grid.length][grid[0].length];
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                distance[i][j] = (int)(1e9);
            }
        }
        
        distance[source[0]][source[1]] = 0;
        
        int []di = {-1, 0, +1, 0, -1 , +1, -1, +1 };
        int []dj = {0, -1, 0, +1, -1 , -1, +1, +1};
        
        Queue<tuple>q = new LinkedList<>();
        
        
        q.add(new tuple(1 , source[0], source[1]));
        
        while(!q.isEmpty()){
            tuple p = q.remove();
            
            if(p.i == destination[0] && p.j == destination[1]){
                return p.dist;
            }
            
            for(int k = 0; k < 8; k++){
                int ni = p.i + di[k];
                int nc = p.j + dj[k];
                
                if(ni >= 0 && ni < grid.length && nc >= 0 &&  nc < grid[0].length 
                && grid[ni][nc] == 0){
                    if(p.dist + 1 < distance[ni][nc]){
                        distance[ni][nc] = p.dist + 1;
                        q.add(new tuple (distance[ni][nc], ni , nc));
                    }
                }
            }
        }
        
        return -1;
    }
}

class tuple {
    int dist;
    int i;
    int j;
    
    tuple(int dist, int i, int j ){
        this.dist = dist;
        this.i = i;
        this.j = j;
    }
}

// TC: O(E log V) 
// n x m x 8
