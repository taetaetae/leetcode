class Solution {
    public int lengthOfLastWord(String s) {
            /*
    공백 빼고 가장 마지막 문자열의 길이를 출력 하라

    공백으로 split 한다음에 마지막 배열의 요소를 출력
     */
    String[] substrings = s.split(" ");
    return substrings[substrings.length-1].length();
    }
}