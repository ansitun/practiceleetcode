package medium;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        HashSet<String> strSet = new HashSet<>();

        for(int i=0; i<nums.length-1; i++) {
            HashMap<Integer,Integer> map = new HashMap<>();
            int target = -nums[i];
            for(int j=i+1; j<nums.length; j++) {
                if(map.containsKey(nums[j])) {
                    Integer[] res = new Integer[]{nums[j],nums[i], map.get(nums[j])};
                    Arrays.sort(res);
                    List<Integer> resultTemp = Arrays.asList(res);

                    String s = "";
                    for(Integer l: res) {
                        s +=l;
                    }

                    if(!strSet.contains(s)) {
                        result.add(resultTemp);
                        strSet.add(s);
                    }

                } else {
                    map.put(target-nums[j], nums[j]);
                }

            }
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSum t = new ThreeSum();
        System.out.println(t.threeSum(new int[]{1,2,-2,-1}));
    }
}
