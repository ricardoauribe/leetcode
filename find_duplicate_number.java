class Solution {
    public int findDuplicate(int[] nums) {
        //https://leetcode.com/problems/find-the-duplicate-number/
        //Similar as finding a cicle in a list, have 2 pointer slow and runner (2x)
        //traverse the array until they meet
        
        int slow = nums[0];
        int runner = nums[0];
        
        
        //This will prove there is a cycle, which in our case will always be true
        do{
            slow = nums[slow];
            runner = nums[nums[runner]];
        }while(slow != runner);
        
        //Search where the cycle starts
        slow =  nums[0];
        while(slow != runner){
            slow = nums[slow];
            runner = nums[runner];
        }
        
        //Return either slow or runner
        return slow;    
    }
}
