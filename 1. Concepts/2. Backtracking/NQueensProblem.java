public class NQueensProblem {

    public static void NQueens(char[][] board, int row) {
        if (row == board.length) {
            print(board);
        }
        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = 'Q';
                NQueens(board, row + 1);
                board[row][i] = '.';
            }
        }
    }

    public static void print(char[][] board) {
        System.out.println("------- board -------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(char[][] board, int row, int col) {
        // Check if there is a queen in the same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check if there is a queen in the left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check if there is a queen in the right diagonal
        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int n = 5; // Change the value of n for different board sizes
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        NQueens(board, 0);
    }
}
