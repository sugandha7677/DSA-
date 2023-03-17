class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        

        // sc: O(2V)
        int [] visited = new int [V];
        Arrays.fill(visited, 0);
        
        Stack<Integer> st = new Stack<>();
        //O(V + E)
        for(int i = 0; i < V; i++){
            if(visited[i] == 0) dfs(adj, visited, st , i);
        }
        
        // step 2 reverse the graph
        //SC: O(v + E)
        ArrayList<ArrayList<Integer>>adjR = new ArrayList<>();
        for(int i= 0; i < V;i++){
            adjR.add(new ArrayList<>());
        }
        
        for(int i =0; i < adj.size(); i++){
            visited[i] = 0;
            for(int nbr : adj.get(i)){
                adjR.get(nbr).add(i);
            }
        }
        
        // step 3 do the dfs according to finishing time
        int scc = 0;
        
        while(!st.isEmpty()){
            int node = st.peek();
            st.pop();
            
            if(visited[node] == 0) {
                scc++;
                dfsR(adjR, visited, node);
            }
        }
        
        return scc;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>>adj , int [] visited, Stack<Integer>st,
    int src){
        
        visited[src] = 1;
        //O(V + E)
        for(int nbr: adj.get(src)){
            if(visited[nbr] == 0) dfs(adj, visited, st, nbr);
        }
        
        st.push(src);
    }
    
    public void dfsR(ArrayList<ArrayList<Integer>> adj, int []visited, int src){
        visited[src] = 1;
        //O(V + E)
        for(int nbr: adj.get(src)){
            if( visited[nbr] == 0) dfsR(adj, visited,  nbr);
        }
    }
}

// TC: O(V + E) * 3

//SC : O(2V) + O(V+ E)
