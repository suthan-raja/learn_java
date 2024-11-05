package msp.test.learn.algorithm.backtracking;

import java.util.Arrays;

public class NQueens {
    private int N;
    private int[] board;

    public NQueens(int n) {
        this.N = n;
        this.board = new int[n];
    }

    public void solve() {
        placeQueens(0);
    }

    private void placeQueens(int row) {
        if (row == N) {
            printSolution();
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(col , row)) {
                board[row] = col;
                placeQueens(row + 1);
            }
        }
    }

    private boolean isSafe( int col , int row) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    private void printSolution() {
        System.out.println("BOARD : "+ Arrays.toString(board));
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens(5);
        nQueens.solve();
    }
}
