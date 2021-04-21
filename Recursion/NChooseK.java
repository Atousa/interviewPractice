public class NChooseK {
//paskal triangle
    public static int nChooseK(int n , int k) {
        if(n <= 1 || k == 0 || k == n) return 1; // base cases bases on Pascal's triangle
        return nChooseK(n-1,k ) + nChooseK(n-1,k-1 );
    }

    public static void main(String[] args) {
        System.out.println(nChooseK(3,2));
    }
}
