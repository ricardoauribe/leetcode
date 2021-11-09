/*
https://leetcode.com/problems/word-search/

Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or 
vertically neighboring. The same letter cell may not be used more than once.
*/


class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean answer = false;
                
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(bfs(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean bfs(char[][] board, String word, int row, int col, int position){
        
        //Determine if we finished
        if(position == word.length()){
            return true;
        }
        
        //Determine if search is within constrains
        if(row <0 || row == board.length || col < 0 || col == board[0].length){
            return false;
        }
        //Check we are still on a valid path
        if(board[row][col] != word.charAt(position)){
            return false;
        }
        
        //Mark as visited
        char temp = board[row][col];
        board[row][col] = '_';
        
        //recurse on the search
        boolean answer =
        bfs(board, word, row-1, col, position+1) || // Up
        bfs(board, word, row+1, col, position+1) || // Down
        bfs(board, word, row, col-1, position+1) || // Left
        bfs(board, word, row, col+1, position+1);   // Right
        
        //Set back to original value for further searches
        board[row][col] = temp;
        
        return answer;
        
    }
}
