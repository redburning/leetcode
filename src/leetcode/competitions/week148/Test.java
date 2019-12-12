package leetcode.competitions.week148;

public class Test {

	public static void main(String[] args) {
		SnapshotArray snapshotArray = new SnapshotArray(3);
		snapshotArray.set(0, 5);
		snapshotArray.snap();
		snapshotArray.set(0, 6);
		snapshotArray.snap();
		snapshotArray.set(0, 7);
		int a = snapshotArray.get(0, 0);
		System.out.println(a);
	}

}

