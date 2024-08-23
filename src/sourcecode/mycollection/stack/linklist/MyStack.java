package sourcecode.mycollection.stack.linklist;

import sourcecode.mycollection.stack.Stack;

public class MyStack<E> implements Stack<E> {

    private static class Node<E>{
        Node<E> prev;
        E data;
        Node<E> next;

        Node(E data){
            this.data = data;
        }

        @Override
        public String toString() {
            String s = super.toString().replaceAll("sourcecode.mycollection.stack.linklist.MyStack\\$","");
            return "("+s+"," + data +")";
        }
    }

    private Node<E> top;
    private int topIndex;

    public MyStack(){
        this.topIndex = -1;
    }

    @Override
    public void push(E data) {
        Node<E> newNode = new Node<>(data);
        // Edge Case 2 : if Stack is Not Empty(contains at-least 1 element)
        if(!isEmpty()){
            top.next = newNode;
            newNode.prev = top;
        }
        // Edge Case 1 : if Stack isEmpty
        top = newNode;
        topIndex++;
    }

    @Override
    public E pop() {
        // Edge Case 1 : if Stack isEmpty
        if(isEmpty()){
            return null;
        }

        Node<E> popedNode = top;
        // Edge Case 2 : if Stack is Not Empty and contains only 1 element
        if(!isEmpty() && topIndex == 0){
            top = null;
        // Edge Case 3 : if Stack is Not Empty and contains more than 1 element
        }else{
            top = top.prev;
            top.next = null;
        }
        topIndex--;

        return popedNode.data;
    }

    @Override
    public E peek() {
        return top.data;
    }

    @Override
    public boolean isEmpty() {
        return topIndex == -1;
    }

    @Override
    public String toString() {
        String nodeList = "";

        if(top != null) {
            Node<E> currNode = top;
            StringBuilder sb = new StringBuilder();
            while(currNode!=null){
                sb.append("    Prev-"+currNode.prev).append("|").append("Curr-"+currNode).append("|").append("Next-"+currNode.next);
                sb.append(",\n");
                currNode = currNode.prev;
            }
            nodeList = sb.substring(0,sb.length()-2);
        }

        return "MyStack\n{" +
                "\n top=" + top +
                ",\n topIndex=" + topIndex +
                ",\n NodeList = " +
                "\n  [\n"+nodeList+"\n  ]"+
                "\n}";
    }

    public static void main(String[] args) {

        MyStack<String> myStack = new MyStack<>();
        System.out.println("----------Stack Push :Operation--------------");
        System.out.println("myStack1 :"+myStack);
        myStack.push("A");
        System.out.println("myStack2 :"+myStack);
        myStack.push("B");
        System.out.println("myStack3 :"+myStack);
        myStack.push("C");
        System.out.println("myStack4 :"+myStack);
        myStack.push("D");
        System.out.println("myStack5 :"+myStack);
        System.out.println("myStack..peek() :"+myStack.peek());
        System.out.println("----------Stack Push :Operation--------------");
        System.out.println("myStack.pop() :"+myStack.pop());
        System.out.println("myStack1 :"+myStack);
        System.out.println("myStack.pop() :"+myStack.pop());
        System.out.println("myStack2 :"+myStack);
        System.out.println("myStack.pop() :"+myStack.pop());
        System.out.println("myStack3 :"+myStack);
        System.out.println("myStack.pop() :"+myStack.pop());
        System.out.println("myStack4 :"+myStack);
        System.out.println("myStack.pop() :"+myStack.pop());
        System.out.println("myStack5 :"+myStack);
        System.out.println("myStack.pop() :"+myStack.pop());
        System.out.println("myStack6 :"+myStack);

    }
}
