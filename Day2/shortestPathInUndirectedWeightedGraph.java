class Solution {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        // code here
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        
        for(int i = 0; i <= n ;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int  i = 0; i < m; i++){
            adj.get(edges[i][0]).add(new pair (edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new pair (edges[i][0], edges[i][2]));
        }
        
        
        int dist[] = new int [n+1];
        int parent[] = new int [n+1];
        
        for(int i = 1 ;i <= n; i++){
            dist[i] = (int)(1e9);
            parent[i] = i;
        } 
        
        dist[1] = 0;
        
        PriorityQueue<pair>pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        pq.add(new pair(1, 0));

        
        while(!pq.isEmpty()){
            pair p = pq.remove();

            for(pair nbr: adj.get(p.node)){
                if(p.distance + nbr.distance < dist[nbr.node]){
                    dist[nbr.node] = p.distance + nbr.distance;
                    pq.add(new pair(nbr.node, dist[nbr.node]));
                    parent[nbr.node] = p.node;
                }
            }
        }
        
        List<Integer> list = new ArrayList<>();
        
        if(dist[n] == 1e9){
            list.add(-1);
            return list;
        }
        
        int node = n;
        // O(N)
        while(parent[node] != node){
            list.add(node);
            node = parent[node];
        }
        list.add(1);
        Collections.reverse(list);
        return list;
        
    }
}

class pair{
    int distance;
    int node;
 
    pair(int node, int distance){
        this.distance = distance;
        this.node = node;
    }
}

// TC : O(Elog V) + O(n) // backtracking
// log(n)

