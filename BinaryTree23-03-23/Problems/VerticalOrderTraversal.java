import java.util.PriorityQueue;
import java.util.TreeMap;

// using inorder traversal
public class VerticalOrderTraversal {
    TreeMap<Integer, TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
    ArrayList<Integer> VerticalOrderTraversal(Node root){
        
        
        inOrder(root, 0 , 0);

        List<List<Integer>>ans = new ArrayList<>();
        for(TreeMap<Integer , PriorityQueue<Integer>> y : map.values()){
            List<Integer>subList = new ArrayList<>();
            for(PriorityQueue<Integer> nodes : y.values()){
                while(!nodes.isEmpty()){
                    subList.add(nodes.poll());
                }
            }
            ans.add(subList);
        }
        return ans;

    }

    void inOrder(Node root, int x, int l){
        if(root == null ) return;


        inOrder(root.left, x - 1, l +1);

        Node node = root;
        int nx = x;
        int nl = l;

        if(!map.containsKey(nx)) {
            map.put(nx , new TreeMap<>());
        }

        if(!map.get(nx).containsKey(nl)) map.get(nx).put(nl , new PriorityQueue<>());

        map.get(nx).get(nl).add(nl, root.val);

        inOrder(root.right, x + 1, l + 1);
    }


}

class Tuple{
    Node node;
    int x;
    int l;

    Tuple(Node node, int x, int l){
        this.node = node;
        this.x = x;
        this.l = l;
    }
}

// TC: O(n log n)
//SC: O(n) + O(n)
