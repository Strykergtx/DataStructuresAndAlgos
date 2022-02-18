package LeetCode.Tree;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
public class TwoSumBST {

    //NORMAL RECURSION WITH COMPLIMENT SET
    public boolean sumExists(TreeNode node, int target, Set set)
    {
        if(node!=null)
        {
            if(set.contains(node.val))
                return true;
            else
            {
                set.add(target-(node.val));
                return (sumExists(node.left,target,set) || sumExists(node.right,target,set));

            }
        }

        return false;
    }

    public boolean findTarget(TreeNode root, int k) {

        Set<Integer> set = new HashSet<>();
        return sumExists(root,k,set);
    }

}
