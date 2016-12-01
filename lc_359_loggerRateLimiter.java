package leetcode;
/* Design a logger system that receive stream of messages along with its timestamps, each message should be printed if and only if it is not printed in the last 10 seconds.

Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given timestamp, otherwise returns false.

It is possible that several messages arrive roughly at the same time.

Example:

Logger logger = new Logger();

// logging string "foo" at timestamp 1
logger.shouldPrintMessage(1, "foo"); returns true; 

// logging string "bar" at timestamp 2
logger.shouldPrintMessage(2,"bar"); returns true;

// logging string "foo" at timestamp 3
logger.shouldPrintMessage(3,"foo"); returns false;

// logging string "bar" at timestamp 8
logger.shouldPrintMessage(8,"bar"); returns false;

// logging string "foo" at timestamp 10
logger.shouldPrintMessage(10,"foo"); returns false;

// logging string "foo" at timestamp 11
logger.shouldPrintMessage(11,"foo"); returns true;
 * 
 */
import java.util.*;
public class lc_359_loggerRateLimiter {
	
	// Method 1: keep a hash map of String that maps to the recent time stamp.
	HashMap<String, Integer> okMap;

    public lc_359_loggerRateLimiter() {
        okMap = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (timestamp < okMap.getOrDefault(message,0)){
            return false;   
        }
        okMap.put(message, timestamp + 10);
        return true;
    }
    
    /*
    // Method 2: I keep a queue to get rid of the old message and set of String to keep the recent messages only. 
     * This approach would make sense when the number of logs within 10 minutes time window is not too large and when we have lots of different messages.
    public class Tuple{
        int timestamp;
        String message;
        public Tuple(int t, String msg){
            this.timestamp = t;
            this.message = msg;
        }
    }
    
    Queue<Tuple> q;
    Set<String> dict;

    public Logger() {
        q = new LinkedList<>();
        dict = new HashSet<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        while (!q.isEmpty() && q.peek().timestamp <= timestamp - 10){
            Tuple curr = q.poll();
            dict.remove(curr.message);
        }
        if (!dict.contains(message)){
            q.offer(new Tuple(timestamp,message));
            dict.add(message);
            return true;
        }
        return false;
    }
    */
    
    /**
     * Your Logger object will be instantiated and called as such:
     * Logger obj = new Logger();
     * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
     */
}
