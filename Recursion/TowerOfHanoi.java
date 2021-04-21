public class TowerOfHanoi {

    public static void TowerOfHanoi(int numDist, char src, char des, char aux) {
        if(numDist == 1) {
            System.out.println("from" + src + "to" + aux);
            return;
        }

        TowerOfHanoi(numDist-1, src, aux, des);
        System.out.println("move disk " + numDist + "from" + src +"to"+ des);
        TowerOfHanoi(numDist-1, aux, des,src);
    }

    public static void main(String[] args) {
        int n = 4; // Number of disks
        TowerOfHanoi(n, 'A', 'C', 'B'); // A, B and C are names of rods
    }
}
