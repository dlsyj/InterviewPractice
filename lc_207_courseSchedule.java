package leetcode;
/* There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * Method: DFS topological sort
 * https://www.youtube.com/watch?v=ddTC4Zovtbc
 */
import java.util.*;
public class lc_207_courseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < numCourses; i ++){
            graph.add(new ArrayList<Integer>());
        }
        // Set up graph
        for (int i = 0; i < prerequisites.length; i ++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i ++){
            if (!dfsHelper(graph, visited, i)){
                return false;
            }
        }
        return true;
    }
    
    public boolean dfsHelper(List<ArrayList<Integer>> graph, boolean[] visited, int course){
        if (visited[course]){
            return false;
        }else{
            visited[course] = true;
        }
        ArrayList<Integer> children = graph.get(course);
        for (int child : children){
            if (!dfsHelper(graph, visited, child)){
                return false;
            }
        }
        visited[course] = false;
        return true;
    }
}
