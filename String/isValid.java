class Solution {
    public boolean isValid(String s) {
        char[] charArr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < charArr.length; i++) {
            if(charArr[i] == '(' || charArr[i] == '{' || charArr[i] == '[') stack.push(charArr[i]);
            else {
                if(stack.isEmpty()) return false;
                char c = stack.pop();
                if(charArr[i] == '}') {
                    if(c != '{') return false;
                } else if(charArr[i] == ')') {
                    if(c != '(') return false;
                } else if(charArr[i] == ']') {
                    if(c != '[') return false;
                }
            }
        }
        return stack.isEmpty() ? true : false;
    }
}
