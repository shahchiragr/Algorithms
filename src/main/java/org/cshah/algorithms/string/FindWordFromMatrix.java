package org.cshah.algorithms.string;

/**
 * Created by cshah on 6/15/14.
 *
 Given a matrix of letters and a word, check if the word is present in the matrix. E,g., suppose matrix is:
 a b c d e f
 z n a b c f
 f g f a b c
 and given word is fnz, it is present. However, gng is not since you would be repeating g twice.
 You can move in all the 8 directions around an element.
 */
public class FindWordFromMatrix {

    public boolean isWordPresent(int i, int j, String target, boolean[][]visited, char[][]matrix){
        if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length){
            return false;
        }

        if(visited[i][j]){
            return false;
        }

        if(matrix[i][j] != target.charAt(0)){
            return false;
        }else{
            visited[i][j] = true;
            //the last char matches
            if(target.length()==1){
                return true;
            }else{
                return isWordPresent(i-1,j-1,target.substring(1),visited,matrix)||
                        isWordPresent(i-1,j,target.substring(1),visited,matrix)||
                        isWordPresent(i-1,j+1,target.substring(1),visited,matrix)||
                        isWordPresent(i,j-1,target.substring(1),visited,matrix)||
                        isWordPresent(i,j+1,target.substring(1),visited,matrix)||
                        isWordPresent(i+1,j-1,target.substring(1),visited,matrix)||
                        isWordPresent(i+1,j,target.substring(1),visited,matrix)||
                        isWordPresent(i+1,j+1,target.substring(1),visited,matrix);
            }
        }
    }

    public boolean findWord(String target, char [][]matrix){
        //first check valid word and matrix
        if(target.equals("") || target==null){
            return false;
        }

        if(matrix.length==0){
            return false;
        }

        //loop
        boolean flag = false;
        for(int row =0; row<matrix.length;row++){
            for(int column=0;column<matrix[0].length;column++){
                boolean [][]visited = new boolean[matrix.length][matrix[0].length];
                flag = isWordPresent(row,column,target,visited,matrix);
                if(flag){
                    return true;
                }
            }
        }

        return false;
    }

     public static void main(String[] args) {
        char[][] m =
                {{'a','b','c','d','e','f'},
                 {'z','n','a','b','c','f'}, // z n a b c f
                 {'f','g','f','a','b','c'}};
        FindWordFromMatrix matrix = new FindWordFromMatrix();
        boolean returnValue = matrix.findWord("cbb",m);
         System.out.println("FOUND " + returnValue);
     }
}
