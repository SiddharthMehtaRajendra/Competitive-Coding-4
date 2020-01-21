// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class LinkedListPalindrome {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	class Solution {
		public boolean isPalindrome(ListNode head) {
			if (head == null || head.next == null)
				return true;
			ListNode temp = head;
			ListNode slow = head;
			ListNode fast = head;

			// Find the median of linked list
			while (fast.next != null && fast.next.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}

			fast = reverse(slow.next);

			while (fast != null) {
				if (temp.val != fast.val)
					return false;
				temp = temp.next;
				fast = fast.next;
			}
			return true;
		}

		private ListNode reverse(ListNode head) {
			ListNode prev = null;
			ListNode curr = head;
			ListNode fast = head.next;
			while (fast != null) {
				curr.next = prev;
				prev = curr;
				curr = fast;
				fast = fast.next;
			}
			curr.next = prev;
			return curr;
		}
	}
}
