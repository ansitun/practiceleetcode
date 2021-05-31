public class NumberOfIslands {

    /*
    Input
[
["1","1","0","0","0"],
["1","1","0","0","0"],
["0","0","1","0","0"],
["0","0","0","1","1"]
]

Output - 3

     */
    
    public static void main(String args[]) {

        int[][] input = new int[][]{
                {1,1,0,0,0},
                {1,1, 0,0,0},
                {0,0,1,0,0},
                {0,0,0,1,1}
        };

        NumberOfIslands n = new NumberOfIslands();

        System.out.println(n.numberOfIslands(input));
    }

    // check if a cell can be included in dfs
    boolean safe(int[][] inp, int row, int col, boolean[][] visited) {
         return (row>=0 && row < inp.length && col >=0 && col < inp[0].length && (inp[row][col] == 1 && !visited[row][col]));
    }

    void dfs(int[][] inp, int row, int col, boolean[][] visited) {
        // check condition

        int[] rowNum = new int[] {-1, -1, -1, 0,0, 1,1,1};
        int[] colNum = new int[] {-1, 0, 1, -1,-1, -1,0,1};


        // mark all as visited
        visited[row][col] = true;

        // all connected neighbours
        for(int p=0; p<8; p++) {
            if(safe(inp, row+rowNum[p], col+colNum[p], visited)) {
                dfs(inp, row+rowNum[p], col+colNum[p], visited);
            }
        }
    }

    public int numberOfIslands(int[][] input) {
        // dfs to find the edges -  find the last egde of the island
        // increment the couunter
        // dfs again to find the next island

        int numOfIslands = 0;

        boolean[][] visited = new boolean[input.length][input[0].length];


        for(int i=0;i< input.length; i++)
        {
            for(int j=0;j < input[0].length; j++) {

                // cell is not visited
                if(input[i][j]== 1 && !visited[i][j]) {
                    this.dfs(input, i, j, visited);
                    ++numOfIslands;
                }
            }

        }

        return numOfIslands;
    }
}
