package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/pascals-triangle/
public class PascalsTriangle {

    //Using jagged array (2d)
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

    //short solution
    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for( int i = 0; i< numRows; i++) {
            List<Integer> list1 = new ArrayList<>();
            list1.add(1);
            for(int j = 0; j < i-1; j++) {
                list1.add(ans.get(i-1).get(j) + ans.get(i-1).get(j+1));
            }
            if(i > 0) {
                list1.add(1);
            }
            ans.add(list1);
        }
        return ans;
    }

    public static void main(String args[])
    {
        System.out.println(generate(5));


    }
}
