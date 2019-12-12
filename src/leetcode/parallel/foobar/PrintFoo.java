package leetcode.parallel.foobar;

public class PrintFoo implements Runnable {

	@Override
	public void run() {
		System.out.print("Foo");
	}

}
