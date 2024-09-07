package sourcecode.builtin.ds.array.question.comparable;

import java.util.Arrays;

public class ComparableDemo2 {

    private static class Pair implements Comparable<Pair> {
        String firstName;
        String lastName;

        public Pair(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.firstName.compareTo(o.firstName) != 0) {
                return this.firstName.compareTo(o.firstName);
            } else {
                return this.lastName.compareTo(o.lastName);
            }
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        System.out.println("---Main---");
        int n = 4;
        Pair[] arr = new Pair[n];
        arr[0] = new Pair("raj", "kashup");
        arr[1] = new Pair("rahul", "singh");
        arr[2] = new Pair("reshmi", "dubey");
        arr[3] = new Pair("rahul", "jetli");
        System.out.println("Before Sort arr:="+ Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("After  Sort arr:="+ Arrays.toString(arr));
    }
}


