public class HappyNumber {
    //leetcode 202

//    Write an algorithm to determine if a number n is happy.
//
//    A happy number is a number defined by the following process:
//
//    Starting with any positive integer, replace the number by the sum of the squares of its digits.
//    Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
//    Those numbers for which this process ends in 1 are happy.
//    Return true if n is a happy number, and false if not.

    // Linear congruential generator

//    private static int fun(int z,int x, int i, int m) {
//        return (z*x+i)%m
//    }
//

//    public static int LCG(int n) {
//
//        int slow = n;
//        int fast = n;
//
//        while(true) {
//            slow = fun(slow);
//            fast = fun(fun(fast));
//            if(fast == slow)
//                int len = 1;
//                    third = slow;
//                    while(fun(third) != slow){}
//                        len++;
//                        third = f(third);
//               return len;
               //cycle found

//        }
//
//
//    }

    public static boolean isHappy(int n) {

        int slow = n;
        int fast = n;

        while(true) {
            slow = fun(slow);
            fast = fun(fun(fast));
            if(fast == slow)
                return true;
        }


    }

    private static int fun(int n) {
        int total = 0;
        while(n!= 0){
            total+=Math.pow(n%10,2);
            n/=10;
        }
        return total;
    }


}
