package easy;

import medium.ThreeSum;

import java.util.HashMap;

public class RomanToString {

    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int num = 0, prev = 0;
        for(int i=s.length()-1; i>=0; i--) {
            Character c = s.charAt(i);
            if(prev <= map.get(c))
                num += map.get(c);
            else
                num -= map.get(c);

            prev = map.get(c);
        }
        return num;
    }
    public static void main(String[] args) {
        RomanToString r = new RomanToString();
        System.out.println(r.romanToInt("MCMXCIV"));
    }
}
