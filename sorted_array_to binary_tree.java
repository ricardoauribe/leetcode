/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        //Traverse the array searching for the middle.
        //Then recursively look on the remaining left and right arrays
        //Follow a similar approach as a binary search but we only care for 
        //the mid points
        //O(n) as all values are touched once
        //https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/submissions/
        
        return recursiveCreation(nums, 0, nums.length -1);
        
    }
    
    public TreeNode recursiveCreation(int[] nums, int start, int end){
        if(start > end ){
            return null;
        }
        if( start == end){
            TreeNode edge = new TreeNode(nums[start]);
            return edge;
        }
        else{
            int midPoint = start + (end -start)/2;
            TreeNode current = new TreeNode(nums[midPoint]);
            
            current.right = recursiveCreation(nums, midPoint +1, end);
            current.left = recursiveCreation(nums, start, midPoint - 1);
            
            return current;
            
        }
    }
}
