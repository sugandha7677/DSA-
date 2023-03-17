class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
         ArrayList<ArrayList<pair>>adj = new ArrayList<>();
        
        for(int i =0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0 ; i < flights.length; i++){
            adj.get(flights[i][0]).add(new pair(flights[i][1], flights[i][2]));
        }
        
        int []distance = new int [n];
        
        for(int i =0; i < n; i++){
                distance[i] = (int)(1e9);
        }
        
        distance[src] = 0;
        
        Queue<tuple> q = new LinkedList<>();
        q.add(new tuple(0 , src, 0));
        
        while(!q.isEmpty()){
            tuple t = q.remove();
            
            if(t.stops > k) continue;
            
            for(pair p : adj.get(t.node)){
                if(t.dist + p.cost < distance[p.nbr]){
                    distance[p.nbr] =  t.dist + p.cost;
                    q.add(new tuple(t.stops + 1, p.nbr, distance[p.nbr]));
                }
            }
        }
        
        if(distance[dst] == 1e9) return -1;
        return distance[dst];
        
    }
}

class pair {
    int nbr;
    int cost;
    
    pair(int nbr, int cost){
        this.nbr = nbr;
        this.cost = cost;
    }
}

class tuple{
    int stops;
    int node;
    int dist;
    
    tuple(int stops, int node, int dist){
        this.stops = stops;
        this.node = node;
        this.dist = dist;
    }
}

// TC: E --> flights.length
