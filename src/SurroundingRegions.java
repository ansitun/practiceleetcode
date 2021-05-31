public class SurroundingRegions {


    public static void main(String args[]) {

        char[][] input = new char[][]{
                {'O','X','X','O','X'},
                {'X','O','O','X','O'},
                {'X','O','X','O','X'},
                {'O','X','O','O','O'},
                {'X','X','O','X','O'}
        };
        /*
       [["O","X","X","O","X"],
        ["X","X","X","X","O"],
        ["X","X","X","O","X"],
        ["O","X","O","O","O"],
        ["X","X","O","X","O"]]
         */

        SurroundingRegions n = new SurroundingRegions();

        n.solve(input);
        //n.solve(input);
        //n.solve(input);
        for(int i=0; i<input.length; i++) {
            for(int j=0; j<input[0].length; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
    }



    public void solve(char[][] board) {
        for(int i=1; i< board.length -1 ; i++) {
            for(int j=1; j< board[0].length - 1; j++) {
                if ((board[i][j] == 'O') &&
                        ((board[i-1][j] == 'X' && board[i][j-1] == 'X' && board[i+1][j] == 'X') ||
                                ((board[i-1][j] == 'X' && board[i][j+1] == 'X' && board[i+1][j] == 'X') ||
                                        (board[i-1][j] == 'X' && board[i][j-1] == 'X' && board[i][j+1] == 'X') ||
                                        (board[i][j-1] == 'X' && board[i][j+1] == 'X' && board[i+1][j] == 'X')))) {
                    board[i][j] = 'X';
                }
            }
        }
        return;
    }


}
