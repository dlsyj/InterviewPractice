public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0){
            n --;
            char curr = (char) (n % 26 + 'A');
            sb.insert(0,curr);
            n /= 26;
        }
        return sb.toString();
    }
}