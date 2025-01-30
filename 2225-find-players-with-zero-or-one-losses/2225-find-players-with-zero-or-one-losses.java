class Solution {
    class Score {

    int win;
    int lose;

    Score(int win, int lose) {
      this.win = win;
      this.lose = lose;
    }

  }

  public List<List<Integer>> findWinners(int[][] matches) {
    /*
    [승자,패자] 리스트 정보가 나열됨
    한번도 안진 사람
    한번만 진 사람 리스트 나열하기

    [1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]
    각 사용자별로 한번도 안진사람과 한번만 진사람을 구별


     */

    Map<Integer, Score> matchMap = new HashMap<>();
    for (int i = 0; i < matches.length; i++) {
      int winner = matches[i][0];
      int loser = matches[i][1];
      if (!matchMap.containsKey(winner)) {
        matchMap.put(winner, new Score(1, 0));
      } else {
        matchMap.get(winner).win++;
      }

      if (!matchMap.containsKey(loser)) {
        matchMap.put(loser, new Score(0, 1));
      } else {
        matchMap.get(loser).lose++;
      }
    }

    List<Integer> notLostUser = new ArrayList<>();
    List<Integer> oneLostUser = new ArrayList<>();
    for (Integer user : matchMap.keySet()) {
      if (matchMap.get(user).lose == 0) {
        notLostUser.add(user);
      } else if (matchMap.get(user).lose == 1) {
        oneLostUser.add(user);
      }
    }
    return List.of(notLostUser.stream().sorted().toList(), oneLostUser.stream().sorted().toList());
  }
}