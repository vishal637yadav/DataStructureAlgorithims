package sourcecode.famous.algo.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StairCaseProblemRecursion {

    public static void main(String[] args) {

        int[] stepsAllowed = new int[]{1,2,5};
        int n = 11;

        String stepsTakenSoFar = "";
        //printAllSteps("",stepsAllowed, n, stepsTakenSoFar);
        List<String> list = getListofAllStepsPermutation(stepsAllowed,n);
        System.out.println("list ::-->>"+list);
        System.out.println("list.size ::-->>"+list.size());


        //recursiveClimbingStairs("",n);
        //printAllStepsReturing(stepsAllowed, n);
        // {1,2}   n=5

        int[] memorization = new int[n + 1];
        Arrays.fill(memorization, -1);
        //mem[i] = CountnoOfSteps from n t
        //
        //dpMemorizationClimbingStairs("", n, memorization);

    }
    // List<List<Integer>> = [ {1,1,1,1,1,1},{12111}];
    // Capturing the Steps taken while going down in the call stack.
    public static void printAllSteps(String space,int[] stepsAllowed, int n, String stepsTakenSoFar) {
        space += "|.";
        System.out.println(space+"---------::--calculate printAllSteps(n,stepsTakenSoFar)::(" + n + ","+stepsTakenSoFar+")");

        //Base Case
        if (n == 0) {
            System.out.println(space+stepsTakenSoFar);
            return;
        }
        if (n < 0) {
            System.out.println(space+"Not Valid Path ::" + stepsTakenSoFar);
            return;
        }

        for (int i = 0; i < stepsAllowed.length; i++) {
            int currentStep = stepsAllowed[i];
            System.out.println(space+" (currentStep,i):=("+currentStep+","+i+")");
            printAllSteps(space,stepsAllowed, n - currentStep, stepsTakenSoFar + currentStep);
        }

    }

    // Capturing the Steps taken while going down in the call stack.
    public static List<String> getListofAllStepsPermutation(int[] stepsAllowed, int n) {
        List<String> list = null;
        //Base Case : Valid Case
        if (n == 0) {
            list = new ArrayList<>();
            list.add("");
            return list;
        }
        //Base Case : Invalid Case
        if (n < 0) {
            list = new ArrayList<>();
            return list;
        }

        List<String> rList = new ArrayList<>();
        for (int i = 0; i < stepsAllowed.length; i++) {
            int currentStep = stepsAllowed[i];
            list = getListofAllStepsPermutation(stepsAllowed, n-currentStep);
            for(int j=0;j<list.size();j++){
                rList.add(currentStep+list.get(j));
            }
        }
        return rList;
    }

    public static int recursiveClimbingStairs(String space, int n) {
        space += "|.";
        int r = 1;
        System.out.println(space + "--n--:" + n);
        if (n <= 1) {
            System.out.println(space + "----(n, r) :==: (" + n + ", " + r + ")");
            return r;
        } else {
            r = recursiveClimbingStairs(space, n - 2) + recursiveClimbingStairs(space, n - 1);
            System.out.println(space + "----(n, r) :==: (" + n + ", " + r + ")");
            return r;
        }
    }

    // steps taken is hard-coded : 1 & 2
    public static int dpMemorizationClimbingStairs(String space, int n, int[] mem) {
        space += "|.";
        System.out.println(space + "--n:" + n + ",  mem:" + Arrays.toString(mem));

        int r = 1;

        if (mem[n] == -1) {
            if (n <= 1) {
                mem[n] = r;
                System.out.println(space + "----(n, r) :==: (" + n + ", " + r + ")" + ",  mem:" + Arrays.toString(mem));
                return r;
            } else {
                r = dpMemorizationClimbingStairs(space, n - 1, mem) + dpMemorizationClimbingStairs(space, n - 2, mem);
                mem[n] = r;
                System.out.println(space + "----(n, r) :==: (" + n + ", " + r + ")" + ",  mem:" + Arrays.toString(mem));
                return r;
            }
        } else {
            r = mem[n];
            System.out.println(space + "-giving result from memory---{mem(n) == r} -:==:- {mem(" + n + ") ==  " + r + "}");
            return r;
        }
    }

    public static int dpMemorizationClimbingStairs(String space, int[] stepsAllowed, int n, int[] mem) {
        space += "|.";
        System.out.println(space + "--n:" + n + ",  mem:" + Arrays.toString(mem));

        int r = 1;

        if (mem[n] == -1) {
            if (n <= 1) {
                mem[n] = r;
                System.out.println(space + "----(n, r) :==: (" + n + ", " + r + ")" + ",  mem:" + Arrays.toString(mem));
                return r;
            } else {
                r=0;
                for (int i = 0; i < stepsAllowed.length; i++) {
                    //if([n-stepsAllowed[i]])
                    r += dpMemorizationClimbingStairs(space, stepsAllowed, n-stepsAllowed[i], mem);
                }
                mem[n] = r;
                System.out.println(space + "----(n, r) :==: (" + n + ", " + r + ")" + ",  mem:" + Arrays.toString(mem));
                return r;
            }
        } else {
            r = mem[n];
            System.out.println(space + "-giving result from memory---{mem(n) == r} -:==:- {mem(" + n + ") ==  " + r + "}");
            return r;
        }
    }

    // return list containing all permuation of climbing stairs
    public static List<String> printAllPermutationClimbingStairs(int n) {
        return null;
    }

    /*

    printAllSteps({1,2 }, 6, "");





     */

}
