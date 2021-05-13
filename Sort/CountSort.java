import java.util.Arrays;

public class CountSort {
// complexity SC(o(n) + o(k)) and TC=o(n)+o(k)
    //not stable unless you have an array of linked list to sav save the objects
    public static int[] countSort(int[] arr) {
        int[] count = new int[256];
        int len = arr.length;
        int[] result = new int[len];

        Arrays.fill(count,0);

        for(int i = 0; i < len; i++)
            count[arr[i]]++;

     // create running sum
        for(int i = 1; i < 256; i++) {
            count[i]= count[i-1] + count[i];
        }

        for(int i = 0; i < len; i++) {
            int m = arr[i];
            result[--count[m]] = m;
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {3,5,6,6,7,8,9,7,7,8,3,5};
        int[] r = countSort(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(r[i]);
        }
    }
}
