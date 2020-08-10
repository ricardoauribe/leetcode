/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    private TreeNode answer;
    
    public Solution(){
        this.answer = null;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        lcaTraversal(root, p,q);
        return this.answer;
        
    }
    
    public Boolean lcaTraversal(TreeNode root, TreeNode p, TreeNode q){
        //Traverse all the tree, keep a record on the left right and my self
        //If 2 of them have found return the current (root) value
        //O(n)
        //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/
        
        if(root == null){
            return false;
        }
        
        int sum = 0;
        
        Boolean left = lcaTraversal(root.left, p, q);
        Boolean right = lcaTraversal(root.right, p, q);
        
        if(left == true ){
            sum++;
        }
        if(right == true ){
            sum++;
        }
        
        if(root == p || root == q){
            sum++;
        }
        
        if(sum >=2){
            this.answer = root;
        }
        
        //At least one was found?
        return (sum > 0);
    }
}
