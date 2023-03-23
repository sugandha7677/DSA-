void preOrder(Node root) {
    if(node == root) return;

    System.out.print(root.data + " ");
    preOrder(root.left);
    preOrder(root.right);
}

//TC: O(n) n = no. of nodes
