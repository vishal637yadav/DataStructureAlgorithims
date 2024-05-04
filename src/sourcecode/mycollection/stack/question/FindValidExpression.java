package sourcecode.mycollection.stack.question;

import java.util.*;

public class FindValidExpression {

    public static void main(String[] args) {
        String s = "{}(()){[()]}";
        boolean output = valid(s);

        System.out.println("output ::" + output);

    }

    public static boolean valid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else if (c == '}' || c == ')' || c == ']') {
                char peek = stack.peek();
                if ((c == '}' && peek == '{') || (c == ')' && peek == '(') || (c == ']' && peek == '['))
                    stack.pop();
            }
        }

        if (stack.size() == 0) {
            return true;
        }
        return false;
    }

}
