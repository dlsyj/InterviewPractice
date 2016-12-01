package leetcode;
/* Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
Example 1:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order
 * 
 * 
 * Method: All the airports are vertices and tickets are directed edges. Then all these tickets form a directed graph.

The graph must be Eulerian since we know that a Eulerian path exists.

Thus, start from "JFK", we can apply the Hierholzer's algorithm to find a Eulerian path in the graph which is a valid reconstruction.

Since the problem asks for lexical order smallest solution, we can put the neighbors in a min-heap. In this way, we always visit the smallest possible neighbor first in our trip.


 */
import java.util.*;
public class lc_332_reconstructItinerary {
	Map<String, PriorityQueue<String>> trip;
    List<String> path;
    
    public List<String> findItinerary(String[][] tickets) {
        trip = new HashMap<>();
        path = new ArrayList<>();
        for (String[] ticket : tickets){
            trip.putIfAbsent(ticket[0], new PriorityQueue<String>());
            trip.get(ticket[0]).add(ticket[1]);
        }
        dfs("JFK");
        return path;
    }
    
    public void dfs(String departure){
        PriorityQueue<String> arrivals = trip.get(departure);
        while (arrivals != null && !arrivals.isEmpty()){
            dfs(arrivals.poll());
        }
        path.add(0,departure);
    }
}
