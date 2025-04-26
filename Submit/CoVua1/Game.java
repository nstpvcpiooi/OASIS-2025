import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<>();

    /**
     * Constructor for Game class.
     *
     * @param board the game board.
     */
    public Game(Board board) {
        this.board = board;
    }

    /**
     * Get the game board.
     *
     * @return the game board.
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Set the game board.
     *
     * @param board the new game board.
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * Get the move history.
     *
     * @return the list of moves made in the game.
     */
    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }

    /**
     * Set the move history.
     *
     * @param moveHistory the new move history.
     */
    public void setMoveHistory(ArrayList<Move> moveHistory) {
        this.moveHistory = moveHistory;
    }

    /**
     * Move a piece on the board.
     *
     * @param p the piece to move.
     * @param x the target x-coordinate.
     * @param y the target y-coordinate.
     */
    public void movePiece(Piece p, int x, int y) {
        if (p.canMove(board, x, y) && board.getAt(x, y) == null) {
            Move move = new Move(p.getCoordinatesX(), x,
                    p.getCoordinatesY(), y, p);
            moveHistory.add(move);
            p.setCoordinatesX(x);
            p.setCoordinatesY(y);
        } else if (p.canMove(board, x, y) && board.getAt(x, y) != null) {
            Move move = new Move(p.getCoordinatesX(), x,
                    p.getCoordinatesY(), y, p, board.getAt(x, y));
            moveHistory.add(move);
            board.removeAt(x, y);
            p.setCoordinatesX(x);
            p.setCoordinatesY(y);
        }
    }
}
