package leetcode.algorithm.queue;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
	
	private static final int MAX_SIZE = 3000;
	
	private Queue<Integer> pingQueue;
	
	public RecentCounter() {
		pingQueue = new LinkedList<Integer>();
	}
	
	public int ping(int t) {
		pingQueue.offer(t);
		while (pingQueue.peek() != null) {
			if (t - pingQueue.peek() > MAX_SIZE)
				pingQueue.poll();
			else
				break;
		}
		return pingQueue.size();
	}
	
	public static void main(String[] args) {
		RecentCounter recentCounter = new RecentCounter();
		System.out.println(recentCounter.ping(1));
		System.out.println(recentCounter.ping(100));
		System.out.println(recentCounter.ping(3001));
		System.out.println(recentCounter.ping(3002));
	}
	
}
