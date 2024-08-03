package sourcecode.builtin.ds.linkedhashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class MyLinkedList{
    String val;
    MyLinkedList next;

    /*
    @Override
    public String toString() {
        return "MyLinkedList{" +
                "val='" + val + '\'' +
                ", next=" + next +
                '}';
    }
    */
}


public class LinkedHashMapDemo {

    static HashMap<String, MyLinkedList> nodeMap = new HashMap<>();

    public static void main(String[] args) {
        ArrayList<String> input1 = new ArrayList<>();
        input1.add("a->b");
        input1.add("r->s");
        input1.add("b->c");
        input1.add("x->c");
        input1.add("q->r");
        input1.add("y->x");
        input1.add("w->z");
        input1.add("c->a");

        ArrayList<String> input2 = new ArrayList<>();
        input2.add("a,q,w");
        input2.add("a,c,r");
        input2.add("y,z,a,r");
        input2.add("a,w");

        System.out.println("input1::"+input1);
        System.out.println("input2::"+input2);
        createNodeGraph(input1);

        displayNodes();

        //findIntersection(nodeMap.get("a"),nodeMap.get("y"));

        //boolean result = findIntersection("a,c,r" );
        //System.out.println("result ::"+result);


        for(int i=0; i< input2.size();i++){
            boolean output = findIntersection(input2.get(i));
            System.out.println("------------->>>>------------------------input :("+input2.get(i)+") result ::"+output);

        }

    }


    static void createNodeGraph(ArrayList<String> input){

        for(int i=0;i< input.size();i++){
            String currNodeInput = input.get(i);
            System.out.println("currNodeInput------:"+currNodeInput);
            int indexOfArrow = currNodeInput.indexOf("->");
            //System.out.println("indexOfArrow------:"+indexOfArrow);
            String sourceNodeData = currNodeInput.substring(0,indexOfArrow);
            System.out.println("sourceNodeData------:"+sourceNodeData);
            String destinationNodeData = currNodeInput.substring(indexOfArrow+2);
            System.out.println("destinationNodeData------:"+destinationNodeData);
            System.out.println("-----------------------------------------------------------");

            MyLinkedList sNode = getNode(sourceNodeData);
            MyLinkedList dNode = getNode(destinationNodeData);
            sNode.next= dNode;

        }

    }

    static MyLinkedList getNode(String data){
        MyLinkedList node = nodeMap.get(data);
        if (node == null){
            node = new MyLinkedList();
            node.val = data;
            nodeMap.put(data,node);
        }
        return node;
    }

    static void displayNodes(){
        System.out.println("node:"+nodeMap);
    }

    static String getNodeTraversalString(MyLinkedList statNode){
        StringBuffer sb = new StringBuffer();
        MyLinkedList curNode = statNode;
        while(curNode != null) {
            sb.append(curNode.val);
            curNode = curNode.next;
        }
        return sb.toString();
    }

    static boolean findIntersection(String startNodeList){

        String startNodeArr [] = startNodeList.split(",");
        HashSet<MyLinkedList> foundNodeSet = new HashSet<>();

        for(int i=0;i<startNodeArr.length;i++) {
            System.out.println("startNodeArr["+i+"]----"+startNodeArr[i]);
            System.out.println("foundNodeSet----"+foundNodeSet);

            MyLinkedList curNode = nodeMap.get(startNodeArr[i]);
            System.out.println("curNode----"+curNode);

            StringBuffer prevNodesString  = new StringBuffer();
            System.out.println("prevNodesString----"+prevNodesString);

            while(curNode != null) {
                System.out.println("prevNodesString----"+prevNodesString);

                if(prevNodesString.indexOf(curNode.val) != -1){
                    System.out.println("---break block--");

                    break;
                }else {
                    System.out.println("---else break block--");

                    prevNodesString.append(curNode.val);

                    if(foundNodeSet.contains(curNode)) {
                        System.out.println("---return  block----");

                        return true;
                    }else {
                        System.out.println("---else return block--");
                        foundNodeSet.add(curNode);
                    }
                }
                curNode = curNode.next;
                System.out.println("---++++++++++++++++++++++++++++++++++++++++++++++++++--");

            }
            System.out.println("------------------------------------------------------------");
        }
        System.out.println("------tst------");
        return false;
    }



}
