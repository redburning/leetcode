package leetcode.algorithm.design;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {

	private Map<Integer, Integer> valueMap;
	private Map<Integer, Integer> indexMap;
	private int index;
	
	/** Initialize your data structure here. */
    public RandomizedSet() {
        valueMap = new HashMap<Integer, Integer>();
        indexMap = new HashMap<Integer, Integer>();
        index = 0;
    }
	
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!valueMap.containsKey(val)) {
        	valueMap.put(val, index);
        	indexMap.put(index, val);
        	index++;
        	return true;
        }
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (valueMap.containsKey(val)) {
        	valueMap.remove(val);
        	return true;
        }
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
    	Random r = new Random();
    	int index;
    	do {
    		index = r.nextInt(valueMap.size());
    	} while (!valueMap.containsValue(indexMap.get(index)));
    	return indexMap.get(indexMap.get(index));
    }
	
    public static void main(String[] args) {
    	RandomizedSet randomSet = new RandomizedSet();
    	System.out.println(randomSet.insert(1));
    	System.out.println(randomSet.remove(2));
    	System.out.println(randomSet.insert(2));
    	System.out.println(randomSet.getRandom());
    	System.out.println(randomSet.remove(1));
    	System.out.println(randomSet.insert(2));
    	System.out.println(randomSet.getRandom());
    }
    
}
