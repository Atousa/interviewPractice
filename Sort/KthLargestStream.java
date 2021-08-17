import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//in the stream case this is the best approach , TC n*log(k) that k  for building the heap and
//log k for extraction , and n times for input.
//SC=o(k)

public class KthLargestStream {

    public static List<Integer> kthLargetStream(int k, int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        List<Integer> result = new ArrayList<>();

        for (int val : nums) {
            if (minHeap.size() < k)
                minHeap.add(val);
            else {
                if (val > minHeap.peek()) {
                    minHeap.poll();
                    minHeap .add(val);
                }
            }
        }

        if (minHeap.size() >= k)
            result.add(minHeap.peek());
        else
            result.add(-1);
        return result;
    }
}

