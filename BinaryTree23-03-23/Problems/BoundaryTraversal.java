package DSA-.BinaryTree23-03-23.Problems;

public class BoundaryTraversal {
    ArrayList <Integer> boundary(Node node)
	{
	    ans = new ArrayList<>();
	    if( isLeaf(node) == false) ans.add(node.data);
	    addLeafBoundary(node);
	    addLeaves(node);
	    addRightBoundary(node);
	    return ans;
	}
	
	public void addLeafBoundary(Node node){
	    Node curr = node.left;
	    while(curr != null){
	        if(isLeaf(curr) == false) ans.add(curr.data);
	        if(curr.left != null) curr = curr.left;
	        else curr = curr.right;
	    }
	}
	
	public void addLeaves(Node node){
	    if(isLeaf(node)){
	        ans.add(node.data);
	        return;
	    }
	    if(node.left != null) addLeaves(node.left);
	    if(node.right != null) addLeaves(node.right);
	}
	
	public void addRightBoundary(Node node){
	    Node curr = node.right;
	    ArrayList<Integer>list = new ArrayList<>();
	    while(curr != null){
	        if(isLeaf(curr) == false) list.add(curr.data);
	        if(curr.right != null) curr = curr.right;
	        else curr = curr.left;
	    }
	    
	    for(int i = list.size() - 1; i >= 0 ; i--){
	        ans.add(list.get(i));
	    }
	}
	
	public boolean isLeaf(Node node){
	    if( node.left == null && node.right == null) return true;
	    else return false;
	}
}

//TC: O(H) + O(H) + O(n) = O(n)
//SC: O(N)
