class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    
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

// TC: O(4(alpha))