class Solution
{
    //Function to return Breadth First Traversal of given graph.
    int timer =1;
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        
        int [] visited = new int [V];
        int [] disc = new int [V];
        int [] low = new int [V];
        int [] artipoint = new int[V];
        
        
        for(int i = 0; i < V; i++){
            if(visited[i] == 0) dfs(i, -1, adj, visited, disc, low, artipoint);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < V; i++){
            if(artipoint[i] == 1) ans.add(i);
        }
        
        if(ans.size() == 0) ans.add(-1);
        return ans;
    }
    
    public void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj , int []visited,
                    int [] disc, int [] low, int [] artipoint) {
        
        visited[node] = 1;
        disc[node] = low[node] = timer;
        timer++;
        int child = 0;
        for(Integer it : adj.get(node)){
            if(it == parent) continue;
            
            if(visited[it] == 1){
                low[node] = Math.min(low[node] , disc[it]);
            }
            else{
                dfs(it, node, adj, visited, disc, low, artipoint);
                low[node] = Math.min(low[node], low[it]);
                
                if(low[it] >= disc[node] && parent != -1) {
                    artipoint[node] = 1;
                }
                child++;
            }
        }
        
        if(child > 1 && parent == -1) artipoint[node] = 1;
    } 
}

// SC: O(3V)
// TC: O(V + 2E)
