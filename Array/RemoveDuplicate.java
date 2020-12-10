public class RemoveDuplicate {
    public static void removeDuplicate(int[] A) {
        int cur = 1;

        for (int read = 0; cur < A.length; read++) {
            while (A[read] == A[cur])
                cur++;
            A[read + 1] = A[cur];
            cur++;
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,5,5,7,11,11,11,13};
        removeDuplicate(arr);
        for(int i = 0; i < arr.length;i++)
            System.out.println(arr[i]);
    }
}


