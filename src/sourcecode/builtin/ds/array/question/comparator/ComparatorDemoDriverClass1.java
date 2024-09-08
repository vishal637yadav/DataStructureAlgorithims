package sourcecode.builtin.ds.array.question.comparator;

import java.util.ArrayList;

public class ComparatorDemoDriverClass1 {

    public static void main(String[] args) {
        System.out.println("=-==main--::==");

        // Creating an empty ArrayList of Student type
        ArrayList<Student> ar = new ArrayList<>();

        // Adding entries in above List using add() method
        ar.add(new Student(111, "Mayank", "london"));
        ar.add(new Student(131, "Anshul", "nyc"));
        ar.add(new Student(121, "Solanki", "jaipur"));
        ar.add(new Student(101, "Aggarwal", "Hongkong"));

        // Display message on console for better readability
        System.out.println("Unsorted");

        // Iterating over entries to print them
        for (Student student : ar) System.out.println(student);

        // Sorting student entries by roll number
        ar.sort(new SortByRollNo());

        // Display message on console for better readability
        System.out.println("\nSorted by rollno");

        // Again iterating over entries to print them
        for (Student value : ar) System.out.println(value);

        // Sorting student entries by name
        ar.sort(new SortByName());

        // Display message on console for better readability
        System.out.println("\nSorted by name");

        // // Again iterating over entries to print them
        for (Student student : ar) System.out.println(student);
    }
}



