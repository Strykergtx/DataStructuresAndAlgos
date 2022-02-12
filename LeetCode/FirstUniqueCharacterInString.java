package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/first-unique-character-in-a-string/
public class FirstUniqueCharacterInString {

    //naive solution 0(n^2)
    public int firstUniqChar(String s) {
        int flag;
        Set<Character> set = new HashSet<>();
        for(int i =0;i<s.length();i++)
        {
            flag =0;
            char ch = s.charAt(i);
            if(!set.contains(ch))
            {  //if it was not previously established as duplicate
                for(int j =i+1;j<s.length();j++)
                {
                    if(ch == s.charAt(j))
                    {
                        //if duplicate found exit
                        flag =-1;
                        set.add(ch); //no need to process this element again
                        break;
                    }

                }
            }
            else
            {
                flag = -1; //already known duplicate
            }

            if(flag==0)
            {
                return i;
            }

        }

        return -1;
    }

    //Using HashMap 0(n)
    public int firstUniqChar2(String s) {
        if (s == null || s.length() == 0) return -1; //Edge case
        HashMap<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) count.put(c, count.getOrDefault(c, 0) + 1); //Count the occurance of every chars
        for (int i = 0; i < s.length(); i++) {
            if (count.containsKey(s.charAt(i)) && count.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
}
