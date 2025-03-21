class Solution {
    private int start, maxLength;
    public String longestPalindrome(String s) {
        int length = s.length();
        if(length < 2){
            return s;
        }

        for(int i=0 ; i<length -1 ; i++){
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i+1);
        }

        return s.substring(start, start + maxLength);
    }

    private void extendPalindrome(String s, int i, int j){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        if(maxLength < j - i - 1){
            start = i + 1;
            maxLength = j - i - 1;
        }
    }
}