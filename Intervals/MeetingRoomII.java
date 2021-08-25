
import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomII {

    public static int meetingRoomII(int[][] intervals) {

        int globalMax = 0;

        Arrays.sort(intervals, (int[] a,int[] b)->a[0] - b[0]);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)-> a[1] - b[1]);

        int nextStart = 0;

        for(int i = 0; i < intervals.length; i++) {
            if(i == intervals.length -1) {
                nextStart = Integer.MAX_VALUE;
            } else {
                nextStart = intervals[i+1][0];
            }

            minHeap.add(intervals[i]);

            globalMax = Math.max(globalMax, minHeap.size());

            while(!minHeap.isEmpty() && minHeap.peek()[1] <= nextStart){
                minHeap.poll();
            }
        }
        return globalMax;
    }

    public static void main(String[] args) {
        int[][] arr = {{13,15},{1,13}};
        int b = meetingRoomII(arr);
        System.out.println(b);
    }



}
