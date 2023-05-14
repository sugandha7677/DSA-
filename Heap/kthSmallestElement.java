package Heap;

public class kthSmallestElement {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        for(int i = 0; i < arr.length; i++){
            maxHeap.add(arr[i]);
            
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        return  maxHeap.peek();

}
// TC: O(n * log k)
// SC: O(k)
