public abstract class Piece {
    private int coordinatesX;
    private int coordinatesY;
    private String color;

    /**
     * Constructor.
     */
    public Piece(int coordinatesX, int coordinatesY, String color) {
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
        this.color = color;
    }

    /**
     * Constructor.
     */
    public Piece(int coordinatesX, int coordinatesY) {
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
        this.color = "white";
    }

    /**
     * Getter.
     */
    public int getCoordinatesX() {
        return coordinatesX;
    }

    /**
     * Setter.
     */
    public void setCoordinatesX(int coordinatesX) {
        this.coordinatesX = coordinatesX;
    }

    /**
     * Getter.
     */
    public int getCoordinatesY() {
        return coordinatesY;
    }

    /**
     * Setter.
     */
    public void setCoordinatesY(int coordinatesY) {
        this.coordinatesY = coordinatesY;
    }

    /**
     * Getter.
     */
    public String getColor() {
        return color;
    }

    /**
     * Setter.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /** Get Symbol. */
    public abstract String getSymbol();

    /** Can Move. */
    public abstract boolean canMove(Board board, int x, int y);

    /**
     * Check if the piece is at the same position as another piece.
     *
     * @param piece the piece to compare with.
     * @return true if the pieces are at the same position, false otherwise.
     */
    public boolean checkPosition(Piece piece) {
        if (!Board.validate(piece.getCoordinatesX(), piece.getCoordinatesY())) {
            return false;
        }

        return piece.getCoordinatesX() == this.coordinatesX
                && piece.getCoordinatesY() == this.coordinatesY;
    }
}
