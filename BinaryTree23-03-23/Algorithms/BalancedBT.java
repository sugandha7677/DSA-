//Naive
public class BalancedBT{
    boolean isBalanced(Node root){
        if(root == null) return true;
        
        int lh = height(root.left);
        int rh = height(root.right);

        if(Math.abs(lh - rh) > 1) return false;

        Boolean left = isBalanced(root.left);
        Boolean right = isBalanced(root.right);

        if(!left || !right) return false;

        return true;
    }

    int height(Node root){
        if(root == null ) return 0;

        return 1 + Math.max(height(root.left), height(root.right));

    }
}


//TC: O(n) x O(n) = O(n ^ 2)


//Better

public class BalancedBT {
    
    boolean isBalanced(Node root){
        return height(root) != -1;
    }

    int height(Node root){

        if(root == null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        if(lh == -1 || rh == -1) return -1;

        if(Math.abs(lh - rh) > 1) return -1;

        return 1 + Math.max(lh, rh);
    }
}

// TC: 0(n)
