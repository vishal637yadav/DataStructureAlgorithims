package sourcecode.cci.stack.minstack;

public class MinMaxStackImpl<E extends Comparable<E>> implements MinMaxStack<E> {

    private static class Node<E> {
        Node<E> prev;
        E data;
        E currentMinMax;
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }

        @Override
        public String toString() {
            String s = super.toString().replaceAll("sourcecode.cci.stack.minstack.MinMaxStackImpl\\$", "");
            return "(" + s + "," + data + "," + currentMinMax + ", Pre-" + (prev != null ? prev.data : null) + ", Next-" + (next != null ? next.data : null) + ")";
        }

    }

    Node<E> top;
    int size;
    boolean isMinStack;

    public MinMaxStackImpl(boolean isMinStack) {
        this.size = -1;
        this.isMinStack = isMinStack;
    }

    @Override
    public void push(E data) {
        Node<E> newNode = new Node<>(data);
        newNode.prev = top;

        if (isEmpty()) {
            newNode.currentMinMax = data;
        } else {
            Node<E> topNode = peekNode();
            if (isMinStack) {
                if (topNode.currentMinMax.compareTo(data) < 0) {
                    newNode.currentMinMax = topNode.currentMinMax;
                } else {
                    newNode.currentMinMax = data;
                }
            } else {
                if (topNode.currentMinMax.compareTo(data) > 0) {
                    newNode.currentMinMax = topNode.currentMinMax;
                } else {
                    newNode.currentMinMax = data;
                }
            }
            top.next = newNode;
        }
        top = newNode;
        size++;
    }

    @Override
    public E pop() {
        E prevTop = null;

        if (!isEmpty()) {
            prevTop = peek();
            if (size == 1) {
                top = null;
            } else {
                top = top.prev;
                top.next = null;
            }
            size--;
        }
        return prevTop;
    }

    @Override
    public E peek() {
        return top.data;
    }

    private Node<E> peekNode() {
        return top;
    }

    @Override
    public E maxOrmin() {
        return top.currentMinMax;
    }

    @Override
    public boolean isEmpty() {
        return size == -1;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder().append("\n        [\n");
        Node<E> currentNode = top;
        while (currentNode != null) {
            sb.append("          ").append(currentNode).append("\n");
            currentNode = currentNode.prev;
        }
        sb.append("        ]");

        return "MinMaxStackImpl{\n" +
                "   top=" + top +
                ",\n        size=" + size +
                ",\n        isMinStack=" + isMinStack +
                ",\n        MinMaxStackContent=" + sb +
                "\n}\n";

    }

}