class Solution {
    public int uniquePaths(int m, int n) {
        int [][]dp = new int[m][n];

        for(int i=0 ; i<m ; i++) dp[i][0] = 1;
        for(int i=0 ; i<n ; i++) dp[0][i] = 1;

        for(int i=1 ; i<m ; i++){
            for(int j=1 ; j<n ; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}

/*


2,1 = 1
2,2 = 2
2,3 = 3
2,4 = 4
3,1 = 1
3,2 = 3
3,3 = 6
3,4 = 10
3,5 = 15
3,6 = 21
3,7 = 28

*/