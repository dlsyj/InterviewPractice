public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        for (String each: path.split("/")){
            if (!each.equals(".") && !each.equals("") && !each.equals("..")){
                stack.push(each);
            }
            if (each.equals("..") && !stack.isEmpty()){
                stack.pop();
            }
        }
        String result = "";
        for (String dir : stack){
            result += "/" + dir;
        }
        return stack.isEmpty() ? "/" : result;
    }
}