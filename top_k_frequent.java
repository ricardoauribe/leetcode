import java.util.Hashtable;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      //Hash table for frequencies
      //priority queue that will only maintain k items
      //poll k items from the queue and return that array
      //O(n log k) time and space, log k comes from using a the heap (priority queue)
      //https://leetcode.com/problems/top-k-frequent-elements/
        
        Arrays.sort(nums);
        Hashtable<Integer, Integer> freq = new Hashtable<>();
        int[] answer = new int[k];
        
        for(int i=0; i<nums.length; i++){
            if(freq.containsKey(nums[i])){
                int val = freq.get(nums[i]);
                val++;
                freq.put(nums[i], val);
            }
            else{
                freq.put(nums[i], 1);
            }
        }
        
        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> freq.get(n1) - freq.get(n2));
        
        
        Set<Integer> keys = freq.keySet();
        for(int key: keys){
            heap.add(key);
           // System.out.println(key + " val " + freq.get(key));
            if(heap.size() > k){
                heap.poll();
            }
        }
        
        
        for(int j = 0; j<k; j++ ){
            answer[j] = heap.poll();
        }
        
        return answer;
    }
}
