package LeetCode;

import java.util.*;

//https://leetcode.com/problems/intersection-of-two-arrays-ii/
public class ArrayIntersection {

    //BRUTE FORCE
    public int[] intersect(int[] nums1, int[] nums2) {

        int max = 0;
        if(nums1.length>=nums2.length)
            max = nums1.length;
        else
            max = nums2.length;

        List<Integer> list = new ArrayList<>();

        for(int i = 0;i<nums1.length;i++)
        {
            for(int j = 0;j<nums2.length;j++)
            {
                if(nums1[i]==nums2[j])
                { nums2[j] = -1; //nullify to avoid matching again
                    list.add(nums1[i]);
                    break;
                }
            }
        }


        return list.stream().mapToInt(Integer::intValue).toArray();

    }

    //USING HASHMAP -O(m+n)
    public int[] intersectWithHashMap(int[] nums1, int[] nums2) {


        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> l =new ArrayList<>();


        for(int i = 0;i<nums1.length;i++)
        {
            if(map.containsKey(nums1[i]))
                map.replace(nums1[i],(map.get(nums1[i])+1));
            else
                map.put(nums1[i],1);

        }

        for(int j = 0;j<nums2.length;j++)
        {

            if(map.containsKey(nums2[j]) && (map.get(nums2[j])>0) )
            {

                map.replace(nums2[j],(map.get(nums2[j])-1));
                l.add(nums2[j]);
            }

        }



        return l.stream().mapToInt(Integer::intValue).toArray();
    }

    //2 pointer method -faster than hashMap
    public int[] intersectWith2pointer(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

    ArrayList<Integer> list=new ArrayList();
    int m=nums1.length-1,n=nums2.length-1;
        while(m>-1 && n>-1)
    {
        if(nums1[m]<nums2[n])
        {n--;}
        else if(nums1[m]>nums2[n])
        {m--;}
        else
        {
            list.add(nums1[m--]);
            n--;
        }
    }
    int size=list.size();
    int[] arr =new int[size];

    for(int k=0;k< size;k++)
        arr[k]=list.get(k);

    return arr;

    }

}
