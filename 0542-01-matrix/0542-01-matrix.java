/*
- DFS 로 하게되면 TLE 발생. BFS로 해야 함
- 0인걸 찾고 해당 좌표를 queue에 추가, 0이 아니면 업데이트 해야하니 -1로 셋팅
- 큐에서 하나씩 빼면서 인접좌표 업데이트 할것이 있는제 체크
- 업데이트 할꺼면 현재 좌표의 값 + 1 로 업데이트 하고 해당 좌표를 큐에 추가

*/
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int results[][] = new int[mat.length][mat[0].length];
        Queue<int[]> queue = new LinkedList<>();
        int calTargetCount = 0;

        for(int i=0 ; i<mat.length ; i++){
            for(int j=0 ; j<mat[0].length ; j++){
                if(mat[i][j] == 0){
                    queue.add(new int[]{i, j});
                    results[i][j] = 0;
                    calTargetCount++;
                }else {
                    results[i][j] = -1;
                }
            }
        }

        List<int[]> calPoints = List.of(
            new int[]{1,0},
            new int[]{0,1},
            new int[]{-1,0},
            new int[]{0,-1}
        );

        for(int[] calPoint : calPoints){
            System.out.println("" + calPoint[0] + "," + calPoint[1]);
        }

        while(queue.size() > 0){
            int points[] = queue.poll();
            for(int[] calPoint : calPoints){
                // System.out.println("" + points[0] + " " + points[1]);
                int x = points[0] + calPoint[0];
                int y = points[1] + calPoint[1];
                if(x >= 0 && x < mat.length &&
                    y >= 0 && y < mat[0].length){
                        if(results[x][y] == -1){
                            results[x][y] = results[points[0]][points[1]] + 1;
                            queue.add(new int[]{x, y});
                            calTargetCount--;
                        }
                    }
            }
        }

        return results;
        
    }
}