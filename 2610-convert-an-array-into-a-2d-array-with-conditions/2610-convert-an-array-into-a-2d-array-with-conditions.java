class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
    /*
    숫자가 들어있는 배열이 주어지고
    같은 숫자가 들어있지 않도록 배열을 나누어라.

    최대 길이 200
    단순 for문 계혹 하기엔... tle 될것 같은데
    hashSet list를 만들고 한번만 순회하면서 contains 하면서 있늘 경우 새롭게 만들어서 체크
    1,3,4,1,2,3,1
    1,3,4,2,
    1,3
    1
     */

    List<Set<Integer>> numSets = new ArrayList<>();
    numSets.add(new LinkedHashSet<>());
    for (int num : nums) {
      Iterator<Set<Integer>> iterator = numSets.iterator();
      boolean append = false;
      while (true) {
        if (!iterator.hasNext()) {
          break;
        }
        Set<Integer> numSet = iterator.next();
        if (!numSet.contains(num)) {
          numSet.add(num);
          append = true;
          break;
        }
      }
      if (!append) {
        HashSet<Integer> newNumSet = new LinkedHashSet<>();
        newNumSet.add(num);
        numSets.add(newNumSet);
      }
    }

    return numSets.stream().map(data -> data.stream().toList()).toList();

  }
}