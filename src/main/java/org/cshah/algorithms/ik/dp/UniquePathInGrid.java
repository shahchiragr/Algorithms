package org.cshah.algorithms.ik.dp;

public class UniquePathInGrid {

    public static int countUniquePathInGrid(int[][] grid) {
        int[][] table = new int[grid.length][grid[0].length];
        int totalRow = table.length;
        int totalCol = table[0].length;

        //first row and col set to 0 as there is no path to land on this cell
        table[0][0] = 0;

        //first row initialize with 1 as there is only one path
        for (int col=1;  col< table[0].length; col++) {
            table[0][col] =1;
        }

        for (int row=1; row < table.length; row++) {
            table[row][0] = 1;
        }


        for (int row=1; row < table.length; row++) {
            for (int col=1; col < table[0].length; col++) {
                table[row][col] = table[row-1][col] + table[row][col-1];
            }
        }

        return table[totalRow-1][totalCol-1];
    }

    /**
     * This is a wall problem, where in table 0 represent wall, means you can not cross that path
     * this is slight different implementation with using same mechanism, to find the max path
     * @param grid
     * @return
     */
    public static int countUniquePathInGridWithWall(int[][] grid) {
        int[][] table = new int[grid.length][grid[0].length];
        int totalRow = table.length;
        int totalCol = table[0].length;

        //first row and col set to 0 as there is no path to land on this cell
        table[0][0] = grid[0][0];

        //first row initialize with 1 as there is only one path
        for (int col=1;  col< table[0].length; col++) {
            table[0][col] =grid[0][col];
        }

        for (int row=1; row < table.length; row++) {
            table[row][0] = grid[row][0];
        }


        for (int row=1; row < table.length; row++) {
            for (int col=1; col < table[0].length; col++) {
                if (grid[row][col] == 0) {
                    table[row][col] = 0;
                } else {
                    table[row][col] = table[row - 1][col] + table[row][col - 1];
                }
            }
        }

        return table[totalRow-1][totalCol-1];
    }

    public static void main(String[] args) {
        int row = 4;
        int col = 4;
        int[][] grid= new int[row][col];

        //initializing array with 1, so that in future, we can set bunch of cell to 0 as a wall so that path is not visitable anymore
        for (int i=0; i < row; i++) {
            for (int j=0; j < col; j++) {
                grid[i][j] = 1;
            }
        }

        System.out.println("Total path.... " + UniquePathInGrid.countUniquePathInGrid(grid));


        /*
        in below example the algo should return only 3 valid path
        1 1 0 1
        1 0 1 0
        1 1 1 0
        1 1 1 1
        */

        grid[0][2] =0;
        grid[1][1] =0;
        grid[1][3] =0;
        grid[2][3] =0;

        System.out.println("Total unique path with wall... " + UniquePathInGrid.countUniquePathInGridWithWall(grid));

    }
}
