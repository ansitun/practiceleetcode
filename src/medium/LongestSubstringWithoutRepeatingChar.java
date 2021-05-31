package medium;

import java.util.*;

public class LongestSubstringWithoutRepeatingChar {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;

        int len=1, start=0, i, newStart;
        HashMap<Character, Integer> map = new HashMap<>();

        for(i=0; i<s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                len = Math.max(len, i-start);
                newStart = map.get(s.charAt(i));

                while(start <= newStart) {
                    map.remove(s.charAt(start));
                    start++;
                }

            }
            map.put(s.charAt(i), i);
        }

        return Math.max(len, i-start);
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingChar l = new LongestSubstringWithoutRepeatingChar();
        System.out.println(l.lengthOfLongestSubstring("ababa"));
    }
}
