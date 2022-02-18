package LeetCode.Tree;


//https://leetcode.com/problems/search-in-a-binary-search-tree/
public class SearchInBST {

    //version one USING RETURN PATTERN, BUT ONLY REQUIRED NODE IS RETURNED
    //This version is different from the pattern for Inserting into BST
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

    //version 2 -look on geeksforgeeks
    public TreeNode search(TreeNode root, int key)
    {

        if (root==null || root.val==key)
            return root;

        if (root.val < key)
            return search(root.right, key);

        return search(root.left, key);
    }
}
