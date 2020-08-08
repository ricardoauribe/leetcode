class Solution {
    public int uniquePaths(int m, int n) {
        //Use DP to calculate prev sub problems
        //O(n*m)
        //https://leetcode.com/problems/unique-paths/
        
        int[][] dpMatrix = new int[m][n];
        
        //this will set all rows top value to 1
        for(int i=0; i<m; i++){
            dpMatrix[i][0] = 1;
        }
        
        //this will set all columns first value to 1
        for(int j=0; j<n; j++){
            dpMatrix[0][j] = 1;
        }
        
        //Now traverse the whole matrix and calculate posible paths using diagonal values
        //this will set all columns top value to 1
        //Starts at 1 sin the first column and row where set to 1
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dpMatrix[i][j] = dpMatrix[i-1][j] + dpMatrix[i][j-1];
            }
        }
        
        //return bottom right value
        return dpMatrix[m-1][n-1];
    }
}
