package leetcode.algorithm.reservoirsampling.randomlistnode;

import java.util.Random;

public class Solution {
	
	private ListNode head;
	
	/** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
	public Solution(ListNode head) {
	    this.head = head;
	}
	
	/** Returns a random node's value. */
	public int getRandom() {
	    if (head != null) {
	    	int res = head.val;
	    	ListNode p = head.next;
	    	int i = 1;
	    	Random random = new Random();
	    	while (p != null) {
	    		i++;
	    		int m = random.nextInt(i) + 1;
	    		if (m <= 1) {
	    			res = p.val;
	    		}
	    		p = p.next;
	    	}
	    	return res;
	    }
	    return -1;
	}
}
