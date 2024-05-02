package sourcecode.mycollection.stack;


public class MyStackDemoDrivingClass {

    public static void main(String[] args) {

        MyStack<Integer> stack = new MyStack<>(5);
        try {
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);
            stack.push(5);
            stack.display();
            System.out.println("----before 6 push---");
            stack.push(6);
            stack.display();
        } catch (MyStackFullException e) {
            System.out.println("Exception :" + e.getMessage());
        }

        int popedElement = 0;
        try {
            popedElement = stack.pop();
            System.out.println("popedElement --:" + popedElement);
            stack.display();
            popedElement = stack.pop();
            System.out.println("popedElement --:" + popedElement);
            stack.display();
            popedElement = stack.pop();
            System.out.println("popedElement --:" + popedElement);
            stack.display();
            popedElement = stack.pop();
            System.out.println("popedElement --:" + popedElement);
            stack.display();
            popedElement = stack.pop();
            System.out.println("popedElement --:" + popedElement);
            stack.display();
            popedElement = stack.pop();
            System.out.println("popedElement --:" + popedElement);
            stack.display();

        } catch (MyStackEmptyException e) {
            System.out.println("Exception :" + e.getMessage());
        }
    }

}

