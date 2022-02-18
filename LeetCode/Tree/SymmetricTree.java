package LeetCode.Tree;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/symmetric-tree/
public class SymmetricTree {
    //RECURSIVE METHOD
    //This uses LEVEL ORDER TRAVERSAL METHOD to get the sub-array for each level
    //max size of each level does not need to be 2^X, it is just = (no of parent nodes in previous level*2)
    //In places where the child is null we fill in -200 which is out of constraint
    //Then we compare the last element of this sub-array with the first element and so on
    //If this comparison fails we return false there itself.
    public boolean isSymmetric(TreeNode root) {

        if(root==null)
        {
            return false;
        }

        Queue<TreeNode> q=new LinkedList<>();
        int idx;
        q.add(root);

        while(!q.isEmpty())
        {
            int size=q.size(); //size of queue consisting of previous parent nodes
            int[] level = new int[size*2]; //current level array size for children nodes
            idx = 0;
            while( size-->0 )
            {
                TreeNode temp = q.poll();

                if(temp.left!=null)
                {
                    q.add(temp.left);  //add it for future queue
                    level[idx++]  = temp.left.val;
                }
                else
                    level[idx++]  = -200;

                if(temp.right!=null)
                {
                    q.add(temp.right);  //add it for future queue
                    level[idx++]  = temp.right.val;
                }
                else
                    level[idx++]  = -200;

            }

            int k = (level.length)-1;
            for(int i=0;i<=(level.length/2)-1;i++)
            {
                if(level[i]!=level[k])
                    return false;
                k--;
            }


        }
        return true;
    }

    //recursive function with n1 and n2 as arguments
    //compare opposite children of n1 and n2 to check if its symmetric
    public boolean isSymmetric(TreeNode n1, TreeNode n2)
    {
        if(n1==null && n2==null)
            return true;


        if(n1!=null && n2!=null && n1.val==n2.val)
        {

            if(isSymmetric(n1.left,n2.right) && isSymmetric(n1.right,n2.left))
                return true;
            else
                return false;

        }


        return false;

    }

    public boolean isSymmetric2(TreeNode root) {

        return(isSymmetric(root.left,root.right));

    }

    //RECURSION VARIANT 2
    //recursive function with n1 and n2 as arguments
    //compare opposite children of n1 and n2 to check if its symmetric
    public boolean isSymmetric2(TreeNode n1, TreeNode n2)
    {
        if(n1==null && n2==null)
            return true;     //if both are null , they are equal


        if(n1!=null && n2!=null && n1.val==n2.val)
        {

            boolean x =isSymmetric(n1.left,n2.right);
            boolean y =isSymmetric(n1.right,n2.left);

            if(x && y)
                return true;  //if both not null, and have values compare
                              //while comparing go all way till the

        }

        return false;

    }

    public boolean isSymmetric3(TreeNode root) {

        return(isSymmetric2(root.left,root.right));

    }



}
