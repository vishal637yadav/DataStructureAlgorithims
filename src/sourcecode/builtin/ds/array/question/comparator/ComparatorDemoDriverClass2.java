package sourcecode.builtin.ds.array.question.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ComparatorDemoDriverClass2 {

    public static void main(String[] args) {
        System.out.println("=-==main--::==");
        //Create an empty ArrayList to store Student
        List<Customer> al = new ArrayList<>();

        // Create customer objects using constructor initialization
        Customer obj1 = new Customer("Ajay", 27);
        Customer obj2 = new Customer("Sneha", 23);
        Customer obj3 = new Customer("Simran", 37);
        Customer obj4 = new Customer("Ajay", 22);
        Customer obj5 = new Customer("Ajay", 29);
        Customer obj6 = new Customer("Sneha", 22);

        // Adding customer objects to ArrayList using add() method
        al.add(obj1);
        al.add(obj2);
        al.add(obj3);
        al.add(obj4);
        al.add(obj5);
        al.add(obj6);

        // Iterating using Iterator before Sorting ArrayList
        Iterator<Customer> custIterator = al.iterator();

        // Display message
        System.out.println("Before Sorting:\n");

        // Holds true till there is single element remaining in List
        while (custIterator.hasNext()) {
            // Iterating using next() method
            System.out.println(custIterator.next());
        }

        // Sorting using sort method of Collections class
        Collections.sort(al,new CustomerSortingComparator());
        // Display message only
        System.out.println("\n\nAfter Sorting:\n");

        // Iterating using enhanced for-loop after Sorting ArrayList
        for (Customer customer : al) {
            System.out.println(customer);
        }

    }
}



