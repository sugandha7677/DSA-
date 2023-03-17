class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        
        PriorityQueue<pair>pq = new PriorityQueue<>((x,y) -> x.distance - y.distance);
        
        int []dist = new int[adj.size()];
        
        for(int i = 0; i < dist.length; i++) dist[i] = (int)(1e9);
        
        dist[S] = 0;
        pq.add(new pair(0, S));
        
        while(!pq.isEmpty()){
            pair p = pq.remove();
            
            int dt = p.distance;
            int node = p.node;
            
            for(ArrayList<Integer> nbr : adj.get(node)){
                int n = nbr.get(0);
                int d = nbr.get(1);
                
                if(dt + d < dist[n]){
                    dist[n] = dt + d;
                    pq.add(new pair(dist[n], n));
                }
            }
        }
        
        return dist;
        
    }
}

class pair {
    int distance;
    int node;
    
    pair(int distance, int node){
        this.distance = distance;
        this.node = node;
    }
}

// TC: O(E log V)
