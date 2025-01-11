class Solution {
  public boolean isIsomorphic(String s, String t) {
    /*
    앞부터 새로운게 나오면 매핑, 각 인덱스별로 다 새롭거나 이미 매핑된대로 되면 true, 하다가 다른게 나오면 false
    한번 매핑된것이 있으면 다른걸로 매핑되면 안됨
     */
    Map<Character, Character> charMap = new HashMap<>();
    Set<Character> charSet = new HashSet<>();
    Set<Character> valueSet = new HashSet<>();

    for (int i = 0; i < s.length(); i++) {
      if (!charSet.contains(s.charAt(i)) && !valueSet.contains(t.charAt(i))) {
        charMap.put(s.charAt(i), t.charAt(i));
        charSet.add(s.charAt(i));
        valueSet.add(t.charAt(i));
        continue;
      } else if (charMap.containsKey(s.charAt(i)) && charMap.get(s.charAt(i)) == t.charAt(i)) {
        continue;
      }
      return false;
    }
    return true;
  }
}