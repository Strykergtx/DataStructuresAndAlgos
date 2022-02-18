package LeetCode.Tree;


//https://leetcode.com/problems/validate-binary-search-tree/
public class CheckIfBSTIsValid {

    //RECURSIVE SHORTEST METHOD
    //YOU CHECK FOR CASES WHICH RETURN FALSE INSTEAD OF WHICH RETURN TRUE
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode root, long min, long max){
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return (helper(root.right,root.val,max) && helper(root.left, min, root.val));
    }

    //RECURSION USING PREVIOUS NODE VALUE DOES NOT WORK
    //ACCORDING TO LEETCODE INPUT FORMAT (LEVEL ORDER)-[5,4,6,null,null,3,7] IS NOT A VALID BINARY TREE
    //BECAUSE NODE 3 IS LESS THAN THE ROOT 5, AND IT LIES ON ITS RIGHT


    //recursive method 2 without the MAX_VALUES
    static boolean isBST(TreeNode root, TreeNode l, TreeNode r)
    {
        if (root == null)
            return true;

        if (l != null && root.val <= l.val)
            return false;

        if (r != null && root.val >= r.val)
            return false;

        return isBST(root.left, l, root) &&
                isBST(root.right, root, r);
    }

    public boolean isValidBST2(TreeNode root) {

        return isBST(root,null,null);

    }

}
