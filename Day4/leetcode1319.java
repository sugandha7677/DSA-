public class Solution {
    public int makeConnected(int n, int[][] connections) {
        
        DisjointSet ds = new DisjointSet(n);

        int extraEdges = 0;
        for(int i = 0; i < connections.length; i++){
            int u = connections[i][0];
            int v = connections[i][1];

            if(ds.findUPar(u) == ds.findUPar(v)) extraEdges++;

            else  ds.UnionBySize(u, v);
        }

        int cntComp = 0;
        for(int i = 0; i < n; i++){
            if(ds.parent.get(i) == i) cntComp++;
        }

        if(extraEdges >= cntComp - 1) return cntComp - 1;
        else return -1;
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
