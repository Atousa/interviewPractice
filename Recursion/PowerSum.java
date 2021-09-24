import javax.swing.*;


//Find the number of ways that a given integer, X, can be expressed as the sum of the  powers of unique, natural numbers.

public class PowerSum {

    public static int numWay=0;
    public static void powerSum2(int X, int K) {
        int curSum = 0;
        if(X == 1) {
            numWay = 1;
            return;
        }
        powerSumHelper2(X, K, (int) Math.pow(X,1./K),curSum); // X^ 1/k
    }
    public static void powerSumHelper2(int X, int K, int curNum, int curSum) {
        if(curSum == X) {
            numWay+=1;
            return;
        }
        if(curNum == 0 || curSum > X)
            return;
        powerSumHelper2(X, K, curNum-1, curSum);

        int times = 1;
        for(int i = 0; i < K; i++) {
            times*=curNum;
        }
        powerSumHelper2(X,K, curNum-1, curSum + times);
    }



    public static void main(String[] args) {
        //powerSum1(100,2);
        //System.out.println(numWay);
        powerSum2(400,2);
        System.out.println(numWay);

    }
}
