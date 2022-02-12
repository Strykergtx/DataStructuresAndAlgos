package LeetCode.LinkedList;

public class CheckForCycle {

    //https://leetcode.com/problems/linked-list-cycle/
    //Floyd Warshall 1 slow and 1 fast pointer technique
    public boolean hasCycle(ListNode head) {

        if(head!=null)
        {
            ListNode marker = head;
            ListNode marker2 = head;

            while(marker.next!=null && marker2.next!=null && marker2.next.next!=null)
            {

                marker = marker.next;

                marker2 = marker2.next.next;

                if(marker == marker2)
                    return true;

            }


        }
        return false;
    }

    //if modification of LINKED  LIST is allowed
    //Make the currently visited Node to some number which is not possible to appear in the list already.
    //This happens for all nodes in the linked list, a cycle is detected if the traversal hits an already updated node.
    public boolean hasCycle2(ListNode head) {

        ListNode curr=head;

        while(curr!=null){
            curr.val=1000000;
            if(curr.next!=null && curr.next.val==1000000){
                return true;
            }
            curr=curr.next;

        }
        return false;
    }

}
