package leetcode.parallel.foobar;

public class PrintBar implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.print("Bar");
	}

}