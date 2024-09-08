package sourcecode.famous.algo.sorting;

public class Student implements Comparable<Student> {

    private int id;
    private String name;
    private String college;
    private int standard;

    public Student(int id, String name, String college, int standard) {
        this.id = id;
        this.name = name;
        this.college = college;
        this.standard = standard;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", college='" + college + '\'' +
                ", standard=" + standard +
                '}';
    }

    /*
    1. standard asc ;
    2. name asc;
    3. college asc;
     */
    @Override
    public int compareTo(Student student) {
        if (this == student || this.equals(student)) {
            return 0;
        }

        int standardComparisonResult = this.standard - student.standard;
        int nameComparisonResult = this.name.compareTo(student.name);
        int collegeComparisonResult = this.college.compareTo(student.college);
        return standardComparisonResult == 0 ? nameComparisonResult == 0 ? collegeComparisonResult : nameComparisonResult : standardComparisonResult;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public int getStandard() {
        return standard;
    }

    public void setStandard(int standard) {
        this.standard = standard;
    }
}
