class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        /*
    도미노 2개쌍 중 앞뒤 같은것 포함해서 같은 쌍의 최대 조합의 수 구하기
     */
    Map<Integer, Integer> dominoMap = new HashMap<>();
    int count = 0;
    for (int i = 0; i < dominoes.length; i++) {
      int min = Math.min(dominoes[i][0], dominoes[i][1]);
      int max = Math.max(dominoes[i][0], dominoes[i][1]);
      int key = min * 10 + max;
      if (dominoMap.containsKey(key)) {
        count += dominoMap.get(key);
        dominoMap.put(key, dominoMap.get(key) + 1);
      } else {
        dominoMap.put(key, 1);
      }
    }
    return count;
    }
}