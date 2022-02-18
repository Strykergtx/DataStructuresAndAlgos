package LeetCode.Tree;

//https://leetcode.com/problems/path-sum/
public class PathSum {
    //Using recursion
    public boolean isPathSumPossible(TreeNode node,int targetSum)
    {
        if(node!=null)
        {
            targetSum = targetSum-node.val;
            if(targetSum==0 && node.left==null && node.right==null)
                return true;
            if(isPathSumPossible(node.left,targetSum) || isPathSumPossible(node.right,targetSum))
                return true;


        }


        return false;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {

        return isPathSumPossible(root,targetSum);

    }
}
