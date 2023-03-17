class Solution {

    public int findCircleNum(int[][] isConnected) {

        DisjointSet ds = new DisjointSet(isConnected.length);

        for(int i = 0 ; i < isConnected.length; i++){
            for(int j =0; j < isConnected[0].length; j++){
                if(i != j && isConnected[i][j] == 1){
                    ds.UnionBySize(i , j);
                }
            }
        }
        
        int count = 0;
        for(int i = 0; i < isConnected.length; i++){
            if(ds.parent.get(i) == i) count++;
        }

        return count;
       
    }
}

class DisjointSet {
    public List<Integer> parent = new ArrayList<>();
    public List<Integer> size = new ArrayList<>();
    public List<Integer> rank = new ArrayList<>();
    
    public DisjointSet (int n){
        for(int i = 0; i <= n; i++){
            size.add(1);
            parent.add(i);
        }
    }
    
    public int findUPar (int node){
        if(node == parent.get(node)) return node;
        
        int ulp = findUPar(parent.get(node));
        // compression
        parent.set(node, ulp);
        
        return parent.get(node);
    }
    
    public void UnionBySize (int u , int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        
        if(ulp_u == ulp_v) return;
        
        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u , ulp_v);
            size.set(ulp_v , size.get(ulp_v) + size.get(ulp_u));
        }
        else{
            parent.set(ulp_v , ulp_u);
            size.set(ulp_u , size.get(ulp_v) + size.get(ulp_u));
        }
    }
    
    public void UnionByRank (int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        
        if(ulp_u == ulp_v) return;
        
        if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u , ulp_v);
            
        }
        
        else if(rank.get(ulp_v) < rank.get(ulp_u)){
            parent.set(ulp_v, ulp_u);
        }
        else{
            parent.set(ulp_u , ulp_v);
            rank.set(ulp_u , rank.get(ulp_u) + 1 );
        }
    }
}
