public class NumOfIslandsPractice {

    public static void main(String args[]) {

        char[][] input = new char[][]{
                {'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}
        };

        NumOfIslandsPractice n = new NumOfIslandsPractice();

        System.out.println(n.numIslands(input));
    }


    public int numIslands(char[][] grid) {
        // loop through th matrix
        // check for 1s - if yes then traverse in 4 dir until we find 0
        // every time we traverse, mark the boolean matrix as true for that cell
        // once we reach 0, traverse in all directions to find the next island

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int numberOfIslands = 0;

        for(int i=0; i< grid.length; i++) {
            for(int j=0; j< grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    numberOfIslands++;
                    visited[i][j] = true;
                    isIsland(i+1, j, visited, grid);
                    isIsland(i, j+1, visited, grid);
                    isIsland(i-1, j, visited, grid);
                    isIsland(i, j-1, visited, grid);

                }
            }
        }

        return numberOfIslands;
    }

    public void isIsland(int i, int j, boolean[][] visited, char[][] grid) {
        if ( i<0 || j< 0 || i>= grid.length || j>= grid[i].length
                || grid[i][j] == '0' || visited[i][j]) {
            return;
        }

        if(grid[i][j] == '1') {
            visited[i][j] = true;
        }

        isIsland(i+1, j, visited, grid);
        isIsland(i, j+1, visited, grid);
        isIsland(i-1, j, visited, grid);
        isIsland(i, j-1, visited, grid);

        return;
    }

}
