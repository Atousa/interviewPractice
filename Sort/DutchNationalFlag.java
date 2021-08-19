public class DutchNationalFlag {
    public static void DutchNationalFlag(char[] balls) {
        int len = balls.length;

        if (len <= 1) return;

        int g = 0;
        int r = 0;
        int b = len - 1;

        while (g <= b) {
            if (balls[g] == 'g') {
                g++;
            } else if (balls[g] == 'r') {
                char temp = balls[r];
                balls[r] = balls[g];
                balls[g] = temp;
                r++;
                g++;
            } else if (balls[g] == 'b') {
                char temp = balls[b];
                balls[b] = balls[g];
                balls[g] = temp;
                b--;
            }
        }
    }

    public static void main(String[] args) {
        char[] a = {'g','g','r','r','b','b','r','r','g'};
        DutchNationalFlag(a);
        for(char c: a) {
            System.out.print(c);
        }
    }
}