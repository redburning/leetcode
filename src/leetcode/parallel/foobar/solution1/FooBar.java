package leetcode.parallel.foobar.solution1;

import java.util.concurrent.CountDownLatch;

public class FooBar {
	private int n;
	private CountDownLatch[] fooLatches;
	private CountDownLatch[] barLatches;
	
    public FooBar(int n) {
        this.n = n;
        fooLatches = new CountDownLatch[n];
        barLatches = new CountDownLatch[n];
        for (int i = 0; i < n; i++) {
        	fooLatches[i] = new CountDownLatch(1);
        	barLatches[i] = new CountDownLatch(1);
        }
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            if (i > 0)
            	barLatches[i - 1].await();
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
        	fooLatches[i].countDown();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            fooLatches[i].await();
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
        	barLatches[i].countDown();
        }
    }
}
