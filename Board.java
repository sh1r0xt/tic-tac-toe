public class Board {
    public String[] board = new String[9];

    public Board() {
        for (int a = 0; a < 9; a++) {
            this.board[a] = String.valueOf(a + 1);
        }
    }

    public boolean isEmptyPosition(int pos) {
        return !(board[pos - 1].equals("X") || board[pos - 1].equals("O"));
    }

    public void displayBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | " + board[1]+ " | " +board[2]+ " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4]+ " | " +board[5]+ " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7]+ " | " +board[8]+ " |");
        System.out.println("|---|---|---|");

    }

    public String winner() {
        // Check rows
        for (int i = 0; i < 9; i += 3) {
            if (board[i].equals(board[i + 1]) && board[i].equals(board[i + 2])) {
                return board[i];
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[i].equals(board[i + 3]) && board[i].equals(board[i + 6])) {
                return board[i];
            }
        }

        // Check diagonals
        if (board[0].equals(board[4]) && board[0].equals(board[8])) {
            return board[0];
        }
        if (board[2].equals(board[4]) && board[2].equals(board[6])) {
            return board[2];
        }

        // Check for draw
        for (int i = 0; i < 9; i++) {
            if (!board[i].equals("X") && !board[i].equals("O")) {
                return null; // Game still ongoing
            }
        }
        return "draw"; // No empty positions left, it's a draw
    }

    public void applyMove(Move move) {
        if (move.pos < 1 || move.pos > 9) {
            System.out.println("Invalid move. Position should be between 1 and 9.");
            return;
        }
        if (!isEmptyPosition(move.pos)) {
            System.out.println("Position already occupied");
            return;
        }
        board[move.pos - 1] = move.player.symbol;
    }
}
