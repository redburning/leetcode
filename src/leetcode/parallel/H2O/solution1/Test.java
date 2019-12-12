package leetcode.parallel.H2O.solution1;

import leetcode.parallel.H2O.Hydrogen;
import leetcode.parallel.H2O.Oxygen;

public class Test {

	public static void main(String[] args) {
		String input = "OOHHHHHHO";
		H2O h2o = new H2O();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == 'H') {
				Thread h = new Thread() {
					@Override
					public void run() {
						Hydrogen hydrongen = new Hydrogen();
						try {
							h2o.hydrogen(hydrongen);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				};
				h.start();
			} else if (input.charAt(i) == 'O') {
				Thread o = new Thread() {
					@Override
					public void run() {
						Oxygen oxygen = new Oxygen();
						try {
							h2o.oxygen(oxygen);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				};
				o.start();
			}
		}
	}

}
