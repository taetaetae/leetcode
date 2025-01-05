class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> romanMap = new HashMap<>(Map.of(
        "I", 1,
        "V", 5,
        "X", 10,
        "L", 50,
        "C", 100,
        "D", 500,
        "M", 1000
    ));

    char[] charArray = s.toCharArray();
    int result = 0;

    for (int i = charArray.length - 1; i >= 0; i--) {
      Integer currentValue = romanMap.get(String.valueOf(charArray[i]));
      result += currentValue;

      if (i != charArray.length - 1 && currentValue < romanMap.get(String.valueOf(charArray[i + 1]))) {
        result += (currentValue * -2);

      }
    }
    return result;
    }
}