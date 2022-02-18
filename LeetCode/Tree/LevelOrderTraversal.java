package LeetCode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-level-order-traversal/
public class LevelOrderTraversal {

    //Has a lot of intermediate data being maintained for the output format otherwise only single queue is enough
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> out = new ArrayList<>();

        if(root==null)
            return out;

        Queue<TreeNode> temp = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> currLevel = new ArrayList<>();

        TreeNode curr = null;
        q.add(root);

        while(!q.isEmpty())
        {
            while(!q.isEmpty())
            {
                curr = q.poll();           //take each element of this level
                currLevel.add(curr.val);  //add to output of current level

                if(curr.left != null)
                    temp.add(curr.left);
                if(curr.right != null)
                    temp.add(curr.right);

            }

            out.add(new ArrayList<>(currLevel)); //add currLevel to output under different new reference
            currLevel.clear();
            q.addAll(temp);
            temp.clear();
        }

        return out;

    }

    //small optimisation using a size to keep track of when the current level nodes are all used up
    public List<List<Integer>> levelOrder2(TreeNode root)
    {
        if(root==null)
        {
            return new ArrayList<>();
        }
        Queue<TreeNode> q=new LinkedList<>();
        List<List<Integer>> al=new ArrayList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            ArrayList<Integer> al1=new ArrayList<>();
            while(size-->0)
            {
                TreeNode temp=q.poll();

                al1.add(temp.val);
                if(temp.left!=null)
                {
                    q.add(temp.left);
                }
                if(temp.right!=null)
                {
                    q.add(temp.right);
                }
            }
            al.add(al1);

        }
        return al;
    }
}
