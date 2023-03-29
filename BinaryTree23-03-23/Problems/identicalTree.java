
public class identicalTree {
    
    boolean check(Node p , Node q){
        if(p == null || q == null) return (p ==q);

        return (p.val == q.val) && check(p.left, q.left) && check(p.right, q.right);
    }
}

//TC: O(n)
