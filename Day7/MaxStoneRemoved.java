class Solution {
    public int removeStones(int[][] stones) {

        // figure out the dimesion of grid
        int row = 0;
        int col = 0;
        for(int i = 0; i < stones.length; i++){
            row = Math.max(row , stones[i][0]);
            col = Math.max(col , stones[i][1]);
        }
        DisjointSet ds = new DisjointSet(row + col + 1);
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int [] i : stones){
            int nodeRow = i[0];
            int nodeCol = i[1] + row + 1;

            ds.UnionBySize(nodeRow, nodeCol);

            map.put(nodeRow, 1);
            map.put(nodeCol , 1);

        }

        int cnt = 0;
        for(Map.Entry<Integer, Integer> m : map.entrySet()){
            if(ds.findUPar(m.getKey()) == m.getKey()) cnt++;
        }
        
        return stones.length -  cnt;
    }
}

class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    DisjointSet(int n ){
        for(int i = 0; i <= n; i++){
            parent.add(i);
            size.add(1);
        }
    }

    int findUPar(int node){
        if(node == parent.get(node)) return node;

        int ulp = findUPar(parent.get(node));
        parent.set(node , ulp);

        return parent.get(node);
    }

    void UnionBySize(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if(ulp_u == ulp_v) return;

        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u , ulp_v);
            size.set(ulp_v , size.get(ulp_u) + size.get(ulp_v));
        }
        else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u , size.get(ulp_u) + size.get(ulp_v));
        }
    }
}