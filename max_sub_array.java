class Solution {
    public int maxSubArray(int[] nums) {
        /*
        int maxSum = Integer.MIN_VALUE;
        
        for(int slow=0; slow<nums.length; slow++){
            
            int sum= nums[slow];
            maxSum = Math.max(sum, maxSum);
            int fast = slow+1;
            
            while(sum>0 && fast < nums.length){
                sum+=nums[fast];
                fast++;
                maxSum = Math.max(sum, maxSum);
            }
            
        }
        
        return maxSum;
        */
        
        //O(n) just one traversal
        //https://leetcode.com/problems/maximum-subarray/submissions/
        //Keep a local max which is either the current number or the prev max plus 
        //current value
        //Compare current max against max
        int maxSoFar = nums[0];
        int max = nums[0];
        
        for(int i=1; i<nums.length; i++){
            maxSoFar = Math.max(nums[i], maxSoFar + nums[i]);
            max = Math.max(maxSoFar, max);
        }
        
        return max;
    }
}
