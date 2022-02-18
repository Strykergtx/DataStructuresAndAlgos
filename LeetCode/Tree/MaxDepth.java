package LeetCode.Tree;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaxDepth {

    //normal solution with external variable having max depth -Variation 1 (PREORDER)
    //NOTE THE PLACEMENT OF THE (HEIGHT>MAXHEIGHT) DOES NOT MATTER COULD BE ALSO PREORDER,POSTORDER,INORDER
    int maxHeight=0;
    public void getMaxHeight(TreeNode root,int height)
    {
        if(root==null)
            return;
        if(height>maxHeight)
            maxHeight=height;

        getMaxHeight(root.left,height+1);
        getMaxHeight(root.right,height+1);

    }

    public int maxDepth(TreeNode root) {

        int height = 1;

        if(root==null)
            return 0;
        else
            getMaxHeight(root,height);

        return maxHeight;

    }


    //method 2
    public int getMaxHeight2(TreeNode root)
    {
        if(root == null)
            return 0;

        int leftHeight = getMaxHeight2(root.left);
        int rightHeight = getMaxHeight2(root.right);

        return (1 + ((leftHeight>rightHeight)? leftHeight : rightHeight));

    }

    public int maxDepth2(TreeNode root) {

        return getMaxHeight2(root);

    }




}
