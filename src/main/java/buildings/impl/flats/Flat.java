package buildings.impl.flats;

import buildings.impl.space.AbstractSpace;
import buildings.interfaces.Space;

public class Flat extends AbstractSpace implements Space {
    public Flat() {
        super();
    }

    public Flat(int square){
        super(square);
    }

    public Flat(int square, int quantity) {
        super(square, quantity);
    }
}
