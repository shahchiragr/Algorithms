package org.cshah.algorithms.leetcode.medium;

public class NumIslands {

    public int numIslands(char[][] grid) {
        int row = grid.length;
        if (row == 0)
            return  0;
        int col = grid[0].length;
        if (col ==0)
            return  0;

        int count =0;
        for (row =0; row < grid.length;row++) {
            for (col=0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    runDFS(row, col,grid);
                    count++;
                }
            }
        }

        return  count;
    }

    public void runDFS(int row, int col, char[][] grid) {

        if (row >= grid.length || row < 0 || col < 0 || col >= grid[0].length || grid[row][col] != '1')
            return;

        grid[row][col] = 'X';

        runDFS(row+1, col, grid);
        runDFS(row-1, col, grid);
        runDFS(row, col+1, grid);
        runDFS(row, col-1, grid);

    }
    public static void main(String args[]) {
        NumIslands numIslands = new NumIslands();

        char[][] islands = { {'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}};
        int count =numIslands.numIslands(islands);
        System.out.println("Total island " + count);

        islands = new char[][]{ {'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
        count =numIslands.numIslands(islands);
        System.out.println("Total island " + count);

    }
}
