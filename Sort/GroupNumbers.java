public class GroupNumbers {

    static int[] solve1(int[] arr) {
        int len = arr.length;
        for(int even = 0, odd = len-1; even < odd; ) {
            if(arr[even]%2 != 0) {
                int temp = arr[even];
                arr[even] = arr[odd];
                arr[odd] = temp;
                odd--;
            } else {
                even++;
            }

        }
        return arr;
    }

    static int[] solve2(int[] arr) {

        int even = 0;
        int odd = arr.length-1;

        while(even < odd) {
            while(even < odd && arr[even] % 2 == 0) {
                even++;
            }
            while(even < odd && arr[odd] %2 != 0) {
                odd--;
            }
            if(even != odd) {
                int temp = arr[even];
                arr[even] = arr[odd];
                arr[odd] = temp;
                even++;
                odd--;
            }

        }
        return arr;

    }




}
