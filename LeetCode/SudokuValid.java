package LeetCode;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/valid-sudoku/
public class SudokuValid {

    //Searching for element in row and the corresponding column at the same time
    //We achieve this by swapping i to j and j to i
    //1 value out of i and j will remain constant, in this case j
    public boolean isValidSudoku(char[][] board) {
        return checkRowColumn(board) && checkSubBlocks(board);
    }
    private boolean checkRowColumn(char[][] board) {
        int size = board.length;
        for (int i = 0; i < size; i++) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> columnSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (board[i][j] != '.' && !rowSet.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !columnSet.add(board[j][i])) {
                    return false;
                }
            }
        }
        return true;
    }

    //Make sub parts of 3x3 by creating limits of i and j for that sub block
    private boolean checkSubBlocks(char[][] board) {
        int size = board.length;
        for (int i = 0; i < size; i=i+3) {
            for (int j = 0; j < size; j=j+3) {
                Set<Character> set = new HashSet<>();
                for (int k = i; k < i+3; k++) {
                    for (int l = j; l < j+3; l++) {
                        if (board[k][l] != '.' && !set.add(board[k][l])) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
