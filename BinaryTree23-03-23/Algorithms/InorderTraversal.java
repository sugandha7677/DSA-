public class InorderTraversal {
    
    void inOrder(Node root) {
        if(root == null) return;

        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }
}

//TC: O(n)

// Iterative way
// push root into node -> go to left -> if(null) -> pop, print and go to right
//            else push in stack and move to left

void inOrder(Node root){
    Stack<Node> st = new Stack<>();

    Node node = root;
    while(true){
        if(node != null){
            st.push(node);
            node = node.left;
        }else{
            if(st.IsEmpty()){
                break;
            }
            
            Node n = st.pop();
            System.out.println(n.data);
            node = node.right;
        }
    }
}

//TC: O(n) height of tree
// why ?? take case having left node only, it goes on pushing and node.left

