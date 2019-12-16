package leetcode.algorithm.design;

import java.util.Arrays;

public class MyHashMap {

	private int[] hashMap;
	
	/** Initialize your data structure here. */
    public MyHashMap() {
        hashMap = new int[1000000];
        Arrays.fill(hashMap, -1);
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        hashMap[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return hashMap[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        hashMap[key] = -1;
    }
	
	public static void main(String[] args) {
		MyHashMap hashMap = new MyHashMap();
		hashMap.put(1, 1);
		hashMap.put(2, 2);
		System.out.println(hashMap.get(1));
		System.out.println(hashMap.get(3));
		hashMap.put(2, 1); 
		System.out.println(hashMap.get(2));
		hashMap.remove(2);
		System.out.println(hashMap.get(2));
	}

}
