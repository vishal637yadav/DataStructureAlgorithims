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
