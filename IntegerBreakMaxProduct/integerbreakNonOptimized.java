package com.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class integerbreakNonOptimized {

    static int maxprod=1;

    static void f(int curSum,int targetSum,int[] arr,int index)
    {
       if(targetSum==curSum) {
           int prod=1;
           for (int x : arr)
               prod = prod * x;

           if(prod>maxprod)
                maxprod=prod;

       }
       if(curSum>targetSum)
        return;

        for(int i = 1;i<=(targetSum-curSum);i++)
        {
            arr[index]= i;
            f(curSum+i,targetSum,arr,index+1);

        }


    }
    public static void main(String[] args)
    {
        int[] arr = new int[10];
        f(0,10,arr,0);

        System.out.println(maxprod);
    }

}
