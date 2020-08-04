class Solution {
    public void gameOfLife(int[][] board) {
        //https://leetcode.com/problems/game-of-life/
        //Traverse the whole board
        //for each location calculates neighbors
        //Apply rules
        //Use temporal states: -1 -> future dead, prev live, 2 future live prev dead
        //Standardize values with a second pass
        //O(n x m)
        
        //Array to find the 8 neighbors, this will handle the offset 00 is itself, the other 8
        //will be the neighbors
        int[] neighbors = {-1, 0, 1};
        int rows = board.length;
        int cols = board[0].length;
        
        //Iterate through the board
        for(int row = 0; row<rows; row++){
            for(int col =0; col<cols; col++){
                
                // Counter for live neighbors
                int count = 0;
                
                for(int i=0; i<3; i++){
                    for(int j=0; j<3; j++){
                        
                        //Calculate neighbors for all but the center
                        if(!(neighbors[i]==0 && neighbors[j]==0)){
                            
                            //r,c will be the location +- the offset
                            int r = row + neighbors[i];
                            int c = col + neighbors[j];
                            
                            //Check neighbors are valid not going off the limits of the board
                            //using the prev state abs(1, -1) will care if future dead but current alive
                            if((r<rows && r>= 0) && (c < cols && c >= 0) && (Math.abs(board[r][c])==1)){
                                count++;
                            }
                        }
                    }
                }
                
                //Set as dead if less than 1 or more than 3
                //Here we only care as if 0 or 1 as this is the place where the could get 
                //modified not before 
                if((board[row][col] == 1) && (count < 2 || count > 3)){
                    board[row][col] = -1;
                }
                //Set as life is exactly 3 neighbors
                if(board[row][col] == 0 && count == 3){
                    board[row][col] = 2;
                }
            }
        }
        
        //Parse again to set final values
        for(int row= 0; row <rows; row++){
            for(int col=0; col<cols; col++){
                if(board[row][col]>0){
                    board[row][col] = 1;
                }
                else{
                    board[row][col] = 0;
                }
            }
        }
        
    }
    
    
}
