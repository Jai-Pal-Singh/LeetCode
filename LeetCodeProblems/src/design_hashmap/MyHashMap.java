package design_hashmap;

import java.util.ArrayList;

/* Design a HashMap without using any built-in hash table libraries.

Implement the MyHashMap class:

MyHashMap()initializes the object with an empty map.void put(int key,int value)inserts a(key,value)pair into the HashMap.If the key already exists in the map,update the corresponding value.int get(int key)returns the value to which the specified key is mapped,or-1 if this map contains no mapping for the key.void remove(key)removes the key and its corresponding value if the map contains the mapping for the key.

Example 1:

Input["MyHashMap","put","put","get","get","put","get","remove","get"][[],[1,1],[2,2],[1],[3],[2,1],[2],[2],[2]]Output[null,null,null,1,-1,null,1,null,-1]

Explanation MyHashMap myHashMap=new MyHashMap();myHashMap.put(1,1); // The map is now [[1,1]]
myHashMap.put(2,2); // The map is now [[1,1], [2,2]]
myHashMap.get(1); // return 1, The map is now [[1,1], [2,2]]
myHashMap.get(3); // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
myHashMap.put(2,1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
myHashMap.get(2); // return 1, The map is now [[1,1], [2,1]]
myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
myHashMap.get(2); // return -1 (i.e., not found), The map is now [[1,1]]

Constraints:

0<=key,value<=106 At most 104 calls will be made to put,get,and remove.
 */

class MyHashMap {
    ArrayList<Integer[]> list;
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        list = new ArrayList<>(); 
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        boolean exist = false;
        for(Integer[] row : list){
            if(row[0]==key){
                exist = true;
                row[1] = value;
                break;
            }
        }
        if(!exist){
            Integer[] point = new Integer[2];
            point[0] = key;
            point[1] = value;
            list.add(point);
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        for(Integer[] row : list){
            if(row[0]==key){
                return row[1];
            }
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = -1;
        for(int i =0; i < list.size() ; i++){
            Integer[] point = list.get(i);
            if(point[0] == key){
                index = i;
            }
        }
        if(index!=-1){
            list.remove(list.get(index));
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */