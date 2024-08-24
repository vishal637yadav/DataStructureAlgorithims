package sourcecode.mycollection.linkedlist.singly;

public class MainDriverTestClass {

    public static void main(String[] args) {
        addTest();
        //addFirstTest();

    }

    public static void addTest(){
        MySLinkedList<Integer> mySLinkedList = new MySLinkedList<>();
        System.out.println("----MySLinkedList :add Operation-----");
        System.out.println("----mySLinkedList1 -----"+mySLinkedList);
        mySLinkedList.add(1);
        System.out.println("----mySLinkedList2 -----"+mySLinkedList);
        mySLinkedList.add(2);
        System.out.println("----mySLinkedList3 -----"+mySLinkedList);
        mySLinkedList.add(3);
        System.out.println("----mySLinkedList4 -----"+mySLinkedList);
        mySLinkedList.add(4);
        System.out.println("----mySLinkedList5 -----"+mySLinkedList);

        setTest(mySLinkedList);
    }
    public static void addFirstTest(){

        MySLinkedList<Integer> mySLinkedList = new MySLinkedList<>();
        System.out.println("----MySLinkedList :addFirst Operation-----");
        System.out.println("----mySLinkedList1 -----"+mySLinkedList);
        mySLinkedList.addFirst(1);
        System.out.println("----mySLinkedList2 -----"+mySLinkedList);
        mySLinkedList.addFirst(2);
        System.out.println("----mySLinkedList3 -----"+mySLinkedList);
        mySLinkedList.addFirst(3);
        System.out.println("----mySLinkedList4 -----"+mySLinkedList);
        mySLinkedList.addFirst(4);
        System.out.println("----mySLinkedList5 -----"+mySLinkedList);

    }

    public static void setTest(MySLinkedList<Integer> mySLinkedList) {

        try{
            System.out.println("---set Test-----");
            System.out.println("mySLinkedList1 setTest ::"+mySLinkedList);
            System.out.println("mySLinkedList2 setTest ::"+mySLinkedList.set(0,33));
            System.out.println("mySLinkedList2 setTest ::"+mySLinkedList);
            System.out.println("mySLinkedList3 set cal ::"+mySLinkedList.set(1,44));
            System.out.println("mySLinkedList4 setTest ::"+mySLinkedList);
            System.out.println("mySLinkedList5 set cal ::"+mySLinkedList.set(2,55));
            System.out.println("mySLinkedList6 setTest ::"+mySLinkedList);
            System.out.println("mySLinkedList7 set cal ::"+mySLinkedList.set(3,66));
            System.out.println("mySLinkedList8 setTest ::"+mySLinkedList);
        }catch (Exception e){
            System.out.println("Exception ::"+e);
        }
    }
}
