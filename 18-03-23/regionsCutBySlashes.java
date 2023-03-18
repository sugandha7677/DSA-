class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;

        int dots = n + 1;
        DisjointSet ds = new DisjointSet(dots * dots);

        

        // connecting boundary dots to 0
        for(int i = 0; i < dots; i++){
            for(int j = 0; j < dots; j++){
                if(i == 0 || j == 0 || i == dots - 1 || j == dots - 1){
                    int cellNum= i * dots + j;
                    ds.UnionBySize(0 , cellNum);
                }
            }
        }


        // travel on grid
        for(int i = 0; i < grid.length; i++){
            char [] ch = grid[i].toCharArray();
            for(int j = 0; j < ch.length; j++){
                if(ch[j] == '/'){
                    int cellNo1 = i * dots + j + 1;
                    int cellNo2 = (i +1) * dots + j;
                    ds.UnionBySize(cellNo1, cellNo2);
                }
                else if(ch[j] ==  '\\'){
                    int cellNo1 = i * dots + j;
                    int cellNo2 = (i + 1) * dots + j + 1;
                    ds.UnionBySize(cellNo1, cellNo2);
                }
            }
        }

        return ds.count;
    }
}

class DisjointSet {
    List<Integer>parent = new ArrayList<>();
    List<Integer>size = new ArrayList<>();
    int count = 0;

    DisjointSet(int n){
        for(int i = 0; i < n; i++){
            parent.add(i);
            size.add(1);
        }
    }

    int findUPar(int node){
        if(node == parent.get(node)){
            return node;
        }

        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    void UnionBySize(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if(ulp_u == ulp_v) {
            count++; 
            return;
        }

        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u , ulp_v);
            size.set(ulp_v , size.get(ulp_u) + size.get(ulp_v));
        }else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u)+size.get(ulp_v));
        }
    }
}

// tc: O(n + 1 * n + 1) +   O(n * n)
// sc : O  2(n + 1 *  n + 1) // parent , size arrayList
