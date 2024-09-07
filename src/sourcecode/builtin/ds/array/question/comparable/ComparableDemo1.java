package sourcecode.builtin.ds.array.question.comparable;

import java.util.Arrays;

public class ComparableDemo1 {

    private static class Pair implements Comparable<Pair> {
        String x;
        int y;

        public Pair(String x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x='" + x + '\'' +
                    ", y=" + y +
                    '}';
        }

        @Override
        public int compareTo(Pair a) {
            //if the string are not equal
            if (this.x.compareTo(a.x) != 0) {
                return this.x.compareTo(a.x);
            } else {
                //we compare int values if the strings are equal
                return this.y - a.y;
            }
        }
    }

    public static void main(String[] args) {
        int n = 6;
        Pair[] arr ;
        arr = new Pair[n];
        arr[0] = new Pair("abc", 13);
        arr[1] = new Pair("a", 4);
        arr[2] = new Pair("bc", 5);
        arr[3] = new Pair("a", 2);
        arr[4] = new Pair("abc", 3);
        arr[5] = new Pair("abc", 6);

        System.out.println("Before Sort arr:="+ Arrays.toString(arr));
        //Sorting Array Data
        Arrays.sort(arr);
        System.out.println("After  Sort arr:="+ Arrays.toString(arr));

    }

}


