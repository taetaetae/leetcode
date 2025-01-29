class Solution {
    
  public class Pair {

    int value;
    int index;

    Pair(int value, int index) {
      this.value = value;
      this.index = index;
    }
  }

  public int miceAndCheese(int[] reward1, int[] reward2, int k) {
    /*
    두 배열이 주어지고 각 배열에서최대 k횟수만큼 선택할수 있음
    인덱스 기준으로 한쪽에서 선택하면 다른쪽에선 선택할수 없음
    합이 최대값을 선택했을때의 최대값 출력

    첫번재 배열을 순회해서 우선순위 큐에 넣고 (인덱스, 값)
    k 만큼 꺼내면서 제일 큰것만 첫번째 배열에서 하고 나머진 두번째 배열에서 하도록
     */

    PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((v1, v2) -> v2.value - v1.value);
    for (int i = 0; i < reward1.length; i++) {
      priorityQueue.add(new Pair(reward1[i] - reward2[i], i));
    }
    int sum = 0;
    for (int i = 0; i < k; i++) {
      int index = priorityQueue.poll().index;
      sum += reward1[index];
      reward2[index] = 0;
    }

    for (int value : reward2) {
      sum += value;
    }

    return sum;
  }
}