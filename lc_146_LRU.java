package leetcode;
/*
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */
import java.util.*;
public class lc_146_LRU {
	private class Node{
        Node prev, next;
        int key, value;
        
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    
    private int capacity;
    private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    
    public lc_146_LRU(int capacity) {
        this.capacity = capacity;
        tail.prev = head;   // The node prior to tail is most recent used
        head.next = tail;   // The node next to head is least recent used
    }
    
    public void set(int key, int value) {
        if (get(key) != -1){            // key is existing
            map.get(key).value = value; // update value
            // move_to_tail(map.get(key)); // optional???
            return;
        }
        if (map.size() == capacity){
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        Node insertNode = new Node(key, value);
        map.put(key,insertNode);
        move_to_tail(insertNode);
    }
    
    public int get(int key) {
       if (!map.containsKey(key)){
           return -1;
       }
       // remove current
       Node current = map.get(key);
       current.prev.next = current.next;
       current.next.prev = current.prev;
       // move current to tail
       move_to_tail(current);
       
       return map.get(key).value;
    }
    
    private void move_to_tail(Node current){
        current.prev = tail.prev;
        tail.prev = current;
        current.next = tail;
        current.prev.next = current;
        
    }
}
