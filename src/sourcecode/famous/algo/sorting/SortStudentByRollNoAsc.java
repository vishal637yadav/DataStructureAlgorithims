package sourcecode.famous.algo.sorting;

import java.util.Comparator;

public class SortStudentByRollNoAsc implements Comparator<Student> {
    /**
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return
     */
    @Override
    public int compare(Student o1, Student o2) {
       return o1.getId()-o2.getId();
    }


}
