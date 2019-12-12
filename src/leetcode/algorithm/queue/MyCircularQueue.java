package leetcode.algorithm.queue;

public class MyCircularQueue {

	private class Node{
		int val;
		Node next;
		Node() {
			
		}
		Node(int v) {
			val = v;
		}
	};
	
	private Node head;
	private Node tail;
	private int initSize;
	private int currSize;
	
	/** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        initSize = k;
        currSize = 0;
        head = new Node();
        tail = head;
        head.next = tail;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (currSize < initSize) {
        	Node pre = tail;
        	Node node = new Node(value);
        	node.next = head;
        	pre.next = node;
        	tail = node;
        	currSize++;
        	return true;
        } else {
        	return false;
        }
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (currSize > 0) {
        	// may cause memory leak
        	head.next = head.next.next;
        	currSize--;
        	if (isEmpty()) {
        		tail = head;
        	}
        	return true;
        } else {
        	return false;
        }
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if (currSize > 0) {
        	return head.next.val;
        } else {
        	return -1;
        }
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if (currSize > 0) {
        	return tail.val;
        } else {
        	return -1;
        }
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return head.next == head ? true : false;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return currSize == initSize ? true : false;
    }
	
    /** Print the circular queue. */
    public void display() {
    	System.out.print("head");
    	Node p = head.next;
    	while(p != head) {
    		System.out.print(" -> " + p.val);
    		p = p.next;
    	}
    	System.out.println(" -> head");
    	System.out.println("tail: " + tail.val);
    }
    
	public static void main(String[] args) {
		MyCircularQueue circularQueue = new MyCircularQueue(81); // 设置长度为 81
		// 返回 true
		System.out.println(circularQueue.enQueue(69));
		//circularQueue.display();
		
		// 返回 true
		System.out.println(circularQueue.deQueue());
		//circularQueue.display();
		
		// 返回 true
		System.out.println(circularQueue.enQueue(92));
		//circularQueue.display();
		
		// 返回 true
		System.out.println(circularQueue.enQueue(12));
		// 返回 true
		System.out.println(circularQueue.deQueue());
		// 返回 false
		System.out.println(circularQueue.isFull());
		// 返回 false
		System.out.println(circularQueue.isFull());
		// 返回 12
		System.out.println(circularQueue.Front());
	}

}
