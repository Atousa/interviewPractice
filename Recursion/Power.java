import java.beans.PropertyEditorSupport;

public class Power{
        // 0(k)
    public static int powerRec(int n , int k) {
        if(k == 0) return 1;
        return n*powerRec(n, k-1);
    }

    public static int powerIter(int n , int k) {
         int result = 1;
        for(int i = 1; i <= k; i++)
            result*=n;
      return result;
    }

    //o(logk)  t(k/2) +1 , t(k/4) + 2,  t(k/2^i)+ i == logk like binary search
    public static int powerRecEf(int n , int k) {
        if(k == 0) return 1;
        if(k % 2 != 0) {
            int result =  n*powerRecEf(n,k-1);
            return result;
        } else {
            int result = powerRecEf(n, k / 2);
            return result * result;
        }
    }




    public static void main(String[] args) {
            System.out.println(powerRec(2,3));
            System.out.println(powerIter(2 ,5));
            System.out.println(powerRecEf(2 ,6));
        }


}
