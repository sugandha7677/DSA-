class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int []dist = new int [V];
        
        for(int i = 0; i < V; i++) dist[i] = (int)1e8;
        dist[S] = 0;
        
        // do relaxation (n-1) times
        for(int i = 0; i <= V-1; i++){
            for(ArrayList<Integer>nbr : edges){
                int src = nbr.get(0);
                int dest = nbr.get(1);
                int wt = nbr.get(2);
                
                if(dist[src] != 1e8 && dist[src] + wt < dist[dest]){
                    dist[dest] = dist[src] + wt ;
                }
            }
        }

        // return dist;


        // if givent --> in case of  -ve cycle return arr -1
        
        // for this we need to do one more relaxation
        for(ArrayList<Integer>nbr : edges){
            int src = nbr.get(0);
            int dest = nbr.get(1);
            int wt = nbr.get(2);
            if(dist[src] != 1e8 && dist[src] + wt < dist[dest]){ // -ve cycle exist
                int [] temp = {-1 };
                return temp;
            }
        }
        
        return dist;
    }
}

// TC: O(E X V) -> quadratic . dij: E log V