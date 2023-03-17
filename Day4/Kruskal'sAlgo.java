

// User function Template for Java

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    
	    // Code Here. 
	    
	    List<Edge> list = new ArrayList<>();
	    
	    for(int i = 0; i < E; i++){
	        int src = edges[i][0];
	        int dest = edges[i][1];
	        int wt = edges[i][2];
	        
	        list.add(new Edge(src , dest, wt));
	    }
	    
	    Collections.sort(list);
	    
	    DisjointSet ds = new DisjointSet(V);
	    
	    int mstWt = 0;
	    
	    for(int i = 0; i < list.size(); i++){
	        int w = list.get(i).wt;
	        int node = list.get(i).src;
	        int nbr = list.get(i).dest;
	        
            // not in same components 
	        if(ds.findUPar(node) != ds.findUPar(nbr)){
	            mstWt += w;
	            ds.UnionBySize(node, nbr);
	        }
	            
	    }
	    
	    return mstWt;
	}
}


class Edge implements Comparable <Edge>{
    int src;
    int dest;
    int wt;
    
    public Edge(int src , int dest, int wt){
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }
    
    public int compareTo(Edge o){
        return this.wt - o.wt;
    }
}


class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    
    public DisjointSet (int n){
        for(int i =0; i <= n; i++){
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
}

//TC : o(N + E) + M log M + O(M x 4alpha x 2)