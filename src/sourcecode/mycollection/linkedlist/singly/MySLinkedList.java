package sourcecode.mycollection.linkedlist.singly;

import sourcecode.mycollection.linkedlist.LinkedList;

public class MySLinkedList<E> implements LinkedList<E> {

    private static class Node<E>{
        E data;
        Node<E> next;

        Node(E data){
            this.data = data;
        }

        @Override
        public String toString() {
            String s = super.toString().replaceAll("sourcecode.mycollection.linkedlist.singly.MySLinkedList\\$","");
            return "("+s+"," + data +")";
        }
    }

    Node<E> head,tail;
    int size;

    @Override
    public String toString() {
        String nodeList = "";

        if(head != null) {
            Node<E> currNode = head;
            StringBuilder sb = new StringBuilder();
            while(currNode!=null){
                sb.append("   ").append("Curr-").append(currNode).append("|").append("Next-").append(currNode.next);
                sb.append(",\n");
                currNode = currNode.next;
            }
            nodeList = sb.substring(0,sb.length()-2);
        }

        return "MySLinkedList\n{" +
                "\n head=" + head +
                ",\n tail=" + tail +
                ",\n size=" + size +
                ",\n NodeList = " +
                "\n  [\n"+nodeList+"\n  ]"+
                "\n}";
    }

    @Override
    public void add(E data) {
        Node<E> newNode = new Node<>(data);

        //edge-case 1 : when Linked-List size = 0 /is Empty
        if(isEmpty()){
            head = newNode;
        //edge-case 2 : when Linked-List size = 1
        }else {
          tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    @Override
    public void addFirst(E data) {
        Node<E> newNode = new Node<>(data);

        //edge-case 1 : when Linked-List size = 0 /is Empty
        if(isEmpty()){
            head = newNode;
            tail = newNode;
        //edge-case 2 : when Linked-List size >= 1
        }else{
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    @Override
    public E set(int index, E data) throws Exception {
        //index validation
        if(index < 0 || index > getTailIndex() ){
            throw new Exception("Index out of Bound !!");
        }

        E prevData = null;
        //edge-case 1 : when index == 0 /is Empty
        if(index == 0){
            prevData = head.data;
            head.data = data;
        //edge-case 1 : when index == getTailIndex()
        }else if(index == getTailIndex()) {
            prevData = tail.data;
            tail.data = data;
        }

        Node<E> curNode = head.next;
        int count = 1;
        while(curNode != null){
            if(count == index){
                prevData = curNode.data;
                curNode.data = data;
                break;
            }
            count++;
            curNode = curNode.next;
        }
        return prevData;
    }

    @Override
    public E removeByData(E data) {

        return null;
    }

    @Override
    public E removeElementAtIndex(int index) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public int getTailIndex(){
        return size-1;
    }
}
