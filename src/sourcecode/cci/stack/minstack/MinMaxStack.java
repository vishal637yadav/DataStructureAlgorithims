package sourcecode.cci.stack.minstack;

interface MinMaxStack<E extends Comparable<E>> {

    //O(1): Time Complexity
    void push(E data);

    //O(1): Time Complexity
    E pop();

    //O(1): Time Complexity
    E peek();

    //O(1): Time Complexity
    E maxOrmin();

    //O(1): Time Complexity
    boolean isEmpty();

}
