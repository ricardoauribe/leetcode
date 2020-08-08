class Solution {
    //O(n)
    //https://leetcode.com/problems/house-robber/submissions/
    //2 pointers prev 1 and prev2 sekke the max betwen prev2 + current or prev1
    //prev1 will keep the las calculation
    public int rob(int[] nums) {
        //Two pointers prev and prev2
        int prev1 = 0;
        int prev2 = 0;
        for(int i=0; i<nums.length; i++){
            int temp = prev1;
            prev1 = Math.max(prev2 + nums[i], prev1);
            prev2 = temp;
        }
        return prev1;
    }
}
