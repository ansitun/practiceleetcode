import java.util.HashMap;

public class LongestSubStrWithKDistinct {

    public static int findLength(String str, int k) {

        int max = 0, startWindow = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i< str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);

            while (map.size() > k && startWindow < i) {
                if (map.get(str.charAt(startWindow)) == 1) {
                    map.remove(str.charAt(startWindow));
                } else {
                    map.put(str.charAt(i), map.get(str.charAt(startWindow)) - 1);
                }
                startWindow++;
            }
            max = Math.max(max, i-startWindow+1);
        }

        return max;
    }

    public static int findLength2(char[] arr) {
        // TODO: Write your code here
        int max = 0, startWindow = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++) {

            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            while (map.size() > 2) {
                int val = map.get(arr[startWindow]);
                if (val == 1) {
                    map.remove(arr[startWindow]);
                } else {
                    map.put(arr[startWindow], val - 1);
                }
                startWindow++;
            }

            max = Math.max(max, i-startWindow + 1);
        }

        return max;
    }

    public static void main(String []args) {
        LongestSubStrWithKDistinct l = new LongestSubStrWithKDistinct();
        System.out.println(l.findLength("araaci", 1));

        String sr = "abcac";
        System.out.println(l.findLength2(sr.toCharArray()));
    }

}
