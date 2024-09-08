package sourcecode.builtin.ds.array.question.comparator;

import java.util.Comparator;

class SortByRollNo implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return s1.rollno - s2.rollno;
    }
}
