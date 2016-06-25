public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> eachLine = new ArrayList<Integer>();
        for (int i = 0; i < numRows; i++){
            eachLine.add(0,1);
            for (int j = 1; j < eachLine.size()-1; j++){
                eachLine.set(j, eachLine.get(j) + eachLine.get(j+1));
            }
            ans.add(new ArrayList<Integer>(eachLine));
        }
        return ans;
    }
}