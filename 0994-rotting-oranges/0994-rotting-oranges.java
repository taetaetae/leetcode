class Solution {
    public int orangesRotting(int[][] grid) {
        // if(grid == null || grid.length == 0) return -1;

        for(int i=0 ; i<grid.length ; i++){
            for(int j=0 ; j<grid[0].length ; j++){
                if(grid[i][j] == 2){
                    dfs(grid, i, j, 2);
                }
            }
        }
        
        int minute = 2;
        for(int i=0 ; i<grid.length ; i++){
            for(int j=0 ; j<grid[0].length ; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
                minute = Math.max(minute, grid[i][j]);
            }
        }

        return minute - 2;
    }

    private void dfs(int[][] grid, int i, int j, int minute){
        if(
            i < 0 || j < 0 ||
            i >=grid.length || j >= grid[0].length ||
            grid[i][j] == 0 ||
            (1 < grid[i][j] && grid[i][j] < minute)
        ){
            return;
        }

        grid[i][j] = minute;

        dfs(grid, i-1, j, minute + 1);
        dfs(grid, i+1, j, minute + 1);
        dfs(grid, i, j-1, minute + 1);
        dfs(grid, i, j+1, minute + 1);
    }
}
/*
2 1 1
0 1 1
1 0 1
*/