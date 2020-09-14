import java.util.Stack;
//Given an expression string exp. Examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
//For example, the program should print 'balanced' for exp = “[()]{}{[()()]()}” and 'not balanced' for exp = “[(])”

public class ExpBalanced {
    public static boolean expBalanced(String s) {
        int len = s.length();
        Stack<Character> myStack = new Stack();
        for (int i = 0; i < len; i++) {
            char e = s.charAt(i); //for(char c: s.toChatArray()
            if (e == '{' || e == '[' || e == '(')
                myStack.push(e);
            else if (e == '}' || e == ')' || e == ']') {
                if(myStack.isEmpty()) return false;
                char poped = myStack.pop();
                if (e == '}' && poped == '{') continue;
                if (e == ']' && poped == '[') continue;
                if (e == ')' && poped == '(') continue;
                return false;
            }
        }
        if(myStack.isEmpty())
            return true;
        return false;
    }

    public static void main(String[] args) {
        String s = "([r(U{Y})]";
        boolean b = expBalanced(s);
        System.out.println(b);

    }
}








