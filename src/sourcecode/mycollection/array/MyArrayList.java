package sourcecode.mycollection.array;

public class MyArrayList<E> implements List<E> {

    private Object[] dataArray;
    private int size;
    private static int DEFAULT_CAPACITY = 10;


    public MyArrayList() {
        dataArray = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initialCapacity) {
        dataArray = new Object[initialCapacity];
    }

    @Override
    public void add(E element) {
        if (size < DEFAULT_CAPACITY) {
            dataArray[size] = element;
            size++;
        } else {
            //throw new IndexOutOfBoundsException("Array Already Full");
            growCapacity(size);
            dataArray[size] = element;
            size++;
        }
    }

    private void growCapacity(int size){
        int newCapacity = 2*size;
        System.out.println(newCapacity);
        Object [] newDataArray = new Object[newCapacity];
        System.arraycopy(dataArray,0,newDataArray,0,size-1);
        dataArray=newDataArray;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isValidIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Valid Index Range is :[0," + size() + "):, Actual index=" + index);
        }
        return true;
    }

    @Override
    public E get(int index) {
        if (isValidIndex(index)) {
            return (E) dataArray[index];
        }
        return null;
    }

    @Override
    public void add(int index, E element) {
        if (isValidIndex(index)) {
            dataArray[index] = element;
        }
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (Object object : dataArray) {
                if (object == null) {
                    return true;
                }
            }
        } else {
            for (Object object : dataArray) {
                if (o.equals(object)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public E set(int index, E element) {
        E oldData = null;
        if (isValidIndex(index)) {
            oldData = (E) dataArray[index];
            dataArray[index] = element;
        }
        return oldData;
    }

    @Override
    public E remove(int index) {
        E removedData = null;
        if (isValidIndex(index)) {
            removedData = (E) dataArray[index];
            fastRemove(index);
            size--;
        }
        return removedData;
    }

    // Shift the element towards right after deletion.
    private void fastRemove(int index){
        System.arraycopy(dataArray, index + 1, dataArray, index, size - index-1);
    }

    @Override
    public void clear() {
        for (int i = 0; i < size(); i++) {
            dataArray[i] = null;
        }
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder dataArrayToString = new StringBuilder();
        dataArrayToString.append("[");
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                dataArrayToString.append(this.dataArray[i]);
            } else {
                dataArrayToString.append(", ").append(this.dataArray[i]);
            }
        }
        dataArrayToString.append("]");
        return "MyArrayList\n{\n" +
                "  dataArray=" + dataArrayToString +
                ",\n  size=" + size() +
                "\n}\n";
    }


    public static void main(String[] args) {
        MyArrayList<Integer> integerMyArrayList = new MyArrayList<>();
        //integerMyArrayList.add(0);
        integerMyArrayList.add(10);
        integerMyArrayList.add(20);
        integerMyArrayList.add(30);
        integerMyArrayList.add(40);
        integerMyArrayList.add(50);
        integerMyArrayList.add(60);
        integerMyArrayList.add(70);
        integerMyArrayList.add(80);
        integerMyArrayList.add(90);
        integerMyArrayList.add(100);
        integerMyArrayList.add(410);
        integerMyArrayList.add(530);

        System.out.println(integerMyArrayList);
        System.out.println(integerMyArrayList.get(8));
        integerMyArrayList.add(8, 45);
        System.out.println(integerMyArrayList.contains(45));
        System.out.println(integerMyArrayList);
        System.out.println("remove ::"+integerMyArrayList.remove(5));
        System.out.println(integerMyArrayList);
        //integerMyArrayList.clear();
        System.out.println(integerMyArrayList);

        integerMyArrayList.growCapacity(10);


    }
}
