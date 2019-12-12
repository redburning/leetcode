package leetcode.algorithm.queue;

public class MyDeque {
	
	class Node {
		int val;
		Node pre;
		Node next;
		
		Node() {
			
		}
		Node(int v) {
			val = v;
		}
	}
	
	private int initSize;
	private int currSize;
	private Node front;
	private Node rear;
	
	/** Initialize your data structure here. Set the size of the deque to be k. */
    public MyDeque(int k) {
        initSize = k;
        currSize = 0;
        front = new Node();
        rear = new Node();
        front.next = rear;
        rear.pre = front;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (currSize < initSize) {
        	Node node = new Node(value);
        	Node head = front.next;
        	node.next = head;
        	head.pre = node;
        	node.pre = front;
        	front.next = node;
	        currSize++;
	        return true;
        } else {
        	return false;
        }
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (currSize < initSize) {
        	Node node = new Node(value);
        	Node tail = rear.pre;
        	node.next = rear;
        	rear.pre = node;
        	node.pre = tail;
        	tail.next = node;
        	currSize++;
        	return true;
        } else {
        	return false;
        }
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (currSize > 0) {
        	Node head = front.next.next;
        	front.next = head;
        	head.pre = front;
        	currSize--;
        	return true;
        } else {
        	return false;
        }
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (currSize > 0) {
        	Node tail = rear.pre.pre;
        	tail.next = rear;
        	rear.pre = tail;
        	currSize--;
        	return true;
        } else {
        	return false;
        }
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        return currSize > 0 ? front.next.val : -1;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        return currSize > 0 ? rear.pre.val : -1;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return currSize == 0 ? true : false;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return currSize == initSize ? true : false;
    }
    
    public static void main(String[] args) {
    	// 设置容量大小为3
    	MyDeque circularDeque = new MyDeque(3);
    	// 返回 true
    	System.out.println(circularDeque.insertLast(1));
    	// 返回 true
    	System.out.println(circularDeque.insertLast(2));
    	// 返回 true
    	System.out.println(circularDeque.insertFront(3));
    	// 已经满了，返回 false
    	System.out.println(circularDeque.insertFront(4));
    	// 返回 2
    	System.out.println(circularDeque.getRear());
    	// 返回 true
    	System.out.println(circularDeque.isFull());
    	// 返回 true
    	System.out.println(circularDeque.deleteLast());
    	// 返回 true
    	System.out.println(circularDeque.insertFront(4));
    	// 返回 4
    	System.out.println(circularDeque.getFront());
    }
}
