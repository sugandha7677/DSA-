package DSA-.BinaryTree23-03-23.Problems;

public class ZigZagTraversal {
    ArrayList<Integer> zigZagTraversal(Node root)
	{
	    //Add your code here.
	    ArrayList<Integer> ans = new ArrayList<>();
	    Queue<Node> q = new LinkedList<>();
	    q.add(root);
	    int flag = 0;
	    
	    while(!q.isEmpty()){
	        int size = q.size();
	        ArrayList<Node> helper = new ArrayList<>();
	        
	        while(size-- > 0){
	            Node top = q.remove();
	            helper.add(top);
	            
	            if(top.left != null ) q.add(top.left);
	            if(top.right != null) q.add(top.right);
	            
	        }
	        
	        if(flag == 0){
	            for(int i = 0; i < helper.size(); i++){
	                ans.add(helper.get(i).data);
	            }
	            flag = 1;
	        }
	        else{
	            for(int i = helper.size() - 1; i >= 0; i--){
	                ans.add(helper.get(i).data);
	            }
	            flag = 0;
	        }
	    }
	    
	    return ans;
	}
}

//TC: O(N)
// SC: O(n) + O(n)

