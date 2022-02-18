package LeetCode.Tree;

//https://leetcode.com/problems/search-in-a-binary-search-tree/
public class InsertingIntoBST {

    //RECURSIVE SOLUTION FOLLOWS THE RETURN PATTERN
    public TreeNode findNode(TreeNode node,int val)
    {
        TreeNode temp = null;

        if(node!=null)
        {
            if(val>node.val)
                temp =findNode(node.right,val);
            else if(val<node.val)
                temp =findNode(node.left,val);
            else if(val==node.val)
                return node;
        }

        return temp;
    }

    public TreeNode searchBST(TreeNode root, int val) {


        return findNode(root,val);
    }
}
