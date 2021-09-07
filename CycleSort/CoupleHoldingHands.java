import java.util.HashMap;
import java.util.Map;

//765. Couples Holding Hands

//There are n couples sitting in 2n seats arranged in a row and want to hold hands.
//
//        The people and seats are represented by an integer array row where row[i] is the ID of the person
//        sitting in the ith seat. The couples are numbered in order, the first couple being (0, 1), the second couple
//        being (2, 3), and so on with the last couple being (2n - 2, 2n - 1).
//
//        Return the minimum number of swaps so that every couple is sitting side by side.
//        A swap consists of choosing any two people, then they stand up and switch seats.
//

// using cycle sort also possible
// complexity
// sc = 0(n), TC= o(n)

// algorithm : each manager handling one sofa (a couple)
// each couple (even, odd)   (2,3  ; 6,7;  9,8)
// we start from left person and decide who should be the right person based on if it is odd or even
// we find the right partner in the hasMap
// we swap
// we update the hashMap 


public class CoupleHoldingHands {

    public static int coupleHoldingHands(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        int numSwap = 0;

        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], i); // (coupleID, seatingID)
        }

        int pairLen = nums.length / 2;

        for (int i = 0; i < pairLen; i++) {
            int seatIdL = 2 * i;
            int seatIdR = 2 * i + 1;

            int temp = nums[seatIdL];
            int expectedPartner = 0;

            if (temp % 2 == 0)
                expectedPartner = temp + 1;
            else
                expectedPartner = temp -1 ;

            int idxR = hm.get(expectedPartner);
            if(idxR != seatIdR) {

                swap(nums, idxR, seatIdR);
                hm.put(nums[2 * i + 1], 2 * i + 1);
                hm.put(nums[idxR], idxR);
                numSwap++;
            }
        }
        return numSwap;

    }
    private static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,2,3,1,4,0};
        int n = coupleHoldingHands(arr);
        for(int a: arr) {
            System.out.println(a);
        }
        System.out.println(n);

    }
}






