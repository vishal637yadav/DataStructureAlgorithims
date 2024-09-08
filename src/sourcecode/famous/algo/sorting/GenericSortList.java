package sourcecode.famous.algo.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GenericSortList<T extends Comparable<T>> {

    List<T> dataList;

    public GenericSortList() {
        dataList = new ArrayList<>();
    }

    public void add( T element){
        dataList.add(element);
    }

    //Sort Using Collections.sort() method
    public void sortUsingCollectionSort(){
        Collections.sort(this.dataList);
    }

    //Bubble sort Implementation
    public void bubbleSort() {
        int size = dataList.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (dataList.get(j).compareTo(dataList.get(j + 1)) > 0) {
                    T oldValueAtJthIndex = dataList.set(j, dataList.get(j + 1));
                    dataList.set(j + 1, oldValueAtJthIndex);
                }
            }
        }
    }

    //Bubble sort Implementation
    public static <T> void  bubbleSort(List<T> dataList, Comparator<? super T> comparator) {
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

    @Override
    public String toString() {
        return "GenericSortList{" +
                "dataList=" + dataList +
                '}';
    }

    static void createStringArray() {
        System.out.println("------------createStringList--start--------------------");

        GenericSortList<String> stringArray = new GenericSortList<>();
        stringArray.dataList.add("aa");
        stringArray.dataList.add("a");
        stringArray.dataList.add("zz");
        stringArray.dataList.add("147");
        stringArray.dataList.add("b");
        stringArray.dataList.add("cbb");
        stringArray.dataList.add("ax");
        stringArray.dataList.add("axd");
        stringArray.dataList.add("asxd");

        System.out.println("before bubbleSort()         stringArray::" + stringArray);
        stringArray.bubbleSort();
        System.out.println("after  bubbleSort()         stringArray::" + stringArray);
        Collections.sort(stringArray.dataList);
        System.out.println("after  Collections.sort()   stringArray::" + stringArray);
        System.out.println("------------createStringList--ends--------------------");

    }

    public static void createIntegerArray() {
        System.out.println("------------createIntegerList--start--------------------");
        GenericSortList<Integer> integerArray = new GenericSortList<>();
        integerArray.dataList.add(65);
        integerArray.dataList.add(55);
        integerArray.dataList.add(5);
        integerArray.dataList.add(6);
        integerArray.dataList.add(5);
        integerArray.dataList.add(365);
        integerArray.dataList.add(1);
        integerArray.dataList.add(34);

        System.out.println("before bubbleSort()         integerArray::" + integerArray);
        integerArray.bubbleSort();
        System.out.println("After  bubbleSort()         integerArray::" + integerArray);
        Collections.sort(integerArray.dataList);
        System.out.println("After  Collections.sort()   integerArray::" + integerArray);
        System.out.println("------------createIntegerList--ends--------------------");

    }

    static void createStudentSortedList(){
        System.out.println("------------createStudentSortedList--start--------------------");
        GenericSortList<Student> studentList = new GenericSortList<>();
        studentList.add(new Student(2001,"Amar","RIMS School",10));
        studentList.add(new Student(2002,"Amar","DPS School",10));
        studentList.add(new Student(2003,"Ajay","RIMS School",10));
        studentList.add(new Student(4001,"Vijay","RIMS School",9));
        studentList.add(new Student(4001,"Vijay","Apex School",10));
        studentList.add(new Student(6002,"Deva-anand","RIMS School",10));

        System.out.println("before bubbleSort()         studentList::" + studentList);
        studentList.bubbleSort();
        System.out.println("after  bubbleSort()         studentList::" + studentList);
        studentList.sortUsingCollectionSort();
        System.out.println("after  Collections.sort()   studentList::" + studentList);
        //studentList.dataList.sort(new SortStudentByRollNoAsc());
        System.out.println("after  SortStudentByRollNoAsc()   studentList::" + studentList);
        bubbleSort(studentList.dataList, new SortStudentByRollNoAsc());
        System.out.println("after  bubbleSort(studentList.dataList, new SortStudentByRollNoAsc())   studentList::" + studentList);
        System.out.println("------------createStudentSortedList--ends--------------------");

    }

    public static void main(String[] args) {

        createStringArray();
        createIntegerArray();
        createStudentSortedList();

    }
}
