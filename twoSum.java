import java.util.Hashtable;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Hashtable to find complement
        // https://leetcode.com/problems/two-sum/
        
        Hashtable<Integer, Integer> numbers = new Hashtable<>();
        int[] answer = new int[2];
        
        for(int i=0; i<nums.length; i++){
            numbers.put(nums[i], i);
        }
        
        for(int j=0; j<nums.length; j++){
            int difference = target - nums[j];
            if(numbers.containsKey(difference)  && numbers.get(difference) != j){
                answer[0] = j;
                answer[1] = numbers.get(difference);
            }
        }
        
        return answer;
        
    }
}
