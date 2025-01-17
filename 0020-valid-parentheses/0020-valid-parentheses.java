class Solution {
    public boolean isValid(String s) {
        /*
        여는게 나오면 스택에 넣고
        닫는게 나오면 쌓이 맞으면 뽑고 아니면 끝
        마지막까지 가서 비어있으면 true, 아니면 false
        */
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      
      if (stack.size() == 0 && (c == ')' || c == '}' || c == ']')) {
        return false;
      }

      if (c == '(' || c == '{' || c == '[') {
        stack.add(c);
      } else {
        Character peeked = stack.peek();
        if (peeked == '(' && c == ')') {
          stack.pop();
        } else if (peeked == '{' && c == '}') {
          stack.pop();
        } else if (peeked == '[' && c == ']') {
          stack.pop();
        } else {
          return false;
        }
      }
    }
    return stack.size() == 0;
    }
}