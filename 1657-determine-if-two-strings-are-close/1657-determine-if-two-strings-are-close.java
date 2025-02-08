class Solution {
    public boolean closeStrings(String word1, String word2) {
    /*
    첫번째 문자열에서
    - 특정 문자열 두개의 순서를 바꾸거나
    - 서로 다른 두 문자들을 맞교환 해서
    두번째 문자와 같은지 판단하기

    두 문자열의 문자들의 빈도수를 카운팅 해서 정렬
    카운팅의 순서가 같은지 비교
     */
    if (word1.length() != word2.length()) {
      return false;
    }

    Map<Character, Integer> countMap1 = new HashMap<>();
    Map<Character, Integer> countMap2 = new HashMap<>();

    for (int i = 0; i < word1.length(); i++) {
      countMap1.put(word1.charAt(i), countMap1.getOrDefault(word1.charAt(i), 0) + 1);
      countMap2.put(word1.charAt(i), countMap2.getOrDefault(word1.charAt(i), 0) + 1);
    }
    List<Integer> counts1 = countMap1.values().stream().sorted().toList();
    List<Integer> counts2 = countMap2.values().stream().sorted().toList();

    for (int i = 0; i < counts1.size(); i++) {
      if (!counts1.get(i).equals(counts2.get(i))) {
        return false;
      }
    }
    return true;
  }
}