class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        int freshCount = 0;
        for(int i=0 ; i<grid.length ; i++){
            for(int j=0 ; j<grid[0].length ; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i, j});
                }else if(grid[i][j] == 1){
                    freshCount++;
                }
            }
        }
        if(freshCount == 0) return 0;

        int[][] directions = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        int rows = grid.length, cols = grid[0].length;
        int minutes = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            minutes++;
            
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                int x = point[0], y = point[1];
                
                for (int[] d : directions) {
                    int newX = x + d[0], newY = y + d[1];
                    
                    if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2; // 오렌지를 썩게 만듦
                        queue.add(new int[]{newX, newY});
                        freshCount--;
                    }
                }
            }
        }

        if(freshCount != 0){
            return -1;
        }
        return minutes;
    }
}