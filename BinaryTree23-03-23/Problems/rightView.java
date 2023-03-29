
public class rightView {
    
    ArrayList<Integer>list = new ArrayList<>();
    
    ArrayList<Integer> rightView(Node node) {
        
        preorderReverse(node, 0);
        return list;
    }
    
    void preorderReverse(Node root , int level) {
        if(root == null) return;
        
        if(level == list.size()) list.add(root.data);
        
        preorderReverse(root.right, level + 1);
        preorderReverse(root.left, level + 1);
    }
}

//TC: O(N)
//SC: O(height) recursion stack
