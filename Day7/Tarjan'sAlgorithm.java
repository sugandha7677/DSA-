// critical connections

class Solution {
    int timer = 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(List<Integer> l : connections){
            int u = l.get(0);
            int v = l.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        
        int [] visited = new int[n];
        int [] disc = new int [n];
        int [] low = new int [n];

        List<List<Integer>> bridges = new ArrayList<>();

        dfs(adj, 0 , -1,  bridges, visited, disc, low);

        return bridges;
    }

   
    public void dfs(ArrayList<ArrayList<Integer>>adj , int node,  int parent,
                        List<List<Integer>>bridges , int [] visited, 
                        int []disc, int []low ) {


            visited[node] = 1;
            disc[node] = low[node] = timer;
            timer++;

            for(Integer it : adj.get(node)){
                if(it == parent) continue;

                if(visited[it] == 0){
                    dfs(adj, it, node, bridges, visited, disc, low);

                    low[node] = Math.min(low[node], low[it]);

                    if(low[it] > disc[node]){
                        bridges.add(Arrays.asList(it, node));
                    }
                }
                else{
                    low[node] = Math.min(low[node], low[it]);
                }
            }
    }
}

 // TC: O(v + e)
 // SC: O(v + 2E) + O(3N)