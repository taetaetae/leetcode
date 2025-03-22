class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        if(digits.length() == 0){
            return results;
        }
        
        Map<Character, String> numberMap = new HashMap<>();
        numberMap.put('2', "abc");
        numberMap.put('3', "def");
        numberMap.put('4', "ghi");
        numberMap.put('5', "jkl");
        numberMap.put('6', "mno");
        numberMap.put('7', "pqrs");
        numberMap.put('8', "tuv");
        numberMap.put('9', "wxyz");

        backtrack(digits, 0, "", results, numberMap);
        return results;
    }

    private void backtrack(String digits, int index, String temp, List<String> results, Map<Character, String> numberMap) {
        if(index == digits.length()){
            results.add(temp);
            return;
        }
        
        String letters = numberMap.get(digits.charAt(index));
        for(char letter: letters.toCharArray()){
            temp += letter;
            backtrack(digits, index + 1, temp, results, numberMap);
            System.out.println(temp);
            temp = temp.substring(0, temp.length() - 1);
        }
    }
}