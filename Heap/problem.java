// Sum of elements between k1'th and k2'th smallest elements


public class problem {
    public static long sumBetweenTwoKth(long A[], long N, long K1, long K2)
    {
        // Your code goes here
        PriorityQueue<Long> maxHeap = new PriorityQueue<>((a,b) -> (int)(b - a));
        
        for(long a : A){
            maxHeap.add(a);
            
            if(maxHeap.size() > K2 - 1) maxHeap.poll();
        }
        
        long ans = 0L;
        while(maxHeap.size() > K1) {
            //System.out.println(maxHeap.peek());
            ans += maxHeap.poll();
        }
        
        return ans;
        
    }
    
}
