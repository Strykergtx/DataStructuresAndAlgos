package com.example;


import java.util.Arrays;
import java.util.stream.Collectors;

public class playground {
    static int count =0 ;

   static void f(int curSum,int targetSum,int[] ans,int index)
   {
       if(curSum==targetSum) {
           System.out.println(Arrays.stream(ans).limit(index)
                   .boxed().collect(Collectors.toList()));
           count++;
       }
       if(curSum>targetSum)
       return;

       for(int i = 1;i<=(targetSum-curSum);i++)
       {
           ans[index]= i;
         f(curSum+i,targetSum,ans,index+1);

       }

   }


    public static void main(String[] args)
    {
        int[] arr = new int[10];
        f(0,10,arr,0);
        System.out.println(count);
    }
}
