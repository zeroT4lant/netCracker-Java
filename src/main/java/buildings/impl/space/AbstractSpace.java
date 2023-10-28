package buildings.impl.space;


import lombok.Data;

@Data
public abstract class AbstractSpace {
    private int square;
    private int quantity;

    private final int SQUARE50 = 50;
    private final int QUANTITY2 = 2;

    public AbstractSpace() {
        this.square = SQUARE50;
        this.quantity = QUANTITY2;
    }

    public AbstractSpace(int square) {
        this.square = square;
        this.quantity = QUANTITY2;
    }

    public AbstractSpace(int square, int quantity) {
        this.square = square;
        this.quantity = quantity;
    }
}
