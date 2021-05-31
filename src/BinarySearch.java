import java.awt.desktop.SystemSleepEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinarySearch {
    public int binarySearch(int[] arr, int val) {
        int mid = arr.length/2, l=0, r= arr.length-1;

        while(l < r) {

            if(val < arr[mid]) r=mid;
            else if(val > arr[mid]) l=mid+1;
            else if (val == arr[mid]) return mid;
            mid = l+(r-l)/2;
        }
        return l;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{3,14,1,7};
        for(int i=1; i< arr.length; i++) {
            arr[i] += arr[i-1];
        }
        BinarySearch b = new BinarySearch();
        //System.out.println(b.binarySearch(arr, 33));

        String[] s = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(b.groupAnagrams(s));
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray()){
                ca[c - 'a']++;
            }

            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());

    }

    // conversion of char array to string is super fast.
    // char takes 0-127 bytes, byte takes -128 to 127, int takes -2^32 - 2^32-1
}
