public class Move {
    /* A data representation of a Move in TicTacToe.
    Each move consists of the player who is taking that move
    and the position (1-9) they would like to place their move.

    The Move class has been fully implemented for you.
    */
    public final Player player;
    public final int pos;

    public Move(Player player, int pos) {
        if (!(pos >= 1 && pos <= 9)) {
            throw new IllegalArgumentException("Invalid Position: Must be 1-9");
        }
        this.player = player;
        this.pos = pos;
    }
}