package sourcecode.builtin.ds.array.question.comparator;

import java.util.Comparator;

public class CustomerSortingComparator implements Comparator<Customer> {

    @Override
    public int compare(Customer customer1, Customer customer2) {
        if (customer1 == customer2 || customer1.equals(customer2))
            return 0;
        // Comparing customers
        int NameCompare = customer1.getName().compareTo(customer2.getName());
        int AgeCompare = customer1.getAge() - customer2.getAge();
        // 2nd level comparison
        return (NameCompare == 0) ? AgeCompare : NameCompare;
    }

}
