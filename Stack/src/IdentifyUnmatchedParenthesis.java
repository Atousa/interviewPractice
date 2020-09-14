
////Q8. Identify and mark unmatched parenthesis in an expression
////Given an expression, find and mark matched and unmatched parenthesis in it. We need to replace all balanced opening parenthesis with 0, balanced closing parenthesis with 1 and all
////unbalanced with -1.
////Examples:
////Input : ((a)
//Output : -10a1

import java.util.Stack;

public class IdentifyUnmatchedParenthesis {

    public static void IdentifyUnmatchedParenthesis(StringBuffer exp) {
        Stack<Integer> myStack = new Stack<>();
        int len = exp.length();
        int i = 0;
        for (; i < len; i++) {
            Character c = exp.charAt(i);
            if (c == '(')
                myStack.push(i);
            else if (c == ')') {
                if (myStack.isEmpty())
                    exp.replace(i, i + 1, "-1"); //exclusive
                else {
                    int idx = myStack.pop();
                    exp.replace(idx, idx + 1, "0");
                    exp.replace(i, i + 1, "1");
                }
            }
        }
        while (!myStack.isEmpty()) {
            int l = myStack.pop();
            exp.replace(l, l + 1, "-1");
        }
        System.out.println(exp);
    }

    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer("(a))");
        IdentifyUnmatchedParenthesis(s1);

    }

}



