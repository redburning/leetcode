package leetcode.parallel.printorder.solution1;

import leetcode.parallel.printorder.PrintFirst;
import leetcode.parallel.printorder.PrintSecond;
import leetcode.parallel.printorder.PrintThird;
import leetcode.parallel.printorder.solution1.Foo;

public class Test {

	public static void main(String[] args) {
		int[] order = {1, 3, 2};
		Foo foo = new Foo();
		for (int i = 0; i < order.length; i++) {
			if (order[i] == 1) {
				Thread t = new Thread() {
					@Override
					public void run() {
						PrintFirst printFirst = new PrintFirst();
						try {
							foo.first(printFirst);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				};
				t.start();
			} else if (order[i] == 2) {
				Thread t = new Thread() {
					@Override
					public void run() {
						PrintSecond printSecond = new PrintSecond();
						try {
							foo.second(printSecond);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				};
				t.start();
			} else if (order[i] == 3) {
				Thread t = new Thread() {
					@Override
					public void run() {
						PrintThird printThird = new PrintThird();
						try {
							foo.third(printThird);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				};
				t.start();
			}
		}
	}


}
