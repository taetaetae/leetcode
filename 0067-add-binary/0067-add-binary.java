class Solution {
    public String addBinary(String a, String b) {
    /*
    두 이진수 문자열이 주어질때 두 이진수를 더해서 이진수로 표현하라

    두 문자열의 길이를 구하고
    뒤에서부터 더하기 연산
    문자열이 끝나면 거기서 그만
    최종 문자열을 출력
     */

    List<String> resultCharList = new LinkedList<>();

    int aIndex = a.length() - 1;
    int bIndex = b.length() - 1;

    int aValue = 0;
    int bValue = 0;
    int upPlus = 0;

    while (aIndex >= 0 || bIndex >= 0) {

      if (aIndex >= 0) {
        aValue = Integer.parseInt(String.valueOf(a.charAt(aIndex)));
      }
      if (bIndex >= 0) {
        bValue = Integer.parseInt(String.valueOf(b.charAt(bIndex)));
      }

      int sum = aValue + bValue;
      if (sum == 2) {
        if (upPlus == 1) {
          resultCharList.add(0, "1");
//          upPlus = 0;
        } else {
          resultCharList.add(0, "0");
          upPlus = 1;
        }
      } else if (sum == 1) {
        if (upPlus == 1) {
          resultCharList.add(0, "0");
        } else {
          resultCharList.add(0, "1");
        }
      } else {
        if (upPlus == 1) {
          resultCharList.add(0, "1");
          upPlus = 0;
        } else {
          resultCharList.add(0, "0");
        }
      }

      aIndex--;
      bIndex--;
      aValue = 0;
      bValue = 0;
    }
    if (upPlus == 1) {
      resultCharList.add(0, "1");
    }
    return String.join("", resultCharList);
  }
}