public class InorderTraversal {
    
    void inOrder(Node root) {
        if(root == null) return;

        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }
}

//TC: O(n)
