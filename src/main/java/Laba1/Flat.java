package Laba1;

public class Flat {
    private int square;
    private int quantity;

    private final int SQUARE50 = 50;
    private final int QUANTITY2 = 2;

    public Flat() {
        this.square = SQUARE50;
        this.quantity = QUANTITY2;
    }

    public Flat(int square) {
        this.square = square;
        this.quantity = QUANTITY2;
    }

    public Flat(int square, int quantity) {
        this.square = square;
        this.quantity = quantity;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
