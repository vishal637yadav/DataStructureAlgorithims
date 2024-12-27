package sourcecode.builtin.ds.stack.problem;


import java.util.LinkedList;
import java.util.Stack;

public class TestLoopSize {

    public static void main(String[] args) {

        //arrayResizingTest();
        arrayResizingTest2();

    }

    public static void arrayResizingTest(){
        System.out.println("------arrayResizingTest-----");
        int n = 5;
        System.out.println("-------n------::"+n);
        for(int i=0;i<n;i++){
            System.out.println("--loop begining--(n,i)::("+n+","+i+")");

            if(i == 3){
                System.out.println("--if before--(n,i)::("+n+","+i+")");
                n=10;
                System.out.println("--if after---(n,i)::("+n+","+i+")");
            }
        }
    }

    public static void arrayResizingTest2(){
        System.out.println("------arrayResizingTest-----");
        int n = 5;

        LinkedList<Object> s = new LinkedList<>();
        s.add(45);
        s.add(55);
        s.add(65);
        s.add(75);
        System.out.println("-------s.size()------::"+s.size());

        for(int i=0;i<s.size();i++){
            System.out.println("--loop begining--(s,i)::("+s+","+i+")");

            if(i == 3){
                System.out.println("--if before--(s,i)::("+s+","+i+")");
                s.add(35);s.add(56);
                System.out.println("--if after---(s,i)::("+s+","+i+")");
            }
        }
    }


}
