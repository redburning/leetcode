package leetcode.algorithm.reservoirsampling.randomlistnode;


public class Test {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		Solution solution = new Solution(head);
		for (int i = 0; i < 30; i++) {
			int value = solution.getRandom();
			System.out.println(value);
		}
	}
	
}
