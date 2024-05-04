package sourcecode.mycollection.linkedlist.question;

/*
Remove Duplicate from Sorted Linked-List
Input : 1 -> 1 -> 3 -> 4 -> 4 -> 4 -> 5 -> 6 -> 6
Output: 1 -> 3 -> 4 -> 5 -> 6
 */
public class RemoveDuplicate {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList (int value){
            this.value = value;
            this.next = null;
        }
    }

    static LinkedList headNode ;

    public static void initialise(){
        LinkedList lastNode ;
        headNode = new LinkedList(1);
        lastNode = headNode;
        lastNode.next = new LinkedList(1);
        lastNode = lastNode.next ;
        lastNode.next = new LinkedList(3);
        lastNode = lastNode.next ;
        lastNode.next = new LinkedList(4);
        lastNode = lastNode.next ;
        lastNode.next = new LinkedList(4);
        lastNode = lastNode.next ;
        lastNode.next = new LinkedList(4);
        lastNode = lastNode.next ;
        lastNode.next = new LinkedList(5);
        lastNode = lastNode.next ;
        lastNode.next = new LinkedList(6);
        lastNode = lastNode.next ;
        lastNode.next = new LinkedList(6);
        lastNode = lastNode.next ;

    }

    public static void display(){
        LinkedList currNode = headNode;
        StringBuilder sb = new StringBuilder();
        while (currNode != null){
            System.out.println("value :"+currNode.value);
            if(sb.isEmpty()){
                sb.append(currNode.value);
            }else{
                sb.append(" -> ").append(currNode.value);
            }
            currNode = currNode.next;
        }
        System.out.println("sb : "+sb.toString());
    }

    public static void main(String[] args) {
        System.out.println("======main-------");
        initialise();
        display();
        removeDuplicateFromLinkedList();
        display();

    }

    public static void removeDuplicateFromLinkedList(){
        System.out.println("-----------removeDuplicateFromLinkedList---start-------");

        System.out.println("-----------removeDuplicateFromLinkedList---end---------");
    }

}

