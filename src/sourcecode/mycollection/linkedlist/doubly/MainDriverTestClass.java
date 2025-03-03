package sourcecode.mycollection.linkedlist.doubly;

public class MainDriverTestClass {

    public static void main(String[] args) {
        addTest();
        //addFirstTest();

    }

    public static void addTest(){
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        System.out.println("----MySLinkedList :add Operation-----");
        System.out.println("----DoublyLinkedList 1.-----"+doublyLinkedList);
        doublyLinkedList.add(1);
        System.out.println("----DoublyLinkedList 2. -----"+doublyLinkedList);
        doublyLinkedList.add(2);
        System.out.println("----DoublyLinkedList 3. -----"+doublyLinkedList);
        doublyLinkedList.add(3);
        System.out.println("----DoublyLinkedList 4. -----"+doublyLinkedList);
        doublyLinkedList.add(4);
        System.out.println("----DoublyLinkedList 5. -----"+doublyLinkedList);

        //setTest(doublyLinkedList);
    }
}
