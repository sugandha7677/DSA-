// Recursive solution

void preOrder(Node root) {
    if(root == null) return;

    System.out.print(root.data + " ");
    preOrder(root.left);
    preOrder(root.right);
}

//TC: O(n) n = no. of nodes


// Iterative way
// use stack of Node , store root , pop & print and then push first its right child then left

void preOrder(Node root) {
    if(noot == null ) return;
    
    Stack<Node> st = new Stack<>();
    st.push(root);

    while(!st.isEmpty()) {
        Node top = st.peek();
        System.out.println(st.pop);
    
        if(top.right != null) st.push(top.right);
        if(top.left != null) st.push(top.left); 
    }
    
}   

// Tc: O(n)
// SC: O(n) or O(height of BT)
