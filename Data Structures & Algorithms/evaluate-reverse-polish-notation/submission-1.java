class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s: tokens){
            int a,b;
            if(!(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))){
                stack.push(Integer.parseInt(s));
                continue;
            }
            b = stack.pop();
            a = stack.pop();

            if(s.equals("+"))
                stack.push(a+b);
            if(s.equals("-"))
                stack.push(a-b);
            if(s.equals("*"))
                stack.push(a*b);
            if(s.equals("/"))
                stack.push(a/b);
        }
        return stack.pop();
    }
}