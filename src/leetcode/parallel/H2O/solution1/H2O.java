package leetcode.parallel.H2O.solution1;

public class H2O {
	
	private int hydrongenNum;
	private Object lock;
	
	public H2O() {
		hydrongenNum = 0;
		lock = new Object();
	}
	
	public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		synchronized (lock) {
			while (hydrongenNum >= 2)
				lock.wait();
			
			// releaseHydrogen.run() outputs "H". Do not change or remove this line.
	        releaseHydrogen.run();
	        
	        hydrongenNum++;
	        if (hydrongenNum == 2)
	        	lock.notifyAll();
		}
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
    	synchronized (lock) {
    		while (hydrongenNum < 2) 
        		lock.wait();
        	
        	// releaseOxygen.run() outputs "H". Do not change or remove this line.
    		releaseOxygen.run();
    		
    		hydrongenNum -= 2;
			lock.notifyAll();
        }
    }
}
