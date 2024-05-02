package sourcecode.concepts;

import java.util.Arrays;

public class ArrayShallowCopy {


    public static void main(String[] args) {

        int[] originalArray = {1,2,3,4,5};
        int[] shallowCopy = originalArray.clone();

        shallowCopy[0] = 100;

        System.out.println("Original array: " + Arrays.toString(originalArray));
        System.out.println("Shallow copied array: " + Arrays.toString(shallowCopy));
        System.out.println("Original array: " + Arrays.toString(originalArray));

        Integer a = 5;

        Integer[] originalArray1 = new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5)};
        Integer[] originalArray3 = originalArray1.clone();

        originalArray3[0] = Integer.valueOf(199);

        System.out.println("Original array:-->>" + Arrays.toString(originalArray1));
        System.out.println("Original array:-->>" + Arrays.toString(originalArray3));


    }
}
