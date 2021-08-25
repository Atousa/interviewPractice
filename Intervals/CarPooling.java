import java.util.*;

public class CarPooling {
    public static boolean carPooling(int[][] trips, int maxCapacity) {

        int curCapacity = 0;
        int nextStep = 0;

        Arrays.sort(trips, (int[] a, int[] b) -> (a[1] - b[1])); // sort bases on the start point

        for (int i = 0; i < trips.length; i++) {
            System.out.println(trips[i][1]);
        }


        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for (int i = 0; i < trips.length; i++) {
            int[] trip = trips[i];
            if (curCapacity + trip[0] > maxCapacity) return false;
            minHeap.add(trip);
            curCapacity = curCapacity + trip[0];

            if (i + 1 == trips.length) {
                nextStep = Integer.MAX_VALUE;
            } else {
                nextStep = trips[i + 1][1];
            }

            while (!minHeap.isEmpty() && minHeap.peek()[2] <= nextStep) {
                curCapacity = curCapacity - minHeap.peek()[0];
                minHeap.poll();
            }

        }
        if (curCapacity <= maxCapacity) return true;
        return false;
    }



    public static void main(String[] args) {
        int[][] arr = {{2,1,5},{3,3,7}};
        System.out.println(carPooling(arr, 5));
    }
}
