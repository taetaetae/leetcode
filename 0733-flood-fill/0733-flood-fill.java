class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color){
            return image;
        }

        dfs(image, sr, sc, image[sr][sc], color);        
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int targetColor, int swapColor){
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != targetColor){
            return;
        }

        image[sr][sc] = swapColor;

        dfs(image, sr, sc-1, targetColor, swapColor);
        dfs(image, sr-1, sc, targetColor, swapColor);
        dfs(image, sr, sc+1, targetColor, swapColor);
        dfs(image, sr+1, sc, targetColor, swapColor);
    }
}