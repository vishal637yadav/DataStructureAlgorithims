package sourcecode.famous.algo.recursion;

public class LoopUsingRecursion {

    public static void main(String[] args) {
        //printIncreasingOrder(1,5);
        System.out.println("printNumbers(5) ::" + printNumbers("", 5));
    }

    public static void printIncreasingOrder(int currentValue, int upperLimit) {
        if (currentValue < upperLimit) {
            System.out.print(currentValue);
            printIncreasingOrder(currentValue + 1, upperLimit);
            System.out.print(currentValue);
        } else {
            System.out.println();
            return;
        }
    }

    public static int printNumbers(String space, int n) {
        space += ".|";
        int result =0;

        System.out.println(space + "-::n::" + n);
        if (n < 0) {
            System.out.println(space + "-::result::" + result);
            return result;
        } else if (n == 1) {
            result = 1;
            System.out.println(space + "-::result::" + result);
            return result;
        } else {
            result = n + printNumbers(space, n - 1) + printNumbers(space, n - 3);
            System.out.println(space + "-::result::" + result);
            return result;
        }
    }
}
