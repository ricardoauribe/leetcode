class Solution {
    public int[] productExceptSelf(int[] nums) {
        //https://leetcode.com/problems/product-of-array-except-self/
        //Compute left product
        //compute right product
        //multipy both products to return the answer
        //O(n) space O(n) time -> O(1) as no extra memory but the answer is used
        
        int len = nums.length;
        int[] answer = new int[len];
        
        //setting first location to 1 to ignore the first location in the product
        answer[0]=1;
        
        //Generating the left product
        for(int i=1; i<len; i++){
            answer[i] = answer[i-1] * nums[i-1];
        }
        
        //Generating the right product in a variable, starting at 1 to ignore most right value
        int right = 1;
        for(int j=len-1; j>=0; j--){
            answer[j] = right * answer[j];
            right = right * nums[j];
        }
        
        return answer;
    }
}
