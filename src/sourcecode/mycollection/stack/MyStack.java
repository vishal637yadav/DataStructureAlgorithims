package sourcecode.mycollection.stack;

/*
Stack : implements LIFO
push(),pop(),peek()
*/

public class MyStack<T> {

    T[] data;
    int peekIndex;

    MyStack(int initialSize) {
        this.data = (T[]) new Object[initialSize];
        this.peekIndex = -1;
    }
    //data.length = 5
    //lastIndex = 4

    public void push(T e) throws MyStackFullException {
        if (peekIndex == data.length - 1) {
            throw new MyStackFullException();
        }
        data[++peekIndex] = e;
    }

    public T pop() throws MyStackEmptyException {
        if (peekIndex == -1) {
            throw new MyStackEmptyException();
        }
        T removedElement = data[peekIndex];
        peekIndex--;
        return removedElement;
    }

    public void display() {
        System.out.println("----------------start-------------------peek:" + peek());
        for (int i = peekIndex; i >= 0; i--) {
            System.out.println(" " + data[i]);
        }
        System.out.println("----------------end-------------------------");
    }

    public int peek() {
        return peekIndex;
    }

}

