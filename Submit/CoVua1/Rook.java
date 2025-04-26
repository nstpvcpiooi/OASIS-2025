public class Rook extends Piece {
    /**
     * Constructor for Piece class.
     *
     * @param coordinateX the x-coordinate of the piece.
     * @param coordinateY the y-coordinate of the piece.
     */
    public Rook(int coordinateX, int coordinateY) {
        super(coordinateX, coordinateY);
    }

    /**
     * Constructor for Piece class with color.
     *
     * @param coordinateX the x-coordinate of the piece.
     * @param coordinateY the y-coordinate of the piece.
     * @param color       the color of the piece.
     */
    public Rook(int coordinateX, int coordinateY, String color) {
        super(coordinateX, coordinateY, color);
    }

    /**
     * Get Symbol.
     *
     * @return the symbol of the piece.
     */
    @Override
    public String getSymbol() {
        return "R";
    }

    /**
     * Check if the piece can move to a given position on the board.
     *
     * @param board the game board.
     * @param x     the x-coordinate of the target position.
     * @param y     the y-coordinate of the target position.
     * @return true if the piece can move to the target position, false otherwise.
     */
    @Override
    public boolean canMove(Board board, int x, int y) {
        if (!Board.validate(x, y)) {
            return false;
        }
        if (x == getCoordinatesX() && y == getCoordinatesY()) {
            return false;
        }
        if (x != getCoordinatesX() && y != getCoordinatesY()) {
            return false;
        }

        if (x == getCoordinatesX()) {
            int minY = Math.min(y, getCoordinatesY());
            int maxY = Math.max(y, getCoordinatesY());
            for (int i = minY + 1; i < maxY; i++) {
                if (board.getAt(x, i) != null) {
                    return false;
                }
            }
        } else {
            int minX = Math.min(x, getCoordinatesX());
            int maxX = Math.max(x, getCoordinatesX());
            for (int i = minX + 1; i < maxX; i++) {
                if (board.getAt(i, y) != null) {
                    return false;
                }
            }
        }
        return board.getAt(x, y) == null
                || !board.getAt(x, y).getColor().equals(this.getColor());
    }
}
