package leetcode.parallel.printorder;

public class PrintSecond implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.print("Two");
	}

}
