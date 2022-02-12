package LeetCode.Stack;

import java.util.Stack;

public class Parenthesis {
    //https://leetcode.com/problems/valid-parentheses/
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();

        int len = s.length();
        if(!(len%2 == 0))
            return false;


        for(int i = 0;i<len;i++)
        {
            char curr = s.charAt(i);
            if(curr=='(' || curr=='{' || curr=='[')
                stack.push(curr);
            else
            {

                if(stack.isEmpty())
                    return false;
                if(curr==')' && stack.peek()=='(' )
                    stack.pop();
                else if(curr=='}' && stack.peek()=='{')
                    stack.pop();
                else if(curr==']' && stack.peek()=='[')
                    stack.pop();
                else
                    return false;

            }

        }

        if(stack.isEmpty())
            return true;


        return false;
    }
}
