package leetcode;
/* There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]
There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].

Note:The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * Method: DFS topological sort, based on 207 course schedule I
 */
import java.util.*;
public class lc_210_courseSchedule2 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        int[] result = new int[numCourses];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < numCourses; i ++){
            graph.add(new ArrayList<Integer>());
        }
        // Set up graph
        for (int i = 0; i < prerequisites.length; i ++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] inStack = new boolean[numCourses];
        for (int i = 0; i < numCourses; i ++){
            if (!dfsHelper(graph, visited, i,stack, inStack)){
                return new int[0];
            }
        }
        for (int i = 0; i < numCourses; i ++){
            result[i] = stack.pop();
        }
        return result;
    }
    
    public boolean dfsHelper(List<ArrayList<Integer>> graph, boolean[] visited, int course, Stack<Integer> stack, boolean[] inStack){
        if (visited[course]){
            return false;
        }else{
            visited[course] = true;
        }
        ArrayList<Integer> children = graph.get(course);
        for (int child : children){
            if (!dfsHelper(graph, visited, child, stack, inStack)){
                return false;
            }
        }
        if (!inStack[course]){
            stack.push(course);
            inStack[course] = true;
        }
        visited[course] = false;
        return true;
    }
}
