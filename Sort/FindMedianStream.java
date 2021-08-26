import java.util.PriorityQueue;

public class FindMedianStream {

    //find median from data stream; 295 leetcode
   //TC = log(n) , SC=log(n)
    
        public static List<Integer> online_median(List<Integer> stream) {


            PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
            List<Integer> result = new ArrayList<>();


            for(Integer num : stream) {

                maxHeap.offer(num); //Insert into maxHeap first.
                minHeap.offer(maxHeap.poll()); //Now remove

                if(minHeap.size() > maxHeap.size()){
                    maxHeap.offer(minHeap.poll());
                }

                if(maxHeap.size() == minHeap.size())
                    result.add((maxHeap.peek()+minHeap.peek())/2);
                else
                    result.add(maxHeap.peek());
            }

            return result;
        }



