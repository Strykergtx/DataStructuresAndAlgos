package LeetCode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/ransom-note/
public class RansomNoteSubsetOfString {

        // Time complexity- O(n)
       //Use a hashmap, 1st loop keep the chars and their count,2nd loop decreases the count based on occurrences.
        public boolean canConstruct(String ransomNote, String magazine) {

            if(ransomNote.length()>magazine.length())
                return false;

            Map<Character,Integer> map = new HashMap<>();

            for(char x: magazine.toCharArray())
            {
                map.put(x,map.getOrDefault(x,0)+1);
            }

            for(char y:ransomNote.toCharArray())
            {
                if(map.containsKey(y) && map.get(y)>0)
                {
                    map.replace(y,(map.get(y)-1));
                }
                else
                {
                    return false;
                }

            }
            return true;

        }

}
