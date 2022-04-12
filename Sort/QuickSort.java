
import java.util.Random;
// in-place but not stable, since the pivot selection can be the way that two sub-arrays could be equal in size
// or not then we are going to have several cases of complexity
// best case time complexity is o(nlogn)
// average case is o(nlogn)
// worse case is similar to average case in quick sort o(n^2)

public class QuickSort {

    public static void quickSort(int[] arr) {
        int len = arr.length;
        quickSortRec(arr, 0, len - 1);
    }

    private static void quickSortRec(int[] arr, int start, int end) {
        if(start >= end ) return;

        int idx = partitionHoares(arr, start, end);
        //int idx = partitionLomutos(arr,start,end);
        quickSortRec(arr, start, idx - 1);
        quickSortRec(arr, idx + 1, end);

    }

    /**
     * @param arr
     * @param s
     * @param e
     * @return Hoare's partitioning
     */

    private static int partitionHoares(int[] arr, int s, int e) {
        Random random = new Random();
        int range = e - s + 1 ;
        int pivotIdx = random.nextInt(range) + s;
        SwapElement.swapElement(arr, e, pivotIdx);

        int smaller = s;
        int greater = e - 1;

        while (smaller <= greater) {

            while (smaller <= e - 1 && arr[smaller] < arr[e])
                smaller++;
            while (greater >= 0 && arr[greater] > arr[e])
                greater--;

            if (smaller < greater) {
                int temp = arr[smaller];
                arr[smaller] = arr[greater];
                arr[greater] = temp;
                greater--;
                smaller++;
            }
        }

            int temp = arr[smaller];
            arr[smaller] = arr[e];
            arr[e] = temp;
            return smaller;
        }


    private static int partitionLomutos(int[] arr, int s, int e) {

        Random random = new Random();
        int range = e - s + 1;
        int pivotIdx = random.nextInt(range) + s;
        SwapElement.swapElement(arr, s, pivotIdx);
        int pivot = arr[s];
        int smaller = s;
        int greater = s;

        while (greater <= e) {
            if (arr[greater] < pivot) {
       
                SwapElement.swapElement(arr, smaller, greater);
		smaller++;
            }
            greater++;
        }
        SwapElement.swapElement(arr,s, smaller );
        return smaller;
    }

        public static void main (String[]args){
            int arr[] = {10, 80, 30, 90, 40, 50, 70,0};
            quickSort(arr);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
                System.out.print(",");
            }

        }

    }




