package LeetCode.LinkedList;

public class RemoveLinkedListElements {
    // https://leetcode.com/problems/remove-linked-list-elements/
    //Using fake head, and 2 pointers prev and marker(current)
    //fake head is for removing head element = target element
    public ListNode removeElements(ListNode head, int val) {

        ListNode marker = head;
        ListNode temp   = new ListNode(-1,head);
        ListNode prev   = temp;

        while(marker!=null)
        {

            if(marker.val == val)
            {  prev.next= marker.next;
                marker = marker.next;
            }
            else
            {
                prev   =marker;
                marker =marker.next;
            }
        }

        return temp.next;

    }

    //alternatively do = head = head->next if head is  = target instead of fake head
}
