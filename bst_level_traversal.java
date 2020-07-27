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
    public List<List<Integer>> levelOrder(TreeNode root) {
        //Breadth Search First Traversal -> Use a queue and a visited list
        //O(n) is the best we can do, we need to touch all nodes
        //https://leetcode.com/problems/binary-tree-level-order-traversal/submissions/
        List<List<Integer>> answer = new ArrayList<>();
        treeBFS(root, answer);
        return answer;
    }
    
    public void treeBFS(TreeNode root, List<List<Integer>> answer) {
        
        //For trees always check root is not null
        if(root == null){
            return;
        }
        
        //Create a queue to store current level nodes
        ArrayDeque<TreeNode> myQueue = new ArrayDeque<>();
        myQueue.offer(root);

        while(!myQueue.isEmpty()){
            //For each level we will create a list and add the childs into the level
            //This prepares for the next level
            
            int size = myQueue.size();
            List<Integer> level = new ArrayList<>();
            
            for(int i=0; i<size; i++){
                TreeNode current = myQueue.poll();
                level.add(current.val);
                if(current.left != null){
                    myQueue.offer(current.left);
                }
                if(current.right != null){
                    myQueue.offer(current.right);
                }
            }
            
            //Finally we add the level nodes into the answer
            answer.add(level);
        }
    } 
}
