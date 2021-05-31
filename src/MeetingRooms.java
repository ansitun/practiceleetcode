import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms {

    public int meetingRooms(int[][] intervals) {

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> a-b);
        int meetingRooms = 0;

        if (intervals.length == 1) {
            return meetingRooms;
        }

        for(int i=0; i< intervals.length; i++) {

            if(pq.size() > 0) {
                if(intervals[i][0] >= pq.peek()) {
                    pq.poll();
                } else {
                    meetingRooms++;
                }
                pq.offer(intervals[i][1]);
            } else {
                pq.offer(intervals[i][1]);
                meetingRooms++;
            }
        }

        return meetingRooms;
    }

    public static void main(String []args) {

//        int[][] input = {{1, 18},{18, 23},{15, 29},{4, 15},{2, 11},{5, 13}};
//        int[][] input = {{7,10},{2,4}};
        int[][] input =   {{0, 14},{6, 25},{12, 19},{13, 19},{5, 9}};
        MeetingRooms m = new MeetingRooms();
        System.out.println(m.meetingRooms(input));
    }
}
