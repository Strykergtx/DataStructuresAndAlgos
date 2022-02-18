package LeetCode.Tree;

//https://leetcode.com/problems/invert-binary-tree/
public class InvertingTree {

    //RECURSIVE SOLUTION
    public TreeNode invert(TreeNode root)
    {
        if(root==null)
            return root;

        TreeNode left = invert(root.left);
        TreeNode right = invert(root.right);

        root.left =right;
        root.right = left;

        return root;

    }

    public TreeNode invertTree(TreeNode root) {

        return invert(root);

    }

    //THIS THING DOES NOT WORK, GUESS WHY?
    //THE ROOT'S LEFT GETS CHANGED ALREADY, SO
    //THERE IS A CHANCE THE CALCULATION FOR THE RIGHT GOES WRONG
    //BECAUSE OF THE RECENT MODIFICATION
    public TreeNode invert2(TreeNode root)
    {
        if(root==null)
            return root;

        root.left  =invert(root.right);
        root.right =invert(root.left);

        return root;

    }

    public TreeNode invertTree2(TreeNode root) {

        return invert2(root);

    }
}
