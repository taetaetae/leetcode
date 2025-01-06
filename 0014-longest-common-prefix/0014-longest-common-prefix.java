class Solution {
    public String longestCommonPrefix(String[] strs) {
        /*
    각 문자열을 순회하면서
    0번째를 기준으로 비교시 더 작은 길이가 메인이 되어 체크
     */
    String baseString = strs[0];
    for (int i = 1; i < strs.length; i++) {
      String currentString = strs[i];
      if (baseString.length() < currentString.length()) {
        baseString = getBaseString(baseString, currentString);
      } else {
        baseString = getBaseString(currentString, baseString);
      }
      if (baseString.length() == 0) {
        break;
      }
    }
    return baseString;
    }

    private String getBaseString(String baseString, String currentString) {
    int index = 0;
    StringBuilder sb = new StringBuilder();
    while (index < baseString.length()) {
      if (baseString.charAt(index) == currentString.charAt(index)) {
        sb.append(baseString.charAt(index));
      } else {
        break;
      }
      index++;
    }
    baseString = sb.toString();
    return baseString;
  }
}