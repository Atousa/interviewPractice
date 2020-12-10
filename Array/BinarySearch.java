public class BinarySearch {

    public static int binarySearchRec(int[] arr, int start, int end, int key) {
            if (end >= start) {
                int midIdx = start + (end - start) / 2;
                if (arr[midIdx] == key) return midIdx;
                if (key < arr[midIdx]) return binarySearchRec(arr, start, midIdx - 1, key);
                return binarySearchRec(arr, midIdx + 1, end, key);
            }
            return -1;
        }

    public static int binarySearch(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) return mid;
            if (key < arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {

            int[] arr1 = {7, 9, 11, 12, 5};
            int[] arr2 = {15, 18, 2, 3, 6, 12};
            //int idx =  binarySearch(arr1, 0,4,5);

        System.out.println(binarySearch(arr1,12));


        }
}

