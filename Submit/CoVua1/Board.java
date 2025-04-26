import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<>();

    /**
     * Constructor for Board class.
     */
    public Board() {}

    /**
     * Get the pieces on the board.
     *
     * @return the list of pieces on the board.
     */
    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    /**
     * Set the pieces on the board.
     *
     * @param pieces the list of pieces to set.
     */
    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    /**
     * Add a piece to the board.
     *
     * @param piece the piece to add.
     */
    public void addPiece(Piece piece) {
        // Check duplicate
        for (Piece p : pieces) {
            if (p.getCoordinatesX() == piece.getCoordinatesX()
                    && p.getCoordinatesY() == piece.getCoordinatesY()) {
                return;
            }
        }
        pieces.add(piece);
    }

    /**
     * Get a piece at the specified coordinates.
     *
     * @param x the x-coordinate.
     * @param y the y-coordinate.
     * @return the piece at the specified coordinates, or null if no piece is found.
     */
    public Piece getAt(int x, int y) {
        for (Piece piece : pieces) {
            if (piece.getCoordinatesX() == x && piece.getCoordinatesY() == y) {
                return piece;
            }
        }
        return null;
    }

    /**
     * Remove a piece at the specified coordinates.
     *
     * @param x the x-coordinate.
     * @param y the y-coordinate.
     */
    public void removeAt(int x, int y) {
        pieces.removeIf(piece -> piece.getCoordinatesX() == x && piece.getCoordinatesY() == y);
    }

    /**
     * Check if the coordinates are valid.
     *
     * @param x the x-coordinate.
     * @param y the y-coordinate.
     * @return true if the coordinates are valid, false otherwise.
     */
    public static boolean validate(int x, int y) {
        return x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT;
    }

}
