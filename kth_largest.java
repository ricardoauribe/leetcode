class Solution {
    // Quick option
    //O(n log n) due to sorting
    /*
    public int findKthLargest(int[] nums, int k) {
        
        Arrays.sort(nums);
        return nums[nums.length - k];
        
    }
    */
    
    //Smart Option
    //Use partition algorithm
    
    public int findKthLargest(int[] nums, int k) {
        
        int len = nums.length;
        
        int looking = len - k;
        int start = 0;
        int end = len - 1;
        
        while(start < end){
            int partitionPoint = partition(nums, start, end);
            if(partitionPoint < looking){
                start = partitionPoint + 1;
            }
            else if(partitionPoint > looking){
                end = partitionPoint - 1;
            }
            else{
                //If partitionPoint == looking we are done
                break;
            }
        }
        
        return nums[looking];
        
    }
    
    //Partition takes the last element in the array and use it as a pivot
    //It is going to swap all elements <= than the pivot to the left of it
    //everything greater than the pivot will be placed at the right
    
    public int partition(int[] nums, int start, int end){
        
        int pivotVal = nums[end];
        int pointer = start;
        
        for(int i = start; i<=end - 1; i++){
            if(nums[i] <= pivotVal){
                //swap values to keep the ones smaller at the right size
                int temp = nums[pointer];
                nums[pointer] = nums[i];
                nums[i] = temp;
                pointer++;
            }
        }
        
        //swap the pivot to the correct position
        int temp = nums[pointer];
        nums[pointer] = nums[end];
        nums[end] = temp;
        
        return pointer;
    }
}
