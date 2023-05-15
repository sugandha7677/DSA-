public class FrequencySort {
    public int[] frequencySort(int[] nums) {
        int [] ans = new int[nums.length];
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i] , 0) + 1);
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> (map.get(a) == map.get(b)) ? (b - a) : (map.get(a) - map.get(b)));
        
         for(int n : map.keySet()){    
            minHeap.add(n);
        }
        
        int idx = 0;
        while(minHeap.size() > 0){
            int key = minHeap.poll();
            for(int i = 0; i < map.get(key); i++){
                ans[idx++] = key;  
            }
        }
        
        return ans;
    }

    // TC: O(n log n)
    // sc: O(n) + O(n)
}
