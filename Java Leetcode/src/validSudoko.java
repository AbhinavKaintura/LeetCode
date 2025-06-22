// 36 Valid Sudoku

import java.util.HashSet;
import java.util.Set;
class Solution {
    @SuppressWarnings("unchecked")
    public boolean isValidSudoku(char[][] board) {
        
        Set<Character>[] rowSet = new HashSet[9];
        Set<Character>[] colSet = new HashSet[9];
        Set<Character>[] gridSet = new HashSet[9];

        for(int i=0; i<9; i++){
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
            gridSet[i] = new HashSet<>();
        }

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                
               int gridNo = (i/3)*3 + j/3;

                if(board[i][j] != '.'){

                    if(rowSet[i].contains(board[i][j]) || colSet[j].contains(board[i][j]) || gridSet[gridNo].contains(board[i][j]))
                        return false;

                    rowSet[i].add(board[i][j]);
                    colSet[j].add(board[i][j]);
                    gridSet[gridNo].add(board[i][j]);
                }
            }
        }
        return true;
    }
}

public class validSudoko {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '6', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '2', '4', '1', '9', '.', '.', '.'},
            {'.', '8', '7', '.', '3', '.', '.', '2', '.'}
        };

        boolean isValid = solution.isValidSudoku(board);
        System.out.println("Is the Sudoku valid? " + isValid);
    }
}