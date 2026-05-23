class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for(String s: tokens){
            int a,b;
            if(!(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))){
                stack.push(s);
                continue;
            }
            b = Integer.parseInt(stack.pop());
            a = Integer.parseInt(stack.pop());

            if(s.equals("+"))
                stack.push(String.valueOf(a+b));
            if(s.equals("-"))
                stack.push(String.valueOf(a-b));
            if(s.equals("*"))
                stack.push(String.valueOf(a*b));
            if(s.equals("/"))
                stack.push(String.valueOf(a/b));
        }
        return Integer.parseInt(stack.pop());
    }
}
