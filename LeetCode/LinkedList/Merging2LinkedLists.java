package LeetCode.LinkedList;

public class Merging2LinkedLists {
     //https://leetcode.com/problems/merge-two-sorted-lists/
    //version 1 (Long and with repetitions), 2 pointer method
    //Returns the head , where the first element is present inside the head itself.
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode list1Marker = list1;
        ListNode list2Marker = list2;
        ListNode myListMarker= null;
        ListNode myListhead  = null;
        ListNode ln          = null;

        while(list1Marker!=null && list2Marker!=null)   //when both lists are full
        {

            if(list1Marker.val<=list2Marker.val)
            {
                ln= new ListNode(list1Marker.val);
                list1Marker = list1Marker.next;  //increment the first list marker
            }
            else
            {
                ln = new ListNode(list2Marker.val);
                list2Marker = list2Marker.next;  //increment the first list marker

            }

            //make new the current
            if(myListhead==null)  //check if its the first element
            {
                myListhead   = ln;
            }
            else
            {
                myListMarker.next = ln; //assign the new node to next of previous
            }
            myListMarker = ln;


        }

        //below 2 while loops for when either one of the lists were already empty
        //and for filling up remaining elements left out after previous while loop
        while(list1Marker!=null)
        {
            ln = new ListNode(list1Marker.val);
            if(myListhead==null)  //check if its the first element
            {
                myListhead   = ln;
            }
            else
            {
                myListMarker.next = ln;
            }
            myListMarker = ln;   //iterator for final list

            list1Marker = list1Marker.next;
        }

        while(list2Marker!=null)
        {
            ln = new ListNode(list2Marker.val);
            if(myListhead==null)  //check if its the first element
            {
                myListhead   = ln;
            }
            else
            {
                myListMarker.next = ln;
            }
            myListMarker = ln;

            list2Marker = list2Marker.next;
        }
        return myListhead;

    }

    //shorter solution , returns head->next in the end
    //uses the property of linked list to avoid creating new nodes
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {

        ListNode list1Marker = list1; //use a different reference so you don't modify the original
        ListNode list2Marker = list2; //use a different reference so you don't modify the original
        ListNode temp = new ListNode(); //temp reference
        ListNode head = temp;  //head reference for returning result

        //fast return if one of them is empty
        if(list1 == null)return list2;
        if(list2 == null)return list1;

        while(list1Marker!=null && list2Marker!=null)
        {
            //no need to create new node
            if(list1Marker.val<=list2Marker.val)
            {
                temp.next = list1Marker;  //
                list1Marker = list1Marker.next;  //increment the first list marker
            }
            else
            {
                temp.next = list2Marker;
                list2Marker = list2Marker.next;  //increment the first list marker

            }

            temp = temp.next;

        }

        if(list1Marker!=null)
        {
            temp.next = list1Marker; //How is this possible ?
            //Because its a linked list, rest of the elements will follow via the next pointer no need to keep repeating for each element
        }

        if(list2Marker!=null)
        {

            temp.next = list2Marker;
        }
        return head.next;
    }
}
