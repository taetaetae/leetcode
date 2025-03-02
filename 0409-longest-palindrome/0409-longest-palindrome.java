class Solution {
    public int longestPalindrome(String s) {
        Set<Character> countSet = new HashSet<>();
        int count = 0;

        for(Character ch: s.toCharArray()){
            if(countSet.contains(ch)){
                countSet.remove(ch);
                count += 2;
            }else {
                countSet.add(ch);
            }
        }

        if(!countSet.isEmpty()){
            count++;
        }
        return count;
    }
}