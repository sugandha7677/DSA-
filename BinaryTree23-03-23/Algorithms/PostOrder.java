// Recursive Approach

public class PostOrder {
    void postOrder(Node root) {
        if(root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }
}

// TC: O(n)

// Using 2 stack

void postOrder(Node root){
    Stack<Node> s1 = new Stack<>();
    Stack<Node> s2 = new Stack<>();
    
    if(root == null) return;
    s1.push(root);
    
    while(!s1.isEmpty()){
        Node node = s1.peek();
        s1.pop();
        s2.push(node);
        
        if(node.left != null) s1.push(node.left);
        if(node.right != null) s2.push(node.right);
    }
    
    while(!s2.isEmpty()){
        System.out.println(s2.pop());
    }
}

// TC: O(n)
// SC: O(2n)


// Using single Stack



