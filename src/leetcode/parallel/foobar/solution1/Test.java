package leetcode.parallel.foobar.solution1;

import leetcode.parallel.foobar.PrintBar;
import leetcode.parallel.foobar.PrintFoo;

public class Test {
	public static void main(String[] args) {
		int n = 3;
		FooBar fooBar = new FooBar(n);
		
		Thread foo = new Thread() {
			@Override
			public void run() {
				PrintFoo printFoo = new PrintFoo();
				try {
					fooBar.foo(printFoo);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		foo.start();
		
		Thread bar = new Thread() {
			@Override
			public void run() {
				PrintBar printBar = new PrintBar();
				try {
					fooBar.bar(printBar);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		bar.start();
	}
}
