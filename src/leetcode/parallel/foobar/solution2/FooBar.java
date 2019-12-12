package leetcode.parallel.foobar.solution2;

public class FooBar {
	private int n;
	private Object lock;
	private boolean foo;
	private boolean bar;
	
    public FooBar(int n) {
        this.n = n;
        lock = new Object();
        foo = true;
        bar = false;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
        	synchronized (lock) {
        		while (!foo || bar)
        			lock.wait();
        		
        		// printFoo.run() outputs "foo". Do not change or remove this line.
            	printFoo.run();
            	foo = false;
            	bar = true;
            	lock.notifyAll();
        	}
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
            	while (!bar || foo)
            		lock.wait();
            	
            	// printBar.run() outputs "bar". Do not change or remove this line.
            	printBar.run();
            	bar = false;
            	foo = true;
            	lock.notifyAll();
            }
        }
    }
}
