package com.example;


import java.util.ArrayList;

public class tree {


    public static void inorder(Node node)
    {
        if(node == null)
            return;
        inorder(node.left);
         System.out.println(node.data);
        inorder(node.right);
    }
    static int distanceOfTargetFromRoot =0;
    static int[] arr = new int[10]; //assuming max ancestors will not go past 10 for this example
    static ArrayList<Ancestor> list = new ArrayList<>();
    public static boolean findAncestors(Node root,int data,int DFA)
    {
        if(root == null)
            return false;
        if(root.data==data)
        {
            System.out.println("Target Node found at "+DFA+" distance from root");
            distanceOfTargetFromRoot =DFA;
            return true;
        }
        if(findAncestors(root.left,data,DFA+1)||findAncestors(root.right,data,DFA+1))
        {
            int x =distanceOfTargetFromRoot-DFA;
             System.out.println(root.data+" - at distance-"+DFA+" from root " +"At distance "+x+ " from target");
             list.add(new Ancestor(root,x));
                   return true;

         }

        return false;
    }

    public static void printList()
    {
        for(Ancestor t:list) {
            System.out.println("Node = "+t.node.data+" , at distance"+t.distance+" from target");
        }
    }

    public static void getNodesAtKDistanceAboveTarget()
    {
        //get each node from list pass to the function which calculates distance/height from a particular node-which is the root
        //for that function call, and the other argument = the distance = (K- Ancestor.distance) for that ancestor.

    }

    public static void main(String args[])
    {
        Node root = new Node(5);
        root.right = new Node(3);
        root.left = new Node(4);
        root.left.left = new Node(2);
        root.left.left.left = new Node(9);
        root.left.right = new  Node(1);

        inorder(root);
        System.out.println();
        findAncestors(root,9,0);
        System.out.println("Printing out list for checking");
        printList();





    }



}
