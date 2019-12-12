package leetcode.parallel.printnumber.solution2;

import leetcode.parallel.printnumber.IntConsumer;
import leetcode.parallel.printnumber.solution1.ZeroEvenOdd;

public class Test {
	public static void main(String[] args) {
		int n = 6;
		ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(n);
		
		Thread evenThread = new Thread() {
			@Override
			public void run() {
				IntConsumer even = new IntConsumer();
				try {
					zeroEvenOdd.even(even);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		evenThread.start();	
		
		Thread oddThread = new Thread() {
			@Override
			public void run() {
				IntConsumer odd = new IntConsumer();
				try {
					zeroEvenOdd.odd(odd);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		oddThread.start();
		
		Thread zeroThread = new Thread() {
			@Override
			public void run() {
				IntConsumer zero = new IntConsumer();
				try {
					zeroEvenOdd.zero(zero);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		zeroThread.start();
	}
}
