import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String input) {
        int maxSize = 0;
    for (int i = 0; i < input.length(); i++) {
      HashSet<String> strings = new HashSet<>();
      strings.add(String.valueOf(input.charAt(i)));

      for (int j = i + 1; j < input.length(); j++) {
        String pickString = String.valueOf(input.charAt(j));
        if (strings.contains(pickString)) {
          if (maxSize < strings.size()) {
            maxSize = strings.size();
          }
            break;
        }
        strings.add(pickString);
      }
        

        if (maxSize < strings.size()) {
        maxSize = strings.size();
      }
        
    }
    if (maxSize == 0 && input.length() > 0) {
      return input.length();
    }
    return maxSize;
    }
}