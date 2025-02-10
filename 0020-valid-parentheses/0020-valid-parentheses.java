class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put(')', '(');
        bracketMap.put('}', '{');
        bracketMap.put(']', '[');

        for(Character ch : s.toCharArray()){
            if(bracketMap.containsValue(ch)){
                stack.push(ch);
            }else if (bracketMap.containsKey(ch)){
                if(stack.isEmpty() || !stack.pop().equals(bracketMap.get(ch))){
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}