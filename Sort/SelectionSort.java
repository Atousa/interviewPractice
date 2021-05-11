public class SelectionSort {

    public static void selectionSort(int[] arr) {
        int len = arr.length;
        for(int i = 0; i < len ; i++) {
            int minIdx = findMin(arr, i);
            swapMin(arr, i, minIdx);
        }
    }

    private static int findMin(int[] arr, int start) {
        int minIdx = start;
        int minValue = arr[start];

        for(int j = start; j < arr.length; j++) {
            if(arr[j] < minValue) {
                minValue = arr[j];
                minIdx = j;
            }
        }
        return  minIdx;
    }

    private static void swapMin(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2]=temp;
    }

    public static void main(String[] args) {
        int[] a = {23,22,15,16,13};
        selectionSort(a);
        for(int i=0; i < a.length; i++) {
            System.out.print(a[i]);
            System.out.print(",");
        }
    }

}
