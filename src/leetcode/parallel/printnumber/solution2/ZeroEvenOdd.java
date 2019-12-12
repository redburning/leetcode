package leetcode.parallel.printnumber.solution2;

import leetcode.parallel.printnumber.IntConsumer;

public class ZeroEvenOdd {
	
	private int n;
	private Object lock;
	private boolean zero;
	private boolean odd;
	
    public ZeroEvenOdd(int n) {
        this.n = n;
        lock = new Object();
        zero = true;
        odd = true;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
        	synchronized (lock) {
        		while (!zero)
        			lock.wait();
        		
        		printNumber.accept(0);
        		zero = false;
        		lock.notifyAll();
        	}
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
    	for (int i = 1; i < n + 1; i += 2) {
    		synchronized (lock) {
    			while (zero || !odd)
    				lock.wait();
    			
    			printNumber.accept(i);
    			zero = true;	// odd active zero
    			odd = false;	// lock itself
    			lock.notifyAll();
    		}
    	}
    }
    
    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i < n + 1; i += 2) {
        	synchronized (lock) {
        		// 既要看zero, 又要看odd, even自身的优先级�?�?
        		while (zero || odd)
        			lock.wait();
        		
        		printNumber.accept(i);
        		zero = true;	// even active zero
        		odd = true;		// even active odd
        		lock.notifyAll();
        	}
        }
    }
    
}
