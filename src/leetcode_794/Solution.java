/*
https://leetcode.com/contest/weekly-contest-74/problems/valid-tic-tac-toe-state/
794. Valid Tic-Tac-Toe State
 */

package leetcode_794;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        String[] board = {"OXX","XOX","OXO"};
        System.out.println(validTicTacToe(board));
    }

    public boolean validTicTacToe(String[] board) {
        char[][] board2D = to2Dboard(board);
        int x_cnt = 0;
        int o_cnt = 0;
        for (char[] b : board2D) {
            for (char c : b) {
                if (c == 'X'){
                    x_cnt++;
                }
                else if (c == 'O') {
                    o_cnt++;
                }
            }
        }
//        System.out.println(isWin(board2D, 'X'));

        if (x_cnt == o_cnt && !isWin(board2D, 'X')) {
            return true;

        }
        else if (x_cnt - o_cnt == 1 && !isWin(board2D, 'O')) {
            return true;
        }
        return false;
    }

    public char[][] to2Dboard(String[] board) {
        char[][] board2D = new char[3][3];
        for (int i = 0; i < board.length; i++) {
            String str = board[i];
            for (int j = 0; j < str.length(); j++) {
                board2D[i][j] = str.charAt(j);
            }
        }
        return board2D;
    }

    public boolean isWin(char[][] board2D, char c) {
        for (int i = 0; i < board2D.length; i++) {
            if (c == board2D[i][0] && c == board2D[i][1] && c == board2D[i][2]) {
                return true;
            }
            else if (c == board2D[0][i] && c == board2D[1][i] && c == board2D[2][i]) {
                return true;
            }
        }
        if (c == board2D[0][0] && c == board2D[1][1] && c == board2D[2][2]) {
            return true;
        }
        else if (c == board2D[2][0] && c == board2D[1][1] && c == board2D[0][2]) {
            return true;
        }
        return false;
    }



}
