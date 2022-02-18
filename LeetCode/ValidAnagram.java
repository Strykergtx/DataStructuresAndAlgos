package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/valid-anagram/
public class ValidAnagram {

    //O(n)
    public boolean isAnagram(String s, String t) {

        Map<Character,Integer> map = new HashMap<>();

        for(char x:s.toCharArray())
        {
            map.put(x,map.getOrDefault(x,0)+1);
        }

        for(char y:t.toCharArray())
        {
            if(map.containsKey(y))
                map.replace(y,(map.get(y)-1));
            else
                return false;
        }

        for(Map.Entry<Character,Integer> ele: map.entrySet())
        {
            if(ele.getValue() >0)
                return false;
        }

        return true;

    }

    //0(n) //without last loop
    //here we check for length first itself because 3rd for loop in the last solution is in the case the original string size is larger and has higher count
        public boolean isAnagram2(String s, String t) {
            if (s.length() == t.length()) {
                Map<Character, Integer> map = new HashMap<>();
                for (char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
                for (char c : t.toCharArray()) {
                    if (map.containsKey(c) && map.get(c) > 0) //we include the check here itself
                    {
                        map.put(c, map.get(c)-1);
                    } else {
                        return false;  //the original count before decreasing must be greater than 0, only then we can decrease it, if its already 0, we have
                                       //extra character count in second string
                    }
                }
                return true;
            }
            return false;
        }

     //Shorter solution O(n)
    //Uses ascii indexed occurrence array -sarr and tarr
     public boolean isAnagram3(String s, String t) {
         if (s.length() != t.length()) return false;
         int[] sarr = new int[26];
         int[] tarr = new int[26];
         for (int i=0; i<s.length();i++){
             sarr[s.charAt(i)-'a']++;
             tarr[t.charAt(i)-'a']++;
         }

         return (Arrays.equals(sarr,tarr));

     }

     //SOLUTION WITH SINGLE ASCII INDEXED OCCURRENCE ARRAY




}
