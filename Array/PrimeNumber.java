import javax.imageio.ImageReadParam;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PrimeNumber {
    /** take an integer argument and return all the prime number
     *
     * @param num
     */

    //the complexity is n* sqrt(n)
    public static void primeNumber1(int num) {

        if(num<2) return;

        for (int i = 2; i < num; i++) {
            boolean f = true;

            for(int j = 2; j < Math.sqrt(i); j++) {
                if(i % j == 0)
                    f = false;
            }
            if(f) System.out.println(i);
        }
    }

    // time complexity is (n/2+n/3+n/4+......) that is nloglogn but there is O(N) space complexity

    public static List<Integer> primeNumber2(int num) {
        if(num<2) return Collections.EMPTY_LIST;

        List<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[num + 1];

        for (int i = 0; i < isPrime.length; i++)
            isPrime[i] = true;

        isPrime[0] = false;
        isPrime[1] = false;

        for (int p = 2; p <= num; p++) {
            if (isPrime[p])
                primes.add(p);
            //sieve p's multiples
            for (int i = p; i <= num; i += p)
                isPrime[i] = false;
        }
        return primes;
    }

    //improve the space complexity

    public static List<Integer> primeNumber3(int num) {
        if (num < 2)
            return Collections.EMPTY_LIST;

        final int size = (int) Math.floor(0.5 * (num - 3) + 1);

        List<Integer> primes = new ArrayList<>();

        primes.add(2);

        boolean[] isPrime = new boolean[size];

        for(int i = 0; i < size; i++)
            isPrime[i] = true;

        for (int i = 0; i < size; i++) {
            int idx = i;
            int value = 2 * idx + 3;
            if (isPrime[idx]) {
                primes.add(value);
                while (idx < size) {
                    value *= value;
                    int cutIdx = (value - 3) / 2;
                    idx = cutIdx;
                    if(idx < size)
                        isPrime[idx] = false;
                }
            }
        }
        return primes;
    }

    public static void main(String[] args) {
       primeNumber1(19);

        List<Integer> l1 = primeNumber2(19);
        System.out.println(l1);

        List<Integer> l = primeNumber3(19);
        System.out.println(l);

    }
}
