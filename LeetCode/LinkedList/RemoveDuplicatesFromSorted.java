package LeetCode.LinkedList;

public class RemoveDuplicatesFromSorted {
        //https://leetcode.com/problems/remove-duplicates-from-sorted-list/
        public ListNode deleteDuplicates(ListNode head) {
            ListNode current = head;
            ListNode previous = head;
            while (current != null) {
                if (current.val == previous.val) {
                    if (current.next == null)
                        previous.next = null;

                } else {
                    previous.next = current;
                    previous = current;
                }
                current = current.next;
            }
            return head;
        }
}
