package leetcode.algorithm.list;

public class RemoveNthFromEnd {
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        int cnt = 0;
        while (cnt < n && first.next != null) {
        	first = first.next;
        	cnt++;
        }
        if (first.next == null && cnt == n - 1)
        	return head.next;
        
        while (first.next != null) {
        	first = first.next;
        	second = second.next;
        }
        second.next = second.next.next;
        return head;
    }
	
}
