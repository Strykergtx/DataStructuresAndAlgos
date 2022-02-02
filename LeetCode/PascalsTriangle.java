package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {

    //https://leetcode.com/problems/pascals-triangle/
    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>>  out = new ArrayList<>();

        Integer[][] arr = new Integer[numRows][];

        if(numRows==1)
        {
            arr[0]= new Integer[]{1};
        }
        else if(numRows>=2)
        {
            //first phase completed
            arr[0]= new Integer[]{1};
            arr[1]= new Integer[]{1,1};

            int itr = 2;                  //iterating for remaining 2nd phase
                                          //itr is 1 less than numRows, it follows index
            int k=0;

            //second phase
            while(itr<numRows)
            {
                arr[itr] = new Integer[itr+1];
                arr[itr][0]=1;
                arr[itr][itr]=1;

                k = 1;
                for(int i = 0;i<itr-1;i++)
                    arr[itr][k++]=(arr[itr-1][i]+arr[itr-1][i+1]);

                itr++;

            }


        }

        int k=0;
        for(int i = 1;i<=numRows;i++)
        {

            out.add(new ArrayList<Integer>(Arrays.asList(arr[k])));

            k++;
        }

        return out;

    }

    public static void main(String args[])
    {
        System.out.println(generate(5));


    }
}
