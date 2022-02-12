package LeetCode.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


//https://leetcode.com/problems/binary-tree-inorder-traversal/
public class InorderTraversal {
    //Inorder recursive
    public void inOrder(TreeNode node, List<Integer> l)
    {
        if(node==null)
            return;

        inOrder(node.left,l);
        l.add(node.val);
        inOrder(node.right,l);

    }
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        inOrder(root, list);

        return list;
    }

    //Uses iteration
    public List<Integer> inorderTraversal2(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        if(root == null)
            return list;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        TreeNode popped = null;  //recently popped node
        TreeNode marker = root;  //tracks the last visited node

        while(!stack.isEmpty())
        {
            if(marker.left!=null)
            {
                marker = marker.left; //keep going left
                stack.push(marker); //keep pushing in all elements
            }
            else
            {
                popped = stack.pop(); //a left node does not exist anymore so pop it and add to list
                list.add(popped.val);

                if(popped.right!=null)
                {
                    stack.push(popped.right); //adding new root
                    marker = popped.right;
                }
            }

        }

        return list;
    }

}
