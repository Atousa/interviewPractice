public class BubbleSort {
    public static void bubbleSort1(int[] arr) {
        int len = arr.length;
        boolean swapped = false;
        for (int i = 0; i < len ;i++) {
            swapped = false;
            for(int j = 0; j <len-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    SwapElement.swapElement(arr, j, j + 1);
                    swapped = true;
                }
            }
            if(swapped == false)
                break;
        }
    }

    public static void bubbleSort2(int[] arr) {
        int len = arr.length;
        boolean swapped = false;
        int i = 0;
        do {
            swapped = false;
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    SwapElement.swapElement(arr, j, j + 1);
                    swapped = true;
                }
            }
            i++;
        } while (swapped == true);
    }


    public static void main(String[] args) {
        int[] a = {23,22,15,16,13};
        bubbleSort1(a);
        for(int i=0; i < a.length; i++) {
            System.out.print(a[i]);
            System.out.print(",");
        }
        System.out.println();
        int[] b = {23,22,15,16,13};
        bubbleSort2(b);
        for(int i=0; i < b.length; i++) {
            System.out.print(b[i]);
            System.out.print(",");
        }

    }

}
