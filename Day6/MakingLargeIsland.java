class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);

        // step -1  - >>> connecting components
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n ; j++){
                if(grid[i][j] == 0) continue;

                int [] di = {-1, 0, 1 , 0};
                int [] dj = {0, -1, 0, 1};

                for(int k = 0; k < 4; k++){
                    int newRow = i + di[k];
                    int newCol = j + dj[k];

                    if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1){
                        int adjNode = i * n + j;
                        int adjNodeNo = newRow * n + newCol;

                        ds.UnionBySize(adjNode, adjNodeNo);
                    }
                }
            }
        }


        // step -2 converting 0's
        int mx = 0;
        for(int i = 0 ; i < n; i++){
            for(int j =0 ; j < n; j++){
                if(grid[i][j] == 1) continue;

                int []di = {-1, 0, 1 , 0};
                int [] dj = {0, -1, 0, 1};
                HashSet<Integer>component = new HashSet<>();
                for(int k = 0; k < 4; k++){
                    int newRow = i + di[k];
                    int newCol = j + dj[k];
                    

                    if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < n ){
                        if(grid[newRow][newCol] == 1) {
                            int adjNodeNo = newRow * n + newCol;

                            component.add(ds.findUPar(adjNodeNo));
                        } 
                    }   
                }
                int sizeTotal = 0;
                for(Integer parent : component){
                    sizeTotal += ds.size.get(parent);
                }

                mx = Math.max(mx, sizeTotal + 1);
            }
        }


        // step 3 
        // edge case

        for(int cell = 0; cell < n * n; cell++){
            mx = Math.max(mx, ds.size.get(ds.findUPar(cell)));
        }

        return mx;
    }
}

class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

        DisjointSet(int n ){
            for(int i = 0 ; i < n ; i++){
                parent.add(i);
                size.add(1);
            }
        }

        int findUPar(int node){
            if(node == parent.get(node)) return node;

            int ulp = findUPar(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }


        void UnionBySize(int u , int v){
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);

            if(ulp_u == ulp_v) return;


            if(size.get(ulp_u) < size.get(ulp_v)){
                parent.set(ulp_u , ulp_v);
                size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
            }
            else{
                parent.set(ulp_v , ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
            }
        }
    
}

// TC: O(n ^ 2)
