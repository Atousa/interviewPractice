public class SelectionSort {

    public static void selectionSort(int[] arr) {
        int len = arr.length;
        for(int i = 0; i < len; i++) {
            int minIdx = findMinIdx(arr, i,len);
            mySwap(arr, minIdx, i);
        }
    }

    public static int findMinIdx(int[] arr, int start, int len) {
        int minIdx = start;
        for(int i = start; i < len ;i++) {
            if(arr[i] < arr[minIdx] ){
                minIdx = i;
            }
        }
        return minIdx;
    }

    public static void mySwap(int[] arr, int value1, int value2) {
        int p = arr[value1];
        arr[value1] = arr[value2];
        arr[value2] = p;
    }

    public static void main(String[] args) {
        int[] a = {23,22,15,15,16,13,-1,67};
        selectionSort(a);
        for(int i=0; i < a.length; i++) {
            System.out.print(a[i]);
            System.out.print(",");
        }
    }
}
