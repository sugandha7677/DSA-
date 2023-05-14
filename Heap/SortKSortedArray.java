package Heap;

// or nearly sorted
public class SortKSortedArray {
    
    ArrayList <Integer> nearlySorted(int arr[], int num, int k)
    {
        // your code here
        ArrayList<Integer> ans = new ArrayList<>();
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int i = 0; i < arr.length; i++){
            minHeap.add(arr[i]);
            
            if(minHeap.size() > k) {
                ans.add(minHeap.poll());
            }
        }
        
        while(minHeap.size() > 0){
            ans.add(minHeap.poll());
        }
        
        return ans;
    }
    // TC: O(n log k)
    // SC: O(k)
}
