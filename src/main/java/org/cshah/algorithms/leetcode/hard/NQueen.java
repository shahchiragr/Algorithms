package org.cshah.algorithms.leetcode.hard;

public class NQueen {
    public void printBoard(int[][] board) {
        for (int i=0; i < board.length;i++) {
            for (int j=0; j< board[0].length;j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("================");
    }

    public boolean hasConflicts(int[][] board, int row, int col, int n) {
        for (int nextRow=0; nextRow <n;nextRow++) {
            if ( nextRow != row  && board[nextRow][col] == 1) {
                return true;
            }
        }

        return  checkUPColMinus(board, row, col, n) || checkUpColPlus(board, row, col, n) ||
                checkDownColPlus(board, row, col, n) || checkDownColMinus(board, row, col, n);

     //   return hasConflictsRec(board, row,col, n,n);
    }

    public boolean checkUPColMinus(int[][]board, int row, int col, int n) {
        while ( row >=0 && col >= 0 ) {
            if ( board[row][col] == 1)
                return  true;

            row--;
            col--;
        }

        return false;
    }

    public boolean checkDownColPlus(int[][]board, int row, int col,int n) {
        while ( row < n && col< n) {
            if ( board[row][col] == 1)
                return  true;

            row++;
            col++;
        }

        return false;
    }

    public boolean checkDownColMinus(int[][]board, int row, int col,int n) {
        while ( row < n && col >= 0) {
            if ( board[row][col] == 1)
                return  true;

            row++;
            col--;
        }

        return false;
    }

    public boolean checkUpColPlus(int[][]board, int row, int col,int n) {
        while ( row >=0  && col < n) {
            if ( board[row][col] == 1)
                return  true;

            row--;
            col++;
        }

        return false;
    }

    public boolean hasConflictsRec(int[][]board, int row, int col, int totalRow, int totalCol) {
        if (row < 0 || row >= totalRow || col < 0 || col >= totalCol) {
            return false;
        }

        if (board[row][col] == 1)
            return true;

        return  hasConflictsRec(board, row -1, col-1, totalRow, totalCol) ||
                hasConflictsRec(board, row -1, col+1, totalRow, totalCol) ||
                hasConflictsRec(board, row +1, col-1, totalRow, totalCol) ||
                hasConflictsRec(board, row +1, col+1, totalRow, totalCol);
    }

    public void findQueenLocation(int row, int n, int[][]board) {
        if (row == n ) {
            printBoard(board);
            return;
        }


        for (int col=0; col < n; col++) {
            if (!hasConflicts(board, row, col,n)) {
                board[row][col] = 1;
                findQueenLocation(row + 1, n, board);
                board[row][col] = 0;
            }
        }

    }
    public static void main(String[] args) {
        int n = 4;
        int board[][] = new int[n][n];
        NQueen nQueen = new NQueen();
        nQueen.findQueenLocation(0, n, board);
    }
}
