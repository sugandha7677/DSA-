class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    
	    // Code Here.
	    ArrayList<ArrayList<pair>> adj = new ArrayList<>();
	    
	    for(int i =0; i < V; i++){
	        adj.add(new ArrayList<pair>());
	    }
	    
	    for(int i = 0; i < E; i++){
	        int src = edges[i][0];
	        int wt = edges[i][2];
	        int nbr = edges[i][1];
	        
	        adj.get(src).add(new pair(nbr , wt));
	        adj.get(nbr).add(new pair(src , wt));
	    }
	    
	    
	    PriorityQueue<pair> pq = new PriorityQueue<>((x,y) -> x.wt - y.wt);
	    
	    pq.add(new pair(0, 0));
	    
	    int sum = 0;
	    
	    int[] visited = new int[V];
	    
	    // E log E
	    while(!pq.isEmpty()){
	        // log E
	        pair p = pq.remove();
	        
	        if(visited[p.node] == 1) continue;
	        
	        sum += p.wt;
	        
	        
	        visited[p.node] = 1;
	        
	        // E log E
	        for(pair nbr : adj.get(p.node)){
	            if(visited[nbr.node] != 1) pq.add(new pair(nbr.node, nbr.wt));
	        }
	    }
	    
	    return sum;
	    
	}
}

class pair {
    int node;
    int wt;
    
    pair(int node, int wt){
        this.node = node;
        this.wt = wt;
    }
}

// TC: E log E + E log E

