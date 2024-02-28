import java.util.Scanner;

public class Main {
    static GameState game = new GameState();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Moved scanner declaration here

        while (true) {
            while (!game.isOver()) {
                game.board.displayBoard(); // Display current board
                System.out.println("Player " + game.currentPlayer.symbol + "'s turn.");
                Move move = game.currentPlayer.getTurn();

                if (game.board.isEmptyPosition(move.pos)) { // Check if the position is valid
                    game.board.applyMove(move);
                    game.nextPlayer(); // Rotate players only if the move is valid
                } else {
                    System.out.println("Invalid move. Please choose an empty position.");
                }
            }

            // Display end game information and update scores
            game.board.displayBoard();
            String winner = game.board.winner();
            if (winner.equals("draw")) {
                System.out.println("It's a draw!");
            } else {
                System.out.println("Player " + winner + " wins!");
                game.addPointToWinningPlayer();
            }
            System.out.println("Scores: Player X - " + game.players[0].points + ", Player O - " + game.players[1].points);
            // Ask if the user wants to play again
            System.out.println("Do you want to play again? (Y/N)");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("Y")) {
                break;
            } else {
                game.newGame(); // Start a new game
            }
        }
        scanner.close(); // Close the scanner when done
    }
}