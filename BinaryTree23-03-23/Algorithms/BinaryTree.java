public class BinaryTree {
    
    int idx = -1;

    Node buildTree(int edges[]){
        idx++;

        if(edges[idx] == -1) return null;

        Node newNode = new Node(edges[idx]);
        newNode.left = buildTree(edges);
        newNode.right = buildTree(edges);

        return newNode;
    }
}

class Node {
    int data; 
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;

    }
}
