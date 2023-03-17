class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        int [][]distance = new int [heights.length][heights[0].length];
        for(int i =0; i < heights.length; i++){
            for(int j = 0; j < heights[0].length; j++){
                distance[i][j] = (int)(1e9);
            }
        }
        distance[0][0] = 0;
        
        PriorityQueue<tuple> pq = new PriorityQueue<>((x,y) -> x.diff - y.    diff);
        pq.add(new tuple(0 , 0, 0));
        
        int [] di = {-1, 0, +1, 0 };
        int [] dj = {0, -1, 0, +1 };
        
        while(!pq.isEmpty()){
            tuple t = pq.remove();
            
            if(t.i == heights.length - 1 && t.j == heights[0].length - 1 ) return t.diff;
            
            for(int k =0 ; k < 4; k++){
                int ni = t.i + di[k];
                int nc = t.j + dj[k];
                
                if(ni >= 0 && ni < heights.length && nc >= 0 && nc < heights[0].length){
                    
                    int newEffort = Math.max(t.diff , Math.abs(heights[t.i][t.j] - 
                                                heights[ni][nc]));
                    
                    if( newEffort <  distance[ni][nc]){
                        distance[ni][nc] = newEffort;
                        pq.add(new tuple(distance[ni][nc] , ni , nc));
                    }                   
                }
            }
        }
        
        return 0;
    }
}

class tuple {
    int diff;
    int i;
    int j;
    
    tuple(int diff, int i, int j){
        this.diff = diff;
        this.i = i;
        this.j = j;
    }
}

//TC : E log V  E = n X m X 4  V  = n X m
// n x m x 4 x log(n x m)