public class NumOfRotation {
    public int numOfRotation(int[] arr) {
        int len = arr.length;
        int idx = findIdxOfMin(arr,0,len-1);
        //if clockwise
        return idx;
        //anti clock wise return (len - idx) of min
    }

    //{18,15,2,4,6,7}  or {7,8,9,10,2,3) //only one element that both side are bigger
    static int findIdxOfMin(int[] arr, int start, int end) {
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            int low = mid;
            int high = mid;
            while(arr[low] == arr[low-1])
                low-=1;
            while(arr[high] == arr[high+1])
                high+=1;
            mid = low;
            if (arr[low] < arr[low - 1] && arr[high] < arr[high + 1])
                    return low; //index of min
            if(arr[low] > arr[low - 1] && arr[high] > arr[high + 1])
                return high+1;
            if (arr[start] < arr[low])
                return findIdxOfMin(arr, low + 1, end);
            else if (arr[high] < arr[end])
                return findIdxOfMin(arr, start, high);

        }
        return -1;
    }

    public static int search(int arr[], int key) {
        int len = arr.length;
        int idx = findIdxOfMin(arr,0,len-1);
        if(arr[idx] == key) return idx;
        if(key > arr[idx] && key <= arr[len-1])
            return BinarySearch.binarySearchRec(arr, idx, len-1,key);
        else
            return BinarySearch.binarySearchRec(arr, 0, idx-1,key);
    }


    public static void main(String[] args) {
        int[] arr1 = {14,15,18, 11,11,11, 12, 13};
        int[] arr2 = {11, 12, 13,2,3,4,6};
        NumOfRotation nr = new NumOfRotation();
        int num = nr.numOfRotation(arr1);
        //int num1 = nr.numOfRotation(arr2);
        System.out.println(num);
        //System.out.println(num1);
        //int element = NumOfRotation.search(arr1, 13);
        //System.out.println(element);

    }

    }

//    1.Find the Rotation Count in Rotated Sorted array
//            Consider an array of distinct numbers sorted in increasing order. The array
//            has been rotated (clockwise) k number of times. Given such an array, find
//            the value of k.
//            Examples:
//            Input : arr[] = {15, 18, 2, 3, 6, 12}
//            Output: 2
//            Explanation : Initial array must be {2, 3,
//            6, 12, 15, 18}. We get the given array after
//            rotating the initial array twice.
//            Input : arr[] = {7, 9, 11, 12, 5}
//            Output: 4
//            Input: arr[] = {7, 9, 11, 12, 15};
//            Output: 0


