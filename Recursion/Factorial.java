public class Factorial {
    public static int factorialRec(int n) {
        if(n == 0) return 1;
        if(n == 1) return 1;
        return n * factorialRec(n-1);
    }

    public static int factorialIte(int n) {
        int result = 1;
        for(int i = 1; i <= n; i++)
            result =result * i ;
        return result;
    }


    public static void main(String[] args) {
        System.out.println(factorialRec(4));
        System.out.println(factorialIte(4));
    }
}
