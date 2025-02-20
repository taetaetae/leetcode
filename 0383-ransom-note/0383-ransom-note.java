class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()){
            return false;
        }
        Map<Character, Integer> charCountMap = new HashMap<>();

        for(Character ch : magazine.toCharArray()){
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
        }

        for(Character ch : ransomNote.toCharArray()){
            if(charCountMap.containsKey(ch)){
                int count = charCountMap.get(ch);
                if(count == 0){
                    return false;
                }
                charCountMap.put(ch, count -1);
            }else {
                return false;
            }
        }
        return true;
    }
}