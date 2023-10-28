package buildings.impl.offices;

import buildings.impl.space.AbstractSpace;
import buildings.interfaces.Space;

public class Office extends AbstractSpace implements Space {

    public Office() {
        super();
    }

    public Office(int square, int quantity) {
        super(square,quantity);
    }
}


