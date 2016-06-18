public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> eachRow = new ArrayList<Integer>();
        for (int i = 0; i < numRows; i++){
            eachRow.add(0,1);
            for (int j = 1; j < eachRow.size()-1; j++){
                eachRow.set(j, eachRow.get(j) + eachRow.get(j+1));
            }
            ans.add(new ArrayList<Integer>(eachRow));
        }
        return ans;
    }
}