public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (Character c : s.toCharArray()){
            if ("({[".contains(String.valueOf(c))){ // string contains string
                stack.push(c);
            } else {
                if (!stack.isEmpty() && is_valid(stack.peek(),c)){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public boolean is_valid(char open, char close){
        return (open == '(' && close == ')') || (open == '{' && close == '}') || (open == '[' && close == ']');
    }
}