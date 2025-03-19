class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> results = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return results;
        }
        int rowMin = 0, rowMax = matrix.length - 1;
        int colMin = 0, colMax = matrix[0].length - 1;

        while(rowMin <= rowMax && colMin <= colMax){
            for(int i=colMin; i<=colMax; i++){
                results.add(matrix[rowMin][i]);
            }
            rowMin++;
            for(int i=rowMin; i<=rowMax; i++){
                results.add(matrix[i][colMax]);
            }
            colMax--;
            
            if(rowMin > rowMax || colMin > colMax) break;

            for(int i=colMax; i>=colMin; i--){
                results.add(matrix[rowMax][i]);
            }
            rowMax--;
            for(int i=rowMax; i>=rowMin; i--){
                results.add(matrix[i][colMin]);
            }
            colMin++;
        }
        return results;
    }
}