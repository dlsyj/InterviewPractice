package leetcode;
/* Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0. 
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? . 
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

According to the example above:

equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction
 * 
 */
import java.util.*;
public class lc_399_evaluateDivision {
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        // use map to save vertix and its index
        Map<String, Integer> map = new HashMap<>();
        int index = 0;
        for (String[] equation : equations){
            for (String vertix : equation){
                if (!map.containsKey(vertix)){
                    map.put(vertix, index++);
                }
            }
        }
        // initialize table by equations
        double[][] table = new double[index][index];
        for (int i = 0; i < index; i ++){
            for (int j = 0; j < index; j ++){
                table[i][j] = (i == j ? 1.0d : -1.0d);
            }
        }
        // save equations into table
        for (int i = 0; i < equations.length; i ++){
            String[] equation = equations[i];
            int row = map.get(equation[0]);
            int col = map.get(equation[1]);
            table[row][col] = values[i];
            table[col][row] = 1 / values[i];
        }
        
        // floyd-warshall like algorithm
        for (int i = 0; i < index; i ++){
            for (int j = 0; j < index; j ++){
                for (int k = 0; k < index; k ++){
                    if (table[i][k] >= 0d && table[k][j] >= 0d){
                        table[i][j] = table[i][k] * table[k][j];
                    }
                }
            }
        }
        
        // query
        double[] result = new double[queries.length];
        for (int i = 0; i < queries.length; i ++){
            String[] vertix = queries[i];
            Integer row = map.get(vertix[0]);   // map get null
            Integer col = map.get(vertix[1]);
            if (row == null || col == null){
                result[i] = -1.0d;
            }else{
                result[i] = table[row][col];
            }
        }
        return result;
    }
}
