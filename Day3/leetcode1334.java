// FloydnWarshall Algo

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int cost [][] = new int[n][n];

        for(int [] e : cost) Arrays.fill(e, (int)1e9);
        for(int i = 0; i < n ; i++) cost[i][i] = 0;

        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            cost[u][v] = wt;
            cost[v][u] = wt;
        }

        for(int via = 0; via < n; via++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    // if not reachable, no need to consider
                    if(cost[i][via] == 1e9 || cost[via][j] == 1e9)
                        continue;
                    
                    cost[i][j] = Math.min(cost[i][j] , cost[i][via] + 
                                            cost[via][j]);
                }
            }
        }

        int cntCity = n;
        int cityNo = -1;

        for(int city = 0 ; city < n; city++){
            int cnt =0;
            for(int adjCity = 0; adjCity < n; adjCity++){
                if(cost[city][adjCity] <= distanceThreshold) cnt++;
            }

            if(cnt <= cntCity){
                cntCity = cnt;
                cityNo = city;
            }
        }
        return cityNo;
    }
}

//TC: o(n ^ 3)


// Dijkshtra Algo
for(int i = 0; i < n; i++){
    // dijkstra() // TC: N x E log V
    // bellman() // N x V
}

