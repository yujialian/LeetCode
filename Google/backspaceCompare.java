//844
//O(1) space, o(n) time.
class Solution {
    public boolean backspaceCompare(String S, String T) {
        StringBuffer sbS = new StringBuffer();
        StringBuffer sbT = new StringBuffer();
        int i = 0;
        while(i < S.length()) {
            if(S.charAt(i) == '#') {
                if(i - 2 >= 0) S = S.substring(0, i - 1) + S.substring(i + 1);
                else S = S.substring(i + 1);
                if(i - 2 >= 0) i -= 2;
                else i = 0;
            } else {
                i++;
            }
        }
        i = 0;
        
        while(i < T.length()) {
            if(T.charAt(i) == '#') {
                if(i - 2 >= 0) T = T.substring(0, i - 1) + T.substring(i + 1);
                else T = T.substring(i + 1);
                if(i - 2 >= 0) i -= 2;
                else i = 0;
            } else {
                i++;
            }
        }
        return S.equals(T);
    }
}
// Using a stack, o(n) space, o(n) time.
class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) != '#') {
                stack.push(S.charAt(i));
            } else {
                if(!stack.isEmpty()) stack.pop();
            }
        }
        S = stack.toString();
        stack.clear();
        for(int i = 0; i < T.length(); i++) {
            if(T.charAt(i) != '#') {
                stack.push(T.charAt(i));
            } else {
                if(!stack.isEmpty()) stack.pop();
            }
        }
        T = stack.toString();
        return S.equals(T);
    }
}
