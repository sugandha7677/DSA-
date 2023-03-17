class Solution {
    
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        
        DisjointSet ds = new DisjointSet(rows * cols);
        
        int [][]visited = new int[rows][cols];
        int cnt = 0;
        List<Integer>ans = new ArrayList<>();
        
        for(int i =0 ; i < operators.length; i++){
            int row = operators[i][0];
            int col = operators[i][1];
            
            if(visited[row][col] == 1){
                ans.add(cnt);
                continue;
            }
            
            visited[row][col] = 1;
            cnt++;
            
            int []di = {-1, 0, +1, 0};
            int []dj = {0, -1, 0, +1};
            
            for(int k = 0; k < 4; k++){
                int newRow = row + di[k];
                int newCol = col + dj[k];
                
                if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols){
                    if(visited[newRow][newCol] == 1){
                        // converting row,col to node number coz dsu stores node not(cel, row)
                        // decusing cell no from row, col
                        int adjNode = row * cols + col;  // base node
                        int adjNodeNo = newRow * cols + newCol; // adj (4 sided node of base node)
                        
                        if(ds.findUPar(adjNode) != ds.findUPar(adjNodeNo)){
                            cnt--;
                            ds.UnionBySize(adjNode , adjNodeNo);
                        }
                    }
                }
            }
            
            ans.add(cnt);
        }
        
        
        return ans;
    }
    
}

class DisjointSet {
    List<Integer>parent = new ArrayList<>();
    List<Integer>size =  new ArrayList<>();
    
    DisjointSet(int n ){
        for(int i =0; i <= n; i++){
            parent.add(i);
            size.add(1);
        }
    }
    
    int findUPar(int node){
        if(node == parent.get(node)) return node;
        
        int ulp = findUPar(parent.get(node));
        
        parent.set(node , ulp);
        return parent.get(node);
    }
    
    void UnionBySize(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        
        if(ulp_u == ulp_v) return;
        
        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        }
        else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u , size.get(ulp_u) + size.get(ulp_v));
        }
        
    }
}