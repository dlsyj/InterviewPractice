public class Solution {
    public int compareVersion(String version1, String version2) {
        // eg 0.1 < 1.1 < 1.2 < 13.37
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        for (int i = 0; i < Math.max(v1.length, v2.length); i ++){
            int num1 = v1.length > i ? Integer.parseInt(v1[i]) : 0;
            int num2 = v2.length > i ? Integer.parseInt(v2[i]) : 0;
            if (num1 < num2){
                return -1;
            } else if (num1 > num2){
                return 1;
            }
        }
        return 0;   // return 0 is out of for loop
    }
}