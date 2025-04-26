public class Move {
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private Piece movedPiece;
    private Piece killedPiece;

    /**
     * Constructor for Move class without killed piece.
     *
     * @param startX     the starting x-coordinate of the move.
     * @param startY     the starting y-coordinate of the move.
     * @param endX       the ending x-coordinate of the move.
     * @param endY       the ending y-coordinate of the move.
     * @param movedPiece the piece being moved.
     */
    public Move(int startX, int endX, int startY, int endY, Piece movedPiece) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.movedPiece = movedPiece;
    }

    /**
     * Constructor for Move class with killed piece.
     *
     * @param startX      the starting x-coordinate of the move.
     * @param startY      the starting y-coordinate of the move.
     * @param endX        the ending x-coordinate of the move.
     * @param endY        the ending y-coordinate of the move.
     * @param movedPiece  the piece being moved.
     * @param killedPiece the piece being killed (if any).
     */
    public Move(int startX, int endX, int startY, int endY, Piece movedPiece, Piece killedPiece) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.movedPiece = movedPiece;
        this.killedPiece = killedPiece;
    }

    /**
     * Get the starting x-coordinate of the move.
     *
     * @return the starting x-coordinate.
     */
    public int getStartX() {
        return startX;
    }

    /**
     * Set the starting x-coordinate of the move.
     *
     * @param startX the new starting x-coordinate.
     */
    public void setStartX(int startX) {
        this.startX = startX;
    }

    /**
     * Get the starting y-coordinate of the move.
     *
     * @return the starting y-coordinate.
     */
    public int getStartY() {
        return startY;
    }

    /**
     * Set the starting y-coordinate of the move.
     *
     * @param startY the new starting y-coordinate.
     */
    public void setStartY(int startY) {
        this.startY = startY;
    }

    /**
     * Get the ending x-coordinate of the move.
     *
     * @return the ending x-coordinate.
     */
    public int getEndX() {
        return endX;
    }

    /**
     * Set the ending x-coordinate of the move.
     *
     * @param endX the new ending x-coordinate.
     */
    public void setEndX(int endX) {
        this.endX = endX;
    }

    /**
     * Get the ending y-coordinate of the move.
     *
     * @return the ending y-coordinate.
     */
    public int getEndY() {
        return endY;
    }

    /**
     * Set the ending y-coordinate of the move.
     *
     * @param endY the new ending y-coordinate.
     */
    public void setEndY(int endY) {
        this.endY = endY;
    }

    /**
     * Get the piece being moved.
     *
     * @return the moved piece.
     */
    public Piece getMovedPiece() {
        return movedPiece;
    }

    /**
     * Set the piece being moved.
     *
     * @param movedPiece the new moved piece.
     */
    public void setMovedPiece(Piece movedPiece) {
        this.movedPiece = movedPiece;
    }

    /**
     * Get the piece being killed (if any).
     *
     * @return the killed piece.
     */
    public Piece getKilledPiece() {
        return killedPiece;
    }

    /**
     * Set the piece being killed (if any).
     *
     * @param killedPiece the new killed piece.
     */
    public void setKilledPiece(Piece killedPiece) {
        this.killedPiece = killedPiece;
    }

    /**
     * Get the string representation of the move.
     *
     * @return the string representation of the move.
     */
    @Override
    public String toString() {
        return movedPiece.getColor() + "-" + movedPiece.getSymbol()
                + (char) ('a' + endX - 1) + endY;
    }
}
