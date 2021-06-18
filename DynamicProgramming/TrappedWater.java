public class TrappedWater {

        public static int trap(int[] height) {
            int ans = 0;

            if(height.length == 0) return 0;
            int len = height.length;

            int[] maxLeft = new int[len];
            int[] maxRight = new int[len];

            maxLeft[0] = height[0];
            maxRight[len-1] = height[len-1];

            for(int i = 1; i < len; i++) {
                maxLeft[i] = Math.max(maxLeft[i-1], height[i]);
            }

            for(int i = len-2; i >=0; i--) {
                maxRight[i]= Math.max(maxRight[i+1], height[i]);
            }

            for(int i = 1; i < len-1; i++) {
                ans += Math.min(maxLeft[i],maxRight[i])- height[i];
            }
            return ans;
        }


    public static void main(String[] args) {
        int[] a = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int b = trap(a);
        System.out.println(b);
    }
}
