public class AttendMeetings {

    public static int attendMeetings(List<List<Integer>> intervals) {

        if (intervals.size() == 0) return 0;

        if (intervals.size() == 1) return 1;


        Collections.sort(intervals, (List<Integer> a, List<Integer> b)->(a.get(0) - b.get(0)));

        for(int i = 0; i < intervals.size()-1; i++) {
            List<Integer> l1 = intervals.get(i);
            List<Integer> l2 = intervals.get(i+1);
            if(l1.get(1) > l2.get(0)) return 0;
        }

        return 1;

    }
}
//public boolean canAttendMeetings(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        
        for(int i = 0; i < intervals. length -1 ; i++) {
            if(intervals[i][1] > intervals[i+1][0])
                return false; 
        }
        return true;
    }
