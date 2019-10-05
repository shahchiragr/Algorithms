package org.cshah.algorithms.ik.recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    static String[][] find_all_arrangements(int n) {
        String[][] board = new String[n][n];
        List<String> resultList = new ArrayList<String>();
        arrangeQueen(board,0,n, resultList);

        String[][] returnArray = new String[resultList.size()][1];
        for (int i=0; i < resultList.size(); i++){
            returnArray[i][0] = resultList.get(i);
        }
        return  returnArray;
    }

    static String printBoard(String[][] board, int boardSize) {
         String returnString = "";
            for (int row=0; row< boardSize;row++) {
                String str = "";
               for (int col=0; col<boardSize;col++) {
                   str += (board[row][col]==null ? "-" : board[row][col]) ;
               }
               returnString += str + "\n";
            }
            return returnString.substring(0, returnString.length()-1);
    }

    static void arrangeQueen(String[][] board, int row, int boardSize, List<String> list) {
        if (row == boardSize) {
             String data = printBoard(board, boardSize);
             list.add(data);
            return;
        }

        for (int col=0; col < boardSize; col++) {
            if (canPlace(board, row, col, boardSize)){
                board[row][col] = "q";
                arrangeQueen(board, row+1, boardSize,list);
                board[row][col] = "-";
            }
        }
    }

    static boolean canPlace(String[][] board, int row, int col, int boardSize) {
        for (int nextRow=0; nextRow < boardSize; nextRow++) {
            if (nextRow != row && "q".equals(board[nextRow][col])) {
                return false;
            }
        }

        int nRow = row;
        int nCol = col;

        while ( nRow >=0 && nCol >=0 && nRow < boardSize && nCol < boardSize) {
            if ("q".equals(board[nRow][nCol])) {
                return false;
            }
            nRow--;
            nCol--;
        }

        nRow = row;
        nCol = col;

        while ( nRow < boardSize && nCol < boardSize) {
            if ("q".equals(board[nRow][nCol])) {
                return false;
            }
            nRow++;
            nCol++;
        }

        nRow = row;
        nCol = col;

        while ( nRow < boardSize && nCol >= 0) {
            if ("q".equals(board[nRow][nCol])) {
                return false;
            }
            nRow++;
            nCol--;
        }

        nRow = row;
        nCol = col;

        while ( nRow >= 0 &&  nCol < boardSize) {
            if ("q".equals(board[nRow][nCol])) {
                return false;
            }
            nRow--;
            nCol++;
        }
        return true;
    }


    public static void main(String[] args) {
        int n = 4;
        String[][] result = NQueen.find_all_arrangements(n);
        for (int i=0; i < result.length;i++) {
            System.out.println(result[i][0]);
        }
    }
}
