package LeetCode.Tree;

import java.util.ArrayList;
import java.util.List;

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



}
