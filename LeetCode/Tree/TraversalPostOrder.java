package LeetCode.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/binary-tree-postorder-traversal/
public class TraversalPostOrder {

     //recursive solution
     public void postOrder(TreeNode node, List<Integer> l)
     {
         if(node==null)
             return;

         postOrder(node.left,l);
         postOrder(node.right,l);
         l.add(node.val);

         }
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        postOrder(root, list);

        return list;

    }

    //iterative solution
    //very close to the InOrder Method
    //We just peek the next top element and get its right node if it exists and push it into stack
    public List<Integer> postorderTraversal2(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        if(root == null)
            return list;

        Stack<TreeNode> stack = new Stack<>();

        TreeNode popped = null;
        TreeNode marker = root;
        TreeNode top    = null;

        stack.push(root);

        while(!stack.isEmpty())
        {
            if(marker.left!=null)
            {
                marker = marker.left;
                stack.push(marker);
            }
            else
            {

             //   if(!stack.isEmpty())   // can be removed because
            //    {
                    top = stack.peek();
                    if(top.right!=null && popped!=top.right) //this is the trick to prevent infinite loop
                    {
                        stack.push(top.right);
                        marker =top.right;
                    }
                    else
                    {
                        popped = stack.pop();
                        list.add(popped.val);
                    }
            //    }

            }

        }

        return list;
    }


}
