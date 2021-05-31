 // you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

    class Solution {
        public int solution(int[] A) {
            // write your code in Java SE 8
            HashMap<Integer, Integer> dictMap = new HashMap<Integer, Integer>();
            HashSet<Integer> uniqueDict = new HashSet<Integer>();
            int targetSize, minDays, leftEnd=0, rightEnd = -1;
            //leftEnd = 0;

            for(int i=0; i<A.length; i++) {
                uniqueDict.add(A[i]);
            }
            targetSize = uniqueDict.size();
            System.out.println("-----" + targetSize);

            minDays = A.length;
            while(leftEnd < A.length) {
                if(dictMap.size() < targetSize) {
                    rightEnd++;
                    if(rightEnd < A.length) {
                        dictMap.put(A[rightEnd], dictMap.getOrDefault(A[rightEnd], 0)+1);
                    } else {
                        break;
                    }
                } else {
                    minDays = Math.min(minDays, rightEnd-leftEnd + 1);
                    System.out.println("-------------");
                    System.out.println(minDays);
                    dictMap.put(A[leftEnd], dictMap.get(A[leftEnd])-1);
                    if(dictMap.get(A[leftEnd]) == 0) {
                        dictMap.remove(A[leftEnd]);
                    }
                    leftEnd++;
                }
            }

            return minDays;
        }

        public static void main(String args[]) {
            Solution s = new Solution();
            int[] sa = {7, 3, 7, 3, 1, 3, 4, 1};

            System.out.println(s.solution(sa));
        }
    }


