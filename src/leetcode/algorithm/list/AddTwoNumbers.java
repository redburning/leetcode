package leetcode.algorithm.list;

import java.util.Stack;

public class AddTwoNumbers {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		while (l1 != null) {
			s1.push(l1.val);
			l1 = l1.next;
		}
		while (l2 != null) {
			s2.push(l2.val);
			l2 = l2.next;
		}
		
		int extra = 0;
		ListNode head = null;
		while (!s1.empty() && !s2.empty()) {
			int v1 = s1.pop();
			int v2 = s2.pop();
			int v = (v1 + v2 + extra) % 10;
			extra = (v1 + v2 + extra) / 10;
			ListNode node = new ListNode(v);
			node.next = head;
			head = node;
		}
		while (!s1.empty()) {
			int v1 = s1.pop();
			int v = (v1 + extra) % 10;
			extra = (v1 + extra) / 10;
			ListNode node = new ListNode(v);
			node.next = head;
			head = node;
		}
		while (!s2.empty()) {
			int v2 = s2.pop();
			int v = (v2 + extra) % 10;
			extra = (v2 + extra) / 10;
			ListNode node = new ListNode(v);
			node.next = head;
			head = node;
		}
		while (extra != 0) {
			int v = extra % 10;
			extra = extra / 10;
			ListNode node = new ListNode(v);
			node.next = head;
			head = node;
		}
		return head;
    }
	
	public static void testCase1() {
		ListNode node11 = new ListNode(7);
		ListNode node12 = new ListNode(2);
		ListNode node13 = new ListNode(4);
		ListNode node14 = new ListNode(3);
		node11.next = node12;
		node12.next = node13;
		node13.next = node14;
		
		ListNode node21 = new ListNode(5);
		ListNode node22 = new ListNode(6);
		ListNode node23 = new ListNode(4);
		node21.next = node22;
		node22.next = node23;
		
		AddTwoNumbers solution = new AddTwoNumbers();
		
		ListNode l = solution.addTwoNumbers(node11, node21);
		while (l != null) {
			System.out.print(" -> " + l.val);
			l = l.next;
		}
	}
	
	public static void main(String[] args) {
		testCase1();
	}
	
}
