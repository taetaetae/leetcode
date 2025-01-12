class Solution {
    public boolean wordPattern(String pattern, String s) {
    Map<Character, String> patternMap = new HashMap<>();
    Set<String> mappingSet = new HashSet<>();

    String[] target = s.split(" ");
    if (pattern.length() != target.length) {
      return false;
    }
    for (int i = 0; i < pattern.length(); i++) {
      char charAt = pattern.charAt(i);
      if (!patternMap.containsKey(charAt)) {
        patternMap.put(charAt, target[i]);
        if (mappingSet.contains(target[i])) {
          return false;
        }
        mappingSet.add(target[i]);
      } else if (!patternMap.get(charAt).equals(target[i])) {
        return false;
      }
    }
    return true;
  }
}