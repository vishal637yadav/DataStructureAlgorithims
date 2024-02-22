package sourcecode.builtin.ds.stack;

import java.util.Stack;

public class StackDemo {

    public static void main(String[] args) {
        System.out.println("This is main !!");

        Stack<String> stack = new Stack<>();

        System.out.println("stack :"+stack);

        stack.push("CardBoard");
        stack.push("White Papers");
        stack.push("Note Book");

        System.out.println("stack :"+stack);
        System.out.println("stack.pop() :"+stack.pop());
        System.out.println("stack :"+stack);

        stack.push("Ipad");
        System.out.println("stack :"+stack);


    }

}
