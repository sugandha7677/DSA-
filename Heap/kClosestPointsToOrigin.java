public class kClosestPointsToOrigin {
    
        public int[][] kClosest(int[][] points, int k) {
            
            PriorityQueue<int []> maxHeap = new PriorityQueue<>(
                (p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1] );
            
            for(int i = 0; i < points.length; i++){
                maxHeap.add(new int[]{points[i][0], points[i][1]});
                
                if(maxHeap.size() > k) maxHeap.poll();
            }
            
            int [][] ans  = new int [k][2];
            int i = 0;
            
            while( k > 0) {
                ans[--k] = maxHeap.poll();
            }
            
            return ans;
        }
    // TC: O(n log k )
    // SC: O(k)
}
