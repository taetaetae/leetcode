class Solution {
    public int matrixScore(int[][] grid) {
    /*
    0과 1로 이루어진 배열이 주어지고
    행 또는 열 기준으로 0 <-> 1 교환해서
    가장 큰 값이 되도록 교환한 후 열을 10진수로 변환하여 합산

    행 단위로 검사하면서 맨앞이 1이 되도록 변환
    열 단위로 검사하면서 1이 많도록 변환
    최종적으로 행단위로 변환하여 합 리턴

    3 O(n2)
     */

    for (int i = 0; i < grid.length; i++) {
      // 0이면 변환
      if (grid[i][0] == 0) {
        for (int j = 0; j < grid[i].length; j++) {
          swapZeroAndOne(grid, i, j);
        }
      }
    }

    for (int i = 0; i < grid[0].length; i++) {
      int zeroCount = 0;
      int oneCount = 0;
      for (int j = 0; j < grid.length; j++) {
        if (grid[j][i] == 0) {
          zeroCount++;
        } else {
          oneCount++;
        }
      }

      if (oneCount < zeroCount) {
        for (int j = 0; j < grid.length; j++) {
          swapZeroAndOne(grid, j, i);
        }
      }
    }

    int sum = 0;
    for (int i = 0; i < grid.length; i++) {
      int size = grid[i].length - 1;

      for (int j = 0; j < grid[i].length; j++) {
        sum += (int) (grid[i][j] * Math.pow(2, size--));
      }
    }
    return sum;
  }

  private static void swapZeroAndOne(int[][] grid, int i, int j) {
    if (grid[i][j] == 0) {
      grid[i][j] = 1;
    } else {
      grid[i][j] = 0;
    }
  }
}