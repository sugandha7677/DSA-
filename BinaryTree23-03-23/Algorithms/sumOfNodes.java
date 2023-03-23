public class sumOfNodes {
    
    int sumOfNodes(Node root) {
        if(root == null) return 0;

        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);

        return leftSum + rightSum + root.data;
    }
}

//TC: 0(n)
