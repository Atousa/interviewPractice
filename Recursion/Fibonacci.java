public class Fibonacci {

    //complexity  rootsqure(2) ^ n < x < (2 ^n+1)-1
    public static int fibonacci1(int n) {
        if(n == 0) return 1;
        if(n == 1) return 1;

        return (fibonacci1(n-1) + fibonacci1(n-2));
    }

    //b1 = 1, b2 = 1 , complexity linear
    public static int fibonacci2(int n, int b1 ,int b2) {
        int i = n;
        while(i > 0 ) {
            int temp = b1;
            b1 = b1+b2;
            b2 = temp;
            i--;
        }
        return b1;
    }
//0(n) same as additive sequence
    public static int fibonacciRe2(int n, int b1, int b2) {
        if(n == 1) return b2; // or n == 0 return b1
        return fibonacciRe2(n-1, b2, b1+b2);
    }

    public static int fibonacciDP(int n) {
        int[] result = new int[n+1];
        result[0] = 1;
        result[1] = 1;
        int i = 2;
        while(i <= n) {
            result[i] = result[i-1] + result[i-2];
            i++;
        }
        return result[n];
    }



    public static void main(String[] args) {
        System.out.println(fibonacci1(4));
        System.out.println(fibonacci2(4,1,0));
        System.out.println(fibonacciRe2(4, 1,1));
        System.out.println(fibonacciDP(4));
    }

}
