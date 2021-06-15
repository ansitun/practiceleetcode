package hard;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    public int totalNQueens(int n) {

        int[][] board = new int[n][n];
        List<List<Integer[]>> result = new ArrayList<>();
        List<Integer[]> combinations = new ArrayList<>();

        totalNQueenHelper(0, board, result, combinations);

        return result.size();
    }

    public void totalNQueenHelper(int i, int[][] board, List<List<Integer[]>> result, List<Integer[]> comb) {
        if(i==board.length) {
            result.add(comb);
            return;
        }

        for(int k=0; k< board.length; k++) {
            if (isValid(i, k, board)) {
                board[i][k] = 1;
                comb.add(new Integer[]{i,k});

                totalNQueenHelper(i+1, board,  result, comb);

                board[i][k] = 0;
                comb.remove(comb.size()-1);

            }

        }

    }

    public boolean isValid(int i, int j, int[][] board) {
        for(int k=i, l = j; k>=0 && l >=0; k--,l--) {
            if(board[k][l] == 1) {
                return false;
            }
        }
        for(int k=i, l = j; k>=0 && l<board.length; k--,l++) {
            if(board[k][l] == 1) {
                return false;
            }
        }

        for(int l = i; l >=0; l--) {
            if(board[l][j] == 1) {
                return false;
            }
        }

        return true;
    }

    public void printBoard(int[][] board) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        NQueen n = new NQueen();
        System.out.println(n.totalNQueens(12));
    }
}
