class Solution {
    public boolean isSubsequence(String s, String t) {
         /*
    s를 순회하면서
    t를 순회
    단, t는 한번만 순회
    O(n)
     */
     
        int sequenceMatchCount = 0;
    int tIndex = 0;
    for (int sIndex = 0; sIndex < s.length(); sIndex++) {
      char sChar = s.charAt(sIndex);

      while (tIndex < t.length()) {
        char tChar = t.charAt(tIndex);
        tIndex++;
        if (Objects.equals(sChar, tChar)) {
          sequenceMatchCount++;
          break;
        }
      }
    }

    return sequenceMatchCount == s.length();
    }
}