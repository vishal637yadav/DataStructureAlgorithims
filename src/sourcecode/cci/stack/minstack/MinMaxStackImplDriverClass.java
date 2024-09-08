package sourcecode.cci.stack.minstack;

public class MinMaxStackImplDriverClass {

    public static void main(String[] args) {

        minStackExample();
        maxStackExample();

    }

    public static void minStackExample(){

        MinMaxStackImpl<Integer> minStack = new MinMaxStackImpl<>(true);

        minStack.push(13);
        System.out.println(minStack);
        minStack.push(15);
        System.out.println(minStack);
        minStack.push(20);
        System.out.println(minStack);
        minStack.push(125);
        System.out.println(minStack);
        minStack.push(11);
        System.out.println(minStack);
        minStack.push(132);
        System.out.println(minStack);
        System.out.println(minStack.pop());
        System.out.println(minStack);
        System.out.println(minStack.pop());
        System.out.println(minStack);
        System.out.println(minStack.pop());
        System.out.println(minStack);
        System.out.println(minStack.maxOrmin());

    }

    public static void maxStackExample(){

        MinMaxStackImpl<Integer> maxStack = new MinMaxStackImpl<>(false);

        maxStack.push(13);
        System.out.println(maxStack);
        maxStack.push(15);
        System.out.println(maxStack);
        maxStack.push(20);
        System.out.println(maxStack);
        maxStack.push(125);
        System.out.println(maxStack);
        maxStack.push(11);
        System.out.println(maxStack);
        maxStack.push(132);
        System.out.println(maxStack);
        System.out.println(maxStack.pop());
        System.out.println(maxStack);
        System.out.println(maxStack.pop());
        System.out.println(maxStack);
        System.out.println(maxStack.pop());
        System.out.println(maxStack);
        System.out.println(maxStack.maxOrmin());


    }
}
