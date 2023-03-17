class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<pair>>adj = new ArrayList<>();

        for(int i= 0 ; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < roads.length; i++){
            adj.get(roads[i][0]).add(new pair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new pair(roads[i][0], roads[i][2]));
        }

        int time[] = new int [n];
        int ways[] = new int [n];

        for(int i = 0; i < n; i++){
            time[i] = Integer.MAX_VALUE; 
            ways[i] = 0;
        }

        time[0] = 0;
        ways[0] = 1;
        int mod = (int)(1e9 + 7);

        PriorityQueue<pair> pq = new PriorityQueue<>((x, y)-> x.ti - y.ti);

        pq.add(new pair(0, 0));
        while(!pq.isEmpty()){
            pair p = pq.remove();

            for(pair nbr : adj.get(p.node)){
                if(p.ti + nbr.ti < time[nbr.node]){
                    time[nbr.node] = p.ti + nbr.ti;
                    ways[nbr.node] = ways[p.node];
                    pq.add(new pair(nbr.node, time[nbr.node]));
                }
                else if(p.ti + nbr.ti == time[nbr.node]){
                    ways[nbr.node] = ( ways[nbr.node] + ways[p.node]) % mod;
                }
            }
        }
        return ways[n-1] % mod;
    }
}

class pair{
    int node;
    int ti;

    pair(int node, int ti){
        this.node = node;
        this.ti = ti;
    }
}
