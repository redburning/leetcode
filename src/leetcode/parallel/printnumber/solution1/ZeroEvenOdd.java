package leetcode.parallel.printnumber.solution1;

import java.util.concurrent.CountDownLatch;

import leetcode.parallel.printnumber.IntConsumer;

public class ZeroEvenOdd {
	private int n;
	private CountDownLatch[] latches;
	
    public ZeroEvenOdd(int n) {
        this.n = n;
        latches = new CountDownLatch[2 * n];
        for (int i = 0; i < 2 * n; i++) {
        	latches[i] = new CountDownLatch(1);
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
        	if (i > 0) 
        		latches[2 * i - 1].await();
        	printNumber.accept(0);
        	latches[2 * i].countDown();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
        	latches[2 * i - 2].await();
        	printNumber.accept(i);
        	latches[2 * i - 1].countDown();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
    	for (int i = 1; i <= n; i += 2) {
        	latches[2 * i - 2].await();
        	printNumber.accept(i);
        	latches[2 * i - 1].countDown();
        }
    }
}
