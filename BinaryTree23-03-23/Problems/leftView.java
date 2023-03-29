

public class leftView {
    ArrayList<Integer>list = new ArrayList<>();
    ArrayList<Integer> leftView(Node root)
    {
      
      
      preorder(root, 0);
      return list;
      
    }
    
    void preorder(Node root , int level) {
        if(root == null) return;
        
        if(level == list.size()) list.add(root.data);
        
        preorder(root.left, level + 1);
        preorder(root.right, level + 1);
    }
}

//TC: O(N)
//SC: O(height) recursion stack
