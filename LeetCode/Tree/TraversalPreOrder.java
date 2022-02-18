package LeetCode.Tree;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


//https://leetcode.com/problems/binary-tree-preorder-traversal/
public class TraversalPreOrder {

    //Recursive solution
    public void preorder(TreeNode node, List<Integer> l)
    {
        if(node==null)
            return;

        l.add(node.val);
        preorder(node.left,l);
        preorder(node.right,l);

    }
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        preorder(root, list);

        return list;
    }


    //ITERATIVE SOLUTION WITH STACK
    public List<Integer> preorderTraversal2(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = null;
        stack.push(root);

        while(!stack.isEmpty())
        {
            curr = stack.pop();    //pop from stack

            if(curr!=null)
            {
                list.add(curr.val);   //print
                stack.push(curr.right);
                stack.push(curr.left);
            }

        }

        return list;
    }

}
