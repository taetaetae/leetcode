/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public enum Direction {
    RIGHT, DOWN, LEFT, UP;
  }

  public int[][] spiralMatrix(int m, int n, ListNode head) {
    /*
    0으로 모두 초기화 한 배열과 결과를 리턴할 배열 2개를 만들고
    우하좌상 반복하며 하나씩 뽑아서 넣는데 다음 방향이 (배열의 크기를 넘어서거나 이미 채워져 있다면) 시계방향으로 꺽기
    다 추가 했고 더 채워야 한다면 -1을 계속 채우면서 끝
    */
    int[][] checkAreas = new int[m][n]; // 0으로 초기화
    int[][] resultAreas = new int[m][n]; // 결과
    int totalElementCount = m * n;

    int i = 0, j = 0;
    Direction direction = Direction.RIGHT;
    while (totalElementCount > 0) {
      // 채울 값 뽑고 (node 가 null 이면 -1로 채우기
      int targetValue = head == null ? -1 : head.val;

      // 채우고
      resultAreas[i][j] = targetValue;
      checkAreas[i][j] = 1;
      totalElementCount--;

      // 채울 다음 index 찾기
      if (j + 1 == n) {
        if (i + 1 == m) {
          direction = Direction.LEFT;
        } else {
          direction = Direction.DOWN;
        }
      } else if (j == 0) {
        if (i == 0) {
          direction = Direction.RIGHT;
        } else {
          direction = Direction.UP;
        }
      }

      // 다음에 채울 인덱스에 이미 있는지 확인
      if (Direction.RIGHT.equals(direction) && (j + 1 == n || checkAreas[i][j + 1] != 0)) {
        direction = Direction.DOWN;
      } else if (Direction.DOWN.equals(direction) && (i + 1 == m || checkAreas[i + 1][j] != 0)) {
        direction = Direction.LEFT;
      } else if (Direction.LEFT.equals(direction) && (j == 0 || checkAreas[i][j - 1] != 0)) {
        direction = Direction.UP;
      } else if (Direction.UP.equals(direction) && (i == 0 || checkAreas[i - 1][j] != 0)) {
        direction = Direction.RIGHT;
      }


      // i, j 최종 결정
      if (Direction.RIGHT.equals(direction)) {
        j++;
      } else if (Direction.DOWN.equals(direction)) {
        i++;
      } else if (Direction.LEFT.equals(direction)) {
        j--;
      } else if (Direction.UP.equals(direction)) {
        i--;
      }

      // 다음가기전에 next로 넘김 (현재 null이면 그대로)
      if (head != null) {
        head = head.next;
      }
    }
    return resultAreas;
  }
}