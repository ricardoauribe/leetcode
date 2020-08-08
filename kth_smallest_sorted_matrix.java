class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        //O(n*m * k log k) 
        //Create a priorityQueue in reverse order (Max to min)
        //Traverse the matrix and add the elements, then keep the size to k elements the first one
        //is the k smallest
        //https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/submissions/
        
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                minHeap.add(matrix[i][j]);
                if(minHeap.size() > k){
                    minHeap.poll();
                }
            }
        }
        
        return minHeap.poll();
        
    }
}
