public class PostOrder {
    void postOrder(Node root) {
        if(root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }
}

// TC: O(n)