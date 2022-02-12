package LeetCode.Stack;

import java.util.Stack;

public class QueueUsingStack {
        //https://leetcode.com/problems/implement-queue-using-stacks/
        //Queue using 2 stacks
        Stack<Integer> mainStack = new Stack<>();
        Stack<Integer> helperStack = new Stack<>();

        public QueueUsingStack() {

        }

        public void push(int x) {  //make push costly

            while (!mainStack.empty())
            {
                //transfer everything to helperstack
                helperStack.push(mainStack.pop());
            }

            helperStack.push(x); //push new element to helperstack

            while (!helperStack.empty())
            {
                //transfer everything back to mainstack
                mainStack.push(helperStack.pop());
            }

        }

        public int pop() {
            return mainStack.pop();
        }

        public int peek() {
            return mainStack.peek();
        }

        public boolean empty() {
            return mainStack.empty();
        }

}
