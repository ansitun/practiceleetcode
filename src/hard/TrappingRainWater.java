package hard;

public class TrappingRainWater {

    public int trap(int[] height) {

        /*
                  .
        ._________.
        ._____.___.
        . .   . . .
        . . _ . . .
        0 2 4 1 2 0
        1 3 5 2 3 0

        0 2 4 1 2 0

        9

        */

        int[] leftSeriesHeight = new int[height.length];

        if(height.length == 0) {
            return 0;
        }

        int totalTappedWater=0,maxHeight=height[0];

        for(int i=0; i<height.length; i++) {

            if(height[i] > maxHeight) {
                maxHeight = height[i];
            }
            leftSeriesHeight[i] = maxHeight - height[i];
        }

        maxHeight=height[height.length-1];
        for(int i=height.length-1; i>=0; i--) {

            if(height[i] > maxHeight) {
                maxHeight = height[i];
            }
            totalTappedWater += Math.min(leftSeriesHeight[i], maxHeight - height[i]);
        }

        return totalTappedWater;
    }

    public static void main(String[] args) {
        TrappingRainWater t = new TrappingRainWater();
        System.out.println(t.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
