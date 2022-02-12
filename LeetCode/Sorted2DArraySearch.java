package LeetCode;

//https://leetcode.com/problems/search-a-2d-matrix/submissions/
public class Sorted2DArraySearch {

    //Solution can be optimized with Binary Search when searching inside row
    //O(n) solution
    //You only check the last column of the 2d array as it's sorted for the pocket/row where it may lie.
    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int columns = matrix[0].length;

        int k= 0;

        while(k<matrix.length && target >matrix[k][columns-1])
        {
            k++;
        }

        if(k+1>matrix.length)
            return false;
        for(int i = 0;i<matrix[0].length;i++)
        {
            if(matrix[k][i]==target)
                return true;
        }



        return false;

    }
}
