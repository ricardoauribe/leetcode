class Solution {
  
  //We traverse all locations for the matrix calling the dfs function
  //As it clears the matrix on every pass it will only count new islands when it finds a new 1
    public int numIslands(char[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid, i,j);
                    grid[i][j] = '0';
                }
            }
        }
        
        return count;
    }
    
  //DFS Traverse
  //This first will validate that the cell to check is inside valid contrains, col, rows and it holds '1s'
  //Then it will marke current cell as visited and recursevely traverse valid locations for islands
    public void dfs(char[][] m, int i, int j){
        
        int rows = m.length;
        int cols = m[0].length;
            
        //Check it is inside valid constrains
        if(i<0 || i>= rows || j<0 || j>=cols || m[i][j] == '0'){
            return;
        }
        else{
            //Mark location as visited
            m[i][j] = '0';
            //Let's continue the search
            dfs(m, i-1, j);
            dfs(m, i, j-1);
            dfs(m, i, j+1);
            dfs(m, i+1, j);
        }
    }
}
