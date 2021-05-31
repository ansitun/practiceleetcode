// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Zolando {
    // minimum cost of splitting
// the array into subarrays
    Integer[][] dp;

    public int solution(int[] A) {
        // write your code in Java SE 8

        // range is more than 5
        int minCost = A[0] + A[2];

        // find non-adj combinations, set the rule, find the min

        for(int i=0; i< A.length-2; i++) {
            //minCost = Math.min(minCost, A[i] + A[i+2]);
            for(int j=i+2; j< A.length; j++) {
                minCost = Math.min(minCost, A[i] + A[j]);
            }
        }

        return minCost;

    }

    // Driver Code
    public static void main(String[] args)
    {
        int[] arr = {5,2,4,6,3,7};

        // Given cost K
        int K = 3;
        int n = arr.length;

        Zolando z = new Zolando();

        // Function Call
        System.out.print(z.solution(arr));
    }
}



