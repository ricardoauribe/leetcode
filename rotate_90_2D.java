class Solution {
    public void rotate(int[][] matrix) {
        //see the matrix as layers we need to traverse form outer to inner
        //https://leetcode.com/problems/rotate-image/
        //O(n2) as it touches all items at the matrix
        
        int len = matrix.length;
        
        //only need to do it for  len/2 as the layer cover 2 sides
        //4x4 has 2 layers 8x8 has 4 layers
        for(int layer=0; layer<len/2; layer++){
            
            //first is where the layer begins
            int first = layer;
            //len - 1 sets the valid end location it will decrease as we get to the inner layers
            int last = len - 1 - layer;
            
            //for each item in the starting row in the layer we rotate
            for(int col = first; col<last; col++){
                //the offset will allow us to move throu the items in the row
                //offset and col are the moving pieces
                int offset = col - first;
                
                //save top [row fixed][col]
                int top = matrix[layer][col];
                
                //top <- left[last-offset][fixed col]
                matrix[first][col] = matrix[last - offset][first];
                
                //left <- bottom[fixed][last-offset]
                matrix[last - offset][first] = matrix[last][last -offset];
                
                //bottom <- right[col][fixed row]
                matrix[last][last-offset] = matrix[col][last];
                
                //right <- top
                matrix[col][last] = top;
            }
        }
    }
}
