class Solution {
    public int minimumRounds(int[] tasks) {
    /*
    작업의 난이도 배열이 오고
    각 라운드에서 동일한 난이도의 2 또는 3개를 해결할수 있다.
    모든 작업을 해결할수 있는 최소 라운드 또는 완료가 안되면 -1
     */

    Map<Integer, Integer> countMap = new HashMap<>();

    for (Integer task : tasks) {
      countMap.put(task, countMap.getOrDefault(task, 0) + 1);
    }

    int result = 0;
    for (Integer count : countMap.values()) {
      if (count == 1) {
        return -1;
      }
      if (count % 3 == 0) {
        result += count / 3;
      } else {
        result += (count + 2) / 3;
      }
    }
    return result;
  }
}