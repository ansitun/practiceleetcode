package medium;

import easy.Pallindrome;

import java.util.HashMap;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0, right = height.length - 1;
        while(left < right) {
            max = Math.max(Math.min(height[right], height[left]) * (right - left), max);
            if (height[left] > height[right]) right--;
            else left++;
            }

        return max;
    }

    public static void main(String[] args) {
        ContainerWithMostWater c = new ContainerWithMostWater();
        System.out.println(c.maxArea(new int[]{4,3,2,1,4}));
    }
}
