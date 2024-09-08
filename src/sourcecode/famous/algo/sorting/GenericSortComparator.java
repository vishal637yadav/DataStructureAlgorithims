package sourcecode.famous.algo.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GenericSortComparator<T> {
    List<T> dataList;

    public GenericSortComparator() {
        this.dataList = new ArrayList<>();
    }

    public void bubbleSort(Comparator<? super T> comparator) {
        int size = dataList.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (comparator.compare(dataList.get(j), dataList.get(j + 1)) > 0) {
                    T oldValueAtJthIndex = dataList.set(j, dataList.get(j + 1));
                    dataList.set(j + 1, oldValueAtJthIndex);
                }
            }
        }
    }

    public void add(T element){
        dataList.add(element);
    }

    @Override
    public String toString() {
        return "GenericSortComparator{" +
                "dataList=" + dataList +
                '}';
    }

    static void createStudentSortedList(){
        System.out.println("------------createStudentSortedList--start--------------------");
        GenericSortComparator<Student> studentList = new GenericSortComparator<>();
        studentList.add(new Student(2001,"Amar","RIMS School",10));
        studentList.add(new Student(2002,"Amar","DPS School",10));
        studentList.add(new Student(2003,"Ajay","RIMS School",10));
        studentList.add(new Student(4001,"Vijay","RIMS School",9));
        studentList.add(new Student(4001,"Vijay","Apex School",10));
        studentList.add(new Student(6002,"Deva-anand","RIMS School",10));

        System.out.println("before bubbleSort()         studentList::" + studentList);
        studentList.bubbleSort(new SortStudentByRollNoAsc());
        System.out.println("after  studentList.bubbleSort(new SortStudentByRollNoAsc())                     studentList::" + studentList);
        Collections.sort(studentList.dataList, new SortStudentByRollNoAsc());
        System.out.println("after  Collections.sort(studentList.dataList, new SortStudentByRollNoAsc())     studentList::" + studentList);

        System.out.println("------------createStudentSortedList--ends--------------------");

    }

    public static void main(String[] args) {

        createStudentSortedList();

    }

}
