class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /*
        2차원 배열이 주어지고 정렬이 되어있음
        O(log(m*n)) 으로 target 이 있는지를 찾는 문제

        첫번째 인덱스만 보고 target을 넘어서는 값 직전의 인덱스 열을 
        바이너리 서치로 검색하기
        */
        int indexX = matrix.length -1;
        if(indexX != 0){
            for(int i=0 ; i<matrix.length ; i++){
                if(target< matrix[i][0]){
                    indexX = i - 1;
                    break;
                }
            }
        }
        if(indexX == -1){
            indexX = 0;
        }
        
        /*
        1 3 5 7
        0 1 2 3

        3
        */


        /*
        int delta = matrix[indexX].length / 2;
        
        System.out.println("indexX : " + indexX + " delta : " + delta);
        while(delta/2 != 0){
            System.out.println(delta);
            if(matrix[indexX][delta] == target){
                return true;
            } else if(matrix[indexX][delta] > target){
                delta = delta/2;
            }else {
                delta += delta/2;
            }
        }
        */
        System.out.println("indexX : " + indexX );
        for(int i=0 ; i<matrix[indexX].length; i++){
            if(matrix[indexX][i] == target){
                return true;   
            }

        }

        return false;
    }
}