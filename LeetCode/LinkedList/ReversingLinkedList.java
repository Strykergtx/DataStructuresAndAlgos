package LeetCode.LinkedList;

public class ReversingLinkedList {
    //https://leetcode.com/problems/reverse-linked-list/submissions/
    public ListNode reverseList(ListNode head) {

        ListNode marker = head;
        ListNode prev   = head;
        ListNode temp   = null;


        while(marker!= null)
        {
            if(marker == head)
            {
                temp = marker.next; //store next in temp
                prev = head;       //make current prev
                marker.next = null;   //make next of this null, as its head
                marker = temp;       //next element to process will be temp
            }
            else
            {

                temp = marker.next;
                marker.next = prev;
                prev = marker;
                marker = temp;

            }


        }

        return prev;


    }
}
