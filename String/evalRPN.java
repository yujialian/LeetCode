class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++) {
            String c = tokens[i];
            if(c.equals("*") || c.equals("/") || c.equals("+") || c.equals("-")) {
                int left = Integer.parseInt(stack.pop());
                int right = Integer.parseInt(stack.pop());
                if(c.equals("*")) stack.push(Integer.toString(left * right));
                else if(c.equals("/")) {
                    
                    stack.push(Integer.toString(right / left));
                }
                else if(c.equals("+")) stack.push(Integer.toString(left + right));
                else stack.push(Integer.toString(right - left));
            } else {
                stack.push(c);
            }
        }
        
        return Integer.parseInt(stack.pop());
    }
}
