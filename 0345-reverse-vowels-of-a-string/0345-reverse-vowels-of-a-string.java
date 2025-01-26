class Solution {
    public String reverseVowels(String s) {
          /*
    문자열에서 모음만 추출하고 거꾸로 한다음
    원래 자리에 매핑해서 출력

    O(n)
    모음을 찾고 인덱스 기억
    다시 거꾸로 돌아가면서 인덱스에 거꾸로 되는 값으로 replace하고 리턴

     */
    Set<Character> vowelsSet = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
    List<Character> contains = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      if (vowelsSet.contains(Character.toLowerCase((s.charAt(i))))) {
        contains.add(s.charAt(i));
      }
    }
    int reverseIndex = contains.size() - 1;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (vowelsSet.contains(Character.toLowerCase((s.charAt(i))))) {
        sb.append(contains.get(reverseIndex--));
      } else {
        sb.append(s.charAt(i));
      }
    }

    return sb.toString();
    }
}