import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

public class GameState {
    /* All the data necessary to manage a TicTacToe game.
    A TicTacToe game consists of a board, two players,
    and a pointer to the current player.

    The GameState class has been fully implemented for you.
    */
    public Player[] players;
    public Board board;
    public Player currentPlayer;

    public GameState() {
        this.players = new Player[2];
        this.players[0] = new Player("X");
        this.players[1] = new Player("O");
        this.board = new Board();
        this.currentPlayer = this.randomPlayer();
    }

    /**
     * Generates a random player, used for randomizing first player.
     * @return player one or player two randomly
     */
    public Player randomPlayer() {
        return this.players[new Random().nextBoolean() ? 0 : 1];
    }

    /**
     * Restarts the board and randomizes the next first player.
     */
    public void newGame() {
        this.board = new Board();
        this.currentPlayer = this.randomPlayer();
    }

    /**
     * Uses the board.winner() function to determine the winning symbol,
     * finds the player with that symbol, then increments their score.
     */
    public void addPointToWinningPlayer() {
        String winner = this.board.winner();
        if (!(winner == null || winner.equals("draw"))) {
            Optional<Player> player = Arrays
                    .stream(this.players)
                    .filter(p -> p.symbol.equals(winner))
                    .findFirst();
            if (player.isPresent()) {
                int idx = Arrays.asList(this.players).indexOf(player.get());
                this.players[idx].points++;
            } else {
                throw new RuntimeException("Error: Couldn't find winning player");
            }
        }
    }

    /**
     * Alternates the current player.
     */
    public void nextPlayer() {
        if (this.currentPlayer.equals(this.players[0])) {
            this.currentPlayer = this.players[1];
        } else {
            this.currentPlayer = this.players[0];
        }
    }

    /**
     * Whether the game has ended.
     * @return false if there is no winner
     */
    public boolean isOver() {
        return this.board.winner() != null;
    }
}
