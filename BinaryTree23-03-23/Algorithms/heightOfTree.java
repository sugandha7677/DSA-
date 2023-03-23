public class heightOfTree {
    
    int heightOfTree(Node root) {
        if(root == null) return 0;

        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}

//TC: O(n)
