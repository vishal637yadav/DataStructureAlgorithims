# Comparator Interface in Java with Examples

A **comparator interface** is used **to order** the **objects** of **user-defined** classes. 

A comparator object is **capable of comparing** **two objects of the same class**. Following function compare obj1 with obj2.

## Syntax:

    public int compare(Object obj1, Object obj2):

Suppose we have an Array/ArrayList of our own class type, 
containing fields like roll no, name, address, DOB, etc, and 

We need to **sort the array based on Roll no or name**?


**Method 1:** One obvious approach is to write our own sort() function using one of the standard algorithms. This solution requires rewriting the whole sorting code for different criteria like Roll No. and Name.

**Method 2:** Using comparator interface- Comparator interface is used to order the objects of a user-defined class. This interface is present in java.util package and contains 2 methods compare(Object obj1, Object obj2) and equals(Object element). Using a comparator, we can sort the elements based on data members. For instance, it may be on roll no, name, age, or anything else.

**Method of Collections class** for **sorting List** elements is used to sort the elements of List by the given comparator.

    public void sort(List list, ComparatorClass c)
To sort a given List, **ComparatorClass must implement a Comparator interface**.

### How do the sort() method of Collections class work?
Internally the **Sort method** does call **Compare method** of the classes it is sorting. **To compare two elements**, it asks “**Which is greater?**” Compare/**compare(Object a,Object b)** method **returns -1, 0, or 1** to say if it is **less than**, **equal**, or **greater** to the other. It uses this result to then determine if they should be swapped for their sort.

### Example
#### Student.java
    package sourcecode.builtin.ds.array.question.comparator;
    
    public class Student {
    
        // Attributes of a student
        int rollno;
        String name;
        String address;
    
        // Constructor
        public Student(int rollno, String name, String address) {
            // This keyword refers to current instance itself
            this.rollno = rollno;
            this.name = name;
            this.address = address;
        }
    
        // Method of Student class To print student details in main()
        public String toString() {
            // Returning attributes of Student
            return this.rollno + " " + this.name + " " + this.address;
        }
    
    }

#### SortByRollNo.java
    package sourcecode.builtin.ds.array.question.comparator;
    
    import java.util.Comparator;
    
    class SortByRollNo implements Comparator<Student> {
    
        @Override
        public int compare(Student s1, Student s2) {
            return s1.rollno - s2.rollno;
        }
    }

#### SortByName.java
    package sourcecode.builtin.ds.array.question.comparator;
    
    import java.util.Comparator;
    
    public class SortByName implements Comparator<Student> {
    
        @Override
        public int compare(Student s1, Student s2) {
            return s1.name.compareTo(s2.name);
        }
    }


#### ComparatorDemoDriverClass1.java
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


#### Output
    "C:\Program Files\Java\jdk-21\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.3.2\lib\idea_rt.jar=55521:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.3.2\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath F:\Programming\Code\21Feb\DataStructureAlgorithims\out\production\DataStructureAlgorithims sourcecode.builtin.ds.array.question.comparator.ComparatorDemoDriverClass1
    =-==main--::==
    Unsorted
    111 Mayank london
    131 Anshul nyc
    121 Solanki jaipur
    101 Aggarwal Hongkong
    
    Sorted by rollno
    101 Aggarwal Hongkong
    111 Mayank london
    121 Solanki jaipur
    131 Anshul nyc
    
    Sorted by name
    101 Aggarwal Hongkong
    131 Anshul nyc
    111 Mayank london
    121 Solanki jaipur
    
    Process finished with exit code 0


>Node
By changing the return value inside the compare method, 
you can sort in any order that you wish to, for example: 
For descending order just change the positions of ‘a’ and ‘b’ in the above compare method.


> [!NOTE]
> By changing the return value inside the compare method,
> we can sort in any order that you wish to., 
> For example:
> For **descending** order just change the positions of ‘a’ and ‘b’ in the above compare method.


> [!TIP]
> Helpful advice for doing things better or more easily.

> [!IMPORTANT]
> Key information users need to know to achieve their goal.

> [!WARNING]
> Urgent info that needs immediate user attention to avoid problems.

> [!CAUTION]
> Advises about risks or negative outcomes of certain actions.


### Sort collection by more than one field
In the previous example, we have discussed how to sort the list of objects on the basis of a single field using the Comparable and Comparator interface 

But, what if we have a requirement to **sort ArrayList objects** in accordance with **more than one field** like firstly, sort according to the Customer **name** and secondly, sort according to customer **age**.

#### Customer.java
    package sourcecode.builtin.ds.array.question.comparator;
    
    public class Customer {
    String name;
    int age;
    
        public Customer(String name, int age) {
            this.name = name;
            this.age = age;
        }
    
        @Override
        public String toString() {
            return "Customer{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public int getAge() {
            return age;
        }
    
        public void setAge(int age) {
            this.age = age;
        }
    }

#### CustomerSortingComparator.java
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

#### CustomerSortingComparator.java
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


#### Output
    =-==main--::==
    Before Sorting:
    
    Customer{name='Ajay', age=27}
    Customer{name='Sneha', age=23}
    Customer{name='Simran', age=37}
    Customer{name='Ajay', age=22}
    Customer{name='Ajay', age=29}
    Customer{name='Sneha', age=22}
    
    
    After Sorting:
    
    Customer{name='Ajay', age=22}
    Customer{name='Ajay', age=27}
    Customer{name='Ajay', age=29}
    Customer{name='Simran', age=37}
    Customer{name='Sneha', age=22}
    Customer{name='Sneha', age=23}
