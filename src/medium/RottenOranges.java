package medium;

import java.util.*;

public class RottenOranges {

    public int orangesRotting(int[][] grid) {

        int fresh = 0, min = 0;
        Queue<Integer[]> q = new LinkedList<>();
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {

                if(grid[i][j] == 2) q.add(new Integer[]{i,j});
                else if(grid[i][j] == 1) fresh++;

            }
        }

        if (fresh==0) return 0;
        while(q.size()!=0) {
            if (fresh == 0) return min;

            int oldFresh = fresh, size = q.size();

            for(int i=0; i<size; i++) {
                Integer[] index = q.poll();

                if(index[1] < grid[0].length-1 && grid[index[0]][index[1]+1] == 1) {
                    q.add(new Integer[]{index[0], index[1]+1});
                    grid[index[0]][index[1]+1] = 2;
                    fresh--;
                }

                if(index[0] < grid.length-1 && grid[index[0]+1][index[1]] == 1) {
                    q.add(new Integer[]{index[0]+1, index[1]});
                    grid[index[0]+1][index[1]] = 2;
                    fresh--;
                }

                if(index[0] > 0 && grid[index[0]-1][index[1]] == 1) {
                    q.add(new Integer[]{index[0]-1, index[1]});
                    grid[index[0]-1][index[1]] = 2;
                    fresh--;
                }

                if(index[1] > 0 && grid[index[0]][index[1]-1] == 1) {
                    q.add(new Integer[]{index[0], index[1]-1});
                    grid[index[0]][index[1]-1] = 2;
                    fresh--;
                }
            }


            if (oldFresh != fresh) min++;

        }
        return -1;
    }

    /*
        2   1   1
        1   1   0
        0   1   1
     */
    public static void main(String[] args) {
        RottenOranges r = new RottenOranges();
        System.out.println(r.orangesRotting(new int[][]{new int[]{2,1,1},new int[]{1,1,0}, new int[]{0,1,1}}));
    }

}
