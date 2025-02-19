package sourcecode.famous.algo.dynamic.programming;

public class Knapsack_01_Problem {

    public static void main(String[] args) {
        System.out.println("--Knapsack_01_Problem--");
        initialiseInput();
        int maximumProfit = knapsack(val,wt,capacity,wt.length);
        System.out.println("maximumProfit ::"+maximumProfit);

    }

    public static int knapsack(int val[],int wt[],int w,int n){
        //base case
        if(n==0 || w == 0){
            return 0;
        }

        if(wt[n-1] <= w){
            return Math.max(
                    //pick the item and moving to next item
                    val[n-1]+knapsack(val,wt,w-wt[n-1],n-1),
                    // not picking the item and moving the next item
                    knapsack(val,wt,w,n-1)
                    );
        }else {
            // not picking the item and moving the next item
            return knapsack(val,wt,w,n-1);
        }
    }

    private static int wt[];
    private static int val[];
    private static int capacity;

    public static void initialiseInput(){
        wt = new int[]{1,3,4,5};
        val= new int[]{10,4,5,7};
        capacity= 7;
    }

}
