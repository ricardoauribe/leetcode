import java.util.*;

/*

https://leetcode.com/problems/lru-cache/

Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.
*/

class LRUCache {
    
    Map<Integer, Node> lruMap = new HashMap<Integer, Node>();
    int capacity;
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head.next = tail;
        this.tail.prev = head;
    }
    
    public int get(int key) {
        if(lruMap.containsKey(key)){
            Node newNode = lruMap.get(key);
            remove(newNode);
            insert(newNode);
            return newNode.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(lruMap.containsKey(key)){
            Node existingNode = lruMap.get(key);
            remove(existingNode);
        }
        if(lruMap.size() == capacity){
            Node lastNode = tail.prev;
            remove(lastNode);
        }
        
        Node newNode = new Node(key, value);
        insert(newNode);
        
        
    }
    
    public void remove(Node node){
        if(lruMap.containsKey(node.key)){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            lruMap.remove(node.key);
        }
    }
    
    public void insert(Node node){
        lruMap.put(node.key, node);
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
    }
    
    class Node{
        
        int key, value;
        Node prev, next;
        
        Node(int key, int value){
            this.key = key;
            this.value=value;
        }
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
