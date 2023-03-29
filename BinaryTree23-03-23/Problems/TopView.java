package DSA-.BinaryTree23-03-23.Problems;

public class TopView {
    
    static ArrayList<Integer> topView(Node root)
    {
    
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        q.add(new Pair(root, 0));
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            Node node = p.node;
            int x = p.row;
            
            if(map.get(x) == null)
                map.put(x , node.data);
                
            if(node.left != null){
                q.add(new Pair(node.left , x - 1));
            }
            if(node.right != null)
                q.add(new Pair(node.right , x + 1));
        }
        
       
        for(Map.Entry<Integer,Integer> y : map.entrySet()){
            ans.add(y.getValue());
        }
        
        return ans;
        
    }
}

class Pair{
    Node node;
    int row;
    
    Pair(Node node , int row){
        this.node = node;
        this.row = row;
    }
}

//TC:O(n)
//SC:O(n)
