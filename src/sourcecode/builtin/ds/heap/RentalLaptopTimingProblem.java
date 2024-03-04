package sourcecode.builtin.ds.heap;

import java.util.*;

public class RentalLaptopTimingProblem {

    // Implement Comparable for Enable sorting on the basis of endTime
    public static class TimeDuration implements Comparable{

        @Override
        public int compareTo(Object o) {
            return this.endTime - ((TimeDuration)o).endTime;
        }

        int startTime;
        int endTime;

        public TimeDuration(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public String toString() {
            return "TimeDuration[" + startTime + ", " + endTime + "]";
        }
    }

    public static class TimeDurationSortByStartTime implements Comparator<TimeDuration> {

        @Override
        public int compare(TimeDuration o1, TimeDuration o2) {
            return o1.startTime-o2.startTime;
        }

    }


    public static void main(String[] args) {
        System.out.println("------------");
        List<TimeDuration> list = new ArrayList<>();
        list.add(new TimeDuration(0,2));
        list.add(new TimeDuration(1,4));
        list.add(new TimeDuration(4,6));
        list.add(new TimeDuration(0,4));
        list.add(new TimeDuration(7,8));
        list.add(new TimeDuration(9,11));
        list.add(new TimeDuration(3,10));
        //copying existing List
        List<TimeDuration> list2 = new ArrayList<>(list);


        //System.out.println("Before Sorting list ::"+list);
        //Collections.sort(list);
        //System.out.println("After Sorting list ::"+list);


        System.out.println("Before Sorting list2 ::"+list2);

        Collections.sort(list2,(o1, o2) -> o1.startTime - o2.startTime);
        TimeDurationSortByStartTime timeDurationSortByEndTime = new TimeDurationSortByStartTime();
        Collections.sort(list2,timeDurationSortByEndTime);
        System.out.println("After Sorting list2  ::"+list2);

        PriorityQueue<TimeDuration> minHeap = new PriorityQueue<>();
        minHeap.add(list.get(0));
        int maxCount = 0;
        for(int i=1;i< list.size();i++){
            if ( (list.get(i)).startTime > (minHeap.peek()).endTime ){
                minHeap.add(list.get(i));
                if(maxCount < minHeap.size()){
                    maxCount = minHeap.size();
                }
            } else {
                minHeap.remove();
                minHeap.add(list.get(i));
            }

        }

        System.out.println("maxCount ::"+maxCount);

    }
}
