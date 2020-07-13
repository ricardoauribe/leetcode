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
    public int kthSmallest(TreeNode root, int k) {
        // https://leetcode.com/problems/kth-smallest-element-in-a-bst/solution/
        //In order traversal
        //Place Items in an array
        //return the k-1 element
        //O(n) since it's traversing all the elements in the tree
        
        List <Integer> inOrder = new ArrayList<>();
        inOrderTree(root, inOrder);
        
        int answer = inOrder.get(k-1);
        return answer;
    }
    
    
    public void inOrderTree(TreeNode root, int k, List <Integer> array) {

        if(root == null){
            return;
        }
        else{
            
            inOrderTree(root.left, array);
            array.add(root.val);
            inOrderTree(root.right, array);
        }
    }
    
    /*
    // Iterative using a Stack
    
    public int kthSmallest(TreeNode root, int k) {
    
        Stack<TreeNode> elements = new Stack<TreeNode>();
        int counter = 0;
        
        while(true){
            while(root !=null){
                elements.push(root);
                root = root.left;
            }
            
            root = elements.pop();
            //System.out.println(root.val);
            counter++;
            
            if(counter == k){
                return root.val;
            }
            root = root.right;
        }
    }
    
    */
}
