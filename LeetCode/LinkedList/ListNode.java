package LeetCode.LinkedList;

   public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
         next = null;
     }

     ListNode() //default
     {
         val = 0;
         next = null;

     }

       public ListNode(int i, ListNode head) {
          this.next = head;
          this.val = i;
       }
   }


