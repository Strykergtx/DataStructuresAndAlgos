package LeetCode.Tree;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
public class LCA_BST {

    //RECURSION STANDARD SOLUTION
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null) return null;

        if(p.val>root.val && q.val>root.val)
            return  lowestCommonAncestor(root.right,p,q);

        if(p.val<root.val && q.val<root.val)
            return  lowestCommonAncestor(root.left,p,q);


        return root;


    }
}
