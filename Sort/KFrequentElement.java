import java.util.*;

public class KFrequentElement {
//nlogk complexity

    public static int[] kFrequentElement(int[] nums, int k) {
        int[] result = new int[k];

        if (nums.length == 0) {
            return result;
        }

        Map<Integer, Integer> hm = new HashMap<>();
        for(int num : nums)
            hm.put(num, hm.getOrDefault(num,0)+1);

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new
                PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            maxHeap.offer(entry);
        }
        List<Integer> res = new ArrayList<>();

        int i = 0;

        while (i < k) {
            result[i++] = (maxHeap.poll().getKey());
        }

        return result;
    }




    public static int[] kFrequentElement2(int[] nums, int k) {

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int num : nums)
            hm.put(num, hm.getOrDefault(num, 0) + 1);

//        for(int n: hm.keySet()) {
//            System.out.print(n+",");
//            System.out.println(hm.get(n));
//        }

        int[] unique = new int[hm.size()];
        int i = 0;

        for (Integer n : hm.keySet())
            unique[i++] = n;

        int start = 0;
        int end = unique.length - 1;
        for(int a: unique){
            System.out.print(a);
        }
        System.out.println();
        int index = select(unique, start, end, hm,k);
        for(int a: unique){
            System.out.print(a);
        }
        System.out.println();
        return Arrays.copyOfRange(unique,unique.length-k,unique.length);
    }

    private static int select(int[] unique, int start, int end, HashMap hm,int k) {

        // if(start >= end ) return unique[start];
        if(start == unique.length - k) return start;
        int pivot = partition(unique, start, end, hm);
        if (pivot == unique.length - k)
            return pivot;
        if (pivot < unique.length - k)
            return select(unique, pivot + 1, end, hm, k);
        else
            return select(unique, start, pivot - 1, hm, k);
    }



    private static int partition(int[] unique, int start, int end, HashMap hm) {

        int pivot = start + new Random().nextInt(end - start + 1);
        swapElement(unique,start,pivot);
        int greater = start+1;
        int smaller = start;
        int freq = (int) hm.get(unique[start]);

        while(greater <= end ) {
            if ((int)hm.get(unique[greater]) < freq || hm.get(unique[greater]).equals(freq) && greater%2 == 0) {
                smaller++;
                swapElement(unique, greater, smaller);
            }
            greater++;
        }
        swapElement(unique,start,smaller);
        return smaller;
    }

    private static void swapElement(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,2,2,5,5,6,6,3,3,3,3,5,5,5};
        int[] a = new int[2];
        a = kFrequentElement2(array,2);
        for(int num: a)
            System.out.println(num);
    }

}
