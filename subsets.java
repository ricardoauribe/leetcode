class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //78 Subsets
        //https://leetcode.com/problems/subsets/
        //O(n x 2^n) The amount of subsets 2^n times the amount of bits in a given item n
        
        /* working
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> empty = new ArrayList<>();
        answer.add(empty);
        
        for(int num : nums){
            List<List<Integer>> newSubsets = new ArrayList<>();
            for(List<Integer> currSubset : answer){
                List<Integer> temp = new ArrayList<>(currSubset);
                temp.add(num);
                newSubsets.add(temp);
            }     
            
            for(List<Integer> current: newSubsets){
                answer.add(current);
            }
        }
        
        return answer;
        */
        
        List<List<Integer>> answer = new ArrayList<>();
        int len = nums.length;
        
        //Generate bit masks from 0000 all zeros (this set the amount of bits needed
        //to 1111 all ones, this set the maximum number that those bits can generate
        for(int i= (int)Math.pow(2,len); i<(int)Math.pow(2,len+1); i++){
        
            //Generate Mask corresponding to i as a number
            //Take the whole substring from char 1
            String mask = Integer.toBinaryString(i).substring(1);
            
            //iterate from the mask to add the needed numbers
            List<Integer> subList = new ArrayList<>();
            int bits = mask.length();
            for(int j = 0; j< bits; j++){
                if(mask.charAt(j) == '1'){
                    subList.add(nums[j]);
                }
            }
            
            //add array into the answer list
            answer.add(subList);
            
        }
        return answer;
        
    }
}
