package sourcecode.mycollection.heap;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * For data[i]
 * data[i].left   = data[i*2 +1]
 * data[i].right  = data[i*2 +2]
 * data[i].parent = data[Math.floor((i-1)/2)]
 */
public class MyHeap<E> implements Heap<E> {

    private static final int DEFAULT_MAX_HEAP_HEIGHT = 4;

    E[] data;
    int size;

    /**
     * @noinspection unchecked
     */
    MyHeap() {
        int maxNoOfNodes = (int) Math.pow(2, (DEFAULT_MAX_HEAP_HEIGHT + 1)) - 1;
        System.out.println("maxNoOfNodes::" + maxNoOfNodes);
        data = (E[]) Array.newInstance(Object.class, maxNoOfNodes);
    }

    /*
     * data[i].left   = data[i*2 +1]
     */
    private E getLeftChild(int index) {
        int leftChildIndex = index * 2 + 1;

        if (leftChildIndex < size) {
            return data[leftChildIndex];
        } else {
            return null;
        }
    }

    private E getRightChild(int index) {
        int rightChildIndex = index * 2 + 2;

        if (rightChildIndex < size) {
            return data[rightChildIndex];
        } else {
            return null;
        }
    }

    //index 0 parent is null;
    private E getParent(int index) {

        if (index == 0) {
            return null;
        }

        int parentIndex = (int) Math.floor((index - 1) / 2);
        return data[parentIndex];
    }

    @Override
    public void insert(E data) {
        this.data[size] = data;
        size++;
    }

    @Override
    public E delete() {
        E deletedElement = data[size - 1];
        size--;
        return deletedElement;
    }

    @Override
    public void preOrderTraversal() {
        System.out.println("--------------inOrderTraversalRecursively-----------------------");
        preOrderTraversalRecursively(0);
        System.out.println();
    }

    @Override
    public void inOrderTraversal() {
        System.out.println("--------------inOrderTraversalRecursively-----------------------");
        inOrderTraversalRecursively(0);
        System.out.println();
    }

    @Override
    public void postOrderTraversal() {
        System.out.println("--------------inOrderTraversalRecursively-----------------------");
        postOrderTraversalRecursively(0);
        System.out.println();
    }

    public void levelOrderTraversal() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(data[i]).append(",");
        }

        System.out.println(sb.toString());
    }

    public void inOrderTraversalRecursively(int index) {
        //base condition
        if (data[index] == null || index > this.size - 1) {
            return;
        }

        inOrderTraversalRecursively(index * 2 + 1);
        System.out.print(data[index] + ", ");
        inOrderTraversalRecursively(index * 2 + 2);
    }

    public void inOrderTraversalIteratively() {
        //will implement soon...
    }

    public void preOrderTraversalRecursively(int index) {
        //base condition
        if (data[index] == null || index > this.size - 1) {
            return;
        }

        System.out.print(data[index] + ", ");
        preOrderTraversalRecursively(index * 2 + 1);
        preOrderTraversalRecursively(index * 2 + 2);
    }

    public void postOrderTraversalRecursively(int index) {
        //base condition
        if (data[index] == null || index > this.size - 1) {
            return;
        }

        postOrderTraversalRecursively(index * 2 + 1);
        postOrderTraversalRecursively(index * 2 + 2);
        System.out.print(data[index] + ", ");

    }

    public void displayParentChildOfEveryHeapNode() {
        System.out.println("------------displayParentChildOfEveryHeapNode---start---------------");
        E parent, leftChild, rightChild;
        for (int i = 0; i < size; i++) {
            parent = this.getParent(i);
            leftChild = this.getLeftChild(i);
            rightChild = this.getRightChild(i);
            System.out.println("----------------------------------------------------------------------");
            System.out.println("----CurrentNode :" + data[i]);
            System.out.println("                Parent :" + parent);
            System.out.println("      LeftChild :" + leftChild + "|      RightChild :" + rightChild);
            System.out.println("----------------------------------------------------------------------");
        }
        System.out.println("------------displayParentChildOfEveryHeapNode---eends---------------");
    }

    @Override
    public String toString() {
        return "MyHeap\n{\n" +
                " data=" + Arrays.toString(data) + ",\n" +
                " size=" + size +
                "}\n";
    }

    public static void main(String[] args) {
        System.out.println("-------------------");

        MyHeap<Character> myHeap = new MyHeap<>();
        myHeap.insert('A');
        myHeap.insert('B');
        myHeap.insert('C');
        myHeap.insert('D');
        myHeap.insert('E');
        myHeap.insert('F');
        myHeap.insert('G');

        System.out.println("myHeap ::" + myHeap);
        myHeap.levelOrderTraversal();
        System.out.println("myHeap ::" + myHeap.delete());
        myHeap.levelOrderTraversal();
        System.out.println("myHeap ::" + myHeap);
        myHeap.inOrderTraversal();

        System.out.println("myHeap.getParent(6) :::" + myHeap.getParent(6));
        System.out.println("myHeap.getParent(5) :::" + myHeap.getParent(5));
        System.out.println("myHeap.getParent(4) :::" + myHeap.getParent(4));
        System.out.println("myHeap.getParent(3) :::" + myHeap.getParent(3));
        System.out.println("myHeap.getParent(2) :::" + myHeap.getParent(2));
        System.out.println("myHeap.getParent(1) :::" + myHeap.getParent(1));
        System.out.println("myHeap.getParent(0) :::" + myHeap.getParent(0));
        myHeap.preOrderTraversal();
        System.out.println();
        myHeap.postOrderTraversal();

        myHeap.displayParentChildOfEveryHeapNode();

    }

}
